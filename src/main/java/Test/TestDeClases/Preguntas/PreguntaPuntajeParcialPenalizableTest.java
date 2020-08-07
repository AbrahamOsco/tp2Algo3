package Test.TestDeClases.Preguntas;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

//VF penalizable
//multiple choice penalizable
public class PreguntaPuntajeParcialPenalizableTest {
    @Test
    public void test01PreguntaMultipleChoicePenalizableRecibe3OpcionesCorrectasYUnaIncorrectaEntoncesDevuelve2Puntos(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);
        opcionesDeUnJugador.add(opcionIncorrecta);

        String consigna = "hay que testear?";
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoicePenalizable.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(2,resultado);
    }
    @Test
    public void test02JugadorNoEligeOpcionesEntoncesPreguntaMultipleChoicePenalizableDevuelve0Puntos(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();

        String consigna = "hay que testear?";
        Pregunta multipleChoice = new PreguntaPuntajeParcialPenalizable(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoice.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(0,resultado);
    }

    @Test
    public void test03PreguntaVerdaderFalsoPenalizableRecibeUnaOpcionCorrectaEntoncesDevuelve1Punto() {
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugador elige opcion
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        //Act
        int resultado = verdaderoFalsoPenalizable.evaluarOpcionesElegidas(opcionesDeJugador1);
        //Assert
        assertEquals(1, resultado);
    }
    @Test
    public void test04PreguntaVerdaderFalsoPenalizableRecibeUnaOpcionIncorrectaEntoncesDevuelveMenos1Punto() {
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugador elige opcion
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion2);

        //Act
        int resultado = verdaderoFalsoPenalizable.evaluarOpcionesElegidas(opcionesDeJugador1);
        //Assert
        assertEquals(-1, resultado);
    }
}
