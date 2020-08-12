package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaConTodasOpcionesCorrectas extends PreguntaCriterioSinErrores{
    public PreguntaConTodasOpcionesCorrectas(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    //cambiar tieneOpcionesNecesarias por tieneCantidadDeOpcionesNecesarias
    protected boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador) {
        int cantidadOpcionesCorrectas = this.getOpcionesCorrectas().size();
        int cantidadOpcionesCorrectasJugador = opcionesJugador.size();
        return cantidadOpcionesCorrectas == cantidadOpcionesCorrectasJugador;
    }
}
