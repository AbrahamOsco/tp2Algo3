package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;

public class PantallaGroupChoiceController extends ControladorSecundario{
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
	public Pane panelRespuesta1;
	@FXML
	public Pane panelRespuesta2;
	@FXML
	public Pane panelRespuesta3;
	@FXML
	public Pane panelRespuesta4;
	@FXML
	public Pane panelRespuesta5;
	@FXML
	public Pane panelRespuesta6;
	@FXML
	public Label tipoPregunta;

	@Override
	public void postInicio() {

    	this.tipoPregunta.setText(this.miJuego.obtenerPreguntaActiva().getIdentificador());
    	this.panelDescripcion.setText(this.miJuego.obtenerPreguntaActiva().getConsigna());
    	this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
	}
	
	 @FXML
	public void siguienteActivado(MouseEvent event) {
			
		 if(this.miJuego.sinJugadores()) {
			 if(this.miJuego.sinPreguntas()) {
	    			
				 GameLauncher unLanzador = new GameLauncher();
	    		 unLanzador.iniciar(myStage, miJuego, "/Vistas/Pantalla/PantallaFinPartida.fxml");
	    	 }
	    	 else {
	    			
	    		 this.miJuego.siguienteRonda();
	    		 BuscadorRutas unBuscador = new BuscadorRutas();
	    		 GameLauncher unLanzador = new GameLauncher();
	    		 unLanzador.iniciar(myStage, miJuego, unBuscador.buscarRutaDePregunta(this.miJuego.obtenerPreguntaActiva()));
	    	 }
	      }
	      else
	      {
	    	  this.miJuego.siguienteTurno();
	    	  this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
	      }
	}
}
