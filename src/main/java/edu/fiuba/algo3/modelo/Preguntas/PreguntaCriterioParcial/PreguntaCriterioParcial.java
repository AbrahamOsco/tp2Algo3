package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioParcial extends Pregunta {

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaCriterioParcial con Consigna y opciones.
     */
    public PreguntaCriterioParcial(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected abstract int obtenerPuntaje(ArrayList<Opcion> opcionesJugador);

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si un conjunto de opcionesJugador es lo suficientemente grande como para ser correcto.
    @Override
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return true;
    }

    //PRE: opcionesJugador es un Arraylist<Opcion> válido.
    //POS: Obtiene el puntaje total de todas las opciones de opcionesJugadores.
    protected int recibirPuntajeOpciones(ArrayList<Opcion> opcionesJugador) {
        return opcionesJugador.stream().mapToInt(o -> o.calcularPuntosAdicionales()).sum();
    }

}
