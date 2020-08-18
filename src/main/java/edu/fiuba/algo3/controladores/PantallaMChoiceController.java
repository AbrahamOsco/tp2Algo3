package edu.fiuba.algo3.controladores;

import java.util.List;

import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    public Pane contenedorBotones;
	
	
	
	
	@Override
	public void postInicio() {

    	this.tipoPregunta.setText(this.miJuego.obtenerPreguntaActiva().getIdentificador());
    	this.panelDescripcion.setText(this.miJuego.obtenerPreguntaActiva().getConsigna());
    	this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
    	this.inicializarBotones();
	}
	
	public void inicializarBotones() {
		
		List<Opcion> listaOpciones = this.miJuego.obtenerPreguntaActiva().getOpciones();
		int contador = 0;
		for(Opcion unaOpcion : listaOpciones) {
			
			Button unBoton = (Button) contenedorBotones.getChildren().get(contador);
			unBoton.setVisible(true);
			unBoton.setText(unaOpcion.getDescripcion());
			contador ++;
		}
		
		
	}
	
	 @FXML
	public void siguienteActivado(MouseEvent event) {
			
		 if(this.miJuego.sinJugadores()) {
			 if(this.miJuego.sinPreguntas()) {
	    			
				 GameLauncher unLanzador = new GameLauncher();
	    		 unLanzador.iniciar(myStage, miJuego, "/Vistas/Pantallas/PantallaFinPartida.fxml");
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
