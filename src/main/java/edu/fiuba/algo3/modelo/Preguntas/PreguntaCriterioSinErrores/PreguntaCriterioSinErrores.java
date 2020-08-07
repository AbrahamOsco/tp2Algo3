package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioSinErrores extends Pregunta {
    public PreguntaCriterioSinErrores(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador) {
        for(Evaluable unaOpcion: opcionesJugador){
            if(!unaOpcion.evaluar())
                return 0;
        }
        return 1;
    }

    @Override
    protected abstract boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador);
}
