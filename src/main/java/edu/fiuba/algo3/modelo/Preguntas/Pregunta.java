package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public abstract class Pregunta {
    private String consigna;
    protected  ArrayList <Opcion> opcionesApresentar;
    protected  ArrayList< ArrayList<Opcion> > listaDeListasDeOpcionesCorrectas;

    public Pregunta(String consigna, ArrayList<Opcion> opcionesApresentar, ArrayList< ArrayList<Opcion> > listaDeListasDeOpcionesCorrectas) {
        this.consigna = consigna;
        this.opcionesApresentar = opcionesApresentar;
        this.listaDeListasDeOpcionesCorrectas = listaDeListasDeOpcionesCorrectas;
    }
    public String getConsigna() {
        return consigna;
    }
    public ArrayList<Opcion> getOpcionesApresentar() {
        return this.opcionesApresentar;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Opcion> opcionesJugador );
    protected  abstract  boolean tieneOpcionesNecesarias(ArrayList<Opcion> opcionesJugador, ArrayList<Opcion> opcionesCorrectas );

    public  abstract int evaluarRespuesta(Respuesta unaRespuesta);
    //Solo se utiliza Para los Test
    public ArrayList<ArrayList<Opcion>> getOpcionesCorrectas () {
        return this.listaDeListasDeOpcionesCorrectas;
    }
}
