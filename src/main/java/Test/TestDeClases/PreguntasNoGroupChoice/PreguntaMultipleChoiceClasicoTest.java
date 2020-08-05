package Test.TestDeClases.PreguntasNoGroupChoice;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntasClasicas.PreguntaClasica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {

    @Test
    public void test01SeEligenTodasLasOpcionesCorrectasEntoncesDevuelve1Punto() {
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoiceClasico = new PreguntaClasica(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(1, resultado);
    }
    @Test
    public void test02SeEligeAlMenosUnaOpcionIncorrectaEntoncesDevuelve0Puntos() {
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoiceClasico = new PreguntaClasica(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion2);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(0, resultado);
    }
    @Test
    public void test03NoSeEligenOpcionesEntoncesDevuelve0Puntos() {
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoiceClasico = new PreguntaClasica(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(0, resultado);
    }
    @Test
    public void test04SeEligenTodasLasOpcionesCorrectasEIncorrectaEntoncesDevuelve0Puntos() {
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoiceClasico = new PreguntaClasica(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion2);
        opcionesDeJugador.add(opcion3);
        opcionesDeJugador.add(opcion4);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(0, resultado);
    }
}
