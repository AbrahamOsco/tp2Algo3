package Test.TestDeClases.Ronda;

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

public class RondaTest {

    @Test
    public void JugadorActivaMultiplicadorX3EnPreguntaVerdaderoFalsoPenalizableEnUnaRondaYEnLaSiguienteNoPuedoUsarDenuevoMultiplicadorX3(){
        //Arrange
        Opcion opcion1 = new Opcion("si");
        Opcion opcion2 = new Opcion("no");

        ArrayList<Opcion> opcionesAPresentarRonda1 = new ArrayList<>();
        opcionesAPresentarRonda1.add(opcion1);
        opcionesAPresentarRonda1.add(opcion2);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectasRonda1 = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);

        listaDeListaDeOpcionesCorrectasRonda1.add(opcionesCorrectas);

        String consigna = "es g(x)=x-F(x) una funcion de punto fijo de F(x)?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaVerdaderoFalsoPenalizable(consigna, opcionesAPresentarRonda1, listaDeListaDeOpcionesCorrectasRonda1);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);


        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setListaDeListaDeOpcionesElejidas(listaDeListaDeOpcionesJugador1);
        if(jugador1.activarMultiplicador("multiplicadorX3")){
            ModificadorMultiplicador unMultiplicador = new MultiplicadorX3();
            turnoJugador1.setMultiplicadorActivo(unMultiplicador);
        }

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();

        //Assert

        assertEquals(3, puntosJugador1);

        Opcion opcion1Ronda2 = new Opcion("si");
        Opcion opcion2Ronda2 = new Opcion("no");



    }




}
