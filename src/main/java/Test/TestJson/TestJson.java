package Test.TestJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.LecturaJson.Anotador;
import edu.fiuba.algo3.modelo.LecturaJson.*;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialPenalizable;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJson {
    @Test
    public void test01SeLeeElArchivoJsonCon4PreguntaVerdaderoOFalsoySeDevuelveUnaListadeTamanio4DeEseTipoDePregunta() throws IOException {
        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        List<Pregunta> unasPreguntaDesordenadas = new ArrayList<>();
        ArrayList<Pregunta> unasPreguntaEnArray = new ArrayList<>();

        JsonArray arrayPreguntas = jsonObject.getAsJsonArray("VerdaderoOFalsoClasico");
        for(JsonElement unJson: arrayPreguntas){
            ArrayList<Opcion> unasOpciones = new ArrayList<>();
            List<Opcion> opcioneDesordenadas = new ArrayList<>();

            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrecta = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion correcta = new OpcionCorrecta(opcionCorrecta);
            Opcion incorrecta = new OpcionIncorrecta(opcionIncorrecta);
            opcioneDesordenadas.add(correcta);
            opcioneDesordenadas.add(incorrecta);
            Collections.shuffle(opcioneDesordenadas);
            unasOpciones.addAll(opcioneDesordenadas);
            Pregunta unaPreguntaDeVoF =  new PreguntaPuntajeParcialSinIncorrectos(unaConsigna,unasOpciones);
            unasPreguntaDesordenadas.add(unaPreguntaDeVoF);
        }
        Collections.shuffle(unasPreguntaDesordenadas);
        unasPreguntaEnArray.addAll(unasPreguntaDesordenadas);
        for(Pregunta unaPregunta: unasPreguntaEnArray){
            System.out.println(unaPregunta.getConsigna());
            for(Opcion unaOpcion: unaPregunta.getOpciones()){
                System.out.println(unaOpcion.getDescripcion());
            }
        }
        assertEquals(4,unasPreguntaDesordenadas.size());
        assertTrue(unasPreguntaDesordenadas.get(1) instanceof PreguntaPuntajeParcialSinIncorrectos);

    }

    @Test
    public void test02SeLeeElArchivoJsonCon3PreguntaMultipleChoiceClasicoYSeDevuelveUnaListadeTamanio3DeEseTipoDePregunta() throws IOException {
        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();
        JsonArray arrayMultipleChoiceClasico = jsonObject.getAsJsonArray("MultipleChoiceClasico");

        ArrayList<Pregunta> preguntasMultipleChoiceClasico = new ArrayList<>();
        List<Pregunta> preguntasDesordendas = new ArrayList<>();

        for(JsonElement unJson: arrayMultipleChoiceClasico){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            List<Opcion> opcionesDesordenadas = new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion UnaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesDesordenadas.add(UnaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion UnaOpcionIncorrecta = new OpcionIncorrecta(opcionIncorrecta);
                opcionesDesordenadas.add(UnaOpcionIncorrecta);
            }
            Collections.shuffle(opcionesDesordenadas);
            opcionesAPresentar.addAll(opcionesDesordenadas);
            Pregunta unaPregunta = new PreguntaConTodasOpcionesCorrectas(unaConsigna,opcionesAPresentar);
            preguntasDesordendas.add(unaPregunta);
        }
        Collections.shuffle(preguntasDesordendas);
        preguntasMultipleChoiceClasico.addAll(preguntasDesordendas);


        for(Pregunta unaPregunta: preguntasMultipleChoiceClasico){
            System.out.println(unaPregunta.getConsigna());
            for(Opcion unaOpcion: unaPregunta.getOpciones()){
                System.out.println(unaOpcion.getDescripcion());
            }

        }

        assertEquals(3,preguntasMultipleChoiceClasico.size());
        assertTrue(preguntasMultipleChoiceClasico.get(2) instanceof PreguntaConTodasOpcionesCorrectas);
    }

    @Test
    public void test03SeLeeElArchivoJsonCon3PreguntaDeOrderedChoiceYSeDevuelveUnaListadeTamanio3DeEseTipoDePregunta() throws IOException {

        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray arrayOrderedChoice = jsonObject.getAsJsonArray("OrderedChoice");
        ArrayList<Pregunta> preguntasOrderedChoice = new ArrayList<>();


        for (JsonElement unJson : arrayOrderedChoice) {
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            JsonArray arrayGrupoAOrdenar = unJson.getAsJsonObject().getAsJsonArray("GrupoAOrdenar");
            JsonArray arrayOrdenCorrecto = unJson.getAsJsonObject().getAsJsonArray("OrdenCorrecto");
            ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
            ArrayList<String> elementosAOrdenar = new ArrayList<>();
            ArrayList<Integer> ordenCorrecto = new ArrayList<>();


            for (JsonElement unJsonOpciones : arrayGrupoAOrdenar) {
                String elementoaOrdenar = unJsonOpciones.getAsString();
                elementosAOrdenar.add(elementoaOrdenar);
            }
            for (JsonElement unJsonOpciones : arrayOrdenCorrecto) {
                int ordenCorrectoElemento = unJsonOpciones.getAsInt();
                ordenCorrecto.add(ordenCorrectoElemento);
            }
            int tamanio = arrayGrupoAOrdenar.size();

            for (int i = 0; i < tamanio; i++) {
                OpcionPertenencia unaOpcion = new OpcionPertenencia(elementosAOrdenar.get(i), ordenCorrecto.get(i));
                opcionesAPresentar.add(unaOpcion);
            }
            Pregunta unaPregunta = new PreguntaConTodasOpcionesClasificadas(unaConsigna, opcionesAPresentar);
            preguntasOrderedChoice.add(unaPregunta);
        }
        assertEquals(3,preguntasOrderedChoice.size());
        assertTrue(preguntasOrderedChoice.get(1) instanceof PreguntaConTodasOpcionesCorrectas);
    }

    @Test
    public void test04SeLeeElArchivoJsonCon3PreguntaMultipleChoiceConPenalidadYSeDevuelveUnaListadeTamanio3DeEseTipoDePregunta() throws IOException {

        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray arrayMultipleChoicePenalizable = jsonObject.getAsJsonArray("MultipleChoiceConPenalidad");
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();


        for(JsonElement unJson: arrayMultipleChoicePenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion unaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesAPresentar.add(unaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion opcionIncorrectaPenalizable = new OpcionIncorrectaPenalizable(opcionIncorrecta);
                opcionesAPresentar.add(opcionIncorrectaPenalizable);
            }
            Pregunta unaPregunta = new PreguntaPuntajeParcialPenalizable(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoicePenalizable.add(unaPregunta);
        }


        assertEquals(3,preguntasMultipleChoicePenalizable.size());
        assertTrue(preguntasMultipleChoicePenalizable.get(1) instanceof PreguntaPuntajeParcialPenalizable);
    }

    @Test
    public void test05SeLeeTodoElArchivoJsonySeDeberiaDevolverUnaListayUnaColaCon23LasPreguntasCargadas() throws IOException {
        Anotador unAnotador = new Anotador();
        ArrayList<Pregunta> preguntasCargadas= new ArrayList<>();

        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();
        RecuperadorVerdaderoOFalso unRecuperador1 = new RecuperadorVerdaderoOFalso();
        RecuperadorVerdaderoFalsoPenalizable unRecuperador2 = new RecuperadorVerdaderoFalsoPenalizable();
        RecuperadorMultipleChoiceClasico unRecuperador3 = new RecuperadorMultipleChoiceClasico();
        RecuperadorMultipleChoiceParcial unRecuperador4 = new RecuperadorMultipleChoiceParcial();
        RecuperadorMultipleChoicePenalizable unRecuperador5 = new RecuperadorMultipleChoicePenalizable();
        RecuperadorOrderedChoice unRecuperador6 = new RecuperadorOrderedChoice();
        RecuperadorGroupChoice unRecuperador7 = new RecuperadorGroupChoice();
        preguntasCargadas.addAll(unRecuperador1.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador2.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador3.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador4.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador5.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador6.recuperarPregunta(jsonObject));
        preguntasCargadas.addAll(unRecuperador7.recuperarPregunta(jsonObject));


        Queue colaPreguntas = new LinkedList();
        preguntasCargadas.stream().forEach(o -> colaPreguntas.offer(o));

        assertEquals(23,preguntasCargadas.size());
        assertEquals(23,colaPreguntas.size());

    }
    @Test
    public void test06SeLeeElArchivoJsonCon3PreguntaMultipleChoiceConPenalidadYSeDevuelveElIdentificadorCorrectamente() throws IOException {

        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray arrayMultipleChoicePenalizable = jsonObject.getAsJsonArray("MultipleChoiceConPenalidad");
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();


        for(JsonElement unJson: arrayMultipleChoicePenalizable){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            ArrayList<Opcion> opcionesAPresentar= new ArrayList<>();
            JsonArray arrayOpcionesCorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesCorrecta");
            JsonArray arrayOpcionesIncorrectas = unJson.getAsJsonObject().getAsJsonArray("OpcionesIncorrecta");

            for (JsonElement unJsonOpcionCorrecta : arrayOpcionesCorrectas) {
                String opcionCorrecta = unJsonOpcionCorrecta.getAsString();
                Opcion unaOpcionCorrecta = new OpcionCorrecta(opcionCorrecta);
                opcionesAPresentar.add(unaOpcionCorrecta);
            }

            for (JsonElement unJsonOpcionIncorrecta : arrayOpcionesIncorrectas) {
                String opcionIncorrecta = unJsonOpcionIncorrecta.getAsString();
                Opcion opcionIncorrectaPenalizable = new OpcionIncorrectaPenalizable(opcionIncorrecta);
                opcionesAPresentar.add(opcionIncorrectaPenalizable);
            }
            Pregunta unaPregunta = new PreguntaPuntajeParcialPenalizable(unaConsigna,opcionesAPresentar);
            preguntasMultipleChoicePenalizable.add(unaPregunta);
            unaPregunta.setIdentificador("MultipleChoiceConPenalidad");
        }
        assertEquals("MultipleChoiceConPenalidad",preguntasMultipleChoicePenalizable.get(1).getIdentificador());
    }


}


