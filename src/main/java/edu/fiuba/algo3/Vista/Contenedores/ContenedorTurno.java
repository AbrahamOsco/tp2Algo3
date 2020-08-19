package edu.fiuba.algo3.Vista.Contenedores;

import edu.fiuba.algo3.Controladores.TerminarTurnoEventHandle;
import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorTurno extends VBox {
    Partida partida;
    Turno turno;
    Stage stage;

    public ContenedorTurno(Jugador jugador, Pregunta pregunta, Stage stage, ManejadorTurnos manejador) {
        this.turno = new Turno(pregunta, jugador);
        this.stage = stage;

        ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
        turno.setOpcionesElejidas(opcionesElegidas);

        Text nombreJugador = new Text(jugador.getNombre());

        ContenedorPregunta vistaPregunta = new ContenedorPregunta(pregunta, turno, opcionesElegidas);

        Button botonTerminarTurno = new Button("Terminar turno");
        TerminarTurnoEventHandle terminarTurno = new TerminarTurnoEventHandle(stage, partida, manejador, turno);
        botonTerminarTurno.setOnAction(terminarTurno);


        this.getChildren().addAll(nombreJugador, vistaPregunta, botonTerminarTurno);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}
