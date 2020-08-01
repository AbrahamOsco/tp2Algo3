package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        int puntajeARetorna = 0;
        for(Opcion unaOpcion: opcionesJugador){
            if(unaOpcion.evaluar())
                puntajeARetorna ++;
        }
        return puntajeARetorna;
    }
}
