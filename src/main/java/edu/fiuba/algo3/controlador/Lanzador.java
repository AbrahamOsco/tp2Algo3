package edu.fiuba.algo3.controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class Lanzador extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       
        try{
            URL url = getClass().getResource("/Vistas/MenuPrincipal.fxml");
            Parent root = FXMLLoader.load(url); //se carga la vista
            Scene scene = new Scene(root);
            stage.setTitle("Tutorial01");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}