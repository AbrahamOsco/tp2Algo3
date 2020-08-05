package Test.TestDeClases.Ronda;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntaPenalizable.PreguntaPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasSimples.PreguntasClasicas.PreguntaClasica;
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
        Opcion opcion1 = new Opcion("Tal vez");
        Opcion opcion2 = new Opcion("Quizas");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "¿Es la filosofía una ciencia exacta?";
        Pregunta verdaderoFalsoClasico = new PreguntaClasica(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Lucius");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Arquímedes");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico,jugador2);
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
    public void test02agregarTurnosYasignarPuntosConMultiplicadores() {

        //Arrange
        Opcion opcion1 = new Opcion("Cayo Julio Cesar");
        Opcion opcion2 = new Opcion("Bob Esponja");
        Opcion opcion3 = new Opcion("Marco Vipsanio Agrippa");
        Opcion opcion4 = new Opcion("Octavio");
        Opcion opcion5 = new Opcion("Craso");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Marque las figuras importantes en la historia romana";
        Pregunta multipleChoicePenalizable = new PreguntaPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);

        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion5);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Samuel");
        Turno turnoJugador1 = new Turno(multipleChoicePenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);
        if(jugador1.activarMultiplicador("multiplicadorX2")){
            ModificadorMultiplicador unMultiplicador = new MultiplicadorX2();
            turnoJugador1.setMultiplicadorActivo(unMultiplicador);
        }

        Jugador jugador2 = new Jugador("LaSenioraDeLosGatos");
        Turno turnoJugador2 = new Turno(multipleChoicePenalizable,jugador2);
        turnoJugador2.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador2);
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
