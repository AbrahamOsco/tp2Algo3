package Test.TestEntregas.TestEntrega1;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Evaluables.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluables.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    @Test
    public void test01PreguntaDeVerdaderoFalsoPenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        Evaluable opcion1 = new OpcionCorrecta("si");
        Evaluable opcion2 = new OpcionIncorrecta("no");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //Act
        ArrayList<Evaluable> opcionesCorrectasDePregunta = verdaderoFalsoPenalizable.getOpcionesCorrectas();
        boolean contieneRespuestaCorrecta = opcionesCorrectasDePregunta.contains(opcion1);

        //Assert
        assertTrue(contieneRespuestaCorrecta);
    }
    @Test
    public void test02PreguntaDeVerdaderoFalsoPenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Evaluable opcion1 = new OpcionCorrecta("si");
        Evaluable opcion2 = new OpcionIncorrecta("no");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Evaluable> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoPenalizable,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);
        assertEquals(-1, puntosJugador2);
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
        Pregunta unaPregunta = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesDePregunta);

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
        Evaluable opcion1 = new OpcionCorrecta("A");
        Evaluable opcion2 = new OpcionIncorrecta("5");
        Evaluable opcion3 = new OpcionCorrecta("B");
        Evaluable opcion4 = new OpcionCorrecta("N");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoiceClasico = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion4);

        ArrayList<Evaluable> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoiceClasico,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoiceClasico,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);
        assertEquals(0, puntosJugador2);
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
        Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesDePregunta);

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
    public void test06PreguntaMultipleChoiceDePuntajeParcialRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos() {
        //Arrange
        Evaluable opcion1 = new OpcionCorrecta("A");
        Evaluable opcion2 = new OpcionIncorrecta("5");
        Evaluable opcion3 = new OpcionCorrecta("B");
        Evaluable opcion4 = new OpcionCorrecta("N");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion3);

        ArrayList<Evaluable> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoicePuntajeParcial, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoicePuntajeParcial, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }
}
