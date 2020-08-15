package edu.fiuba.algo3.controlador;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MenuCrearJugadorController {

    @FXML
    public TextField entradaDeTexto;

    @FXML
    public Button botonOK;

    @FXML
    public Button botonIniciarPartida;

    @FXML
    public Label areaDeTexto;
    
    private List<String> jugadores;
    
    private int contadorJugadores;
    
    
    public MenuCrearJugadorController() {
    	jugadores = new ArrayList<>();
    	contadorJugadores = 1;
    }
    
    public List<String> getJugadores(){
    	return jugadores;
    }
    
    @FXML
    public void botonNuevaPartidaActivado(MouseEvent event) {
    	
    }

    @FXML
    public void botonOkActivado(MouseEvent event) {
    	
    	contadorJugadores++;
    	jugadores.add(entradaDeTexto.getText());
    	areaDeTexto.setText("Elija un nombre para el jugador " + contadorJugadores);
    	entradaDeTexto.setText(null);

    }

}
