package Test.TestDeClases.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePuntajeParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoicePuntajeParcialTest {
    @Test
    public void test01SeEligenLas4De4opcionesCorrectasYNingunaIncorrectaEntoncesDevuelve4Puntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial= new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);
        opcionesDeJugador.add(opcion5);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        Jugador unJugador = new Jugador("Ra");
        Respuesta unaRespuesta = new Respuesta(unJugador, listaDeListaDeOpcionesJugador);

        //Act
        int resultado = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(unaRespuesta);
        //Assert
        assertEquals(4, resultado);
    }
    @Test
    public void test02SeEligenLas3De4opcionesCorrectasYNingunaIncorrectaEntoncesDevuelve3Puntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial= new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        Jugador unJugador = new Jugador("Ra");
        Respuesta unaRespuesta = new Respuesta(unJugador, listaDeListaDeOpcionesJugador);

        //Act
        int resultado = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(unaRespuesta);
        //Assert
        assertEquals(3, resultado);
    }
    @Test
    public void test03SeEligenAlgunasOpcionesCorrectasYUnaOpcionIncorrectaEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial= new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion2);
        opcionesDeJugador.add(opcion4);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        Jugador unJugador = new Jugador("Ra");
        Respuesta unaRespuesta = new Respuesta(unJugador, listaDeListaDeOpcionesJugador);

        //Act
        int resultado = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(unaRespuesta);
        //Assert
        assertEquals(0, resultado);
    }
    @Test
    public void test04NoSeEligenOpcionesEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial= new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        Jugador unJugador = new Jugador("Ra");
        Respuesta unaRespuesta = new Respuesta(unJugador, listaDeListaDeOpcionesJugador);

        //Act
        int resultado = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(unaRespuesta);
        //Assert
        assertEquals(0, resultado);
    }
    @Test
    public void test05SeEligenTodasLasOpcionesCorrectasYAlgunaIncorrectaEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial= new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion2);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);
        opcionesDeJugador.add(opcion5);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        Jugador unJugador = new Jugador("Ra");
        Respuesta unaRespuesta = new Respuesta(unJugador, listaDeListaDeOpcionesJugador);

        //Act
        int resultado = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(unaRespuesta);
        //Assert
        assertEquals(0, resultado);
    }
}
