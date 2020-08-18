package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Contenedores.ContenedorTurno;
import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        /*this.jugadores = new LinkedList<>();
        partida.getJugadores().forEach(j->jugadores.offer(j));*/
        this.asignador = new AsignadorPuntos();
    }

    public void siguienteTurno(){
        if(pregunta!=null) {
            ContenedorTurno turnoActual = new ContenedorTurno(jugadores.poll(), pregunta, stage, this);
            stage.setScene(new Scene(turnoActual, 500, 500));
        }
        else{
            //mover a un contenedor de fin de juego
            Text textoDeFinDeJuego = new Text("El juego ha terminado, estos son los resultados:");

            VBox contenedorFinDeJuego = new VBox();
            contenedorFinDeJuego.getChildren().add(textoDeFinDeJuego);

            List<String > resultados = partida.obtenerResultadoPartida();
            resultados.forEach(o->contenedorFinDeJuego.getChildren().add(new Text(o)));
            contenedorFinDeJuego.setAlignment(Pos.CENTER);
            contenedorFinDeJuego.setSpacing(20);

            Scene finDejuego = new Scene(contenedorFinDeJuego,500,500);
            stage.setScene(finDejuego);
        }
    }
    public void recargar(){
        this.inicializar();
    }
    public void agregarTurnoDeRonda(Turno turno){
        asignador.agregarTurno(turno);
    }
    public void puntuarJugadores(){
        asignador.asignarPuntos();
    }
}
