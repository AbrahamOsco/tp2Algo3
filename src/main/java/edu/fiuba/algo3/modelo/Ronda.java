package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {

    private Pregunta pregunta;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<int> puntajesDeEstaRonda;
    private ModificadorGlobal unModificadorGlobal;

    public Ronda(Pregunta unaPregunta, ArrayList<Jugador> nuevosJugadores) {

        this.pregunta = unaPregunta;
        this.jugadores = nuevosJugadores;

    }

    public void comenzarRonda() {

        for (int i = 0; i < this.jugadores.size(); i++) {

            Turno unTurno = Turno new(this.jugadores.get(i));

            Respuesta unaRespuesta = unTurno.correrTurno(this.pregunta);

            this.pregunta.evaluarOpciones(unaRespuesta);

            this.respuestas.add(unaRespuesta);
        }

    }

    public void terminarRonda() {

        AsignadorPuntos asignadorPuntos = AsignadorPuntos new;

        asignadorPuntos.asignarPuntaje(this.respuestas);

    }

}
