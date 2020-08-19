package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class PantallaFinRondaController extends ControladorSecundario{
	@FXML
	public Label labelPuntuaciones;

	@Override
	public void postInicio() {
		
		String resultados = "";
		 
		 for(String unResultado : miJuego.obtenerPuntajeFinal()) {
			resultados += (unResultado + "\n");
		 }
		 
		 labelPuntuaciones.setText(resultados);
	}
	
	@FXML
	public void botonSiguienteRondaActivado(MouseEvent event) {
		
		this.miJuego.siguienteRonda();
		BuscadorRutas unBuscador = new BuscadorRutas();
		GameLauncher unLanzador = new GameLauncher();
		unLanzador.iniciar(myStage, miJuego, unBuscador.buscarRutaDePregunta(this.miJuego.obtenerPreguntaActiva()));
	}
}
