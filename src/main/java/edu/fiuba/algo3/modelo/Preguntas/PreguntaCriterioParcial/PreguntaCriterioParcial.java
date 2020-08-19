package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioParcial extends Pregunta {

    /*
     * PRE: opciones no es vacio.
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaCriterioParcial con consigna y opciones.
     */
    public PreguntaCriterioParcial(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected abstract int obtenerPuntaje(ArrayList<Opcion> opcionesJugador);

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si opcionesJugador tiene la cantidad necesaria de opciones requerida para obtener un puntaje positivo.
    @Override
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return true;
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Devuelve la suma de puntos total de las opcionesJugador.
    protected int recibirPuntajeOpciones(ArrayList<Opcion> opcionesJugador) {
        return opcionesJugador.stream().mapToInt(o -> o.calcularPuntosAdicionales()).sum();
    }

}
