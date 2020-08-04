package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.modificador.ModificadorIndividual;
import edu.fiuba.algo3.modelo.modificador.NuloIndividual;

import java.util.ArrayList;

public class Respuesta {

    private Jugador jugador;
    private int puntajeParcial;
    private ModificadorIndividual modificadorActivo;
    private ArrayList<ArrayList<Opcion>> opciones;

    public Respuesta (Jugador unJugador, ArrayList<ArrayList<Opcion>> opciones) {
        this.jugador = unJugador;
        this.puntajeParcial = 0;
        this.modificadorActivo = new NuloIndividual();
        this.opciones = opciones;
    }

    /*public Respuesta (Jugador unJugador, ArrayList<Evaluable> unasOpciones, int unFactor) {
        this.jugador = unJugador;
        this.puntajeParcial = 0;
        this.modificadorActivo = new Multiplicador(unFactor);
        this.opciones = unasOpciones;
    }*/

    public void setPuntajeParcial (int unPuntaje) { this.puntajeParcial = unPuntaje; }
    public Jugador getJugador () { return this.jugador; }

    public ModificadorIndividual getModificadorActivo() {
        return modificadorActivo;
    }

    public ArrayList<ArrayList<Opcion>> getOpciones() {
        return opciones;
    }

    public int getPuntajeParcial () { return this.puntajeParcial; }
    public ModificadorIndividual getModificadorIndividual () { return this.modificadorActivo; }
    public void aplicarPuntaje () { this.jugador.modificarPuntaje(this.puntajeParcial); }

}
