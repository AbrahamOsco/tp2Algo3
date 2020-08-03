package Test.TestDeClases.Pregunta.PreguntaClasicaTest;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Evaluable.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluable.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoClasicoTest {
    @Test
    public void test01SeLeEnviaUnaOpcionCorrectaYDevuelveUnPunto(){
        //Arrange
        Evaluable opcionCorrecta = new OpcionCorrecta("Verdadero");
        Evaluable opcionIncorrecta = new OpcionIncorrecta("falso");

        ArrayList <Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcionCorrecta);
        opcionesAPresentar.add(opcionIncorrecta);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrecta);

        String consigna = "Siempre se deberia hacer test?";
        Pregunta preguntaVerdaderoFalsoClasico = new PreguntaVerdaderoFalsoClasico(consigna,opcionesAPresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta respuestaUnJugador = new Respuesta(unJugador,opcionesDeUnJugador);
        //Act
        int resultado = preguntaVerdaderoFalsoClasico.evaluarRespuesta(respuestaUnJugador);

        //Assert
        assertEquals(1,resultado);
    }

    @Test
    public void test02SeLeEnviaUnaOpcionIncorrectaYDevuelveCeroPuntos(){
        //Arrange
        Evaluable opcionCorrecta = new OpcionCorrecta("Verdadero");
        Evaluable opcionIncorrecta = new OpcionIncorrecta("falso");

        ArrayList <Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcionCorrecta);
        opcionesAPresentar.add(opcionIncorrecta);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionIncorrecta);

        String consigna = "Siempre se deberia hacer test?";
        Pregunta preguntaVerdaderoFalsoClasico = new PreguntaVerdaderoFalsoClasico(consigna,opcionesAPresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta respuestaUnJugador = new Respuesta(unJugador,opcionesDeUnJugador);
        //Act
        int resultado = preguntaVerdaderoFalsoClasico.evaluarRespuesta(respuestaUnJugador);

        //Assert
        assertEquals(0,resultado);
    }


}
