package edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalizable extends Pregunta {
    public PreguntaVerdaderoFalsoPenalizable(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList<ArrayList<Opcion>> listaDeListasDeOpcionesCorrectas) {
        super(consigna, opcionesApresentar, listaDeListasDeOpcionesCorrectas);
    }

    @Override
    public int evaluarOpcionesElegidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElegidas) {
        boolean todoOk = true;
        for (ArrayList<Opcion> opcionesJugador : listaDeListaDeOpcionesElegidas) {
            int indice = 0;
            ArrayList<Opcion> opcionesCorrectas = this.listaDeListasDeOpcionesCorrectas.get(indice);
            if (!tieneOpcionesNecesarias(opcionesJugador, opcionesCorrectas))
                return 0;
            for (Opcion unaOpcionElejida : opcionesJugador) {
                if (!opcionesCorrectas.contains(unaOpcionElejida)) {
                    todoOk = false;
                }
            }
            indice++;
        }
        return (todoOk) ? 1 : -1;
    }
}
