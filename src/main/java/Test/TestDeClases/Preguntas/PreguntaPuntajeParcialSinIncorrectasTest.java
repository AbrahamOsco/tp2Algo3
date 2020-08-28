package Test.TestDeClases.Preguntas;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

//VerdaderoFalso CLasico
//multipleChoice puntaje parcial
public class PreguntaPuntajeParcialSinIncorrectasTest {
    @Test
    public void test01PreguntaVerdaderoFalsoClasicoRecibeLaOpcionCorrectaEntoncesDevuelve1Punto(){
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugador elige opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        //Act
        int resultado = verdaderoFalsoClasico.evaluarOpcionesElegidas(opcionesDeJugador1);

        //Assert
        assertEquals(1, resultado);
    }
    @Test
    public void test02PreguntaVerdaderoFalsoClasicoRecibeLaOpcionIncorrectaEntoncesDevuelve0Puntos(){
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugador elige opciones
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion2);

        //Act
        int resultado = verdaderoFalsoClasico.evaluarOpcionesElegidas(opcionesDeJugador);

        //Assert
        assertEquals(0, resultado);
    }
    @Test
    public void test03PreguntaMultipleChoicePuntajeParcialRecibe2De3OpcionesCorrectasSinNingunaIncorrectaEntoncesDevuelve2Puntos(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("A");
        Opcion opcion2 = new OpcionIncorrecta("5");
        Opcion opcion3 = new OpcionCorrecta("B");
        Opcion opcion4 = new OpcionCorrecta("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugador elige opciones
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion3);

        //Act
        int puntosJugador1 = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(opcionesDeJugador);


        //Assert
        assertEquals(2, puntosJugador1);
    }
    @Test
    public void test04PreguntaMultipleChoicePuntajeParcialRecibe2De3OpcionesCorrectasYUnaIncorrectaEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("A");
        Opcion opcion2 = new OpcionIncorrecta("5");
        Opcion opcion3 = new OpcionCorrecta("B");
        Opcion opcion4 = new OpcionCorrecta("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugador elige opciones
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        opcionesDeJugador.add(opcion1);
        opcionesDeJugador.add(opcion2);
        opcionesDeJugador.add(opcion3);

        //Act
        int puntosJugador1 = multipleChoicePuntajeParcial.evaluarOpcionesElegidas(opcionesDeJugador);

        //Assert
        assertEquals(0, puntosJugador1);
    }
}
