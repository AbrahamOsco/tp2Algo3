package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialSinIncorrectos extends PreguntaCriterioParcial{

    public PreguntaPuntajeParcialSinIncorrectos(String consigna, ArrayList<Opcion> opciones) {
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Opcion unaOpcion: opcionesJugador){
            if(!unaOpcion.esCorrecta()){
                return 0;
            }
            puntajeARetornar ++;
        }
        return puntajeARetornar;
    }
}
