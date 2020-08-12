package Test.TestDeClases.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    @Test
    public void test01CuandoPartidaTerminaDevuelveDatosDeJugadoresOrdenadosPorMayorPuntaje(){
        Partida algohoot = new Partida();
        algohoot.agregarJugador("condorito");
        algohoot.agregarJugador("Jet");

        List<Jugador> jugadores = algohoot.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        jugador1.modificarPuntaje(2);

        Jugador jugador2 = jugadores.get(1);
        jugador1.modificarPuntaje(5);

        List<String > datosFinalesDeJugadores = algohoot.obtenerResultadoPartida();
        String resultado1 = datosFinalesDeJugadores.get(0);
        String resultado2 = datosFinalesDeJugadores.get(1);

        assertEquals(jugador2.toString(), resultado1);
        assertEquals(jugador1.toString(), resultado2);
    }
}
