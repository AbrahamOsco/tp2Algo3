package edu.fiuba.algo3.Vista.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;

import java.util.ArrayList;

public class RecuperadorMultipleChoiceParcial extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayMultipleChoiceParcial= unObjetoJson.getAsJsonArray("MultipleChoiceConPuntajeParcial");
        ArrayList<Pregunta> preguntasMultipleChoiceParcial = new ArrayList<>();

        for(JsonElement unJson: arrayMultipleChoiceParcial){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion UnaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesAPresentar.add(UnaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion UnaOpcionIncorrecta = new OpcionIncorrecta(opcionIncorrecta);
                opcionesAPresentar.add(UnaOpcionIncorrecta);
            }
            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoiceParcial.add(unaPregunta);
        }
        return preguntasMultipleChoiceParcial;
    }
}
