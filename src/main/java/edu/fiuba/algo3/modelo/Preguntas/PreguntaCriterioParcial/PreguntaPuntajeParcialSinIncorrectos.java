package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialSinIncorrectos extends PreguntaCriterioParcial{

    /*
     * PRE: opciones no es vacio.
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una PreguntaParcialSinIncorrectos con consigna y opciones.
     */
    public PreguntaPuntajeParcialSinIncorrectos(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Devuelve el puntaje a recibir a partir de opcionesJugador.
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(this.tieneAlgunaOpcionIncorrecta(opcionesJugador)){
            return 0;
        }
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
