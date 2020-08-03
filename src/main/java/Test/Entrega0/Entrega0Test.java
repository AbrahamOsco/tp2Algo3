package Test.Entrega0;

import edu.fiuba.algo3.modelo.Evaluable.Evaluable;
import edu.fiuba.algo3.modelo.Evaluable.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluable.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioPuntajeParcial.PreguntaPuntajeParcialClasico;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Entrega0Test {

    @Test
    public void test01PreguntaDeVerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Evaluable opcionUno = new OpcionCorrecta ("Verdadero");
        Evaluable opcionDos = new OpcionIncorrecta ("Falso");

        ArrayList<Evaluable> opciones = new ArrayList<Evaluable>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);

        Pregunta unaPregunta = new PreguntaPuntajeParcialClasico("La mayonesa es un instrumento musical", opciones);
        //Act
        boolean contieneRespuestaCorrecta = unaPregunta.getOpcionesCorrectas().contains(opcionUno);
        //Assert
        assertTrue(contieneRespuestaCorrecta);
    }
    @Test
    public void test02PreguntaDeVerdaderoFalsoClasicoRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Jugador jugadorUno = new Jugador("AbrahamLincolnCazadorDeVampiros");
        Jugador jugadorDos = new Jugador("JetSupersonico");

        Evaluable opcionUno = new OpcionCorrecta ("Verdadero");
        Evaluable opcionDos = new OpcionIncorrecta ("Falso");

        ArrayList<Evaluable> opciones = new ArrayList<Evaluable>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);

        Pregunta unaPregunta = new PreguntaPuntajeParcialClasico("La mayonesa es un instrumento musical", opciones);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesElegidasJugadorUno = new ArrayList<>();
        opcionesElegidasJugadorUno.add(opcionUno);

        ArrayList<Evaluable> opcionesElegidasJugadorDos = new ArrayList<>();
        opcionesElegidasJugadorDos.add(opcionDos);

        Respuesta respuestaJugadorUno = new Respuesta (jugadorUno, opcionesElegidasJugadorUno);
        Respuesta respuestaJugadorDos = new Respuesta (jugadorDos, opcionesElegidasJugadorDos);

        //Act
        int puntajeParaJugador1 = unaPregunta.evaluarRespuesta(respuestaJugadorUno);
        int puntajeParaJugador2 = unaPregunta.evaluarRespuesta(respuestaJugadorDos);
        //Assert
        assertEquals(1, puntajeParaJugador1);
        assertEquals(0, puntajeParaJugador2);
    }
}