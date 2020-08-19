package edu.fiuba.algo3.Vista.Contenedores;

import edu.fiuba.algo3.Controladores.GuardarJugadorEventHandler;
import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorCreacionJugadores extends VBox {
    Partida partida;
    ManejadorTurnos manejador;
    Stage stage;

    public ContenedorCreacionJugadores(Partida partida, Stage stage, ManejadorTurnos manejador) {
        this.partida = partida;
        this.manejador = manejador;
        this.stage = stage;

        Text texto = new Text("Ingrese su nombre");
        TextField cuadroDeNombre = new TextField();
        cuadroDeNombre.requestFocus();

        Button botonAceptar = new Button("Aceptar");
        GuardarJugadorEventHandler eventoGuardarJugador = new GuardarJugadorEventHandler(partida,cuadroDeNombre, stage, manejador);
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
