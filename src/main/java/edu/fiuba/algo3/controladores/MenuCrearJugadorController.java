package edu.fiuba.algo3.controladores;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class MenuCrearJugadorController extends ControladorSecundario implements Initializable{
	@FXML
	public TextField entradaDeTexto;
	@FXML
	public Button botonOK;
	@FXML
	public Button botonIniciarPartida;
	@FXML
	public Label areaDeTexto;
	
	private int contadorJugadores = 1;
	
	private HashMap<String,Integer> rutasFXML;
	
	
	private void obtenerPantallaParaPregunta(Pregunta unaPregunta) {
		
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*String 
		botonIniciarPartida.setDisable(true);
		rutasFXML = new HashMap<>();
		rutasFXML.put(key, value)*/
	}

	// Event Listener on Button[#botonOK].onMouseClicked
	@FXML
	public void botonOkActivado(MouseEvent event) {
		
		if (!entradaDeTexto.getText().equals("")) {
			
			this.miJuego.cargarJugador(entradaDeTexto.getText());
			entradaDeTexto.clear();
			entradaDeTexto.requestFocus();
			contadorJugadores ++;
			areaDeTexto.setText("Inserte Nombre de Jugador " + contadorJugadores);
		}
		else {
			
			areaDeTexto.setText("Pone el nombre, ahi abajo!");
		}
		
		if (this.miJuego.alcanzoJugadoresMaximos()) {
			
			this.botonOK.setDisable(true);
		}
		
		if(!this.miJuego.alcanzoJugadoresMinimos()) {
			
			this.botonIniciarPartida.setDisable(false);
		}
			
	}
	
	// Event Listener on Button[#botonIniciarPartida].onMouseClicked
	@FXML
	public void botonNuevaPartidaActivado(MouseEvent event) {
		
		this.miJuego.comenzarPartida();
		this.obtenerPantallaParaPregunta(this.miJuego.obtenerPreguntaActiva());
	}


}
