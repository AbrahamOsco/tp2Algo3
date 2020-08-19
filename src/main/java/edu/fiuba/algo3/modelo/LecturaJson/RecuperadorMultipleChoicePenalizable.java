package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrectaPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecuperadorMultipleChoicePenalizable extends  RecuperadorDePreguntas{
    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayMultipleChoicePenalizable = unObjetoJson.getAsJsonArray("MultipleChoiceConPenalidad");
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();
        List<Pregunta> preguntasDesordenadas = new ArrayList<>();



        for(JsonElement unJson: arrayMultipleChoicePenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcionesDesordenadas = new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion unaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesDesordenadas.add(unaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion opcionIncorrectaPenalizable = new OpcionIncorrectaPenalizable(opcionIncorrecta);
                opcionesDesordenadas.add(opcionIncorrectaPenalizable);
            }

            Collections.shuffle(opcionesDesordenadas);
            opcionesAPresentar.addAll(opcionesDesordenadas);
            Pregunta unaPregunta = new PreguntaPuntajeParcialPenalizable(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoicePenalizable.add(unaPregunta);
            unaPregunta.setIdentificador("MultipleChoiceConPenalidad");
            preguntasDesordenadas.add(unaPregunta);
        }
        Collections.shuffle(preguntasDesordenadas);
        preguntasMultipleChoicePenalizable.addAll(preguntasDesordenadas);
        return preguntasMultipleChoicePenalizable;

    }
}
