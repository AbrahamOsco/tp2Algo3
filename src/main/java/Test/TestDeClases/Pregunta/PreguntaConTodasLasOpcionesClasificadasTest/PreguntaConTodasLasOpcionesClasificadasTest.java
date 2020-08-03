package Test.TestDeClases.Pregunta.PreguntaConTodasLasOpcionesClasificadasTest;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Evaluable.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaConTodasLasOpcionesClasificadasTest {
    @Test
    public void test01SeLeEnviaTodasLasOpcionesOrdenasBienYDevuelveUnPunto(){
        //Arrange
        Evaluable opcionClasificableUno = new OpcionPertenencia("Voy Primero",1);
        Evaluable opcionClasificableDos = new OpcionPertenencia("Voy Segundo",2);
        Evaluable opcionClasificableTres = new OpcionPertenencia("Voy Tercero",3);
        Evaluable opcionClasificableCuatro = new OpcionPertenencia("Voy Primero",4);
        ArrayList<Evaluable> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionClasificableUno);
        opcionesApresentar.add(opcionClasificableDos);
        opcionesApresentar.add(opcionClasificableTres);
        opcionesApresentar.add(opcionClasificableCuatro);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        //Jugador Ordena las opciones
        opcionClasificableUno.setUbicacionActual(1);
        opcionClasificableDos.setUbicacionActual(2);
        opcionClasificableTres.setUbicacionActual(3);
        opcionClasificableCuatro.setUbicacionActual(4);

        opcionesDeUnJugador.add(opcionClasificableUno);
        opcionesDeUnJugador.add(opcionClasificableDos);
        opcionesDeUnJugador.add(opcionClasificableTres);
        opcionesDeUnJugador.add(opcionClasificableCuatro);

        String consigna = "Ordenar todo";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesClasificadas(consigna,opcionesApresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,opcionesDeUnJugador);

        //Act
        int resultado = multipleChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(1,resultado);
    }
    @Test
    public void test02SeLeEnviaOpcionesOrdenadasMaslYDevuelveCeroPuntos(){
        //Arrange
        Evaluable opcionClasificableUno = new OpcionPertenencia("Voy Primero",1);
        Evaluable opcionClasificableDos = new OpcionPertenencia("Voy Segundo",2);
        Evaluable opcionClasificableTres = new OpcionPertenencia("Voy Tercero",3);
        Evaluable opcionClasificableCuatro = new OpcionPertenencia("Voy Primero",4);
        ArrayList<Evaluable> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionClasificableUno);
        opcionesApresentar.add(opcionClasificableDos);
        opcionesApresentar.add(opcionClasificableTres);
        opcionesApresentar.add(opcionClasificableCuatro);

        ArrayList<Evaluable> opcionesDeUnJugador = new ArrayList<>();
        //Jugador Ordena las opciones
        opcionClasificableUno.setUbicacionActual(1);
        opcionClasificableDos.setUbicacionActual(3);
        opcionClasificableTres.setUbicacionActual(2);
        opcionClasificableCuatro.setUbicacionActual(4);

        opcionesDeUnJugador.add(opcionClasificableUno);
        opcionesDeUnJugador.add(opcionClasificableDos);
        opcionesDeUnJugador.add(opcionClasificableTres);
        opcionesDeUnJugador.add(opcionClasificableCuatro);

        String consigna = "Ordenar Todo";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesClasificadas(consigna,opcionesApresentar);
        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,opcionesDeUnJugador);

        //Act
        int resultado = multipleChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(0,resultado);
    }
}
