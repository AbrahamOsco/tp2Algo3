package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesCorrectas extends PreguntaCriterioSinErrores{
    public PreguntaConTodasOpcionesCorrectas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        int cantidadOpcionesCorrectas = 0;
        for(Opcion unaOpcion: this.opciones){
            if(unaOpcion.esCorrecta())
                cantidadOpcionesCorrectas++;
        }
        return cantidadOpcionesCorrectas == opcionesJugador.size();
    }
}
