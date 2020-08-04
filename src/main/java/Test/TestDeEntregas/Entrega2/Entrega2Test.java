package Test.TestDeEntregas.Entrega2;

public class Entrega2Test {
    /*
    @Test
    public void test01PreguntaMultipleChoiceDePenalizablePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePenalizable = new PreguntaMultipleChoicePenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = multipleChoicePenalizable.getOpcionesCorrectas();
        ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        boolean contieneRespuestaCorrectaUno = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
        boolean contieneRespuestaCorrectaDos = primerListaDeOpcionesCorrectasDePregunta.contains(opcion3);
        boolean contieneRespuestaCorrectaTres = primerListaDeOpcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(contieneRespuestaCorrectaUno);
        assertTrue(contieneRespuestaCorrectaDos);
        assertTrue(contieneRespuestaCorrectaTres);
    }
    @Test
    public void test02PreguntaMultipleChoiceDePenalizableRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Opcion opcion1 = new Opcion("A");
        Opcion opcion2 = new Opcion("5");
        Opcion opcion3 = new Opcion("B");
        Opcion opcion4 = new Opcion("N");
        Opcion opcion5 = new Opcion("Z");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);
        opcionesAPresentar.add(opcion5);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion4);
        opcionesCorrectas.add(opcion5);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Selecione las opciones que representen letras del alfabeto";
        Pregunta multipleChoicePenalizable = new PreguntaMultipleChoicePenalizable(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion3);

        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion2);
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion5);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = multipleChoicePenalizable.evaluarOpcionesElegidas(respuestaJugador1);
        int puntosParaJugador2 = multipleChoicePenalizable.evaluarOpcionesElegidas(respuestaJugador2);

        //Assert
        assertEquals(1, puntosParaJugador1);
        assertEquals(3, puntosParaJugador2);
    }
    @Test
    public void test03PreguntaOrderedChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        //Arrange
        Opcion opcion1 = new Opcion("5");
        Opcion opcion2 = new Opcion("10");
        Opcion opcion3 = new Opcion("0");
        Opcion opcion4 = new Opcion("15");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion2);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaOrderedChoice(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = orderedChoice.getOpcionesCorrectas();
        ArrayList<Opcion> primerListaDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        boolean vaEnPosicion1 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion3);
        boolean vaEnPosicion2 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion1);
        boolean vaEnPosicion3 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion2);
        boolean vaEnPosicion4 = primerListaDeOpcionesCorrectasDePregunta.contains(opcion4);

        //Assert
        assertTrue(vaEnPosicion1);
        assertTrue(vaEnPosicion2);
        assertTrue(vaEnPosicion3);
        assertTrue(vaEnPosicion4);
    }
    @Test
    public void test04PreguntaOrderedChoiceRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos() {
        //Arrange
        Opcion opcion1 = new Opcion("5");
        Opcion opcion2 = new Opcion("10");
        Opcion opcion3 = new Opcion("0");
        Opcion opcion4 = new Opcion("15");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1);
        opcionesAPresentar.add(opcion2);
        opcionesAPresentar.add(opcion3);
        opcionesAPresentar.add(opcion4);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion3);
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion2);
        opcionesCorrectas.add(opcion4);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectas);

        String consigna = "Ordene los siguientes numeros de menor a mayor";
        Pregunta orderedChoice = new PreguntaOrderedChoice(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador1 = new ArrayList<>();
        opcionesDeJugador1.add(opcion3);
        opcionesDeJugador1.add(opcion1);
        opcionesDeJugador1.add(opcion2);
        opcionesDeJugador1.add(opcion4);

        listaDeListaDeOpcionesJugador1.add(opcionesDeJugador1);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();
        ArrayList<Opcion> opcionesDeJugador2 = new ArrayList<>();
        opcionesDeJugador2.add(opcion3);
        opcionesDeJugador2.add(opcion1);
        opcionesDeJugador2.add(opcion4);
        opcionesDeJugador2.add(opcion2);
        listaDeListaDeOpcionesJugador2.add(opcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = orderedChoice.evaluarOpcionesElegidas(respuestaJugador1);
        int puntosParaJugador2 = orderedChoice.evaluarOpcionesElegidas(respuestaJugador2);
        //Assert
        assertEquals(1, puntosParaJugador1);
        assertEquals(0, puntosParaJugador2);
    }
    @Test
    public void test05PreguntaGroupChoicePuedeCrearseIndicandoleCualEsLaRespuestaCorrecta() {
        //Arrange
        Opcion opcion1A = new Opcion("pertenesco a A");
        Opcion opcion2A = new Opcion("pertenesco a A");
        Opcion opcion3A = new Opcion("pertenesco a A");

        Opcion opcion1B = new Opcion("pertenesco a B");
        Opcion opcion2B = new Opcion("pertenesco a B");
        Opcion opcion3B = new Opcion("pertenesco a B");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1A);
        opcionesAPresentar.add(opcion2A);
        opcionesAPresentar.add(opcion3A);
        opcionesAPresentar.add(opcion1B);
        opcionesAPresentar.add(opcion2B);
        opcionesAPresentar.add(opcion3B);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectasGrupoA = new ArrayList<>();
        opcionesCorrectasGrupoA.add(opcion1A);
        opcionesCorrectasGrupoA.add(opcion2A);
        opcionesCorrectasGrupoA.add(opcion3A);

        ArrayList<Opcion> opcionesCorrectasGrupoB = new ArrayList<>();
        opcionesCorrectasGrupoB.add(opcion1B);
        opcionesCorrectasGrupoB.add(opcion2B);
        opcionesCorrectasGrupoB.add(opcion3B);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoA);
        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoB);

        String consigna = "Ordenas las opciones en sus correspondientes grupos";
        Pregunta groupChoice = new PreguntaGroupChoice(consigna, opcionesAPresentar, listaDeListaDeOpcionesCorrectas);

        //Act
        ArrayList<ArrayList<Opcion>> opcionesCorrectasPedidasAPregunta = groupChoice.getOpcionesCorrectas();

        ArrayList<Opcion> primerGrupoDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(0);
        ArrayList<Opcion> segundoGrupoDeOpcionesCorrectasDePregunta = opcionesCorrectasPedidasAPregunta.get(1);

        boolean opcion1AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion1A);
        boolean opcion2AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion2A);
        boolean opcion3AEstaEnGrupoA = primerGrupoDeOpcionesCorrectasDePregunta.contains(opcion3A);

        boolean opcion1BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion1B);
        boolean opcion2BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion2B);
        boolean opcion3BEstaEnGrupoB = segundoGrupoDeOpcionesCorrectasDePregunta.contains(opcion3B);

        //Assert
        assertTrue(opcion1AEstaEnGrupoA);
        assertTrue(opcion2AEstaEnGrupoA);
        assertTrue(opcion3AEstaEnGrupoA);

        assertTrue(opcion1BEstaEnGrupoB);
        assertTrue(opcion2BEstaEnGrupoB);
        assertTrue(opcion3BEstaEnGrupoB);
    }
    @Test
    public void test06PreguntaGroupChoiceRecibeLasOpcionesElegidasPorLosJugadoresEntoncesAsignaBienSusPuntos(){
        //Arrange
        Opcion opcion1A = new Opcion("pertenesco a A");
        Opcion opcion2A = new Opcion("pertenesco a A");
        Opcion opcion3A = new Opcion("pertenesco a A");

        Opcion opcion1B = new Opcion("pertenesco a B");
        Opcion opcion2B = new Opcion("pertenesco a B");
        Opcion opcion3B = new Opcion("pertenesco a B");

        ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
        opcionesAPresentar.add(opcion1A);
        opcionesAPresentar.add(opcion2A);
        opcionesAPresentar.add(opcion3A);
        opcionesAPresentar.add(opcion1B);
        opcionesAPresentar.add(opcion2B);
        opcionesAPresentar.add(opcion3B);

        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesCorrectas = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectasGrupoA = new ArrayList<>();
        opcionesCorrectasGrupoA.add(opcion1A);
        opcionesCorrectasGrupoA.add(opcion2A);
        opcionesCorrectasGrupoA.add(opcion3A);

        ArrayList<Opcion> opcionesCorrectasGrupoB = new ArrayList<>();
        opcionesCorrectasGrupoB.add(opcion1B);
        opcionesCorrectasGrupoB.add(opcion2B);
        opcionesCorrectasGrupoB.add(opcion3B);

        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoA);
        listaDeListaDeOpcionesCorrectas.add(opcionesCorrectasGrupoB);

        String consigna = "Ordenas las opciones en sus correspondientes grupos";
        Pregunta groupChoice = new PreguntaGroupChoice(consigna, opcionesAPresentar,listaDeListaDeOpcionesCorrectas);

        //jugadores eligen opciones en los grupos que crean que son los correctos
        //jugador1 (acierta)
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador1 = new ArrayList<>();

        ArrayList<Opcion> primerListaOpcionesDeJugador1 = new ArrayList<>();
        primerListaOpcionesDeJugador1.add(opcion1A);
        primerListaOpcionesDeJugador1.add(opcion2A);
        primerListaOpcionesDeJugador1.add(opcion3A);

        ArrayList<Opcion> SegundaListaOpcionesDeJugador1 = new ArrayList<>();
        SegundaListaOpcionesDeJugador1.add(opcion1B);
        SegundaListaOpcionesDeJugador1.add(opcion2B);
        SegundaListaOpcionesDeJugador1.add(opcion3B);

        listaDeListaDeOpcionesJugador1.add(primerListaOpcionesDeJugador1);
        listaDeListaDeOpcionesJugador1.add(SegundaListaOpcionesDeJugador1);

        //jugador2 (falla)
        ArrayList<ArrayList<Opcion>> listaDeListaDeOpcionesJugador2 = new ArrayList<>();

        ArrayList<Opcion> primerListaOpcionesDeJugador2 = new ArrayList<>();
        primerListaOpcionesDeJugador2.add(opcion1B);
        primerListaOpcionesDeJugador2.add(opcion2A);
        primerListaOpcionesDeJugador2.add(opcion3A);

        ArrayList<Opcion> SegundaListaOpcionesDeJugador2 = new ArrayList<>();
        SegundaListaOpcionesDeJugador2.add(opcion1A);
        SegundaListaOpcionesDeJugador2.add(opcion2B);
        SegundaListaOpcionesDeJugador2.add(opcion3B);

        listaDeListaDeOpcionesJugador2.add(primerListaOpcionesDeJugador2);
        listaDeListaDeOpcionesJugador2.add(SegundaListaOpcionesDeJugador2);

        Jugador jugador1 = new Jugador("Maho");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, listaDeListaDeOpcionesJugador1);

        Jugador jugador2 = new Jugador("Ryuk");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, listaDeListaDeOpcionesJugador2);

        //Act
        int puntosParaJugador1 = groupChoice.evaluarOpcionesElegidas(respuestaJugador1);
        int puntosParaJugador2 = groupChoice.evaluarOpcionesElegidas(respuestaJugador2);
        //Assert
        assertEquals(1, puntosParaJugador1);
        assertEquals(0, puntosParaJugador2);
    }*/
}
