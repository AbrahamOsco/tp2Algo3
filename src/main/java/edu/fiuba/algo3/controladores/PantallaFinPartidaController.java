package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.control.ControladorSecundario;
import edu.fiuba.algo3.control.GameLauncher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PantallaFinPartidaController extends ControladorSecundario{

	 @FXML
	 public Label labelPuntuaciones;

	 @FXML
	 public Label labelResultado;

	 @FXML
	 public Label labelGanador;
	 
	 @Override
	 public void postInicio() {
		 
		 this.labelGanador.setText(this.miJuego.obtenerPuntajeFinal().get(0));
		 
		 if(esEmpate()) {
			 
			 this.labelResultado.setText("El resultado es:");
			 this.labelGanador.setText("Es un empate!!");
		 }
		 
		 String resultados = "";
		 
		 for(String unResultado : miJuego.obtenerPuntajeFinal()) {
			resultados += (unResultado + "\n");
		 }
		 
		 labelPuntuaciones.setText(resultados);
	 }
	 
	 private boolean esEmpate() {
		 
		 String[] puntaje1 = this.miJuego.obtenerPuntajeFinal().get(0).split(" ");
		 String[] puntaje2 = this.miJuego.obtenerPuntajeFinal().get(1).split(" ");
		 
		 return ((puntaje1[puntaje1.length - 1].compareTo(puntaje2[puntaje2.length - 1]) == 0));
	 }

	 @FXML
	 public void botonVolverAlMenuActivado(MouseEvent event) {
		 GameLauncher unLanzador = new GameLauncher();
	        unLanzador.iniciar(this.myStage,"/Vistas/Menu/MenuPrincipal.fxml");
	 }
}
