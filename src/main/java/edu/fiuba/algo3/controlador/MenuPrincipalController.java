package edu.fiuba.algo3.controlador;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MenuPrincipalController {
	@FXML
	public AnchorPane lienzoDePantallas;
	@FXML
	public Button botonNuevaPartida;
	@FXML
	public Button botonCrearPregunta;
	@FXML
	public Button botonSalir;
	
	private Stage myStage;
	
	// Event Listener on Button[#botonNuevaPartida].onMouseClicked
	@FXML
	public void botonNuevaPartidaActivado(MouseEvent event) {
		invocarPantallaCreacionDeJugadores();
	}
	
	@FXML
    public void botonSalirActivado(MouseEvent event) {
		myStage.close();
    }
	
	public void inicializar() {
		this.myStage = (Stage) this.lienzoDePantallas.getScene().getWindow();
	}
	
	private void invocarPantallaCreacionDeJugadores() {
		try{
            URL url = getClass().getResource("/Vistas/MenuCrearJugador.fxml");
            Parent root = FXMLLoader.load(url); //se carga la vista
            Scene scene = new Scene(root);
            myStage.setScene(scene);
            myStage.show();
		} 
		catch (IOException ex) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage()); //Tambien puedo poner mi mensaje aca
            alert.showAndWait();
	
		}
	}
}
