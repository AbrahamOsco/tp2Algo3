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

public class RecuperadorVerdaderoOFalso extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayPreguntasVoFClasico = unObjetoJson.getAsJsonArray("VerdaderoOFalsoClasico");
        ArrayList<Pregunta> preguntasVerdaderoFalsoClasico = new ArrayList<>();
        List<Pregunta> preguntasDesordenadas = new ArrayList<>();


        for(JsonElement unJson: arrayPreguntasVoFClasico){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrecta = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion opcion1 = new OpcionCorrecta(opcionCorrecta);
            Opcion opcion2 = new OpcionIncorrecta(opcionIncorrecta);

            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcionesDesordenadas = new ArrayList<>();

            opcionesDesordenadas.add(opcion1);
            opcionesDesordenadas.add(opcion2);

            Collections.shuffle(opcionesDesordenadas);
            opcionesAPresentar.addAll(opcionesDesordenadas);
            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,opcionesAPresentar);
            preguntasDesordenadas.add(unaPregunta);
            unaPregunta.setIdentificador("VerdaderoOFalsoClasico");
        }
        Collections.shuffle(preguntasDesordenadas);
        preguntasVerdaderoFalsoClasico.addAll(preguntasDesordenadas);
        return preguntasVerdaderoFalsoClasico;
    }

}
