package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalizable extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        for(Opcion unaOpcion: opcionesElejidas){
            if(!unaOpcion.evaluar())
                return -1;
        }
        return 1;
    }
}
