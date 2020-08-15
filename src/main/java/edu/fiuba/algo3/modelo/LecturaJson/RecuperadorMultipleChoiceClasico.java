package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;

import java.util.ArrayList;

public class RecuperadorMultipleChoiceClasico extends RecuperadorDePreguntas{


    @Override
    public  ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {
        JsonArray arrayMultipleChoiceClasico = unObjetoJson.getAsJsonArray("MultipleChoiceClasico");

        ArrayList<Pregunta> preguntasMultipleChoiceClasico = new ArrayList<>();

        for(JsonElement unJson: arrayMultipleChoiceClasico){
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
            Pregunta unaPregunta = new PreguntaConTodasOpcionesCorrectas(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoiceClasico.add(unaPregunta);
        }
        return  preguntasMultipleChoiceClasico;
        }

}
