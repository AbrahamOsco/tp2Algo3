package edu.fiuba.algo3.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorBase extends ControladorSecundario {
	
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
    public Label tipoPregunta;

    
    @Override
	public void postInicio() {

    	this.tipoPregunta.setText(this.miJuego.obtenerPreguntaActiva().getIdentificador());
    	this.panelDescripcion.setText(this.miJuego.obtenerPreguntaActiva().getConsigna());
    	this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
	}
    
    @FXML
    public void activarExclusividad(MouseEvent event) {

    }

    @FXML
    public void activarMultiplicadorX2(MouseEvent event) {

    }

    @FXML
    public void activarMultiplicadorX3(MouseEvent event) {

    }

    @FXML
    public void siguienteActivado(MouseEvent event) {
    	
    	if(this.miJuego.sinJugadores()) {
    		if(this.miJuego.sinPreguntas()) {
    			//lanzo pantalla fin juego
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