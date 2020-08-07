package Test.TestEntregas.TestEntrega2;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsignacionDePuntosSinMultiplicadoresTest {
    @Test
    public void test01PreguntaMultipleChoiceDePenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("A");
        Opcion opcion2 = new OpcionIncorrecta("5");
        Opcion opcion3 = new OpcionCorrecta("B");
        Opcion opcion4 = new OpcionCorrecta("N");
        Opcion opcion5 = new OpcionCorrecta("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePenalizable = new PreguntaPuntajeParcialPenalizable(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion5);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoicePenalizable,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoicePenalizable,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

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
        OpcionPertenencia opcion1 = new OpcionPertenencia("5",2);
        OpcionPertenencia opcion2 = new OpcionPertenencia("10",3);
        OpcionPertenencia opcion3 = new OpcionPertenencia("0",1);
        OpcionPertenencia opcion4 = new OpcionPertenencia("15",4);

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaConTodasOpcionesClasificadas(consigna, opcionesAPresentar);

        //jugadores eligen opciones en el orden que creen es el correcto:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y ubicacion correcta)cuya posicion actual sera seteada con la que el crea que es la correcta
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador1 = new OpcionPertenencia("5",2);
        opcion1Jugador1.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador1 = new OpcionPertenencia("10",3);
        opcion2Jugador1.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador1 = new OpcionPertenencia("0",1);
        opcion3Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador1 = new OpcionPertenencia("15",4);
        opcion4Jugador1.setUbicacionActual(4);

        opcionesDeJugador1.add(opcion1Jugador1);
        opcionesDeJugador1.add(opcion2Jugador1);
        opcionesDeJugador1.add(opcion3Jugador1);
        opcionesDeJugador1.add(opcion4Jugador1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("5",1);
        opcion1Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("10",3);
        opcion2Jugador2.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("0",2);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("15",4);
        opcion4Jugador2.setUbicacionActual(4);

        opcionesDeJugador2.add(opcion1Jugador2);
        opcionesDeJugador2.add(opcion2Jugador2);
        opcionesDeJugador2.add(opcion3Jugador2);
        opcionesDeJugador2.add(opcion4Jugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(orderedChoice,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(orderedChoice,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        Ronda unaRonda = new Ronda();
        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(1, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test03PreguntaGroupChoiceRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
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

        ///jugadores agrupan opciones en los grupos que crean correctos:
        //cuando el jugador elige una opcion de las opciones mostradas, se crea una opcion igual(misma descripcion
        // y grupo correcto)cuyo grupo actual sera seteado segun el grupo  en el que lo coloque el jugador
        ArrayList<Opcion> opcionesAgrupadasPorJugador1 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador1 = new OpcionPertenencia("Hola",1);
        opcion1Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador1 = new OpcionPertenencia("100",2);
        opcion2Jugador1.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador1 = new OpcionPertenencia("341",1);
        opcion3Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador1 = new OpcionPertenencia("Azul",2);
        opcion4Jugador1.setUbicacionActual(2);

        opcionesAgrupadasPorJugador1.add(opcion1Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion2Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion3Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion4Jugador1);

        //jugador2 (falla)
        ArrayList<Opcion> opcionesAgrupadasPorJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("Hola",1);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("100",2);
        opcion2Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("341",1);
        opcion3Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("Azul",2);
        opcion4Jugador2.setUbicacionActual(2);

        opcionesAgrupadasPorJugador2.add(opcion1Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion2Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion3Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion4Jugador2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(groupChoice,jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesAgrupadasPorJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(groupChoice,jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesAgrupadasPorJugador2);

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
