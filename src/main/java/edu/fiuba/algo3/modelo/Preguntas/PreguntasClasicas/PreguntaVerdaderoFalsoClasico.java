package edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoClasico extends PreguntaClasica {
    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return true;
    }
}
