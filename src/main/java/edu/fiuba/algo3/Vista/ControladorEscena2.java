package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.control.ControladorSecundario;
import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class ControladorEscena2 extends ControladorSecundario{

	// Event Listener on Button.onMouseClicked
	@FXML
	public void botonActivado(MouseEvent event) {
		this.cerrarEstaEscena();
	}
}
