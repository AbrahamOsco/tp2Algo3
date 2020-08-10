package Test.TestEntregas.TestEntrega3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.Turno.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsignacionDePuntosConExclusividadTest {
    @Test
    public void test01PreguntaDeVerdaderoFalsoClasicoJugador1RespondeBienYActivaExclusividadYJugador2RespondeMal() {
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

        Ronda unaRonda = new Ronda();

        if(jugador1.activarMultiplicador("puntajeExclusivo")){
            unaRonda.agregarExclusividad();
        }

        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test02PreguntaDeVerdaderoFalsoClasicoJugador1RespondeBienYJugador2RespondeMalYAmbosActivanExclusividad() {
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);


        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);
        Ronda unaRonda = new Ronda();

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion2);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico, jugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo")){
            unaRonda.agregarExclusividad();
        }

        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);
        if(jugador1.activarMultiplicador("puntajeExclusivo")){
            unaRonda.agregarExclusividad();
        }

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(4, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test03PreguntaDeVerdaderoFalsoClasicoJugador1RespondeBienYJugador2RespondeBienYAmbosActivanExclusividad() {
        Opcion opcion1 = new OpcionCorrecta("si");
        Opcion opcion2 = new OpcionIncorrecta("no");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);


        String consigna = "Es 5 + 5 igual a 10?";
        Pregunta verdaderoFalsoClasico = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);
        Ronda unaRonda = new Ronda();

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);

        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(verdaderoFalsoClasico, jugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo")){
            unaRonda.agregarExclusividad();
        }

        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(verdaderoFalsoClasico, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);
        if(jugador1.activarMultiplicador("puntajeExclusivo")){
            unaRonda.agregarExclusividad();
        }

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test04PreguntaMultipleChoiceDePuntajeParcialJugador1Responde3BienYJugador2Responde2BienYAmbosActivanExclusividad(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("A");
        Opcion opcion2 = new OpcionIncorrecta("5");
        Opcion opcion3 = new OpcionCorrecta("B");
        Opcion opcion4 = new OpcionCorrecta("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion4);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);

        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Maho");
        Turno turnoJugador1 = new Turno(multipleChoicePuntajeParcial, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Ryuk");
        Turno turnoJugador2 = new Turno(multipleChoicePuntajeParcial, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        if(jugador2.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(12, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }
    @Test
    public void test05PreguntaMultipleChoiceDePuntajeParcialJugador1Responde4BienYUsaExclusividadyJugador2Responde3BienyDeberiatenerCeroPuntos(){
        //Arrange Test donde se pone a prueba un supuesto que definimos.
        Opcion opcion1 = new OpcionCorrecta("Peru");
        Opcion opcion2 = new OpcionCorrecta("Argentina");
        Opcion opcion3 = new OpcionCorrecta("Bolivia");
        Opcion opcion4 = new OpcionIncorrecta("Rusia");
        Opcion opcion5 = new OpcionCorrecta("Ecuador");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecciones paises de america Latina ";
        Pregunta multipleChoicePuntajeParcial = new PreguntaPuntajeParcialSinIncorrectos(consigna, opcionesAPresentar);

        //jugadores eligen opciones//jugador1RespondeTodasBien
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion5);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);


        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(multipleChoicePuntajeParcial, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(multipleChoicePuntajeParcial, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(8, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }
    @Test
    public void test06PreguntaMultipleChoiceClasicoJugador1RespondeTodasBienYUsaExclusividadyJugador2RespondeTodasBien(){
        //Arrange //Test donde se pone a prueba la definicion de exclusividad.
        Opcion opcion1 = new OpcionCorrecta("Peru");
        Opcion opcion2 = new OpcionCorrecta("Argentina");
        Opcion opcion3 = new OpcionCorrecta("Bolivia");
        Opcion opcion4 = new OpcionIncorrecta("Rusia");
        Opcion opcion5 = new OpcionCorrecta("Ecuador");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecciones paises de america Latina ";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesAPresentar);

        //jugadores eligen opciones//jugador1RespondeTodasBien
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion5);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion5);


        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(multipleChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(multipleChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test07PreguntaMultipleChoiceClasicoJugador1RespondeTodasBienYUsaExclusividadyJugador2RespondeSolo3Bien(){
        //Arrange
        Opcion opcion1 = new OpcionCorrecta("Peru");
        Opcion opcion2 = new OpcionCorrecta("Argentina");
        Opcion opcion3 = new OpcionCorrecta("Bolivia");
        Opcion opcion4 = new OpcionIncorrecta("Rusia");
        Opcion opcion5 = new OpcionCorrecta("Ecuador");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecciones paises de america Latina ";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesAPresentar);

        //jugadores eligen opciones//jugador1RespondeTodasBien
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion5);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);



        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(multipleChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(multipleChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }

    @Test
    public void test08PreguntaMultipleChoiceClasicoJugador1RespondeTodasBienyJugador2RespondeSolo3BienyAmbosUsaExclusividad(){
        //Arrange

        Opcion opcion1 = new OpcionCorrecta("Peru");
        Opcion opcion2 = new OpcionCorrecta("Argentina");
        Opcion opcion3 = new OpcionCorrecta("Bolivia");
        Opcion opcion4 = new OpcionIncorrecta("Rusia");
        Opcion opcion5 = new OpcionCorrecta("Ecuador");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecciones paises de america Latina ";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesAPresentar);

        //jugadores eligen opciones//jugador1RespondeTodasBien
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion5);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);



        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(multipleChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(multipleChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        if(jugador2.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(4, puntosJugador1);
        assertEquals(0, puntosJugador2);
    }
    @Test
    public void test09PreguntaMultipleChoiceClasicoJugador1Responde3BienYUsaExclusividadyJugador2RespondeTodasBien(){
        //Arrange //se prueba otra definicion de exclusivdad basta que un jugador active exclusivdad para que la regla afecta a ambos.

        Opcion opcion1 = new OpcionCorrecta("Peru");
        Opcion opcion2 = new OpcionCorrecta("Argentina");
        Opcion opcion3 = new OpcionCorrecta("Bolivia");
        Opcion opcion4 = new OpcionIncorrecta("Rusia");
        Opcion opcion5 = new OpcionCorrecta("Ecuador");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        String consigna = "Selecciones paises de america Latina ";
        Pregunta multipleChoice = new PreguntaConTodasOpcionesCorrectas(consigna, opcionesAPresentar);

        //jugadores eligen opciones//jugador1RespondeTodasBien
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);


        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion5);



        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(multipleChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(multipleChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();

        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(2, puntosJugador2);
    }

    @Test
    public void test09PreguntaOrderedChoiceJugador1RespondeBienyActivaExclusivdadyJugador2RespondeMalYActivaExclusivdad(){

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
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("5",2);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("10",3);
        opcion2Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("0",1);
        opcion3Jugador2.setUbicacionActual(3);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("15",4);
        opcion4Jugador2.setUbicacionActual(4);

        opcionesDeJugador2.add(opcion1Jugador2);
        opcionesDeJugador2.add(opcion2Jugador2);
        opcionesDeJugador2.add(opcion3Jugador2);
        opcionesDeJugador2.add(opcion4Jugador2);


        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(orderedChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(orderedChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);

        if(jugador2.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(4, puntosJugador1);
        assertEquals(0, puntosJugador2);

    }
    @Test
    public void test10PreguntaOrderedChoiceJugador1RespondeBienyActivaExclusivdadyJugador2RespondeMal(){

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
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("5",2);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("10",3);
        opcion2Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("0",1);
        opcion3Jugador2.setUbicacionActual(3);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("15",4);
        opcion4Jugador2.setUbicacionActual(4);

        opcionesDeJugador2.add(opcion1Jugador2);
        opcionesDeJugador2.add(opcion2Jugador2);
        opcionesDeJugador2.add(opcion3Jugador2);
        opcionesDeJugador2.add(opcion4Jugador2);


        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(orderedChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(orderedChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(0, puntosJugador2);

    }
    @Test
    public void test11PreguntaOrderedChoiceJugador1RespondeMalyActivaExclusivdadyJugador2RespondeBien(){

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
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador1 = new OpcionPertenencia("5",2);
        opcion1Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador1 = new OpcionPertenencia("10",3);
        opcion2Jugador1.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador1 = new OpcionPertenencia("0",1);
        opcion3Jugador1.setUbicacionActual(3);
        OpcionPertenencia opcion4Jugador1 = new OpcionPertenencia("15",4);
        opcion4Jugador1.setUbicacionActual(4);

        opcionesDeJugador1.add(opcion1Jugador1);
        opcionesDeJugador1.add(opcion2Jugador1);
        opcionesDeJugador1.add(opcion3Jugador1);
        opcionesDeJugador1.add(opcion4Jugador1);

        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("5",2);
        opcion1Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("10",3);
        opcion2Jugador2.setUbicacionActual(3);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("0",1);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("15",4);
        opcion4Jugador2.setUbicacionActual(4);

        opcionesDeJugador2.add(opcion1Jugador2);
        opcionesDeJugador2.add(opcion2Jugador2);
        opcionesDeJugador2.add(opcion3Jugador2);
        opcionesDeJugador2.add(opcion4Jugador2);


        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(orderedChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesDeJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(orderedChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesDeJugador2);


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(2, puntosJugador2);

    }
//hacertestDeGroupChoice
    @Test
    public void test12PreguntaGroupChoiceJugador1RespondeBienyActivaExclusivdadyJugador2RespondeMal(){

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

        ArrayList<Opcion> opcionesAgrupadasPorJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("Hola",1);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("100",2);
        opcion2Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("341",1);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("Azul",2);
        opcion4Jugador2.setUbicacionActual(2);

        opcionesAgrupadasPorJugador2.add(opcion1Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion2Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion3Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion4Jugador2);




        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(groupChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesAgrupadasPorJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(groupChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesAgrupadasPorJugador2);


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(2, puntosJugador1);
        assertEquals(0, puntosJugador2);

    }

    @Test
    public void test13PreguntaGroupChoiceJugador1yJugador2AmbosRespondenBienyAmbosAplicanExclusividades(){

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

        ArrayList<Opcion> opcionesAgrupadasPorJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("Hola",1);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("100",2);
        opcion2Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("341",1);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("Azul",2);
        opcion4Jugador2.setUbicacionActual(2);

        opcionesAgrupadasPorJugador2.add(opcion1Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion2Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion3Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion4Jugador2);




        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(groupChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesAgrupadasPorJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(groupChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesAgrupadasPorJugador2);

        if(jugador2.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();


        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(0, puntosJugador2);


    }
    @Test
    public void test14PreguntaGroupChoiceJugador1RespondeBienYJugador2RespondeMalYAmbosAplicanExclusividades(){

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

        ArrayList<Opcion> opcionesAgrupadasPorJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("Hola",1);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("100",2);
        opcion2Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("341",1);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("Azul",2);
        opcion4Jugador2.setUbicacionActual(2);

        opcionesAgrupadasPorJugador2.add(opcion1Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion2Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion3Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion4Jugador2);




        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(groupChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesAgrupadasPorJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(groupChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesAgrupadasPorJugador2);
        if(jugador2.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();



        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(4, puntosJugador1);
        assertEquals(0, puntosJugador2);

    }
    @Test
    public void test15PreguntaGroupChoiceJugador1RespondeMalYActivaExclusividadJugador2RespondeBien(){

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
        ArrayList<Opcion> opcionesAgrupadasPorJugador1 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador1 = new OpcionPertenencia("Hola",1);
        opcion1Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador1 = new OpcionPertenencia("100",2);
        opcion2Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion3Jugador1 = new OpcionPertenencia("341",1);
        opcion3Jugador1.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador1 = new OpcionPertenencia("Azul",2);
        opcion4Jugador1.setUbicacionActual(2);

        opcionesAgrupadasPorJugador1.add(opcion1Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion2Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion3Jugador1);
        opcionesAgrupadasPorJugador1.add(opcion4Jugador1);

        ArrayList<Opcion> opcionesAgrupadasPorJugador2 = new ArrayList<>();
        OpcionPertenencia opcion1Jugador2 = new OpcionPertenencia("Hola",1);
        opcion1Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion2Jugador2 = new OpcionPertenencia("100",2);
        opcion2Jugador2.setUbicacionActual(2);
        OpcionPertenencia opcion3Jugador2 = new OpcionPertenencia("341",1);
        opcion3Jugador2.setUbicacionActual(1);
        OpcionPertenencia opcion4Jugador2 = new OpcionPertenencia("Azul",2);
        opcion4Jugador2.setUbicacionActual(2);

        opcionesAgrupadasPorJugador2.add(opcion1Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion2Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion3Jugador2);
        opcionesAgrupadasPorJugador2.add(opcion4Jugador2);




        Ronda unaRonda = new Ronda();
        Jugador jugador1 = new Jugador("Darkoskure");
        Turno turnoJugador1 = new Turno(groupChoice, jugador1);
        turnoJugador1.setOpcionesElejidas(opcionesAgrupadasPorJugador1);

        if(jugador1.activarMultiplicador("puntajeExclusivo"))
            unaRonda.agregarExclusividad();

        Jugador jugador2 = new Jugador("Pedro");
        Turno turnoJugador2 = new Turno(groupChoice, jugador2);
        turnoJugador2.setOpcionesElejidas(opcionesAgrupadasPorJugador2);




        unaRonda.agregarTurno(turnoJugador1);
        unaRonda.agregarTurno(turnoJugador2);
        unaRonda.asignarPuntos();


        //Act
        int puntosJugador1 = jugador1.getPuntaje();
        int puntosJugador2 = jugador2.getPuntaje();

        //Assert
        assertEquals(0, puntosJugador1);
        assertEquals(2, puntosJugador2);
    }

}
