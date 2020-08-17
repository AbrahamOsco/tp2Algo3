package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controladores.GuardarJugadorEventHandler;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorCreacionJugadores extends VBox {
    private Partida partida;

    public ContenedorCreacionJugadores(Partida partida, Stage stage) {
        this.partida = partida;

        Text texto = new Text("Ingrese su nombre");
        TextField cuadroDeNombre = new TextField();
        cuadroDeNombre.requestFocus();

        Button botonAceptar = new Button("Aceptar");
        GuardarJugadorEventHandler eventoGuardarJugador = new GuardarJugadorEventHandler(partida,cuadroDeNombre, stage/*, escena*/);
        botonAceptar.setOnAction(eventoGuardarJugador);


        //ChoiceBox<Integer> numeros = new ChoiceBox<>();
        //numeros.getItems().addAll(1,2,3,4,5);


        HBox contenedorNombreYAceptar = new HBox(cuadroDeNombre, botonAceptar);
        contenedorNombreYAceptar.setAlignment(Pos.CENTER);
        contenedorNombreYAceptar.setSpacing(20);
        this.getChildren().setAll(texto, contenedorNombreYAceptar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}