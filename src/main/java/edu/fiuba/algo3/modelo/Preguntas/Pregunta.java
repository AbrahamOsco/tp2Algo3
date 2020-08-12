package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Opcion> opcionesJugador );
    protected  abstract  boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador );

    public  int evaluarOpcionesElegidas(ArrayList<Opcion> opcionesJugador){
        if(opcionesJugador.isEmpty() || !tieneCantidadDeOpcionesNecesarias(opcionesJugador))
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

    public ArrayList<Opcion> getOpcionesCorrectas () {
        return opciones.stream().filter(o -> o.calcularPuntosAdicionales() == 1).collect(Collectors.toCollection(ArrayList<Opcion>:: new));

    }

    protected boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesJugador) {
        return opcionesJugador.stream().anyMatch(o -> o.calcularPuntosAdicionales() <= 0);
    }
}
