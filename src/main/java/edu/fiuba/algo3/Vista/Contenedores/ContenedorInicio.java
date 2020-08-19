package edu.fiuba.algo3.Vista.Contenedores;

import edu.fiuba.algo3.Controladores.CambioEscenaEventHandler;
import edu.fiuba.algo3.Controladores.CerrarAppEventHandler;
import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorInicio extends StackPane {
    Stage stage;
    Partida partida;
    ManejadorTurnos manejador;

    public ContenedorInicio(Partida partida, Stage stage, ManejadorTurnos manejador) {
        this.stage = stage;
        this.partida = partida;
        this.manejador = manejador;

        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/Vista/Imagenes/pair.png");
        ImageView imagenFondo = new ImageView(imagen);
        imagenFondo.setFitWidth(500);
        imagenFondo.setFitHeight(500);
        Text textoBienvenida = new Text("Bienvenido a AlgoHoot");
        textoBienvenida.setFont(Font.font ("Verdana", 20));
        textoBienvenida.setFill(Color.GREEN);
        textoBienvenida.requestFocus();


        Button botonInicio = new Button("Iniciar");
        botonInicio.setOnAction(new CambioEscenaEventHandler(partida, stage, manejador));
        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(new CerrarAppEventHandler());

        VBox ventanaInicio = new VBox();
        ventanaInicio.setSpacing(20);
        ventanaInicio.setAlignment(Pos.CENTER);
        ventanaInicio.getChildren().addAll(textoBienvenida, botonInicio, botonSalir);

        this.getChildren().addAll(imagenFondo,ventanaInicio);
    }
}
