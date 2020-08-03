package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaConTodasOpcionesClasificadas extends PreguntaCriterioSinErrores{

    public PreguntaConTodasOpcionesClasificadas(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }
    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return (this.opciones.size()) == opcionesJugador.size();
    }
}
