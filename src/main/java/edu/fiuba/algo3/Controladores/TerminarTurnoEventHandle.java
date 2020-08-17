package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class TerminarTurnoEventHandle implements EventHandler<ActionEvent> {
    Stage stage;
    ManejadorTurnos manejador;
    Partida partida;
    static int cont = 1;

    public TerminarTurnoEventHandle(Stage stage, Partida partida, ManejadorTurnos manejador) {
        this.stage = stage;
        this.manejador = manejador;
        this.partida = partida;
        this.cont++;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(cont);
        if(this.cont % 2 == 0){
            manejador.siguienteTurno();
            System.out.println(cont);
        }
        else {
            manejador.recargar();
            manejador.siguienteTurno();
        }

    }
}
