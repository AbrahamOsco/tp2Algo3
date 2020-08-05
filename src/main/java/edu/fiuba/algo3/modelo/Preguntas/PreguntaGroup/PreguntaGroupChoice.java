package edu.fiuba.algo3.modelo.Preguntas.PreguntaGroup;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta {
    public PreguntaGroupChoice(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    public int evaluarOpcionesElegidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElegidas) {
        boolean todoOk = true;
        if(listaDeListaDeOpcionesElegidas.isEmpty())
            return 0;
        int indice = 0;
        for(ArrayList<Opcion> opcionesJugador: listaDeListaDeOpcionesElegidas){
            ArrayList<Opcion> opcionesCorrectasUnGrupo = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if(!opcionesCumplenCriterios(opcionesCorrectasUnGrupo, opcionesJugador))
                todoOk = false;
            indice++;
        }
        return ( todoOk ) ?  1 : 0 ;
    }

    protected boolean opcionesCumplenCriterios(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas) {
        boolean retorno = tieneLaMismaCantidadQueOpcionesCorrectas(opcionesCorrectas,opcionesElejidas) && !tieneAlgunaOpcionIncorrecta(opcionesCorrectas,opcionesElejidas);
        return retorno;
    }
    private boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas){
        boolean retorno = false;
        for(Opcion unaOpcionElejida: opcionesElejidas){
            if(!opcionesCorrectas.contains(unaOpcionElejida))
                retorno = true;
        }
        return retorno;
    }
    private boolean tieneLaMismaCantidadQueOpcionesCorrectas(ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesElejidas){
        return opcionesCorrectas.size() == opcionesElejidas.size();
    }

}

