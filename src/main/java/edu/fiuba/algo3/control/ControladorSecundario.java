package edu.fiuba.algo3.control;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.stage.Stage;

public class ControladorSecundario extends ControladorPrimario {
	
	protected Juego miJuego;
	

	public void inicializar (Stage unEscenario, Juego unJuego) {
		
		super.inicializar(unEscenario);
		this.miJuego = unJuego;
	}

}
