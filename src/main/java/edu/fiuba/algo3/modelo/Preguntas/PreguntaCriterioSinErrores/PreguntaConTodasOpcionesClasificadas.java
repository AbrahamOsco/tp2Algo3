package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesClasificadas extends PreguntaCriterioSinErrores{
    public PreguntaConTodasOpcionesClasificadas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }
    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return (this.opciones.size()) == opcionesJugador.size();
    }
    @Override
    public ArrayList<Opcion> getOpcionesCorrectas(){
        return this.opciones;
    }
}
