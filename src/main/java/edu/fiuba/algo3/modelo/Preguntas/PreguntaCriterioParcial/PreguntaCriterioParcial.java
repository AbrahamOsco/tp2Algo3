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
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return true;
    }

    //RefactoDeNombre pendiente
    protected int recibirPuntajeOpciones(ArrayList<Opcion> opcionesJugador) {
        int puntajeARetornar = 0;
        for (Opcion unaOpcionJugador : opcionesJugador) {
            puntajeARetornar += unaOpcionJugador.calcularPuntosAdicionales();
        }
        return puntajeARetornar;
    }

}
