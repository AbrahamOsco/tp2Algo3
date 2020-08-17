package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RondaVista {
    AsignadorPuntos asignador;
    Partida partida;
    Stage stage;

    public RondaVista(AsignadorPuntos asignador, Partida partida, Stage stage) {
        this.asignador = asignador;
        this.partida = partida;
        this.stage = stage;
        Pregunta pregunta = partida.obtenerSiguientePregunta();
        Queue<Jugador> jugadores = new LinkedList<>(partida.getJugadores());
        ContenedorTurno turnoActual = new ContenedorTurno(jugadores.poll(),pregunta,stage);
    }
}
