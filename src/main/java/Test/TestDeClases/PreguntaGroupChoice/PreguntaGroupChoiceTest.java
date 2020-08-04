package Test.TestDeClases.PreguntaGroupChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {
    @Test
    public void test01SeAgrupanLasOpcionesCorrectamenteYDevuelveUnPunto(){
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

        Pregunta groupChoice = new PreguntaGroupChoice("Ordenas en grupos", opcionesAPresentar,listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesGrupoAJugador = new ArrayList<>();
        opcionesGrupoAJugador.add(opcion1A);
        opcionesGrupoAJugador.add(opcion2A);
        opcionesGrupoAJugador.add(opcion3A);

        ArrayList<Opcion> opcionesGrupoBJugador = new ArrayList<>();
        opcionesGrupoBJugador.add(opcion1B);
        opcionesGrupoBJugador.add(opcion2B);
        opcionesGrupoBJugador.add(opcion3B);

        listaDeListaDeOpcionesJugador.add(opcionesGrupoAJugador);
        listaDeListaDeOpcionesJugador.add(opcionesGrupoBJugador);

        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,listaDeListaDeOpcionesJugador);

        //Act
        int resultado = groupChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(1,resultado);

    }

    @Test
    public void test02SeAgrupanLasOpcionesIncorrectamenteYDevuelveCeroPuntos(){
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

        Pregunta groupChoice = new PreguntaGroupChoice("Ordenas en grupos", opcionesAPresentar,listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesGrupoAJugador = new ArrayList<>();
        opcionesGrupoAJugador.add(opcion1A);
        opcionesGrupoAJugador.add(opcion2B);
        opcionesGrupoAJugador.add(opcion3B);

        ArrayList<Opcion> opcionesGrupoBJugador = new ArrayList<>();
        opcionesGrupoBJugador.add(opcion1B);
        opcionesGrupoBJugador.add(opcion2A);
        opcionesGrupoBJugador.add(opcion3A);

        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,listaDeListaDeOpcionesJugador);

        listaDeListaDeOpcionesJugador.add(opcionesGrupoAJugador);
        listaDeListaDeOpcionesJugador.add(opcionesGrupoBJugador);
        //Act
        int resultado = groupChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(0,resultado);

    }
    @Test
    public void test03SeAgrupanNoTodasLasOpcionesYDevuelveCeroPuntos(){
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

        Pregunta groupChoice = new PreguntaGroupChoice("Ordenas en grupos", opcionesAPresentar,listaDeListaDeOpcionesCorrectas);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador = new ArrayList<>();
        ArrayList<Opcion> opcionesGrupoAJugador = new ArrayList<>();
        opcionesGrupoAJugador.add(opcion1A);
        opcionesGrupoAJugador.add(opcion2A);
        opcionesGrupoAJugador.add(opcion3A);

        ArrayList<Opcion> opcionesGrupoBJugador = new ArrayList<>();
        opcionesGrupoBJugador.add(opcion1B);
        opcionesGrupoBJugador.add(opcion2B);

        Jugador unJugador = new Jugador("Jet");
        Respuesta unaRespuesta = new Respuesta(unJugador,listaDeListaDeOpcionesJugador);

        listaDeListaDeOpcionesJugador.add(opcionesGrupoAJugador);
        listaDeListaDeOpcionesJugador.add(opcionesGrupoBJugador);
        //Act
        int resultado = groupChoice.evaluarRespuesta(unaRespuesta);
        //Assert
        assertEquals(0,resultado);

    }
}
