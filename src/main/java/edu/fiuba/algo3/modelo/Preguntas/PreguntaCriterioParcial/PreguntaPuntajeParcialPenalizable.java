package edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import java.util.ArrayList;

public class PreguntaPuntajeParcialPenalizable extends PreguntaCriterioParcial{

    public PreguntaPuntajeParcialPenalizable(String consigna, ArrayList<Opcion> opciones){
        super(consigna, opciones);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        int puntajeARetornar = 0;
        for(Opcion unaOpcionJugador: opcionesJugador){
            if(unaOpcionJugador.esCorrecta())
                puntajeARetornar ++;
            else
                puntajeARetornar --;
        }
        return puntajeARetornar;
    }
}
