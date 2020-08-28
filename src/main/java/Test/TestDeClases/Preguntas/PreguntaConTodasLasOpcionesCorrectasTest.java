package Test.TestDeClases.Preguntas;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;
import org.junit.jupiter.api.Test;

//multipleChoice clasico
public class PreguntaConTodasLasOpcionesCorrectasTest {
    @Test
    public void test01PreguntaMultipleChoiceClasicoRecibeTodasLasOpcionesCorrectasSinNingunaIncorrectaEntoncesDevuelve1Punto(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        //jugador elige opciones
        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);

        String consigna = "hay que testear?";
        Pregunta multipleChoiceClasico = new PreguntaConTodasOpcionesCorrectas(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(1,resultado);
    }
    @Test
    public void test02PreguntaMultipleChoiceClasicoRecibe2De3OpcionesCorrectasSinNingunaIncorrectaEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);

        String consigna = "hay que testear?";
        Pregunta multipleChoiceClasico = new PreguntaConTodasOpcionesCorrectas(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(0,resultado);
    }
    @Test
    public void test03PreguntaMultipleChoiceClasicoTodasLasOpcionesCorrectasYAlgunaIncorrectaEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();

        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);
        opcionesDeUnJugador.add(opcionIncorrecta);

        String consigna = "hay que testear?";
        Pregunta multipleChoiceClasico = new PreguntaConTodasOpcionesCorrectas(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoiceClasico.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(0,resultado);
    }
    @Test
    public void JugadorNoEligeOpcionesEntoncesPreguntaMultipleChoiceClasicoDevuelve0puntos(){
        //Arrange
        Opcion opcionCorrectaUno = new OpcionCorrecta("Seeee");
        Opcion opcionCorrectaDos = new OpcionCorrecta("Clarin");
        Opcion opcionCorrectaTres = new OpcionCorrecta("Por su pollo");
        Opcion opcionIncorrecta = new OpcionIncorrecta("nop");
        ArrayList<Opcion> opcionesApresentar = new ArrayList<>();
        opcionesApresentar.add(opcionCorrectaUno);
        opcionesApresentar.add(opcionCorrectaDos);
        opcionesApresentar.add(opcionCorrectaTres);
        opcionesApresentar.add(opcionIncorrecta);

        ArrayList<Opcion> opcionesDeUnJugador = new ArrayList<>();
        opcionesDeUnJugador.add(opcionCorrectaUno);
        opcionesDeUnJugador.add(opcionCorrectaDos);
        opcionesDeUnJugador.add(opcionCorrectaTres);
        opcionesDeUnJugador.add(opcionIncorrecta);

        String consigna = "hay que testear?";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesCorrectas(consigna,opcionesApresentar);

        //Act
        int resultado = multipleChoice.evaluarOpcionesElegidas(opcionesDeUnJugador);
        //Assert
        assertEquals(0,resultado);
    }
}
