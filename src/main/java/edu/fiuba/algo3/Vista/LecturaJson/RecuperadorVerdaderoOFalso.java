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

public class RecuperadorVerdaderoOFalso extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayPreguntasVoFClasico = unObjetoJson.getAsJsonArray("VerdaderoOFalsoClasico");
        ArrayList<Pregunta> preguntasVerdaderoFalsoClasico = new ArrayList<>();

        for(JsonElement unJson: arrayPreguntasVoFClasico){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrecta = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion opcion1 = new OpcionCorrecta(opcionCorrecta);
            Opcion opcion2 = new OpcionIncorrecta(opcionIncorrecta);
            ArrayList<Opcion> OpcionesAPresentar= new ArrayList<>();
            OpcionesAPresentar.add(opcion1);
            OpcionesAPresentar.add(opcion2);
            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,OpcionesAPresentar);
            preguntasVerdaderoFalsoClasico.add(unaPregunta);
        }
        return preguntasVerdaderoFalsoClasico;
    }

}
