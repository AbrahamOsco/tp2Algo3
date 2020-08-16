package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ContenedorTurno;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambioTurnoEventHandler implements EventHandler<ActionEvent> {
    Partida partida;
    Stage stage;
    Pregunta preguntaActual;

    public CambioTurnoEventHandler(Partida partida, Stage stage, Pregunta preguntaActual) {
        this.partida = partida;
        this.stage = stage;
        this.preguntaActual = preguntaActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //ContenedorTurno turnoJugador = new ContenedorTurno();
        //Scene turnoVista = new Scene(turnoJugador,500,500);
    }
}
