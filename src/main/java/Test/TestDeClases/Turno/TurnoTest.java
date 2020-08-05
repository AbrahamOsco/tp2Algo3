package Test.TestDeClases.Turno;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaVerdaderoFalsoPenalizable;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void test01JugadorRespondeCorrectamentePreguntaVerdaderoFalsoPenalizableSinMultiplicadoresObtiene1PuntoEnEseTurno(){
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

        String consigna = "es g(x)=x-F(x) una funcion de punto fijo de F(x)?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);


        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        int puntajeParcialJugador1 = turnoJugador1.obtenerPuntajeParcial();

        assertEquals(1,puntajeParcialJugador1);

    }

    @Test
    public void test01JugadorRespondeCorrectamentePreguntaVerdaderoFalsoPenalizableConMultiplicadoresObtiene1PuntoEnEseTurno() {
        Opcion opcion1 = new Opcion("si");
        Opcion opcion2 = new Opcion("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "es g(x)=x-F(x) una funcion de punto fijo de F(x)?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion2);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);


        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        ModificadorMultiplicador unMultiplicador = new MultiplicadorX3();
        turnoJugador1.setMultiplicadorActivo(unMultiplicador);

        int puntajeParcialJugador1 = turnoJugador1.obtenerPuntajeParcial();
        int puntajeFinalJugador1 = unMultiplicador.aplicarModificador(puntajeParcialJugador1);

        turnoJugador1.asignarPuntajeFinal(puntajeParcialJugador1);

        assertEquals(-3,puntajeFinalJugador1);

    }


}
