package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioParcial extends Pregunta {

    public PreguntaCriterioParcial(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected abstract int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador);

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return true;
    }
}
