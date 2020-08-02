package edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaClasica extends Pregunta {

    public PreguntaClasica(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Evaluable> opcionesJugador) {
        if(!tieneOpcionesNecesarias(opcionesJugador))
            return 0;
        for(Evaluable unaOpcion: opcionesJugador){
            if(!unaOpcion.evaluar())
                return 0;
        }
        return 1;
    }
    protected abstract boolean tieneOpcionesNecesarias(ArrayList<Evaluable>opcionesJugador);
}
