package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioParcial extends Pregunta {

    public PreguntaCriterioParcial(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected abstract int obtenerPuntaje(ArrayList<Opcion> opcionesJugador);

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return true;
    }
}
