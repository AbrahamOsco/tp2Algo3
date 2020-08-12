package Test.TestEntregas.TestEntrega2;


import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrearPreguntasConSusRespuestasTest {
    @Test
    public void test01PreguntaMultipleChoiceDePenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("A");
        Opcion opcion2 = new OpcionIncorrectaPenalizable("5");
        Opcion opcion3 = new OpcionCorrecta("B");
        Opcion opcion4 = new OpcionCorrecta("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //Act
        ArrayList<Opcion> opcionesCorrectasDePregunta = multipleChoicePenalizable.getOpcionesCorrectas();
        boolean contieneRespuestaCorrectaUno = opcionesCorrectasDePregunta.contains(opcion1);
        boolean contieneRespuestaCorrectaDos = opcionesCorrectasDePregunta.contains(opcion3);
        boolean contieneRespuestaCorrectaTres = opcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
        assertTrue(contieneRespuestaCorrectaDos);
        assertTrue(contieneRespuestaCorrectaTres);
    }
    @Test
    public void test02PreguntaOrderedChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new OpcionPertenencia("5",2);
        Opcion opcion2 = new OpcionPertenencia("10",3);
        Opcion opcion3 = new OpcionPertenencia("0",1);
        Opcion opcion4 = new OpcionPertenencia("15",4);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //Act
        ArrayList<Opcion> opcionesCorrectasDePregunta = orderedChoice.getOpciones();
        //caso trivial, dado que tienen una clave que indica el orden Correcto, solo queda verificar
        //que se agregaron correctamente a la lista de opciones de pregunta
        boolean opcion1EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion1);
        boolean opcion2EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion2);
        boolean opcion3EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion3);
        boolean opcion4EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(opcion1EstaEnOpcionesDePregunta);
        assertTrue(opcion2EstaEnOpcionesDePregunta);
        assertTrue(opcion3EstaEnOpcionesDePregunta);
        assertTrue(opcion4EstaEnOpcionesDePregunta);
    }
    @Test
    public void test03PreguntaGroupChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        //Arrange
        Opcion opcion1 = new OpcionPertenencia("A",1);
        Opcion opcion2 = new OpcionPertenencia("Hola",2);
        Opcion opcion3 = new OpcionPertenencia("B",1);

        Opcion opcion4 = new OpcionPertenencia("Adios",2);
        Opcion opcion5 = new OpcionPertenencia("C",1);
        Opcion opcion6 = new OpcionPertenencia("Luna",2);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);
        opcionesAPresentar.add(opcion6);

        String consigna = "coloque las letras en el grupo 1 y las palabras en el grupo 2";
        Pregunta groupChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //Act
        ArrayList<Opcion> opcionesCorrectasDePregunta = groupChoice.getOpciones();
        //caso trivial, dado que tienen una clave que indica el grupo de pertenencia, solo queda verificar
        //que se agregaron correctamente a la lista de opciones de pregunta
        boolean opcion1EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion1);
        boolean opcion2EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion2);
        boolean opcion3EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion3);
        boolean opcion4EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion4);
        boolean opcion5EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion5);
        boolean opcion6EstaEnOpcionesDePregunta = opcionesCorrectasDePregunta.contains(opcion6);

        //Assert
        assertTrue(opcion1EstaEnOpcionesDePregunta);
        assertTrue(opcion2EstaEnOpcionesDePregunta);
        assertTrue(opcion3EstaEnOpcionesDePregunta);
        assertTrue(opcion4EstaEnOpcionesDePregunta);
        assertTrue(opcion5EstaEnOpcionesDePregunta);
        assertTrue(opcion6EstaEnOpcionesDePregunta);
    }
}
