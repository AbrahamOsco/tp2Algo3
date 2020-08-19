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
import java.util.Collections;
import java.util.List;

public class RecuperadorMultipleChoiceClasico extends RecuperadorDePreguntas{


    @Override
    public  ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {
        JsonArray arrayMultipleChoiceClasico = unObjetoJson.getAsJsonArray("MultipleChoiceClasico");

        ArrayList<Pregunta> preguntasMultipleChoiceClasico = new ArrayList<>();
        List<Pregunta> preguntaDesordenadas = new ArrayList<>();


        for(JsonElement unJson: arrayMultipleChoiceClasico){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcioneDesordenadas= new ArrayList<>();

            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion UnaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcioneDesordenadas.add(UnaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion UnaOpcionIncorrecta = new OpcionIncorrecta(opcionIncorrecta);
                opcioneDesordenadas.add(UnaOpcionIncorrecta);
            }

            Collections.shuffle(opcioneDesordenadas);
            opcionesAPresentar.addAll(opcioneDesordenadas);
            Pregunta unaPregunta = new PreguntaConTodasOpcionesCorrectas(unaConsigna,opcionesAPresentar);
            preguntaDesordenadas.add(unaPregunta);
        }
        Collections.shuffle(preguntaDesordenadas);
        preguntasMultipleChoiceClasico.addAll(preguntaDesordenadas);
        return  preguntasMultipleChoiceClasico;
        }

}
