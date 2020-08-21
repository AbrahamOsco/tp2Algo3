package edu.fiuba.algo3.controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.controladores.HerramientaParaControladores.GameLauncher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.input.MouseEvent;

public class MenuPrincipalController extends ControladorPrimario implements Initializable{
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
        final String NOMBRE_ARCHIVO = "src/main/resources/Audio/MusicaNoPirateada.mp3";
        File archivo = new File(NOMBRE_ARCHIVO);
        
        Media audio = new Media(archivo.toURI().toString());
        
        MediaPlayer reproductor = new MediaPlayer(audio);
        
        reproductor.setCycleCount(reproductor.INDEFINITE);
        reproductor.play();
	}
}
