package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.control.ControladorPrimario;
import edu.fiuba.algo3.control.GameLauncher;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controlador extends ControladorPrimario{
    private  int contador = 0;
    @FXML
    public TextField fldContador;

    @FXML
    public void contar(ActionEvent event) {
      
    	contador ++;
        fldContador.setText(String.valueOf(contador)); 
        GameLauncher unLanzador = new GameLauncher();
        Juego unJuego = new Juego();
        unLanzador.iniciar(this.myStage, unJuego, "/Vistas/Escena2.fxml");
    }

}