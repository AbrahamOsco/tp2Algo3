package edu.fiuba.algo3.control;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorPrimario {
	
	protected Stage myStage;
	
	protected Scene myScene;
	
	
	public void inicializar (Stage unEscenario) {
		
		this.myStage = unEscenario;
		this.myScene = unEscenario.getScene();
	}
	
	protected void mostrarEscenaPorDefecto() {
		
		myStage.setScene(myScene);
		myStage.show();
		
	}
	

}
