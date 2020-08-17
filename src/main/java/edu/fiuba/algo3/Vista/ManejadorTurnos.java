package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ManejadorTurnos {
    AsignadorPuntos asignador;
    Partida partida;
    Stage stage;
    Pregunta pregunta;
    Queue<Jugador> jugadores;


    public ManejadorTurnos(Partida partida, Stage stage) {
        this.asignador = new AsignadorPuntos();
        this.partida = partida;
        this.stage = stage;
    }

    public void inicializar(){
        this.pregunta = partida.obtenerSiguientePregunta();
        this.jugadores = new LinkedList<>(partida.getJugadores());
    }

    public void siguienteTurno(){
        if(pregunta!=null) {
            ContenedorTurno turnoActual = new ContenedorTurno(jugadores.poll(), pregunta, stage, this);
            stage.setScene(new Scene(turnoActual, 500, 500));
        }
        else{
            Scene finDejuego = new Scene(new VBox(new Text("el juego ha terminado")),500,500);
            stage.setScene(finDejuego);
        }
    }
    public void recargar(){
        this.inicializar();
    }
}
