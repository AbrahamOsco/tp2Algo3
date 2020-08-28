package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesClasificadas extends PreguntaCriterioSinErrores{

    /*
     * PRE: opciones no es vacio.
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaConTodasOpcionesClasificadas con consigna y opciones.
     */
    public PreguntaConTodasOpcionesClasificadas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si opcionesJugador tiene la cantidad necesaria de opciones requerida para obtener un puntaje positivo.
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
