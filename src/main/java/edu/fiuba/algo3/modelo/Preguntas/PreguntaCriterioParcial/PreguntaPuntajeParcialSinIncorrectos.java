package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialSinIncorrectos extends PreguntaCriterioParcial{

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva PreguntaPuntajeParcialSinIncorrectos con Consigna y opciones.
     */
    public PreguntaPuntajeParcialSinIncorrectos(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Obtiene el puntaje del jugador a partir de las opciones que eligió.
    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        if(this.tieneAlgunaOpcionIncorrecta(opcionesJugador)){
            return 0;
        }
        return this.recibirPuntajeOpciones(opcionesJugador);
    }
}
