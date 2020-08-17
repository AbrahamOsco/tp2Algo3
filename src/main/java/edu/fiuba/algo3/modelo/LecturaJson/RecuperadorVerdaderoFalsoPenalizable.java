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

public class RecuperadorVerdaderoFalsoPenalizable extends RecuperadorDePreguntas{

    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson){

        JsonArray arrayPreguntasVoFPenalizable = unObjetoJson.getAsJsonArray("VerdaderoOFalsoPenalizable");
        ArrayList<Pregunta> preguntasVerdaderoFalsoPenalizable = new ArrayList<>();


        for(JsonElement unJson: arrayPreguntasVoFPenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrectaPenalizable = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion opcion1 = new OpcionCorrecta(opcionCorrecta);
            Opcion opcion2 = new OpcionIncorrectaPenalizable(opcionIncorrectaPenalizable);
            ArrayList<Opcion> OpcionesAPresentar= new ArrayList<>();
            OpcionesAPresentar.add(opcion1);
            OpcionesAPresentar.add(opcion2);
            Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,OpcionesAPresentar);
            preguntasVerdaderoFalsoPenalizable.add(unaPregunta);
            unaPregunta.setIdentificador("VerdaderoOFalsoPenalizable");
        }
        return preguntasVerdaderoFalsoPenalizable;
    }
}
