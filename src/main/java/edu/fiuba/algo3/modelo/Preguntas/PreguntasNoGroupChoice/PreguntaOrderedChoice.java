package edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta {


    public PreguntaOrderedChoice(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    /*@Override
    protected int obtenerPuntaje(ArrayList<Opcion> opcionesJugador) {
        return 0;
    }*/

    @Override
    public int evaluarOpcionesElegidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElegidas) {
        ArrayList<ArrayList <Opcion> > listaDeListaDeOpcionesJugador = listaDeListaDeOpcionesElegidas.getOpciones();
        boolean todoOk = true;
        for(ArrayList<Opcion> opcionesJugador:  listaDeListaDeOpcionesJugador){
            int indice = 0;
            ArrayList<Opcion> opcionesCorrectas = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if(!tieneOpcionesNecesarias(opcionesJugador,opcionesCorrectas))
                return 0;
            for(int j = 0; j < opcionesJugador.size(); j++ ){
                if(!opcionesJugador.get(j).equals(opcionesCorrectas.get(j)))
                    todoOk = false;
            }
            indice++;
        }
        return (todoOk) ? 1 : 0;
    }
}
