package Test.TestDeEntregas.Entrega2;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaVerdaderoFalsoPenalizable;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2AsignacionDePuntosConMultiplicadoresTest {


    @Test
    public void test01PreguntaDeVerdaderoFalsoPenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntosJugador2usaX3(){
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
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoPenalizable,jugador2);
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
        assertEquals(1, puntosJugador1);
        assertEquals(-3, puntosJugador2);
    }

    @Test
    public void test02PreguntaMultipleChoiceDePenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntosJugador1UsaX2YJugador2UsaX3(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

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

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePenalizable = new PreguntaMultipleChoicePenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

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

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoicePenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);
        if(jugador1.activarMultiplicador("multiplicadorX2")){
            ModificadorMultiplicador unMultiplicador = new MultiplicadorX2();
            turnoJugador1.setMultiplicadorActivo(unMultiplicador);
        }

        Jugador jugador2 = new Jugador("Ryuk");
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
