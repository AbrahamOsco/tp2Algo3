package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioSinErrores extends Pregunta {
    public PreguntaCriterioSinErrores(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        for(Opcion unaOpcion: opcionesJugador){
            if(!unaOpcion.esCorrecta())
                return 0;
        }
        return 1;
    }

    @Override
    protected abstract boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador);
}
