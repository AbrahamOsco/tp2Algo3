package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialPenalizable extends PreguntaCriterioParcial{

    public PreguntaPuntajeParcialPenalizable(String consigna, ArrayList<Opcion> opciones){
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
