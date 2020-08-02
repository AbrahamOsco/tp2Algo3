package edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends PreguntaClasica {
    private boolean tieneMismaCantidadDeOpcionesCorrectas(ArrayList<Evaluable>opcionesJugador){
        int cantidadOpcionesCorrectas = 0;
        for(Evaluable unaOpcion: this.opciones){
            if(unaOpcion.evaluar())
                cantidadOpcionesCorrectas++;
        }
        return cantidadOpcionesCorrectas == opcionesJugador.size();
    }

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        return tieneMismaCantidadDeOpcionesCorrectas(opcionesJugador);
    }
}
