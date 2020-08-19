package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecuperadorMultipleChoiceParcial extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayMultipleChoiceParcial= unObjetoJson.getAsJsonArray("MultipleChoiceConPuntajeParcial");
        ArrayList<Pregunta> preguntasMultipleChoiceParcial = new ArrayList<>();
        List<Pregunta> preguntasDesordenadas = new ArrayList<>();

        for(JsonElement unJson: arrayMultipleChoiceParcial){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcionesDesordenadas= new ArrayList<>();

            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion UnaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesDesordenadas.add(UnaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion UnaOpcionIncorrecta = new OpcionIncorrecta(opcionIncorrecta);
                opcionesDesordenadas.add(UnaOpcionIncorrecta);
            }

            Collections.shuffle(opcionesDesordenadas);
            opcionesAPresentar.addAll(opcionesDesordenadas);
            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoiceParcial.add(unaPregunta);
            unaPregunta.setIdentificador("MultipleChoiceConPuntajeParcial");
            preguntasDesordenadas.add(unaPregunta);
        }
        Collections.shuffle(preguntasDesordenadas);
        preguntasMultipleChoiceParcial.addAll(preguntasDesordenadas);
        return preguntasMultipleChoiceParcial;
    }
}
