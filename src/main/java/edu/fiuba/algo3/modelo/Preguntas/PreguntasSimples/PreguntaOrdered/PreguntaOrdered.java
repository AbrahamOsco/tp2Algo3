package edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaOrdered;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaSimple;

import java.util.ArrayList;

public class PreguntaOrdered extends PreguntaSimple {
    public PreguntaOrdered(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    protected boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        return opcionesCorrectas.equals(opcionesElejidas);
    }

    @Override
    public int obtenerPuntaje(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        boolean todoOk = opcionesCumplenCriterios(opcionesCorrectas,opcionesElejidas);
        return (todoOk) ? 1 : 0;
    }

}
