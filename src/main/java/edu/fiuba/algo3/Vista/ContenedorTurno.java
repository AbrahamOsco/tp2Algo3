package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controladores.CambioEscenaEventHandler;
import edu.fiuba.algo3.Controladores.TerminarTurnoEventHandle;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorTurno extends VBox {
    Partida partida;
    Turno turno;
    Stage stage;

    public ContenedorTurno(Jugador jugador, Pregunta pregunta, Stage stage, ManejadorTurnos manejador) {
        this.turno = new Turno(pregunta, jugador);
        this.stage = stage;

        Text nombreJugador = new Text(jugador.getNombre());
        ContenedorPregunta vistaPregunta = new ContenedorPregunta(pregunta);
        Button botonTerminarTurno = new Button("Terminar turno");
        TerminarTurnoEventHandle terminarTurno = new TerminarTurnoEventHandle(stage, partida, manejador);
        botonTerminarTurno.setOnAction(terminarTurno);
        //CambioEscenaEventHandler volverPrincipio = new CambioEscenaEventHandler(partida,stage);
        //botonTerminarTurno.setOnAction(volverPrincipio);

        this.getChildren().addAll(nombreJugador, vistaPregunta, botonTerminarTurno);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}
