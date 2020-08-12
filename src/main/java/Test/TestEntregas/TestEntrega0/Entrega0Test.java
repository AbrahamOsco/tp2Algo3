package Test.TestEntregas.TestEntrega0;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega0Test {
    @Test
    public void test01PreguntaDeVerdaderoFalsoClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Verdadero");
        Opcion opcion2 = new OpcionIncorrecta("Falso");

        ArrayList<Opcion> opciones = new ArrayList<>();

        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta unaPregunta = new PreguntaPuntajeParcialSinIncorrectos("La mayonesa es un instrumento musical", opciones);
        //Act
        boolean contieneRespuestaCorrecta = unaPregunta.getOpcionesCorrectas().contains(opcion1);
        //Assert
        assertTrue(contieneRespuestaCorrecta);
    }
    @Test
    public void test02PreguntaDeVerdaderoFalsoClasicoRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos() {
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico, jugador2);
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
