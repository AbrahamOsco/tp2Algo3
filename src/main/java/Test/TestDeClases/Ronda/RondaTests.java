package Test.TestDeClases.Ronda;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Evaluables.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluables.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTests {

    //Necesita agregar turnos para asignar puntos.
    @Test
    public void test01agregarTurnosYasignarPuntosSinMultiplicadores() {

        //Arrange
        Evaluable opcion1 = new OpcionCorrecta("Tal vez");
        Evaluable opcion2 = new OpcionIncorrecta("Quizas");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<Evaluable> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        String consigna = "¿Es la filosofía una ciencia exacta?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Evaluable> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);

        Jugador jugador1 = new Jugador("Lucius");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Arquímedes");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico,jugador2);
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
    public void test02agregarTurnosYasignarPuntosConMultiplicadores() {

        //Arrange
        Evaluable opcion1 = new OpcionCorrecta("Cayo Julio Cesar");
        Evaluable opcion2 = new OpcionIncorrecta("Bob Esponja");
        Evaluable opcion3 = new OpcionCorrecta("Marco Vipsanio Agrippa");
        Evaluable opcion4 = new OpcionCorrecta("Octavio");
        Evaluable opcion5 = new OpcionCorrecta("Craso");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Marque las figuras importantes en la historia romana";
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);

        ArrayList<Evaluable> opcionesDeJugador2 = new ArrayList<>();
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

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(9, puntosJugador2);

    }
}
