package edu.fiuba.algo3.controladores;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import edu.fiuba.algo3.controladores.HerramientaParaControladores.GameLauncher;

public class Runner extends Application {

    @Override
    public void start(Stage stage) throws IOException {
 
        GameLauncher unLanzador = new GameLauncher();
        unLanzador.iniciar(stage,"/Vistas/Menu/MenuPrincipal.fxml");
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}