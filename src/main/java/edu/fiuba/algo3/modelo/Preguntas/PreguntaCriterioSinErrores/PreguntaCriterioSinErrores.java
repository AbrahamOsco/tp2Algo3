package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioSinErrores extends Pregunta {

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaCriterioSinErrores con Consigna y opciones.
     */
    public PreguntaCriterioSinErrores(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Obtiene el puntaje de un Jugador a partir de las opciones que eligió
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(this.tieneAlgunaOpcionIncorrecta(opcionesJugador))
            return 0;
        return 1;
    }

    @Override
    protected abstract boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador);

}
