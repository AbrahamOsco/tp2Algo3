package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Contenedores.ContenedorInicio;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrectaPenalizable;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

/**
 * JavaFX App
 */
public class App extends Application {
    Partida partida;

    @Override
    public void start(Stage stage){
        partida = this.cargarPartida();
        ManejadorTurnos manejadorTurnos = new ManejadorTurnos(partida, stage);

        ContenedorInicio inicio = new ContenedorInicio(partida, stage, manejadorTurnos);
        Scene escenaInicio = new Scene(inicio,500,500);
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Partida cargarPartida(){
        Partida partida = new Partida();
        Queue<Pregunta> preguntasDelJuego = new LinkedList<>();
        //pregunta1
        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(new OpcionCorrecta("10"));
        opcionesAPresentar.add(new OpcionCorrecta("15"));
        opcionesAPresentar.add(new OpcionCorrecta("5"));
        opcionesAPresentar.add(new OpcionIncorrecta("no"));
        Pregunta multipleChoice = new PreguntaPuntajeParcialSinIncorrectos("Eliga los numeros",opcionesAPresentar);
        //
        ArrayList<Opcion> opcionesAPresentar2 = new ArrayList<>();
        opcionesAPresentar2.add(new OpcionCorrecta("si"));
        opcionesAPresentar2.add(new OpcionIncorrecta("no"));
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos("Se debe testear?",opcionesAPresentar2);
        //
        //
        ArrayList<Opcion> opcionesAPresentar3 = new ArrayList<>();
        opcionesAPresentar3.add(new OpcionCorrecta("No"));
        opcionesAPresentar3.add(new OpcionIncorrectaPenalizable("Si"));
        Pregunta verdaderoFalsoClasico2 = new PreguntaPuntajeParcialPenalizable("Es Uruguay otra provincia de Argentina?",opcionesAPresentar3);
        //

        preguntasDelJuego.offer(multipleChoice);
        preguntasDelJuego.offer(verdaderoFalsoClasico);
        preguntasDelJuego.offer(verdaderoFalsoClasico2);

        partida.setPreguntas(preguntasDelJuego);
        return partida;
    }
}