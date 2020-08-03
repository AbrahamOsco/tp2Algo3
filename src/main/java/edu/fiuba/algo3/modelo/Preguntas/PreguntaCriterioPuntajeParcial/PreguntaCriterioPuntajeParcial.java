package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioPuntajeParcial;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioPuntajeParcial extends Pregunta {

    public PreguntaCriterioPuntajeParcial(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected abstract int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador);

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return true;
    }
}
