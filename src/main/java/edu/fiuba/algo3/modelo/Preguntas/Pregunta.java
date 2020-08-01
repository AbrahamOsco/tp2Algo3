package edu.fiuba.algo3.modelo.Preguntas;

import java.util.ArrayList;

public abstract class Pregunta {
    private String consigna;
    private  ArrayList <Opcion> opciones ;

    public String getConsigna() {
        return consigna;
    }

    public void setConsigna(String consigna) {
        this.consigna = consigna;
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }
    protected boolean jugadorUsoTodasLasOpciones(ArrayList<Opcion> opcionesJugador){
        return opcionesJugador.lenght() == this.opciones.lenght();
    }



    protected  abstract  int obtenerPuntaje(ArrayList<Opcion>opcionesJugador);

    public  int evaluarRespuesta(Respuesta unaRespuesta){
        ArrayList<Opcion>opcionesJugador = unaRespuesta.getOpcionesElejidas();
        if(opcionesJugador.isEmpty())
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

}
