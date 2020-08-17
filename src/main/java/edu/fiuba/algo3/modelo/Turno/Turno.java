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
     * PRE: unaPregunta es una Pregunta válida.
     *      unJugador es un Jugador válido.
     * POS: Crea un Turno con unaPregunta y unJugador.
     */
    public Turno (Pregunta unaPregunta, Jugador unJugador) {
        this.pregunta = unaPregunta;
        this.jugador = unJugador;
        multiplicadorActivo = new MultiplicadorX1();
        opcionesElejidas = new ArrayList<>();
    }

    //PRE: multiplicadorActivo es un ModificadorMultiplicador válido.
    //POS: Recibe y activa un ModificadorMultiplicador.
    //Controlador sera el encargado de crear el Multiplicador y pasarselo
    public void setMultiplicadorActivo(ModificadorMultiplicador multiplicadorActivo) {
        this.multiplicadorActivo = multiplicadorActivo;
    }

    //PRE: opcionesElejidas es un ArrayList<Opcion> válido.
    //POS: Carga el atributo opcionesElejidas con las opiones recibidas.
    public void setOpcionesElejidas(ArrayList<Opcion> opcionesElejidas) {
        this.opcionesElejidas = opcionesElejidas;
    }

    //PRE: -
    //POS: Calcula y devuelve el puntaje que jugador recibe por responder la pregunta.
    public int obtenerPuntajeParcial(){
        return multiplicadorActivo.aplicarModificador(this.pregunta.evaluarOpcionesElegidas(this.opcionesElejidas));
    }

    //PRE: unPuntaje es un int válido.
    //POS: Avisa a jugador que modifique su puntaje con el puntaje obtenido durante el propio Turno.
    public void asignarPuntajeFinal(int unPuntaje){
        jugador.modificarPuntaje(unPuntaje);
    }

}
