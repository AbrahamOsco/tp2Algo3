package Test.TestDeClases.Turno;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Evaluables.Evaluable;
import edu.fiuba.algo3.modelo.Evaluables.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Evaluables.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void test01JugadorRespondeCorrectamentePreguntaVerdaderoFalsoPenalizableSinMultiplicadoresObtiene1PuntoEnEseTurno(){
        //Arrange
        Evaluable opcion1 = new OpcionCorrecta("si");
        Evaluable opcion2 = new OpcionIncorrecta("no");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "es g(x)=x-F(x) una funcion de punto fijo de F(x)?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        int puntajeParcialJugador1 = turnoJugador1.obtenerPuntajeParcial();

        assertEquals(1,puntajeParcialJugador1);

    }

    @Test
    public void test01JugadorRespondeCorrectamentePreguntaVerdaderoFalsoPenalizableConMultiplicadoresObtiene1PuntoEnEseTurno() {
        Evaluable opcion1 = new OpcionCorrecta("si");
        Evaluable opcion2 = new OpcionIncorrecta("no");

        ArrayList<Evaluable> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "es g(x)=x-F(x) una funcion de punto fijo de F(x)?";
        Pregunta verdaderoFalsoPenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Evaluable> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion2);


        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(verdaderoFalsoPenalizable,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        ModificadorMultiplicador unMultiplicador = new MultiplicadorX3();
        turnoJugador1.setMultiplicadorActivo(unMultiplicador);

        int puntajeParcialJugador1 = turnoJugador1.obtenerPuntajeParcial();
        int puntajeFinalJugador1 = unMultiplicador.aplicarModificador(puntajeParcialJugador1);

        turnoJugador1.asignarPuntajeFinal(puntajeParcialJugador1);

        assertEquals(-3,puntajeFinalJugador1);

    }

}
