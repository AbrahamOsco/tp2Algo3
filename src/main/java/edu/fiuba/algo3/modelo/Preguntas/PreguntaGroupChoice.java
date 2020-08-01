package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(!this.jugadorUsoTodasLasOpciones(opcionesJugador))
            return 0;

        for(Opcion unaOpcion: opcionesJugador){
            if(!unaOpcion.evaluar())
                return 0;
        }
        return 1;
    }
}
