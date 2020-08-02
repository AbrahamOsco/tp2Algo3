package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;

import java.util.ArrayList;

public abstract class Pregunta {
    private String consigna;
    protected  ArrayList <Evaluable> opciones ;

    public String getConsigna() {
        return consigna;
    }

    public void setConsigna(String consigna) {
        this.consigna = consigna;
    }

    public ArrayList<Evaluable> getOpciones() {
        return this.opciones;
    }

    public void setOpciones(ArrayList<Evaluable> opciones) {
        this.opciones = opciones;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Evaluable>opcionesJugador);

    public  int evaluarRespuesta(Respuesta unaRespuesta){
        ArrayList<Evaluable>opcionesJugador = unaRespuesta.getOpcionesElejidas();
        if(opcionesJugador.isEmpty())
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

}
