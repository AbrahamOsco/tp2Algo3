package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;


public abstract class RecuperadorDePreguntas {

    public abstract ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson);

}
