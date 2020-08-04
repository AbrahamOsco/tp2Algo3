package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX1;

import java.util.ArrayList;

public class Turno {
    private Jugador jugador;
    private Pregunta pregunta;
    ModificadorMultiplicador multiplicadorActivo;
    ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElejidas;

    public Turno (Pregunta unaPregunta,Jugador unJugador) {
        this.pregunta = unaPregunta;
        this.jugador = unJugador;
        multiplicadorActivo = new MultiplicadorX1();
        listaDeListaDeOpcionesElejidas = new ArrayList<>();
    }

    public ModificadorMultiplicador getMultiplicadorActivo() {
        return multiplicadorActivo;
    }

    public void setMultiplicadorActivo(ModificadorMultiplicador multiplicadorActivo) {
        this.multiplicadorActivo = multiplicadorActivo;
    }

    public void setListaDeListaDeOpcionesElejidas(ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesElejidas) {
        this.listaDeListaDeOpcionesElejidas = listaDeListaDeOpcionesElejidas;
    }
    public int obtenerPuntajeParcial(){
        return this.pregunta.evaluarOpcionesElegidas(listaDeListaDeOpcionesElejidas);
    }
    public void asignarPuntajeFinal(int unPuntaje){
        jugador.modificarPuntaje(unPuntaje);
    }
}
