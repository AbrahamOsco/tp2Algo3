package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PantallaMChoiceController extends ControladorSecundario{
	@FXML
	public AnchorPane panelBase;
	@FXML
	public Label panelDescripcion;
	@FXML
	public Button botonMultiplicadorX2;
	@FXML
	public Button botonMultiplicadorX3;
	@FXML
	public Button botonExclusividad;
	@FXML
	public Button botonSiguiente;
	@FXML
	public Label nombreJugador;
	@FXML
	public Button botonOpcion3;
	@FXML
	public Button botonOpcion2;
	@FXML
	public Button botonOpcion4;
	@FXML
	public Button botonOpcion1;
	@FXML
	public Button botonOpcion5;
	@FXML
	public Label tipoPregunta;
	
	 @FXML
	public void botonNextActivado(MouseEvent event) {
		 //GameLauncher unLanzador = new GameLauncher();
		// unLanzador.iniciar(myStage, miJuego, unBuscador.buscarRutaDePregunta(this.miJuego.obtenerPreguntaActiva()));
	}

}
