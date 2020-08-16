package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambioPregunta implements EventHandler<ActionEvent> {
    Stage stage;
    Scene escena;

    public CambioPregunta(Stage stage, Scene escena) {
        this.stage = stage;
        this.escena = escena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(escena);
    }
}
