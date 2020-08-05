package edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntasClasicas;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaSimple;

import java.util.ArrayList;

public class PreguntaClasica extends PreguntaSimple {

    public PreguntaClasica(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    protected boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        boolean retorno = (tieneLaMismaCantidadQueOpcionesCorrectas(opcionesCorrectas,opcionesElejidas) && !tieneAlgunaOpcionIncorrecta(opcionesCorrectas,opcionesElejidas));
        return retorno;
    }
    private boolean tieneLaMismaCantidadQueOpcionesCorrectas(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas){
        return opcionesCorrectas.size() == opcionesCorrectas.size();
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
        if (!opcionesCumplenCriterios(opcionesCorrectas,opcionesElejidas))
            return 0;
        else
            return 1;
    }
}
