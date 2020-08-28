package edu.fiuba.algo3.controladores;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorSecundario extends ControladorPrimario {
	
	protected ManejadorDePartida miJuego;
	private Scene myParentScene; //renombrar a escenaPadre?
	

	public void setearElementos(Stage unEscenario, ManejadorDePartida unJuego, Scene escenaAnterior) {
		super.setearElementos(unEscenario);
		this.miJuego = unJuego;
		this.myParentScene = escenaAnterior;
		this.postInicio();
	}
	
	public void cerrarEstaEscena() { //CAMBIAR el nombre del metodo
		if(myParentScene != null) {
			this.myStage.setScene(myParentScene);
		}
	}
	
	public void postInicio(){
		//TODO reimplementar para cada hijo que lo necesite
	}
}
