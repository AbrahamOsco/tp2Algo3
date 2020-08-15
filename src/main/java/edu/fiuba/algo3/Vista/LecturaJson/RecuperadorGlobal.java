package edu.fiuba.algo3.Vista.LecturaJson;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class RecuperadorGlobal extends RecuperadorDePreguntas{
    public ArrayList<Pregunta> unasPreguntas;


    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {
        return null;
    }
}
