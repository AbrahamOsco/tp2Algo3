package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrectaPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecuperadorVerdaderoFalsoPenalizable extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson){

        JsonArray arrayPreguntasVoFPenalizable = unObjetoJson.getAsJsonArray("VerdaderoOFalsoPenalizable");
        List<Pregunta> preguntaDesordenadas = new ArrayList<>();
        ArrayList<Pregunta> preguntasVerdaderoFalsoPenalizable = new ArrayList<>();


        for(JsonElement unJson: arrayPreguntasVoFPenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrectaPenalizable = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion opcion1 = new OpcionCorrecta(opcionCorrecta);
            Opcion opcion2 = new OpcionIncorrectaPenalizable(opcionIncorrectaPenalizable);

            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcionesDesordenadas = new ArrayList<>();
            opcionesDesordenadas.add(opcion1);
            opcionesDesordenadas.add(opcion2);
            Collections.shuffle(opcionesDesordenadas);
            opcionesAPresentar.addAll(opcionesDesordenadas);

            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,opcionesAPresentar);
            preguntaDesordenadas.add(unaPregunta);
        }
        Collections.shuffle(preguntaDesordenadas);
        preguntasVerdaderoFalsoPenalizable.addAll(preguntaDesordenadas);
        return preguntasVerdaderoFalsoPenalizable;
    }
}
