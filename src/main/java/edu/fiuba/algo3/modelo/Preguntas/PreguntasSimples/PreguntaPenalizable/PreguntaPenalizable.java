package edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaPenalizable;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaSimple;

import java.util.ArrayList;

public class PreguntaPenalizable extends PreguntaSimple {
    public PreguntaPenalizable(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    protected boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        return true;
    }

    @Override
    public int obtenerPuntaje(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {

        int puntosARetornar = 0;
        //if(cumpleCriterios)
        for (Opcion unaOpcionElejida : opcionesElejidas) {
            if(!opcionesCorrectas.contains(unaOpcionElejida)){
                puntosARetornar--;
            }
            else puntosARetornar++;
        }
        return puntosARetornar;
    }
}
