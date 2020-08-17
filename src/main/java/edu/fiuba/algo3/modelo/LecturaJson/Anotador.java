package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Anotador {
    private ArrayList<Pregunta> preguntasCargadas;
    private RecuperadorDePreguntas unRecuperador;

    //PRE: -
    //POS: Instanci un Anotador sin datos.
    public Anotador(){
        preguntasCargadas= new ArrayList<>();
    }

    //PRE: -
    //POS: Toma el archivo y lo devuelve como un jsonObject.
    public JsonObject aperturadeArchivos() throws IOException {
        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();
        return jsonObject;
    }

    //PRE: -
    //POS: Devuelve una cola de preguntas.
    public Queue<?> getColaDePreguntas() throws IOException {
        ArrayList<Pregunta> preguntas= new ArrayList<>();
        preguntas = this.getPreguntas();
        Queue colaPreguntas = new LinkedList();
        preguntas.stream().forEach(o -> colaPreguntas.offer(o));
        return colaPreguntas;
    }

    //PRE: -
    //POS: Carga las preguntas en una lista.
    public ArrayList<Pregunta> getPreguntas() throws IOException {
        this.agregarPreguntasVoFClasico();
        this.agregarPreguntasVoFPenalizable();
        this.agregarPreguntasMultipleChoiceClasica();
        this.agregarPreguntasMultipleChoiceParcial();
        this.agregarPreguntasMultipleChoicePenalizable();
        this.agregarPreguntasOrderedChoice();
        this.agregarPreguntasGroupChoice();
        return preguntasCargadas;
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo VoFClasico.
    public void agregarPreguntasVoFClasico() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoF = new ArrayList<>();
        RecuperadorVerdaderoOFalso unRecuperador = new RecuperadorVerdaderoOFalso();
        preguntasVoF = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoF);
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo VoFPenalizable.
    public void agregarPreguntasVoFPenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoFPenalizable = new ArrayList<>();

        RecuperadorVerdaderoFalsoPenalizable unRecuperador = new RecuperadorVerdaderoFalsoPenalizable();
        preguntasVoFPenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoFPenalizable) ;
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo MultipleChoiceClasica.
    public void agregarPreguntasMultipleChoiceClasica() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceClasica = new ArrayList<>();

        RecuperadorMultipleChoiceClasico unRecuperador = new RecuperadorMultipleChoiceClasico();
        preguntasMultipleChoiceClasica = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceClasica);
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo MultipleChoiceParcial.
    public void agregarPreguntasMultipleChoiceParcial() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceParcial = new ArrayList<>();

        RecuperadorMultipleChoiceParcial unRecuperador = new RecuperadorMultipleChoiceParcial();
        preguntasMultipleChoiceParcial = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceParcial);
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo MultipleChoicePenalizable.
    public void agregarPreguntasMultipleChoicePenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();

        RecuperadorMultipleChoicePenalizable unRecuperador = new RecuperadorMultipleChoicePenalizable();
        preguntasMultipleChoicePenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoicePenalizable);
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo OrderedChoice.
    public void agregarPreguntasOrderedChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasOrderedChoice = new ArrayList<>();

        RecuperadorOrderedChoice unRecuperador = new RecuperadorOrderedChoice();
        preguntasOrderedChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasOrderedChoice);
    }

    //PRE: -
    //POS: Carga todas las preguntas de tipo GroupChoice.
    public void agregarPreguntasGroupChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasGroupChoice = new ArrayList<>();

        RecuperadorGroupChoice unRecuperador = new RecuperadorGroupChoice();
        preguntasGroupChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasGroupChoice);
    }

}
