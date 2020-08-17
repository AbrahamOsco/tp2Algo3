package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialPenalizable extends PreguntaCriterioParcial{

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaParcialPenalizable con Consigna y opciones.
     */
    public PreguntaPuntajeParcialPenalizable(String consigna, ArrayList<Opcion> opciones){
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: obtiene el puntaje del jugador a partir de las opciones que eligió.
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
