package Test.TestDeEntregas.Entrega1;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaPenalizable.PreguntaPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaPuntajeParcial.PreguntaPuntajeParcial;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntasClasicas.PreguntaClasica;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    @Test
    public void test01PreguntaDeVerdaderoFalsoPenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
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
        Pregunta verdaderoFalsoPenalizable = new PreguntaPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = verdaderoFalsoPenalizable.getOpcionesCorrectas();
        ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        boolean contieneRespuestaCorrectaUno = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
    }

    @Test
    public void test02PreguntaDeVerdaderoFalsoPenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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
        Pregunta verdaderoFalsoPenalizable = new PreguntaPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoPenalizable,jugador2);
        turnoJugador2.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador2);

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

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = multipleChoiceClasico.getOpcionesCorrectas();
        ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        boolean contieneRespuestaCorrectaUno = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
        boolean contieneRespuestaCorrectaDos = primerListaDeOpcionesCorrectasDePregunta.contains(opcion3);
        boolean contieneRespuestaCorrectaTres = primerListaDeOpcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
        assertTrue(contieneRespuestaCorrectaDos);
        assertTrue(contieneRespuestaCorrectaTres);
    }

    @Test
    public void test04PreguntaMultipleChoiceClasicoRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion4);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoiceClasico,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoiceClasico,jugador2);
        turnoJugador2.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador2);

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
       Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

       //Act
       ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = multipleChoicePuntajeParcial.getOpcionesCorrectas();
       ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
       boolean contieneRespuestaCorrectaUno = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
       boolean contieneRespuestaCorrectaDos = primerListaDeOpcionesCorrectasDePregunta.contains(opcion3);
       boolean contieneRespuestaCorrectaTres = primerListaDeOpcionesCorrectasDePregunta.contains(opcion4);

       //Assert
       assertTrue(contieneRespuestaCorrectaUno);
       assertTrue(contieneRespuestaCorrectaDos);
       assertTrue(contieneRespuestaCorrectaTres);
    }
    @Test
    public void test06PreguntaMultipleChoiceDePuntajeParcialRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion3);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoicePuntajeParcial,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoicePuntajeParcial,jugador2);
        turnoJugador2.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador2);

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
