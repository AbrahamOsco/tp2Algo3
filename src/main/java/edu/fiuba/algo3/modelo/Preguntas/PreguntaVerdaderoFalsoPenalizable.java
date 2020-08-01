package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalizable extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        int puntajeAretornar = 0;
        for(Opcion unaOpcion: opcionesElejidas){
            if(unaOpcion.evaluar())
                puntajeAretornar++;
            else
                puntajeAretornar--;
        }
        return puntajeAretornar;
    }
}
