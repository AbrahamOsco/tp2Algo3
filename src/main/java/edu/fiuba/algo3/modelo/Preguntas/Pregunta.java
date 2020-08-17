package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Pregunta {
    private String consigna;
    protected ArrayList<Opcion> opciones ;
    protected  String  identificador;

    /*
     * PRE: opciones no es vacio (amerita Exception).
     *      opciones es un ArrayList<Opcion> válido.
     * POS: Instancia una Pregunta con consigna y opciones.
     */
    public Pregunta(String consigna, ArrayList<Opcion> opciones) {
        this.consigna = consigna;
        this.opciones = opciones;
    }

    //PRE: -
    //POS: Devuelve su consigna.
    public String getConsigna() {
        return consigna;
    }

    //PRE: -
    //POS: Devuelve sus opciones.
    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    protected  abstract  int obtenerPuntaje(ArrayList<Opcion> opcionesJugador );
    protected  abstract  boolean tieneCantidadDeOpcionesNecesarias(ArrayList<Opcion> opcionesJugador );

    //PRE: opcionesJugador es un ArrayList<Jugador> válido.
    //POS: Genera un puntaje a partir de opcionesJugador.
    public int evaluarOpcionesElegidas(ArrayList<Opcion> opcionesJugador){
        if(opcionesJugador.isEmpty() || !tieneCantidadDeOpcionesNecesarias(opcionesJugador))
            return 0;
        return obtenerPuntaje(opcionesJugador);
    }

    //PRE: -
    //POS: Devuelve las opciones correctas.
    public ArrayList<Opcion> getOpcionesCorrectas () {
        return opciones.stream().filter(o -> o.calcularPuntosAdicionales() == 1)
                .collect(Collectors.toCollection(ArrayList<Opcion>:: new));

    }

    /*
     * PRE: opcionesJugador no es vacío (amerita Exception).
     *      opcionesJugador es un ArrayList<Opcion> válido.
     * POS: Determina si alguna de las opciones pasadas es incorrecta.
     */
    protected boolean tieneAlgunaOpcionIncorrecta(ArrayList<Opcion> opcionesJugador) {
        return opcionesJugador.stream().anyMatch(o -> o.calcularPuntosAdicionales() <= 0);
    }

    //PRE: identificadorPregunta es un String válido.
    //POS: Setea identificador con identificadorPregunta.
    public void setIdentificador(String identificadorPregunta){
        this.identificador=identificadorPregunta;
    }

    //PRE: -
    //POS: Devuelve el identificador.
    public String getIdentificador(){
        return identificador;
    }
}
