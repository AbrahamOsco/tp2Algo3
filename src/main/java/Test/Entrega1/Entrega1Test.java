package Test.Entrega1;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Evaluable.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasClasicas.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasPenalizables.PreguntaPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasPuntajeParcial.PreguntaPuntajeParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    @Test
    public void test01PreguntaDeVerdaderoFalsoPenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        //Arrange
        Evaluable opcionUno = new OpcionCorrecta("si");
        Evaluable opcionDos = new OpcionIncorrecta("no");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);

        String consigna = "Se empieza por las pruebas en TDD?";
        Pregunta unaPregunta = new PreguntaVerdaderoFalsoClasico(consigna, opcionesDePregunta);

        //Act
        boolean contieneRespuestaCorrecta = unaPregunta.getOpcionesCorrectas().contains(opcionUno);

        //Assert
        assertTrue(contieneRespuestaCorrecta);
    }
    @Test
    public void test02PreguntaDeVerdaderoFalsoPenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Jugador jugadorUno = new Jugador("Pepe");
        Jugador jugadorDos = new Jugador("Lucho");

        Evaluable opcionUno = new OpcionCorrecta ("Verdadero");
        Evaluable opcionDos = new OpcionIncorrecta ("Falso");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);

        String consigna = "Vive Bob Esponja debajo del mar?";
        Pregunta unaPregunta = new PreguntaPenalizable(consigna, opcionesDePregunta);

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
        assertEquals(-1, puntajeParaJugador2);
    }
    @Test
    public void test03PreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        //Arrange
        Evaluable opcionUno = new OpcionCorrecta("mora");
        Evaluable opcionDos = new OpcionCorrecta("mandarina");
        Evaluable opcionTres= new OpcionCorrecta("naranja");
        Evaluable opcionCuatro = new OpcionIncorrecta("papa");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);
        opcionesDePregunta.add(opcionTres);
        opcionesDePregunta.add(opcionCuatro);

        String consigna = "Elija todas las opciones que sean una fruta";
        Pregunta unaPregunta = new PreguntaMultipleChoiceClasico(consigna, opcionesDePregunta);

        //Act
        boolean contieneRespuestaCorrectaUno = unaPregunta.getOpcionesCorrectas().contains(opcionUno);
        boolean contieneRespuestaCorrectaDos = unaPregunta.getOpcionesCorrectas().contains(opcionDos);
        boolean contieneRespuestaCorrectaTres = unaPregunta.getOpcionesCorrectas().contains(opcionTres);

        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
        assertTrue(contieneRespuestaCorrectaDos);
        assertTrue(contieneRespuestaCorrectaTres);
    }
    @Test
    public void test04PreguntaMultipleChoiceClasicoRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Jugador jugadorUno = new Jugador("Kvothe");
        Jugador jugadorDos = new Jugador("Geralt");

        Evaluable opcionUno = new OpcionCorrecta("mora");
        Evaluable opcionDos = new OpcionCorrecta("mandarina");
        Evaluable opcionTres = new OpcionIncorrecta("papa");
        Evaluable opcionCuatro= new OpcionCorrecta("naranja");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);
        opcionesDePregunta.add(opcionTres);
        opcionesDePregunta.add(opcionCuatro);

        String consigna = "Elija todas las opciones que sean una fruta";
        Pregunta unaPregunta = new PreguntaMultipleChoiceClasico(consigna, opcionesDePregunta);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesElegidasJugadorUno = new ArrayList<>();
        opcionesElegidasJugadorUno.add(opcionUno);
        opcionesElegidasJugadorUno.add(opcionDos);
        opcionesElegidasJugadorUno.add(opcionCuatro);

        ArrayList<Evaluable> opcionesElegidasJugadorDos = new ArrayList<>();
        opcionesElegidasJugadorDos.add(opcionDos);
        opcionesElegidasJugadorDos.add(opcionTres);
        opcionesElegidasJugadorDos.add(opcionCuatro);

        Respuesta respuestaJugadorUno = new Respuesta (jugadorUno, opcionesElegidasJugadorUno);
        Respuesta respuestaJugadorDos = new Respuesta (jugadorDos, opcionesElegidasJugadorDos);

        //Act
        int puntajeParaJugador1 = unaPregunta.evaluarRespuesta(respuestaJugadorUno);
        int puntajeParaJugador2 = unaPregunta.evaluarRespuesta(respuestaJugadorDos);

        //Assert
        assertEquals(1, puntajeParaJugador1);
        assertEquals(0, puntajeParaJugador2);
    }
    @Test
    public void test05PreguntaMultipleChoiceDePuntajeParcialPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Evaluable opcionUno = new OpcionCorrecta("mora");
        Evaluable opcionDos = new OpcionIncorrecta("papa");
        Evaluable opcionTres = new OpcionCorrecta("mandarina");
        Evaluable opcionCuatro= new OpcionCorrecta("naranja");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);
        opcionesDePregunta.add(opcionTres);
        opcionesDePregunta.add(opcionCuatro);

        String consigna = "Elija todas las opciones que sean una fruta";
        Pregunta unaPregunta = new PreguntaPuntajeParcial(consigna, opcionesDePregunta);

        //Act
        boolean contieneRespuestaCorrectaUno = unaPregunta.getOpcionesCorrectas().contains(opcionUno);
        boolean contieneRespuestaCorrectaDos = unaPregunta.getOpcionesCorrectas().contains(opcionTres);
        boolean contieneRespuestaCorrectaTres = unaPregunta.getOpcionesCorrectas().contains(opcionCuatro);

        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
        assertTrue(contieneRespuestaCorrectaDos);
        assertTrue(contieneRespuestaCorrectaTres);
    }
    @Test
    public void test06PreguntaMultipleChoiceDePuntajeParcialRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Jugador jugadorUno = new Jugador("Elodin");
        Jugador jugadorDos = new Jugador("Ciri");

        Evaluable opcionUno = new OpcionIncorrecta("papa");
        Evaluable opcionDos = new OpcionCorrecta("mora");
        Evaluable opcionTres = new OpcionCorrecta("mandarina");
        Evaluable opcionCuatro= new OpcionCorrecta("naranja");

        ArrayList<Evaluable> opcionesDePregunta = new ArrayList<>();
        opcionesDePregunta.add(opcionUno);
        opcionesDePregunta.add(opcionDos);
        opcionesDePregunta.add(opcionTres);
        opcionesDePregunta.add(opcionCuatro);

        String consigna = "Elija todas las opciones que sean una fruta";
        Pregunta unaPregunta = new PreguntaPuntajeParcial(consigna, opcionesDePregunta);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesElegidasJugadorUno = new ArrayList<>();
        opcionesElegidasJugadorUno.add(opcionUno);
        opcionesElegidasJugadorUno.add(opcionDos);
        opcionesElegidasJugadorUno.add(opcionCuatro);

        ArrayList<Evaluable> opcionesElegidasJugadorDos = new ArrayList<>();
        opcionesElegidasJugadorDos.add(opcionDos);
        opcionesElegidasJugadorDos.add(opcionTres);

        Respuesta respuestaJugadorUno = new Respuesta (jugadorUno, opcionesElegidasJugadorUno);
        Respuesta respuestaJugadorDos = new Respuesta (jugadorDos, opcionesElegidasJugadorDos);

        //Act
        int puntajeParaJugador1 = unaPregunta.evaluarRespuesta(respuestaJugadorUno);
        int puntajeParaJugador2 = unaPregunta.evaluarRespuesta(respuestaJugadorDos);

        //Assert
        assertEquals(0, puntajeParaJugador1);
        assertEquals(2, puntajeParaJugador2);
    }
}
