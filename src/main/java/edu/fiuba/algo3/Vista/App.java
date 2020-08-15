package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show()
         */

        /*
        try{
            URL url = getClass().getResource("/Vistas/VistaInicio.fxml");
            Parent root = FXMLLoader.load(url); //se carga la vista
            Scene scene = new Scene(root);
            stage.setTitle("AlgoHoot");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(new OpcionCorrecta("10"));
        opcionesAPresentar.add(new OpcionCorrecta("15"));
        opcionesAPresentar.add(new OpcionCorrecta("5"));
        opcionesAPresentar.add(new OpcionCorrecta("20"));
        Pregunta multipleChoice = new PreguntaPuntajeParcialSinIncorrectos("numeros?",opcionesAPresentar);

        stage.setScene(this.preguntaMultipleChoiceEscena(multipleChoice));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Scene preguntaMultipleChoiceEscena(Pregunta pregunta){
        Text consigna = new Text(pregunta.getConsigna());
        ArrayList<Opcion> opciones = pregunta.getOpciones();

        VBox cajaDeOpciones = new VBox();
        cajaDeOpciones.setAlignment(Pos.CENTER);
        cajaDeOpciones.setSpacing(20);

        for(Opcion opcion: opciones){
            Button botonOpcion = new Button(opcion.getDescripcion());
            cajaDeOpciones.getChildren().add(botonOpcion);
            //setea action event q tenga
        }

        Button botonTerminarTurno = new Button("Terminar Turno");

        VBox vistaGeneral = new VBox(consigna, cajaDeOpciones,  botonTerminarTurno);
        vistaGeneral.setSpacing(20);
        vistaGeneral.setAlignment(Pos.CENTER);
        Scene escenaGeneralPregunta = new Scene(vistaGeneral,500,500);
        return escenaGeneralPregunta;
    }
}