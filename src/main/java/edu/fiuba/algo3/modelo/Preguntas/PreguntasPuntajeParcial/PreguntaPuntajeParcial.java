package edu.fiuba.algo3.modelo.Preguntas.PreguntasPuntajeParcial;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class PreguntaPuntajeParcial extends Pregunta {
    public PreguntaPuntajeParcial(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Evaluable unaOpcion: opcionesJugador){
            if(unaOpcion.evaluar())
                puntajeARetornar ++;
        }
        return puntajeARetornar;
    }
}
