package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialPenalizable extends PreguntaCriterioParcial{

    /*
     * PRE: opciones no es vacio.
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaPuntajeParcialPenalizable con consigna y opciones.
     */
    public PreguntaPuntajeParcialPenalizable(String consigna, ArrayList<Opcion> opciones){
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Devuelve el puntaje a recibir a partir de opcionesJugador.
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
