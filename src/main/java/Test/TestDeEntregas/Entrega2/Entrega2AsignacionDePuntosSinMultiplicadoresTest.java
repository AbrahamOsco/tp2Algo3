package Test.TestDeEntregas.Entrega2;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaMultipleChoicePenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntasNoGroupChoice.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2AsignacionDePuntosSinMultiplicadoresTest {


    @Test
    public void test01PreguntaMultipleChoiceDePenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoicePenalizable,jugador2);
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
        assertEquals(3, puntosJugador2);
    }


    @Test
    public void test02PreguntaOrderedChoiceRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos() {
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

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion4);

        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion2);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(orderedChoice,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(orderedChoice,jugador2);
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
    public void test03PreguntaGroupChoiceRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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
        Pregunta groupChoice = new PreguntaGroupChoice(consigna, opcionesAPresentar,listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones en los grupos que crean que son los correctos
        //jugador1 (acierta)
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();

        ArrayList<Opcion> primerListaOpcionesDeJugador1 = new ArrayList<>();
        primerListaOpcionesDeJugador1.add(opcion1A);
        primerListaOpcionesDeJugador1.add(opcion2A);
        primerListaOpcionesDeJugador1.add(opcion3A);

        ArrayList<Opcion> SegundaListaOpcionesDeJugador1 = new ArrayList<>();
        SegundaListaOpcionesDeJugador1.add(opcion1B);
        SegundaListaOpcionesDeJugador1.add(opcion2B);
        SegundaListaOpcionesDeJugador1.add(opcion3B);

        listaDeListaDeOpcionesJugador1.add(primerListaOpcionesDeJugador1);
        listaDeListaDeOpcionesJugador1.add(SegundaListaOpcionesDeJugador1);

        //jugador2 (falla)
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();

        ArrayList<Opcion> primerListaOpcionesDeJugador2 = new ArrayList<>();
        primerListaOpcionesDeJugador2.add(opcion1B);
        primerListaOpcionesDeJugador2.add(opcion2A);
        primerListaOpcionesDeJugador2.add(opcion3A);

        ArrayList<Opcion> SegundaListaOpcionesDeJugador2 = new ArrayList<>();
        SegundaListaOpcionesDeJugador2.add(opcion1A);
        SegundaListaOpcionesDeJugador2.add(opcion2B);
        SegundaListaOpcionesDeJugador2.add(opcion3B);

        listaDeListaDeOpcionesJugador2.add(primerListaOpcionesDeJugador2);
        listaDeListaDeOpcionesJugador2.add(SegundaListaOpcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(groupChoice,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(groupChoice,jugador2);
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
}
