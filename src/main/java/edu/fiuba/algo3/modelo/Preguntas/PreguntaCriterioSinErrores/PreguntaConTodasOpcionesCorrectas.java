package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesCorrectas extends PreguntaCriterioSinErrores{

    /*
     * PRE: opciones no es vacio (amerita Exception).
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaConTodasOpcionesCorrectas con consigna y opciones.
     */
    public PreguntaConTodasOpcionesCorrectas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Determina si opcionesJugador tiene la cantidad necesaria de opciones requerida para obtener un puntaje positivo.
    @Override
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        int cantidadOpcionesCorrectas = this.getOpcionesCorrectas().size();
        int cantidadOpcionesJugador = opcionesJugador.size();
        return cantidadOpcionesCorrectas == cantidadOpcionesJugador;
    }
}
