package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Evaluable.*;
import edu.fiuba.algo3.modelo.modificador.ModificadorIndividual;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.NuloIndividual;

import java.util.ArrayList;

public class Respuesta {

    private Jugador jugador;
    private int puntajeParcial;
    private ModificadorIndividual modificadorActivo;
    private ArrayList<Evaluable> opciones;

    public Respuesta (Jugador unJugador, ArrayList<Evaluable> unasOpciones) {

        this.jugador = unJugador;
        this.puntajeParcial = 0;
        this.modificadorActivo = new NuloIndividual();
        this.opciones = unasOpciones;

    }

    public Respuesta (Jugador unJugador, ArrayList<Evaluable> unasOpciones, int unFactor) {

        this.jugador = unJugador;
        this.puntajeParcial = 0;
        this.modificadorActivo = new Multiplicador(unFactor);
        this.opciones = unasOpciones;

    }

    public void setJugador (Jugador unJugador) { this.jugador = unJugador; }
    public void setOpcionesElegidas (ArrayList<Evaluable> unasOpciones) { this.opciones = unasOpciones; }
    public void setPuntajeParcial (int unPuntaje) { this.puntajeParcial = unPuntaje; }
    public Jugador getJugador () { return this.jugador; }
    public ArrayList<Evaluable> getOpcionesElegidas () { return this.opciones; }
    public int getPuntajeParcial () { return this.puntajeParcial; }
    public ModificadorIndividual getModificadorIndividual () { return this.modificadorActivo; }
    public void aplicarPuntaje () { this.jugador.modificarPuntaje(this.puntajeParcial); }

}
