package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TerminarTurnoEventHandle implements EventHandler<ActionEvent> {
    Stage stage;
    ManejadorTurnos manejador;
    Partida partida;
    Turno turno;
    static int cont = 1;


    public TerminarTurnoEventHandle(Stage stage, Partida partida, ManejadorTurnos manejador, Turno turno) {
        this.stage = stage;
        this.manejador = manejador;
        this.partida = partida;
        this.turno = turno;
        this.cont++;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        manejador.agregarTurnoDeRonda(turno);
        if(this.cont % 2 == 0) {
            manejador.siguienteTurno();
        }
        else {
            manejador.puntuarJugadores();
            manejador.recargar();
            manejador.siguienteTurno();
        }
    }

}
