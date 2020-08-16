package edu.fiuba.algo3.control;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher {
	
	public void iniciar (Stage unEscenario, String unaRutaDeFXML) {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            unEscenario.setScene(scene);
            
            ControladorPrimario controlador = loader.getController();
            controlador.inicializar(unEscenario);
            
            unEscenario.show();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void iniciar (String unaRutaDeFXML) {
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            Stage unEscenario = new Stage();
            unEscenario.setScene(scene);
            
            ControladorPrimario controlador = loader.getController();
            controlador.inicializar(unEscenario);
            
            unEscenario.show();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void iniciar (Juego unJuego, String unaRutaDeFXML) {
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            Stage unEscenario = new Stage();
            unEscenario.setScene(scene);
            
            ControladorSecundario controlador = loader.getController();
            controlador.inicializar(unEscenario, unJuego);
            
            unEscenario.show();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void iniciar (Stage unEscenario, Juego unJuego, String unaRutaDeFXML) {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            unEscenario.setScene(scene);
            
            ControladorSecundario controlador = loader.getController();
            controlador.inicializar(unEscenario, unJuego);
           
            unEscenario.show();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

}
