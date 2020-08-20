package edu.fiuba.algo3.controladores.HerramientaParaControladores;

import edu.fiuba.algo3.controladores.ControladorPrimario;
import edu.fiuba.algo3.controladores.ControladorSecundario;
import edu.fiuba.algo3.controladores.ManejadorDePartida;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
//renombra al español
public class GameLauncher {

    private <T>T cargarLayout (FXMLLoader cargador){
        T unLayout = null;
        try {
             unLayout = cargador.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return unLayout;
    }
    private void prepararYMostrarEscenario(Stage unEscenario,Pane unPanel){
        Scene scene = new Scene(unPanel); //escena español
        unEscenario.setScene(scene);
        unEscenario.show();
    }

    public void iniciar (Stage unEscenario, String unaRutaDeFXML) {
        FXMLLoader cargador = new FXMLLoader(); // renombrar al español
        cargador.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
        Pane unPanel = cargarLayout(cargador);
        ControladorPrimario controlador = cargador.getController();
        controlador.setearElementos(unEscenario);
        prepararYMostrarEscenario(unEscenario,unPanel);
    }

	
	public void iniciar (Stage unEscenario, ManejadorDePartida unJuego, String unaRutaDeFXML) {
        FXMLLoader cargador = new FXMLLoader();
        cargador.setLocation(GameLauncher.class.getResource(unaRutaDeFXML));
        Pane unPanel = cargarLayout(cargador);

        ControladorSecundario controlador = cargador.getController();
        Scene escenaPrevia = unEscenario.getScene();
        controlador.setearElementos(unEscenario, unJuego, escenaPrevia);

        prepararYMostrarEscenario(unEscenario,unPanel);
	}

}
