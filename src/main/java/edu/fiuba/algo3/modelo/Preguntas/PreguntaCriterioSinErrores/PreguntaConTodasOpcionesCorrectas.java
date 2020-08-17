package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesCorrectas extends PreguntaCriterioSinErrores{

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaConTodasOpcionesCorrectas con Consigna y opciones.
     */
    public PreguntaConTodasOpcionesCorrectas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si un conjunto de opcionesJugador es lo suficientemente grande como para ser correcto.
    @Override
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        int cantidadOpcionesCorrectas = this.getOpcionesCorrectas().size();
        int cantidadOpcionesJugador = opcionesJugador.size();
        return cantidadOpcionesCorrectas == cantidadOpcionesJugador;
    }
}
