package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Pregunta {
    private String consigna;
    protected ArrayList<Opcion> opciones ;

    /*
     * PRE: Consigna es un String válido.
     *     opciones es un ArrayList<Opcion> válido.
     *     opciones no es vacío (debatir si amerita Exception).
     * POS: Crea una nueva Pregunta con Consigna y opciones.
     */
    public Pregunta(String consigna, ArrayList<Opcion> opciones) {
        this.consigna = consigna;
        this.opciones = opciones;
    }

    //PRE: -
    //POS: Devuelve consigna.
    public String getConsigna() {
        return consigna;
    }

    //PRE: -
    //POS: Devuelve opciones.
    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Opcion> opcionesJugador );
    protected  abstract  boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador );

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Evalua opcionesJugador, devolviendo el puntaje acorde a lo estipulado por obtenerPuntaje.
    public int evaluarOpcionesElegidas(ArrayList<Opcion> opcionesJugador){
        if(opcionesJugador.isEmpty() || !tieneCantidadDeOpcionesNecesarias(opcionesJugador))
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

    //PRE: -
    //POS: Devuelve las opcionesCorrectas de la pregunta en formato ArrayList<Opcion>.
    public ArrayList<Opcion> getOpcionesCorrectas () {
        return opciones.stream().filter(o -> o.calcularPuntosAdicionales() == 1)
                .collect(Collectors.toCollection(ArrayList<Opcion>:: new));

    }

    //PRE: opcionesJugador es un ArrayList<Opcion> válido.
    //POS: Devuelve un bool que es verdadero si al menos una de las opciones en opcionesJugador es incorrecta.
    protected boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesJugador) {
        return opcionesJugador.stream().anyMatch(o -> o.calcularPuntosAdicionales() <= 0);
    }
}
