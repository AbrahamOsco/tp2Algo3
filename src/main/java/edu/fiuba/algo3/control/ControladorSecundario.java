package edu.fiuba.algo3.control;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorSecundario extends ControladorPrimario {
	
	protected Juego miJuego;
	private Scene myParentScene;
	

	public void inicializar (Stage unEscenario, Juego unJuego, Scene escenaAnterior) {
		
		super.inicializar(unEscenario);
		this.miJuego = unJuego;
		this.myParentScene = escenaAnterior;
	}
	
	public void cerrarEstaEscena() {
		
		if(myParentScene != null) {
			this.myStage.setScene(myParentScene);
		}
	}

}
