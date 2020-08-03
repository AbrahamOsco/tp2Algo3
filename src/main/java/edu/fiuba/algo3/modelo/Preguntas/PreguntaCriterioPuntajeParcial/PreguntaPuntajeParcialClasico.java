package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioPuntajeParcial;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaPuntajeParcialClasico extends PreguntaCriterioPuntajeParcial{
    public PreguntaPuntajeParcialClasico(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Evaluable unaOpcion: opcionesJugador){
            if(!unaOpcion.evaluar()){
                return 0;
            }
            puntajeARetornar ++;
        }
        return puntajeARetornar;
    }
}
