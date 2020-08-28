package Test.TestDeClases.AsignadorPuntos;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsignadorPuntosTests {

    //Necesita agregar turnos para asignar puntos.
    @Test
    public void test01agregarTurnosYasignarPuntosSinModifadores() {

        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Tal vez");
        Opcion opcion2 = new OpcionIncorrecta("Quizas");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "¿Es la filosofía una ciencia exacta?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);

        Jugador jugador1 = new Jugador("Lucius");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Arquímedes");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        AsignadorPuntos unaAsignadorPuntos = new AsignadorPuntos();
        unaAsignadorPuntos.agregarTurno(turnoJugador1);
        unaAsignadorPuntos.agregarTurno(turnoJugador2);
        unaAsignadorPuntos.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test02agregarTurnosYasignarPuntosConMultiplicadores() {

        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Cayo Julio Cesar");
        Opcion opcion2 = new OpcionIncorrectaPenalizable("Bob Esponja");
        Opcion opcion3 = new OpcionCorrecta("Marco Vipsanio Agrippa");
        Opcion opcion4 = new OpcionCorrecta("Octavio");
        Opcion opcion5 = new OpcionCorrecta("Craso");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Marque las figuras importantes en la historia romana";
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion5);

        Jugador jugador1 = new Jugador("Samuel");
        Turno turnoJugador1 = new Turno(multipleChoicePenalizable,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);
        if(jugador1.activarMultiplicador("multiplicadorX2")){
            ModificadorMultiplicador unMultiplicador = new MultiplicadorX2();
            turnoJugador1.setMultiplicadorActivo(unMultiplicador);
        }

        Jugador jugador2 = new Jugador("LaSenioraDeLosGatos");
        Turno turnoJugador2 = new Turno(multipleChoicePenalizable,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);
        if(jugador2.activarMultiplicador("multiplicadorX3")){
            ModificadorMultiplicador unMultiplicador = new MultiplicadorX3();
            turnoJugador2.setMultiplicadorActivo(unMultiplicador);
        }

        AsignadorPuntos unaAsignadorPuntos = new AsignadorPuntos();
        unaAsignadorPuntos.agregarTurno(turnoJugador1);
        unaAsignadorPuntos.agregarTurno(turnoJugador2);
        unaAsignadorPuntos.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(9, puntosJugador2);

    }

    @Test
    public void test03agregarTurnosYasignarPuntosSinModificadores() {

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

        //jugador elige opciones en el orden que cree correcto:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y ubicacion correcta)cuya posicion actual sera seteada con la que el crea que es la correcta
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        OpcionPertenencia opcion1Jugador = new OpcionPertenencia("5",2);
        opcion1Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador = new OpcionPertenencia("10",3);
        opcion2Jugador.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador = new OpcionPertenencia("0",1);
        opcion3Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador = new OpcionPertenencia("15",4);
        opcion4Jugador.setUbicacionActual(4);

        opcionesDeJugador.add(opcion1Jugador);
        opcionesDeJugador.add(opcion2Jugador);
        opcionesDeJugador.add(opcion3Jugador);
        opcionesDeJugador.add(opcion4Jugador);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("5",2);
        opcion1Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("10",3);
        opcion2Jugador.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("0",1);
        opcion3Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("15",4);
        opcion4Jugador.setUbicacionActual(4);

        opcionesDeJugador2.add(opcion1Jugador2);
        opcionesDeJugador2.add(opcion2Jugador2);
        opcionesDeJugador2.add(opcion3Jugador2);
        opcionesDeJugador2.add(opcion4Jugador2);


        Jugador jugador1 = new Jugador("Lucius");
        Turno turnoJugador1 = new Turno(orderedChoice,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador);


        Jugador jugador2 = new Jugador("Arquímedes");
        Turno turnoJugador2 = new Turno(orderedChoice,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        AsignadorPuntos unaAsignadorPuntos = new AsignadorPuntos();
        unaAsignadorPuntos.agregarTurno(turnoJugador1);
        unaAsignadorPuntos.agregarTurno(turnoJugador2);
        unaAsignadorPuntos.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }



}
