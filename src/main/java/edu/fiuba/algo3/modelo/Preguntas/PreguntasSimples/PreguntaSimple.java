package edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public  abstract class PreguntaSimple extends Pregunta {
    public PreguntaSimple(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    protected abstract boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas);
    public  abstract int obtenerPuntaje(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas);

    public  int evaluarOpcionesElegidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElegidas){
        ArrayList<Opcion> opcionesCorrectas = this.listaDeListasDeOpcionesCorrectas.get(0);
        ArrayList<Opcion> opcionesElejidas = listaDeListaDeOpcionesElegidas.get(0);
        if(opcionesElejidas.isEmpty())
            return 0;
        int puntajeAretornar = 0;
        puntajeAretornar += obtenerPuntaje(opcionesCorrectas,opcionesElejidas);
        return puntajeAretornar;
    }

}
