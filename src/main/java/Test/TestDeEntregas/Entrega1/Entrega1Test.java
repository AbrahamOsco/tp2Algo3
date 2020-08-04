package Test.TestDeEntregas.Entrega1;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePuntajeParcial;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaVerdaderoFalsoPenalizable;
import edu.fiuba.algo3.modelo.Respuesta;
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
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = verdaderoFalsoPenalizable.evaluarRespuesta(respuestaJugador1);
        int puntosParaJugador2 = verdaderoFalsoPenalizable.evaluarRespuesta(respuestaJugador2);

        //Assert
        assertEquals(1, puntosParaJugador1);
        assertEquals(-1, puntosParaJugador2);
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
        Pregunta multipleChoiceClasico = new PreguntaMultipleChoiceClasico(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Pregunta multipleChoiceClasico = new PreguntaMultipleChoiceClasico(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = multipleChoiceClasico.evaluarRespuesta(respuestaJugador1);
        int puntosParaJugador2 = multipleChoiceClasico.evaluarRespuesta(respuestaJugador2);

        //Assert
        assertEquals(1, puntosParaJugador1);
        assertEquals(0, puntosParaJugador2);
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
       Pregunta multipleChoicePuntajeParcial = new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Pregunta multipleChoicePuntajeParcial = new PreguntaMultipleChoicePuntajeParcial(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = multipleChoicePuntajeParcial.evaluarRespuesta(respuestaJugador1);
        int puntosParaJugador2 = multipleChoicePuntajeParcial.evaluarRespuesta(respuestaJugador2);

        //Assert
        assertEquals(2, puntosParaJugador1);
        assertEquals(0, puntosParaJugador2);
    }
}
