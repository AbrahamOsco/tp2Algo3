package edu.fiuba.algo3.controladores;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class PantallaCambioJugadorController extends ControladorSecundario{
	@FXML
	public Label labelNombreJugador;

	@Override
	public void postInicio() {
		
		labelNombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
	}
	
	@FXML
	public void botonComenzarActivado(MouseEvent event) {
		this.myStage.close();
	}
}
