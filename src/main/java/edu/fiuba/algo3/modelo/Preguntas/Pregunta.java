package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.ArrayList;

public abstract class Pregunta {
    private String consigna;
    protected ArrayList<Opcion> opciones ;

    public Pregunta(String consigna, ArrayList<Opcion> opciones) {
        this.consigna = consigna;
        this.opciones = opciones;
    }

    public String getConsigna() {
        return consigna;
    }

    public void setConsigna(String consigna) {
        this.consigna = consigna;
    }

    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Opcion> opcionesJugador );
    protected  abstract  boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador );

    public  int evaluarOpcionesElegidas(ArrayList<Opcion> opcionesJugador){
        if(opcionesJugador.isEmpty() || !tieneCantidadDeOpcionesNecesarias(opcionesJugador))
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

    public ArrayList<Opcion> getOpcionesCorrectas () {
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        for (Opcion opcion: opciones) {
            if(opcion.calcularPuntosAdicionales()==1)
                opcionesCorrectas.add(opcion);
        }
        return opcionesCorrectas;
    }

    //Intentar cambiar con algun metodo de stream
    protected boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesJugador) {
        for (Opcion unaOpcion : opcionesJugador) {
            if (unaOpcion.calcularPuntosAdicionales() == 0) {
                return true;
            }
        }
        return false;
    }
}
