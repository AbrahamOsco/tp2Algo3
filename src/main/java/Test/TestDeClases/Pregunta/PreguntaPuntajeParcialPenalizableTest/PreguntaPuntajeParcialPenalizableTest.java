package Test.TestDeClases.Pregunta.PreguntaPuntajeParcialPenalizableTest;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Evaluable.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluable.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioPuntajeParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaPuntajeParcialPenalizableTest {
    @Test
    public void test01SeLeEnviaTodasLasOpcionesCorrectasYDevuelveTresPuntos(){
        //Arrange
        Evaluable opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Evaluable opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Evaluable opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Evaluable opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Evaluable> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);

        String consigna = "hay que testear?";
        Pregunta multipleChoice = new PreguntaPuntajeParcialPenalizable(consigna,opcionesApresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,opcionesDeUnJugador);

        //Act
        int resultado = multipleChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(3,resultado);
    }
    @Test
    public void test02SeLeEnviaDosDeTresOpcionesCorrectasYDevuelveDosPuntos(){
        //Arrange
        Evaluable opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Evaluable opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Evaluable opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Evaluable opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Evaluable> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);

        String consigna = "hay que testear?";
        Pregunta multipleChoice = new PreguntaPuntajeParcialPenalizable(consigna,opcionesApresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,opcionesDeUnJugador);

        //Act
        int resultado = multipleChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(2,resultado);
    }

    @Test
    public void test03SeLeEnviaTresCorrectasYUnaIncorrectaYDevuelveDosPuntos(){
        //Arrange
        Evaluable opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Evaluable opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Evaluable opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Evaluable opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Evaluable> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);
        opcionesDeUnJugador.add(opcionIncorrecta);

        String consigna = "hay que testear?";
        Pregunta multipleChoice = new PreguntaPuntajeParcialPenalizable(consigna,opcionesApresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,opcionesDeUnJugador);

        //Act
        int resultado = multipleChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(2,resultado);
    }
}
