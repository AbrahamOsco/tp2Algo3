package edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaDeClasificacion extends PreguntaClasica {
    public PreguntaDeClasificacion(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    private boolean jugadorUsoTodasLasOpciones(ArrayList<Evaluable> opcionesJugador) {
        return !(opcionesJugador.size() == this.opciones.size());
    }
    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return jugadorUsoTodasLasOpciones(opcionesJugador);
    }

}
