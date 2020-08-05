package edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaPuntajeParcial;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaSimple;

import java.util.ArrayList;

public class PreguntaPuntajeParcial extends PreguntaSimple {
    public PreguntaPuntajeParcial(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    protected boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        return !tieneAlgunaOpcionIncorrecta(opcionesCorrectas,opcionesElejidas);
    }
    private boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas){
        boolean retorno = false;
        for(Opcion unaOpcionElejida: opcionesElejidas){
            if(!opcionesCorrectas.contains(unaOpcionElejida))
                retorno = true;
        }
        return retorno;
    }

    @Override
    public int obtenerPuntaje(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        int puntosARetornar = 0;
        if(!opcionesCumplenCriterios(opcionesCorrectas,opcionesElejidas))
            return 0;
        puntosARetornar = opcionesElejidas.size();
        return puntosARetornar;
    }
}
