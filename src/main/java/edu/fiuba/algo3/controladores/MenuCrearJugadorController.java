package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.control.ControladorPrimario;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class MenuCrearJugadorController extends ControladorPrimario{
	@FXML
	public TextField entradaDeTexto;
	@FXML
	public Button botonOK;
	@FXML
	public Button botonIniciarPartida;
	@FXML
	public Label areaDeTexto;

	// Event Listener on Button[#botonOK].onMouseClicked
	@FXML
	public void botonOkActivado(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#botonIniciarPartida].onMouseClicked
	@FXML
	public void botonNuevaPartidaActivado(MouseEvent event) {
		// TODO Autogenerated
	}
}
