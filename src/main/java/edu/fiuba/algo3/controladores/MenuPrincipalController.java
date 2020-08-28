package edu.fiuba.algo3.controladores;

import java.io.IOException;

import edu.fiuba.algo3.controladores.HerramientaParaControladores.GameLauncher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;

public class MenuPrincipalController extends ControladorPrimario{
	@FXML
	public Button botonNuevaPartida;
	@FXML
	public Button botonSalir;
	
	private ManejadorDePartida miJuego;

	// Event Listener on Button[#botonNuevaPartida].onMouseClicked
	@FXML
	public void botonNuevaPartidaActivado(MouseEvent event) {
		miJuego = new ManejadorDePartida();
		GameLauncher unLanzador = new GameLauncher();
		
		try {
			miJuego.nuevaPartida();
		} catch (IOException e) { 
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
		}
		
		unLanzador.iniciar(this.myStage, miJuego, "/Vistas/Menu/MenuCrearJugador.fxml");
	}
	// Event Listener on Button[#botonSalir].onMouseClicked
	@FXML
	public void botonSalirActivado(MouseEvent event) {
		this.myStage.close();
	}
}