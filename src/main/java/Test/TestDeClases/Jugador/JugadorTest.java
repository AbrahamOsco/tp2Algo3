package Test.TestDeClases.Jugador;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JugadorTest {
    @Test
    public void test01JugadorPuedeUsarUnaVezElMultiplicadorx2(){
        //Arrange
        Jugador jugador = new Jugador("Elodin");

        //act
        boolean puedeActivaMultiplicadorx2 = jugador.activarMultiplicador("multiplicadorX2");

        //assert
        assertTrue(puedeActivaMultiplicadorx2);
    }
    @Test
    public void test02JugadorPuedeUsarUnaVezElMultiplicadorx3(){
        //Arrange
        Jugador jugador = new Jugador("Elodin");

        //act
        boolean puedeActivaMultiplicadorx3 = jugador.activarMultiplicador("multiplicadorX2");

        //assert
        assertTrue(puedeActivaMultiplicadorx3);
    }
    @Test
    public void test03JugadorNoPuedeUsarDosVecesElMultiplicadorx2PorqueSoloTiene1DeEseTipo(){
        //Arrange
        Jugador jugador = new Jugador("Elodin");
        boolean puedeActivaMultiplicadorx2 = jugador.activarMultiplicador("multiplicadorX2");

        //act
        //jugador intenta volver a activar el multiplcadorx2 y le debe tirar false
        puedeActivaMultiplicadorx2 = jugador.activarMultiplicador("multiplicadorX2");

        //assert
        assertFalse(puedeActivaMultiplicadorx2);
    }

    @Test
    public void test04JugadorNoPuedeUsarDosVecesElMultiplicadorx3PorqueSoloTiene1DeEseTipo(){
        //Arrange
        Jugador jugador = new Jugador("Elodin");
        boolean puedeActivaMultiplicadorx3 = jugador.activarMultiplicador("multiplicadorX3");

        //act
        //jugador intenta volver a activar el multiplcadorx3 y le debe tirar false
        puedeActivaMultiplicadorx3 = jugador.activarMultiplicador("multiplicadorX3");

        //assert
        assertFalse(puedeActivaMultiplicadorx3);
    }
}
