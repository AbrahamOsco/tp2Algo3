package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.controladores.ControladorPrimario;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorSecundario extends ControladorPrimario {
	
	protected Juego miJuego;
	private Scene myParentScene; //renombrar a escenaPadre?
	

	public void setearElementos(Stage unEscenario, Juego unJuego, Scene escenaAnterior) {
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