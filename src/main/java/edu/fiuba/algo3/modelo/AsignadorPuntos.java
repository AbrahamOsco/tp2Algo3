package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Evaluable.*;
import edu.fiuba.algo3.modelo.modificador.ModificadorGlobal;

import java.util.ArrayList;

public class AsignadorPuntos {

    public void asignarPuntajes (ArrayList<Respuesta> respuestas, ModificadorGlobal unModificadorGlobal) {

        aplicarModificadoresGlobales(respuestas, unModificadorGlobal);
        aplicarModificadoresIndividuales(respuestas);

        for (int i = 0; i < respuestas.size(); i++) {

            respuestas.get(i).aplicarPuntaje();

        }

    }

    private void aplicarModificadoresGlobales (ArrayList<Respuesta> respuestas, ModificadorGlobal unModificadorGlobal) {

        unModificadorGlobal.aplicarModificador(respuestas);

    }

    private void aplicarModificadoresIndividuales (ArrayList<Respuesta> respuestas) {

        /*for (int i = 0; i < respuestas.size(); i++) {

            Respuesta unaRespuesta = respuestas.get(i);
            respuestas.get(i).getModificadorIndividual().aplicarModificador(unaRespuesta);

        }*/

    }

}
