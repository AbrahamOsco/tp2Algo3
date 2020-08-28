package Test.TestDeClases.Turno;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTests {

    @Test
    public void test01asignarPuntajeFinal () {

        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Falso");
        Opcion opcion2 = new OpcionIncorrecta("Verdadero");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Cayo Julio Cesar murió en el año 45 BC";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        Jugador jugador1 = new Jugador("Cicero");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico,jugador1);

        //Act
        turnoJugador1.asignarPuntajeFinal(1);
        int puntosJugador1 = jugador1.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);

    }

    @Test
    public void test02obtenerPuntajeParcial () {

        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Falso");
        Opcion opcion2 = new OpcionIncorrecta("Verdadero");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);

        String consigna = "Micky Vainilla es un conocido rockero argentino";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        Jugador jugador1 = new Jugador("Calamardo");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        //Act
        int puntajeParcial = turnoJugador1.obtenerPuntajeParcial();

        //Assert
        assertEquals(1, puntajeParcial);

    }

}