package edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta {
    public PreguntaGroupChoice(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        return 0;
    }

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador, ArrayList<Opcion> opcionesCorrectas) {
        return opcionesJugador.size() == opcionesCorrectas.size();
    }

    @Override
    public int evaluarRespuesta(Respuesta unaRespuesta) {
        ArrayList<ArrayList <Opcion> > listaDeListaDeOpcionesJugador = unaRespuesta.getOpciones();
        boolean todoOk = true;
        if(listaDeListaDeOpcionesJugador.isEmpty())
            return 0;
        int indice = 0;
        for(ArrayList<Opcion> opcionesJugador: listaDeListaDeOpcionesJugador ){

            ArrayList<Opcion> opcionesCorrectasUnGrupo = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if(!tieneOpcionesNecesarias(opcionesJugador, opcionesCorrectasUnGrupo))
                return 0;

            for(Opcion unaOpcionElejida: opcionesJugador){
                if(!opcionesCorrectasUnGrupo.contains(unaOpcionElejida)) {
                    todoOk = false;
                }
            }
            indice++;
        }
        return ( todoOk ) ?  1 : 0 ;
    }
}
