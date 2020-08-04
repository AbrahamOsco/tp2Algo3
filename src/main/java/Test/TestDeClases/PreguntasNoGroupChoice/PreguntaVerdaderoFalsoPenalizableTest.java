package Test.TestDeClases.PreguntasNoGroupChoice;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaVerdaderoFalsoPenalizable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoPenalizableTest {

    @Test
    public void test01SeEligeLaOpcionCorrectaEntoncesDevuelve1Punto() {
        //Arrange
        Opcion opcion1 = new Opcion("si");
        Opcion opcion2 = new Opcion("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = verdaderoFalsoPenalizable.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(1, resultado);
    }
    @Test
    public void test02SeEligeLaOpcionInCorrectaEntoncesDevuelveMenos1Punto() {
        //Arrange
        Opcion opcion1 = new Opcion("si");
        Opcion opcion2 = new Opcion("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion2);

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = verdaderoFalsoPenalizable.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(-1, resultado);
    }
    @Test
    public void test03NoSeEligeNingunaOpcionEntoncesDevuelve0Puntos() {
        //Arrange
        Opcion opcion1 = new Opcion("si");
        Opcion opcion2 = new Opcion("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();

        listaDeListaDeOpcionesJugador.add(opcionesDeJugador);

        //Act
        int resultado = verdaderoFalsoPenalizable.evaluarOpcionesElegidas(listaDeListaDeOpcionesJugador);
        //Assert
        assertEquals(0, resultado);
    }
}
