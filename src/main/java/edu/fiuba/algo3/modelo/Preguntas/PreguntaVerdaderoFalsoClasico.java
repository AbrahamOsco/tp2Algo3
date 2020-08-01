package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoClasico extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        for(Opcion unaOpcion: opcionesJugador){
            if(!unaOpcion.evaluar())
                return 0;
        }
        return 1;
    }
}
