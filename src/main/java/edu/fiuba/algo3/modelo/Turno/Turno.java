package edu.fiuba.algo3.modelo.Turno;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX1;

import java.util.ArrayList;

public class Turno {
    private Jugador jugador;
    private Pregunta pregunta;
    ModificadorMultiplicador multiplicadorActivo;
    ArrayList<Opcion> opcionesElejidas;

    public Turno (Pregunta unaPregunta, Jugador unJugador) {
        this.pregunta = unaPregunta;
        this.jugador = unJugador;
        multiplicadorActivo = new MultiplicadorX1();
        opcionesElejidas = new ArrayList<>();
    }

    //Controlador sera el encargado de crear el Multiplicador y pasarselo
    public void setMultiplicadorActivo(ModificadorMultiplicador multiplicadorActivo) {
        this.multiplicadorActivo = multiplicadorActivo;
    }

    public void setOpcionesElejidas(ArrayList<Opcion> opcionesElejidas) {
        this.opcionesElejidas = opcionesElejidas;
    }

    public int obtenerPuntajeParcial(){
        return multiplicadorActivo.aplicarModificador(this.pregunta.evaluarOpcionesElegidas(this.opcionesElejidas));
    }
    public void asignarPuntajeFinal(int unPuntaje){
        jugador.modificarPuntaje(unPuntaje);
    }

}
