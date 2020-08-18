package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.control.BuscadorRutas;
import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import edu.fiuba.algo3.control.InicializadorOpciones;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    
    @Override
	public void postInicio() {

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
    
 	@FXML
    public void activarExclusividad(MouseEvent event) {

    }

    @FXML
    public void activarMultiplicadorX2(MouseEvent event) {

    }

    @FXML
    public void activarMultiplicadorX3(MouseEvent event) {

    }
 	
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
    		this.inicializarModificadores();
    	}
    }

}
