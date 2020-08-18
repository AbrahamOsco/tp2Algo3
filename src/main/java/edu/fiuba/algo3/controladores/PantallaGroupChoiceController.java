package edu.fiuba.algo3.controladores;

import java.util.List;

import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import edu.fiuba.algo3.control.InicializadorOpciones;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	@FXML
    public Pane contenedorBotones;

	@Override
	public void postInicio() {

    	this.tipoPregunta.setText(this.miJuego.obtenerPreguntaActiva().getIdentificador());
    	this.panelDescripcion.setText(this.miJuego.obtenerPreguntaActiva().getConsigna());
    	this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
    	InicializadorOpciones unInicializador = new InicializadorOpciones(this.miJuego.obtenerPreguntaActiva(), contenedorBotones);
    	unInicializador.inicializar();
	}
	
	private void inicializarGC() {
		
		List<Opcion> listaOpciones = this.miJuego.obtenerPreguntaActiva().getOpciones();
		int contador = 0;
		for(Opcion unaOpcion : listaOpciones) {
			
			Pane unPanel = (Pane) contenedorBotones.getChildren().get(contador);
			Label unLabel = (Label) unPanel.getChildren().get(0);
			unLabel.setText(unaOpcion.getDescripcion());
			ChoiceBox<Integer> unaCajaDeOpciones = (ChoiceBox<Integer>) unPanel.getChildren().get(1);
			ObservableList<Integer> opcionesGC = FXCollections.observableArrayList(1,2);
			unaCajaDeOpciones.setItems(opcionesGC);
			unPanel.setVisible(true);
			contador ++;
		}
	}
	
	private void inicializarOC() {
		
		List<Opcion> listaOpciones = this.miJuego.obtenerPreguntaActiva().getOpciones();
		int contador = 0;
		for(Opcion unaOpcion : listaOpciones) {
			
			Pane unPanel = (Pane) contenedorBotones.getChildren().get(contador);
			unPanel.setVisible(true);
			contador ++;
		}
	}
	
	private void detectarPregunta() {
		
		if (this.miJuego.obtenerPreguntaActiva().getIdentificador() == "OrderedChoice") {
			
			this.inicializarOC();
		}
		else {
			
			this.inicializarGC();
		}
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
