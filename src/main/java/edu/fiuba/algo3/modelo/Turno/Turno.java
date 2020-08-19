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

    /*
     * PRE: unaPregunta es una instancia válida de Pregunta.
     *      unJugador es una instancia válida de unJugador.
     * POS: Genera una instancia de Turno con unaPregunta y unJugador.
     */
    public Turno (Pregunta unaPregunta, Jugador unJugador) {
        this.pregunta = unaPregunta;
        this.jugador = unJugador;
        multiplicadorActivo = new MultiplicadorX1();
        opcionesElejidas = new ArrayList<>();
    }

    //PRE: multiplicadorActivo es una instancia válida de ModificadorMultiplicador.
    //POS: Carga su multiplicadorActivo con el multiplicador recibidio.
    //Controlador sera el encargado de crear el Multiplicador y pasarselo
    public void setMultiplicadorActivo(ModificadorMultiplicador multiplicadorActivo) {
        this.multiplicadorActivo = multiplicadorActivo;
    }

    //PRE: opcionesElejidas es un ArrayList<Opcion> válido.
    //POS: Carga su opcionesElejidas con las opcionesElejidas recibidas.
    public void setOpcionesElejidas(ArrayList<Opcion> opcionesElejidas) {
        this.opcionesElejidas = opcionesElejidas;
    }

    //PRE: -
    //POS: Calcula el puntaje recibido por responder la pregunta, aplicando los multiplicadores activos.
    public int obtenerPuntajeParcial(){
        return multiplicadorActivo.aplicarModificador(this.pregunta.evaluarOpcionesElegidas(this.opcionesElejidas));
    }

    //PRE: unPuntaje es un int válido.
    //POS: Avisa a modificador que modifique su puntaje con unPuntaje.
    public void asignarPuntajeFinal(int unPuntaje){
        jugador.modificarPuntaje(unPuntaje);
    }

}
