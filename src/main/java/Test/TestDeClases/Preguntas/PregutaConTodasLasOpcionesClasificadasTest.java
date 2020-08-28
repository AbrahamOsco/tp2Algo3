package Test.TestDeClases.Preguntas;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

//orederdChoice
//groupChoice
public class PregutaConTodasLasOpcionesClasificadasTest {
    @Test
    public void test01PreguntaOrderedChoiceRecibeLasOpcionesDelJugadorOrdenadasBienEntoncesDevuelve1Punto(){
        //Arrange
        Opcion opcion1 = new OpcionPertenencia("5",2);
        Opcion opcion2 = new OpcionPertenencia("10",3);
        Opcion opcion3 = new OpcionPertenencia("0",1);
        Opcion opcion4 = new OpcionPertenencia("15",4);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //jugador elige opciones en el orden que cree correcto:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y ubicacion correcta)cuya posicion actual sera seteada con la que el crea que es la correcta
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        OpcionPertenencia opcion1Jugador = new OpcionPertenencia("5",2);
        opcion1Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador = new OpcionPertenencia("10",3);
        opcion2Jugador.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador = new OpcionPertenencia("0",1);
        opcion3Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador = new OpcionPertenencia("15",4);
        opcion4Jugador.setUbicacionActual(4);

        opcionesDeJugador.add(opcion1Jugador);
        opcionesDeJugador.add(opcion2Jugador);
        opcionesDeJugador.add(opcion3Jugador);
        opcionesDeJugador.add(opcion4Jugador);

        //Act
        int resultado = orderedChoice.evaluarOpcionesElegidas(opcionesDeJugador);
        //Assert
        assertEquals(1,resultado);
    }
    @Test
    public void test02PreguntaOrderedChoiceRecibeLasOpcionesDelJugadorOrdenadasMalEntoncesDevuelve0Puntos(){
        //Arrange
        Opcion opcion1 = new OpcionPertenencia("5",2);
        Opcion opcion2 = new OpcionPertenencia("10",3);
        Opcion opcion3 = new OpcionPertenencia("0",1);
        Opcion opcion4 = new OpcionPertenencia("15",4);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //jugador elige opciones en el orden que cree correcto:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y ubicacion correcta)cuya posicion actual sera seteada con la que el crea que es la correcta
        ArrayList<Opcion> opcionesDeJugador = new ArrayList<>();
        OpcionPertenencia opcion1Jugador = new OpcionPertenencia("5",2);
        opcion1Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador = new OpcionPertenencia("10",3);
        opcion2Jugador.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador = new OpcionPertenencia("0",1);
        opcion3Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion4Jugador = new OpcionPertenencia("15",4);
        opcion4Jugador.setUbicacionActual(4);

        opcionesDeJugador.add(opcion1Jugador);
        opcionesDeJugador.add(opcion2Jugador);
        opcionesDeJugador.add(opcion3Jugador);
        opcionesDeJugador.add(opcion4Jugador);

        //Act
        int resultado = orderedChoice.evaluarOpcionesElegidas(opcionesDeJugador);
        //Assert
        assertEquals(0,resultado);
    }
    @Test
    public void test03PreguntaGroupChoiceRecibeLasOpcionesDelJugadorAgrupadasBienEntoncesDevuelve1Punto(){
        //Arrange
        OpcionPertenencia opcion1 = new OpcionPertenencia("Hola",1);
        OpcionPertenencia opcion2 = new OpcionPertenencia("100",2);
        OpcionPertenencia opcion3 = new OpcionPertenencia("341",1);
        OpcionPertenencia opcion4 = new OpcionPertenencia("Azul",2);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "coloca las palabras en el grupo 1 y los numeros en el grupo 2";
        Pregunta groupChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        ///jugador agrupan opciones en los grupos que crea correctos:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y grupo correcto)cuyo grupo actual sera seteado segun el grupo  en el que lo coloque el jugador
        ArrayList<Opcion> opcionesAgrupadasPorJugador = new ArrayList<>();
        OpcionPertenencia opcion1Jugador = new OpcionPertenencia("Hola",1);
        opcion1Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador = new OpcionPertenencia("100",2);
        opcion2Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador = new OpcionPertenencia("341",1);
        opcion3Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador = new OpcionPertenencia("Azul",2);
        opcion4Jugador.setUbicacionActual(2);

        opcionesAgrupadasPorJugador.add(opcion1Jugador);
        opcionesAgrupadasPorJugador.add(opcion2Jugador);
        opcionesAgrupadasPorJugador.add(opcion3Jugador);
        opcionesAgrupadasPorJugador.add(opcion4Jugador);

        //Act
        int resultado = groupChoice.evaluarOpcionesElegidas(opcionesAgrupadasPorJugador);

        //Assert
        assertEquals(1, resultado);
    }
    @Test
    public void test04PreguntaGroupChoiceRecibeLasOpcionesDelJugadorAgrupadasMalEntoncesDevuelve0Puntos(){
        //Arrange
        OpcionPertenencia opcion1 = new OpcionPertenencia("Hola",1);
        OpcionPertenencia opcion2 = new OpcionPertenencia("100",2);
        OpcionPertenencia opcion3 = new OpcionPertenencia("341",1);
        OpcionPertenencia opcion4 = new OpcionPertenencia("Azul",2);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "coloca las palabras en el grupo 1 y los numeros en el grupo 2";
        Pregunta groupChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        ///jugador agrupan opciones en los grupos que crea correctos:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y grupo correcto)cuyo grupo actual sera seteado segun el grupo  en el que lo coloque el jugador
        ArrayList<Opcion> opcionesAgrupadasPorJugador = new ArrayList<>();
        OpcionPertenencia opcion1Jugador = new OpcionPertenencia("Hola",1);
        opcion1Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador = new OpcionPertenencia("100",2);
        opcion2Jugador.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador = new OpcionPertenencia("341",1);
        opcion3Jugador.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador = new OpcionPertenencia("Azul",2);
        opcion4Jugador.setUbicacionActual(1);

        opcionesAgrupadasPorJugador.add(opcion1Jugador);
        opcionesAgrupadasPorJugador.add(opcion2Jugador);
        opcionesAgrupadasPorJugador.add(opcion3Jugador);
        opcionesAgrupadasPorJugador.add(opcion4Jugador);

        //Act
        int resultado = groupChoice.evaluarOpcionesElegidas(opcionesAgrupadasPorJugador);

        //Assert
        assertEquals(0, resultado);
    }
}
