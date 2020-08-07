package Test.TestEntregas.TestEntrega2;

import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Evaluables.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluables.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Evaluables.OpcionPertenencia;
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
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //Act
        ArrayList<Evaluable> opcionesCorrectasDePregunta = multipleChoicePenalizable.getOpcionesCorrectas();
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
        Evaluable opcion1 = new OpcionPertenencia("5",2);
        Evaluable opcion2 = new OpcionPertenencia("10",3);
        Evaluable opcion3 = new OpcionPertenencia("0",1);
        Evaluable opcion4 = new OpcionPertenencia("15",4);

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //Act
        ArrayList<Evaluable> opcionesCorrectasDePregunta = orderedChoice.getOpciones();
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
        Evaluable opcion1 = new OpcionPertenencia("A",1);
        Evaluable opcion2 = new OpcionPertenencia("Hola",2);
        Evaluable opcion3 = new OpcionPertenencia("B",1);

        Evaluable opcion4 = new OpcionPertenencia("Adios",2);
        Evaluable opcion5 = new OpcionPertenencia("C",1);
        Evaluable opcion6 = new OpcionPertenencia("Luna",2);

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);
        opcionesAPresentar.add(opcion6);

        String consigna = "coloque las letras en el grupo 1 y las palabras en el grupo 2";
        Pregunta groupChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //Act
        ArrayList<Evaluable> opcionesCorrectasDePregunta = groupChoice.getOpciones();
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
