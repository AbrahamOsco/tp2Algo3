package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ContenedorPregunta extends VBox {
    Pregunta pregunta;
    public ContenedorPregunta(Pregunta pregunta){
        this.pregunta = pregunta;

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
        this.getChildren().addAll(consigna, cajaDeOpciones);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }
}
