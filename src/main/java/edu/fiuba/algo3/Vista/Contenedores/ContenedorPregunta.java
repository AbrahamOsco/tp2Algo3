package edu.fiuba.algo3.Vista.Contenedores;

import edu.fiuba.algo3.Controladores.BotonOpcion;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ContenedorPregunta extends VBox {
    Pregunta pregunta;
    Turno turno;

    public ContenedorPregunta(Pregunta pregunta, Turno turno, ArrayList<Opcion> opcionesElegidas){
        this.pregunta = pregunta;
        this.turno = turno;

        Text consigna = new Text(pregunta.getConsigna());
        ArrayList<Opcion> opciones = pregunta.getOpciones();

        VBox cajaDeOpciones = new VBox();
        cajaDeOpciones.setAlignment(Pos.CENTER);
        cajaDeOpciones.setSpacing(20);

        for(Opcion opcion: opciones){
            BotonOpcion botonOpcion = new BotonOpcion(opcion, opcionesElegidas);
            cajaDeOpciones.getChildren().add(botonOpcion);
        }

        this.getChildren().addAll(consigna, cajaDeOpciones);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }
    //estrategias de apagado de botones cuando se elige alguna opcion
}
