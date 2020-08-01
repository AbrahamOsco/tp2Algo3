package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaMultipleChoicePenalizable extends Pregunta {
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Opcion unaOpcion: opcionesElejidas){
            if(unaOpcion.evaluar())
                puntajeARetornar ++;
            else
                puntajeARetornar --;
        }
        return puntajeARetornar;
    }
}
