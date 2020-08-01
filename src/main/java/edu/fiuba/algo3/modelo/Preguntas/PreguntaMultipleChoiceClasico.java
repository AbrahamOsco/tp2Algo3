package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(!tieneMismaCantidadDeOpcionesCorrectas(opcionesJugador))
            return 0;

        for(Opcion unaOpcion: opcionesElejidas){
            if(!unaOpcion.evaluar())
                return 0;
        }
        return 1;
    }


    private boolean tieneMismaCantidadDeOpcionesCorrectas(ArrayList<Opcion>opcionesJugador){
        int cantidadOpcionesCorrectas = 0;
        for(Opcion unaOpcion: this.opciones){
            if(unaOpcion.evaluar())
                cantidadOpcionesCorrectas++;
        }
        return cantidadOpcionesCorrectas == opcionesJugador.lenght();
    }
}
