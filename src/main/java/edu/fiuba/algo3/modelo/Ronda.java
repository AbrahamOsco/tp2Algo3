package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.modificador.ModificadorGlobal;

import java.util.ArrayList;

public class Ronda {

    private Pregunta pregunta;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<Integer> puntajesDeEstaRonda;
    private ModificadorGlobal unModificadorGlobal;

    public Ronda(Pregunta unaPregunta, ArrayList<Jugador> nuevosJugadores) {

        this.pregunta = unaPregunta;
        this.jugadores = nuevosJugadores;

    }

    public void comenzarRonda() {

        for (int i = 0; i < this.jugadores.size(); i++) {

            Turno unTurno = new Turno(this.jugadores.get(i));

            Respuesta unaRespuesta = unTurno.correrTurno(this.pregunta);

            this.pregunta.evaluarRespuesta(unaRespuesta);

            this.respuestas.add(unaRespuesta);
        }

    }

    public void terminarRonda() {

        AsignadorPuntos asignadorPuntos = AsignadorPuntos new;

        asignadorPuntos.asignarPuntajes(this.respuestas);

    }

}