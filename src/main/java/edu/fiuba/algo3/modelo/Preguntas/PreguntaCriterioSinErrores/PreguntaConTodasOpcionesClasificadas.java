package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesClasificadas extends PreguntaCriterioSinErrores{

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaConTodasOpcionesClasificadas con Consigna y opciones.
     */
    public PreguntaConTodasOpcionesClasificadas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si un conjunto de opcionesJugador es lo suficientemente grande como para ser correcto.
    @Override
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        return (this.opciones.size()) == opcionesJugador.size();
    }

    //PRE: -
    //POS: Devuelve las opciones correctas.
    @Override
    public ArrayList<Opcion> getOpcionesCorrectas(){
        return this.opciones;
    }
}
