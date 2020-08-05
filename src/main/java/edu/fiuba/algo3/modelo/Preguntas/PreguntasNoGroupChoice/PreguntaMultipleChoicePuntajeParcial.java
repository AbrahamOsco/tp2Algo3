package edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class PreguntaMultipleChoicePuntajeParcial extends Pregunta {
    public PreguntaMultipleChoicePuntajeParcial(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }
    @Override
    protected boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador, ArrayList<Opcion> opcionesCorrectas) {
        return !opcionesJugador.isEmpty();
    }
    @Override
    public int evaluarOpcionesElegidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElegidas) {
        boolean todoOk = true;
        int puntosARetornar = 0;
        for(ArrayList<Opcion> opcionesJugador: listaDeListaDeOpcionesElegidas){
            int indice = 0;
            ArrayList<Opcion> opcionesCorrectas = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if(!tieneOpcionesNecesarias(opcionesJugador,opcionesCorrectas))
                return 0;
            for(Opcion unaOpcionElejida: opcionesJugador){
                if(!opcionesCorrectas.contains(unaOpcionElejida)) {
                    todoOk = false;
                }
                puntosARetornar++;
            }
            indice++;
        }
        return ( todoOk ) ?  puntosARetornar : 0 ;
    }
}
