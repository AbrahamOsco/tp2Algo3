package Test.Entrega0;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Evaluable.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Entrega0Test {

    @Test
    public void test01PreguntaDeVerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcionCorrecta = new Opcion("si");
        Opcion opcionIncorrecta = new Opcion("no");

        ArrayList<Opcion> opcionesAMostrar = new ArrayList<>();
        opcionesAMostrar.add(opcionCorrecta);
        opcionesAMostrar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcionCorrecta);

        ListaOpcionesParaPregunta listaDeOpciones = new ListaOpcionesParaPregunta(opcionesAMostrar, opcionesCorrectas);

        TipoPregunta tipoPreguntaVerdaderoFalso = new PreguntaVerdaderoFalso();
        Pregunta unaPregunta = new Pregunta("se debe hacer test?",tipoPreguntaVerdaderoFalso, listaDeOpciones );

        //Act
        boolean contieneRespuestaCorrecta = unaPregunta.getOpcionesCorrectas().contains(opcionCorrecta);
        //Assert
        assertTrue(contieneRespuestaCorrecta);
    }
    @Test
    public void test02PreguntaDeVerdaderoFalsoClasicoRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Opcion opcionCorrecta = new Opcion("si");
        Opcion opcionIncorrecta = new Opcion("no");

        ArrayList<Opcion> opcionesAMostrar = new ArrayList<>();
        opcionesAMostrar.add(opcionCorrecta);
        opcionesAMostrar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcionCorrecta);

        ListaOpcionesParaPregunta listaDeOpciones = new ListaOpcionesParaPregunta(opcionesAMostrar, opcionesCorrectas);

        TipoPregunta tipoPreguntaVerdaderoFalso = new PreguntaVerdaderoFalso();
        Pregunta unaPregunta = new Pregunta("se debe testear?",tipoPreguntaVerdaderoFalso, listaDeOpciones);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesElegidasJugador1 = new ArrayList<>();
        opcionesElegidasJugador1.add(opcionCorrecta);

        ArrayList<Opcion> opcionesElegidasJugador2 = new ArrayList<>();
        opcionesElegidasJugador2.add(opcionIncorrecta);

        //Act
        int puntajeParaJugador1 = unaPregunta.obtenerPuntajeOpcionesElejidas(opcionesElegidasJugador1);
        int puntajeParaJugador2 = unaPregunta.obtenerPuntajeOpcionesElejidas(opcionesElegidasJugador2);
        //Assert
        assertEquals(1, puntajeParaJugador1);
        assertEquals(0, puntajeParaJugador2);
    }
}