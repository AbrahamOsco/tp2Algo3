package Test.TestDeEntregas.Entrega2;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2CrearPreguntasConSusRespuestas {
    @Test
    public void test01PreguntaMultipleChoiceDePenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
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
        Pregunta multipleChoicePenalizable = new PreguntaMultipleChoicePenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = multipleChoicePenalizable.getOpcionesCorrectas();
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
    public void test02PreguntaOrderedChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new Opcion("5");
        Opcion opcion2 = new Opcion("10");
        Opcion opcion3 = new Opcion("0");
        Opcion opcion4 = new Opcion("15");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion2);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaOrderedChoice(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = orderedChoice.getOpcionesCorrectas();
        ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        boolean vaEnPosicion1 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion3);
        boolean vaEnPosicion2 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
        boolean vaEnPosicion3 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion2);
        boolean vaEnPosicion4 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(vaEnPosicion1);
        assertTrue(vaEnPosicion2);
        assertTrue(vaEnPosicion3);
        assertTrue(vaEnPosicion4);
    }
    @Test
    public void test03PreguntaGroupChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        //Arrange
        Opcion opcion1A = new Opcion("pertenesco a A");
        Opcion opcion2A = new Opcion("pertenesco a A");
        Opcion opcion3A = new Opcion("pertenesco a A");

        Opcion opcion1B = new Opcion("pertenesco a B");
        Opcion opcion2B = new Opcion("pertenesco a B");
        Opcion opcion3B = new Opcion("pertenesco a B");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1A);
        opcionesAPresentar.add(opcion2A);
        opcionesAPresentar.add(opcion3A);
        opcionesAPresentar.add(opcion1B);
        opcionesAPresentar.add(opcion2B);
        opcionesAPresentar.add(opcion3B);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectasGrupoA = new ArrayList<>();
        opcionesCorrectasGrupoA.add(opcion1A);
        opcionesCorrectasGrupoA.add(opcion2A);
        opcionesCorrectasGrupoA.add(opcion3A);

        ArrayList<Opcion> opcionesCorrectasGrupoB = new ArrayList<>();
        opcionesCorrectasGrupoB.add(opcion1B);
        opcionesCorrectasGrupoB.add(opcion2B);
        opcionesCorrectasGrupoB.add(opcion3B);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoA);
        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoB);

        String consigna = "Ordenas las opciones en sus correspondientes grupos";
        Pregunta groupChoice = new PreguntaGroupChoice(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = groupChoice.getOpcionesCorrectas();

        ArrayList<Opcion> primerGrupoDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        ArrayList<Opcion> segundoGrupoDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(1);

        boolean opcion1AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion1A);
        boolean opcion2AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion2A);
        boolean opcion3AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion3A);

        boolean opcion1BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion1B);
        boolean opcion2BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion2B);
        boolean opcion3BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion3B);

        //Assert
        assertTrue(opcion1AEstaEnGrupoA);
        assertTrue(opcion2AEstaEnGrupoA);
        assertTrue(opcion3AEstaEnGrupoA);

        assertTrue(opcion1BEstaEnGrupoB);
        assertTrue(opcion2BEstaEnGrupoB);
        assertTrue(opcion3BEstaEnGrupoB);
    }
}
