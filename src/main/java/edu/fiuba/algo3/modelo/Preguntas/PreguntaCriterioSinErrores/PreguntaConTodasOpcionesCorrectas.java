package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public class PreguntaConTodasOpcionesCorrectas extends  PreguntaCriterioSinErrores{
    public PreguntaConTodasOpcionesCorrectas(String consigna, ArrayList<Evaluable> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Evaluable> opcionesJugador) {
        int cantidadOpcionesCorrectas = 0;
        for(Evaluable unaOpcion: this.opciones){
            if(unaOpcion.evaluar())
                cantidadOpcionesCorrectas++;
        }
        return cantidadOpcionesCorrectas == opcionesJugador.size();
    }
}
