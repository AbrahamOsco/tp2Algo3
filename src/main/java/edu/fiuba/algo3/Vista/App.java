package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
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
        ContenedorInicio inicio = new ContenedorInicio(partida, stage);
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
        opcionesAPresentar.add(new OpcionCorrecta("20"));
        Pregunta multipleChoice = new PreguntaPuntajeParcialSinIncorrectos("numeros?",opcionesAPresentar);
        //
        ArrayList<Opcion> opcionesAPresentar2 = new ArrayList<>();
        opcionesAPresentar2.add(new OpcionCorrecta("si"));
        opcionesAPresentar2.add(new OpcionCorrecta("no"));
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos("testeo?",opcionesAPresentar2);
        //
        preguntasDelJuego.offer(multipleChoice);
        preguntasDelJuego.offer(verdaderoFalsoClasico);

        partida.setPreguntas(preguntasDelJuego);
        return partida;
    }
}
/*ContenedorTurno turnoVista = new ContenedorTurno(jugadores.get(0), partida.obtenerSiguientePregunta());
        Scene escenaDeJuego = new Scene(turnoVista,500,500);*/