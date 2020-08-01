package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class AsignadorPuntos {

    public void asignarPuntaje (ArrayList<Respuesta> respuestas) {

        this.modificarPuntajes(respuestas);
        this.entregarPuntajes(respuestas);

    }

    private void entregarPuntajes (ArrayList<Respuesta> respuestas) {

        for (int i = 0; i < respuestas.size(); i++) {

            respuestas.get(i).aplicarPuntaje();

        }

    }

    private void modificarPuntajes (ArrayList<Respuesta> respuestas) {



    }

}
