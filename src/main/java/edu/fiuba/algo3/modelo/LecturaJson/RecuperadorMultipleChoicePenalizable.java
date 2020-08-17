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

public class RecuperadorMultipleChoicePenalizable extends  RecuperadorDePreguntas{
    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayMultipleChoicePenalizable = unObjetoJson.getAsJsonArray("MultipleChoiceConPenalidad");
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();


        for(JsonElement unJson: arrayMultipleChoicePenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion unaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesAPresentar.add(unaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion opcionIncorrectaPenalizable = new OpcionIncorrectaPenalizable(opcionIncorrecta);
                opcionesAPresentar.add(opcionIncorrectaPenalizable);
            }
            Pregunta unaPregunta = new PreguntaPuntajeParcialPenalizable(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoicePenalizable.add(unaPregunta);
        }
        return preguntasMultipleChoicePenalizable;

    }
}
