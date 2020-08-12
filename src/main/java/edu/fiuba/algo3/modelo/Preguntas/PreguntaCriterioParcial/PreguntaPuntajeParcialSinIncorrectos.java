package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialSinIncorrectos extends PreguntaCriterioParcial{

    public PreguntaPuntajeParcialSinIncorrectos(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(this.tieneAlgunaOpcionIncorrecta(opcionesJugador)){
            return 0;
        }
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
