package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class AsignadorPuntos {

    public void asignarPuntajes (ArrayList<Respuesta> respuestas, modificadorGlobal unModificadorGlobal) {

        aplicarModificadoreGlobales(respuestas, unModificadorGlobal);
        aplicarModificadoresIndividuales(respuestas);

        for (int i = 0; i < respuestas.size(); i++) {

            respuestas.get(i).aplicarPuntaje();

        }

    }

    private void aplicarModificadoreGlobales (ArrayList<Respuesta> respuestas, modificadorGlobal unModificadorGlobal) {

        unModificadorGlobal.aplicarModificador(respuestas);

    }

    private void aplicarModificadoresIndividuales (ArrayList<Respuesta> respuestas) {

        for (int i = 0; i < respuestas.size(); i++) {

            Respuesta unaRespuesta = respuestas.get(i);
            respuestas.get(i).getModificadorIndividual().aplicarModificador(unaRespuesta);

        }

    }

}
