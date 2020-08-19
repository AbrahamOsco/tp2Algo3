package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.Contenedores.ContenedorCreacionJugadores;
import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambioEscenaEventHandler implements EventHandler<ActionEvent> {
    Stage stagePrincipal;
    Partida partida;
    ManejadorTurnos manejador;

    public CambioEscenaEventHandler(Partida partida, Stage stagePrincipal, ManejadorTurnos manejador) {
        this.stagePrincipal = stagePrincipal;
        this.partida = partida;
        this.manejador = manejador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorCreacionJugadores creacionJugadores = new ContenedorCreacionJugadores(partida, stagePrincipal, manejador);
        Scene proximaEscena = new Scene(creacionJugadores,500,500);
        stagePrincipal.setScene(proximaEscena);
    }
}
