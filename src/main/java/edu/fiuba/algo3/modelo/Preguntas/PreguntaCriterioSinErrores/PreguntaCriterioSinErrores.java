package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public abstract class PreguntaCriterioSinErrores extends Pregunta {

    /*
     * PRE: opciones no es vacio (amerita Exception).
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaCriterioSinErrores con consigna y opciones.
     */
    public PreguntaCriterioSinErrores(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Devuelve el puntaje a recibir a partir de opcionesJugador.
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(this.tieneAlgunaOpcionIncorrecta(opcionesJugador))
            return 0;
        return 1;
    }

    @Override
    protected abstract boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador);

}
