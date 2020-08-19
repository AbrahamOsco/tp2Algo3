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
		 String resultados = "";
		 
		 for(String unResultado : miJuego.obtenerPuntajeFinal()) {
			resultados += (unResultado + "\n");
		 }
		 
		 labelPuntuaciones.setText(resultados);
	 }

	 @FXML
	 public void botonVolverAlMenuActivado(MouseEvent event) {
		 GameLauncher unLanzador = new GameLauncher();
	        unLanzador.iniciar(this.myStage,"/Vistas/Menu/MenuPrincipal.fxml");
	 }
}
