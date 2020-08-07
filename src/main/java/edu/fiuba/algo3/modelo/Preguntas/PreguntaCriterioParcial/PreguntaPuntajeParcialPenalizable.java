package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Evaluables.Evaluable;

import java.util.ArrayList;

public class PreguntaPuntajeParcialPenalizable extends PreguntaCriterioParcial{

    public PreguntaPuntajeParcialPenalizable(String consigna, ArrayList<Evaluable> opciones){
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Evaluable unaOpcionJugador: opcionesJugador){
            if(unaOpcionJugador.evaluar())
                puntajeARetornar ++;
            else
                puntajeARetornar --;
        }
        return puntajeARetornar;
    }
}
