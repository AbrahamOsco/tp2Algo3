package edu.fiuba.algo3.controladores;


import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import edu.fiuba.algo3.control.InicializadorOpciones;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControladorPantallaJuego extends ControladorSecundario {
	
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
    @FXML
    public Pane panelOpciones;
    
    
    @FXML
    public Button boton1VF;
    @FXML
    public Button boton2VF;
    
    
    private List<Opcion> listaOpciones;
    
    private ArrayList<Opcion> opcionesRespondidas;
    
    
    
    @Override
	public void postInicio() {
    	
    	opcionesRespondidas = new ArrayList<>();
    	listaOpciones = this.miJuego.obtenerPreguntaActiva().getOpciones();
    	this.inicializarTexto();
    	this.inicializarOpciones();
    	this.inicializarModificadores();
	}
    
    private void inicializarTexto() {
    	
    	this.tipoPregunta.setText(this.miJuego.obtenerPreguntaActiva().getIdentificador());
    	this.panelDescripcion.setText(this.miJuego.obtenerPreguntaActiva().getConsigna());
    	this.nombreJugador.setText(this.miJuego.nombreDelJugadorActivo());
    }
    
    private void inicializarModificadores() {
    	
    	if(this.miJuego.preguntaEsPenalizable())
    	{
    		this.botonExclusividad.setDisable(true);
    		if (!this.miJuego.jugadorPuedeUsarModificador("multiplicadorX2")) { this.botonMultiplicadorX2.setDisable(true);}
        	if (!this.miJuego.jugadorPuedeUsarModificador("multiplicadorX3")) { this.botonMultiplicadorX3.setDisable(true);}
    	}
    	else
    	{
    		this.botonMultiplicadorX2.setDisable(true);
    		this.botonMultiplicadorX3.setDisable(true);
    		if (!this.miJuego.jugadorPuedeUsarModificador("puntajeExclusivo")) { this.botonExclusividad.setDisable(true);}
    	}
    }
	
 	private void inicializarOpciones() {
		
		InicializadorOpciones unInicializador = new InicializadorOpciones(this.miJuego.obtenerPreguntaActiva(), panelOpciones);
    	unInicializador.inicializar();
	}
 	
 	private void recolectarChoiceBox() {
 		
 		int contador = 0;
 		
 		for(Opcion unaOpcion : listaOpciones) {
			
			Pane otroPanel = (Pane) panelOpciones.getChildren().get(contador);
			ChoiceBox<Integer> unaCajaDeOpciones = (ChoiceBox<Integer>) otroPanel.getChildren().get(1);
			OpcionPertenencia otraOpcion = new OpcionPertenencia (unaOpcion.getDescripcion(), unaOpcion.getUbicacionCorrecta());
			otraOpcion.setUbicacionActual(unaCajaDeOpciones.getValue());
			System.out.println(otraOpcion.getDescripcion());
			System.out.println(otraOpcion.getUbicacionCorrecta());
			System.out.println(unaCajaDeOpciones.getValue());
			opcionesRespondidas.add(otraOpcion);
			contador ++;
		}
 		
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
    public void boton1VFActivado(MouseEvent event) {
    	
    	this.opcionesRespondidas.add(this.listaOpciones.get(0));
    	this.boton1VF.setDisable(true);
    	this.boton1VF.setStyle("-fx-background-color: #1024EB; ");
    	this.boton2VF.setDisable(true);
    }

    @FXML
    public void boton2VFActivado(MouseEvent event) {
    	
    	this.opcionesRespondidas.add(this.listaOpciones.get(1));
    	this.boton2VF.setDisable(true);
    	this.boton2VF.setStyle("-fx-background-color: #1024EB; ");
    	this.boton1VF.setDisable(true);
    }
    
    
    @FXML
    public void boton1MCActivado(MouseEvent event) {

    	this.opcionesRespondidas.add(this.listaOpciones.get(0));
    	this.panelOpciones.getChildren().get(0).setDisable(true);
    }

    @FXML
    public void boton2MCActivado(MouseEvent event) {

    	this.opcionesRespondidas.add(this.listaOpciones.get(1));
    	this.panelOpciones.getChildren().get(1).setDisable(true);
    }

    @FXML
    public void boton3MCActivado(MouseEvent event) {

    	this.opcionesRespondidas.add(this.listaOpciones.get(2));
    	this.panelOpciones.getChildren().get(2).setDisable(true);
    }

    @FXML
    public void boton4MCActivado(MouseEvent event) {

    	this.opcionesRespondidas.add(this.listaOpciones.get(3));
    	this.panelOpciones.getChildren().get(3).setDisable(true);
    }

    @FXML
    public void boton5MCActivado(MouseEvent event) {

    	this.opcionesRespondidas.add(this.listaOpciones.get(4));
    	this.panelOpciones.getChildren().get(4).setDisable(true);
    }
    
    @FXML
    public void siguienteActivado(MouseEvent event) {
    	
    	if(this.listaOpciones.get(0).getClass().getSimpleName().equals("OpcionPertenencia")) {
    		System.out.println("entre al recolector de chois bocks");
    		this.recolectarChoiceBox();
    	}
    	
    	this.miJuego.recibirUnaRespuesta(opcionesRespondidas);
    	this.miJuego.responder();
    	
    	if(this.miJuego.sinJugadores()) {
    		
    		this.miJuego.finDeRonda();
    		
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
    		this.postInicio();
    	}
    }

}