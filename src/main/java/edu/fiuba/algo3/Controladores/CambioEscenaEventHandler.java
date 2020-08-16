package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ContenedorCreacionJugadores;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambioEscenaEventHandler implements EventHandler<ActionEvent> {
    Stage stagePrincipal;
    Partida partida;

    public CambioEscenaEventHandler(Partida partida, Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorCreacionJugadores creacionJugadores = new ContenedorCreacionJugadores(partida,stagePrincipal);
        Scene proximaEscena = new Scene(creacionJugadores,500,500);
        stagePrincipal.setScene(proximaEscena);
        //this.stagePrincipal.setScene(this.proximaEscena);
    }
}
