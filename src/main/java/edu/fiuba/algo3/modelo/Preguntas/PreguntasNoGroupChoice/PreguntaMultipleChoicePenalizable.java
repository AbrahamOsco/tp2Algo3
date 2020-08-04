package edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class PreguntaMultipleChoicePenalizable extends Pregunta {
    public PreguntaMultipleChoicePenalizable(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador, ArrayList<Opcion> opcionesCorrectas) {
        return !opcionesJugador.isEmpty();
    }
    @Override
    public int evaluarRespuesta(Respuesta unaRespuesta) {
        ArrayList<ArrayList <Opcion> > listaDeListaDeOpcionesJugador = unaRespuesta.getOpciones();
        boolean todoOk = true;
        int puntosARetornar = 0;
        for(ArrayList<Opcion> opcionesJugador: listaDeListaDeOpcionesJugador ){
            int indice = 0;
            ArrayList<Opcion> opcionesCorrectas = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if(!tieneOpcionesNecesarias(opcionesJugador,opcionesCorrectas))
                return 0;
            for(Opcion unaOpcionElejida: opcionesJugador){
                if(!opcionesCorrectas.contains(unaOpcionElejida)){
                    puntosARetornar--;
                }
                else puntosARetornar++;
            }
            indice++;
        }
        return puntosARetornar;
    }
}
