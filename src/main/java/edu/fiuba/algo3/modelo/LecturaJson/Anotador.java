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

    public Anotador(){
        preguntasCargadas= new ArrayList<>();
    }



    public JsonObject aperturadeArchivos() throws IOException {
        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();
        return jsonObject;
    }
    public Queue<?> getColaDePreguntas() throws IOException {
        ArrayList<Pregunta> preguntas= new ArrayList<>();
        preguntas = this.getPreguntas();
        Queue colaPreguntas = new LinkedList();
        preguntas.stream().forEach(o -> colaPreguntas.offer(o));
        return colaPreguntas;
    }

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

    public void agregarPreguntasVoFClasico() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoF = new ArrayList<>();
        RecuperadorVerdaderoOFalso unRecuperador = new RecuperadorVerdaderoOFalso();
        preguntasVoF = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoF);
    }

    public void agregarPreguntasVoFPenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoFPenalizable = new ArrayList<>();

        RecuperadorVerdaderoFalsoPenalizable unRecuperador = new RecuperadorVerdaderoFalsoPenalizable();
        preguntasVoFPenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoFPenalizable) ;
    }

    public void agregarPreguntasMultipleChoiceClasica() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceClasica = new ArrayList<>();

        RecuperadorMultipleChoiceClasico unRecuperador = new RecuperadorMultipleChoiceClasico();
        preguntasMultipleChoiceClasica = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceClasica);
    }

    public void agregarPreguntasMultipleChoiceParcial() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceParcial = new ArrayList<>();

        RecuperadorMultipleChoiceParcial unRecuperador = new RecuperadorMultipleChoiceParcial();
        preguntasMultipleChoiceParcial = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceParcial);
    }
    public void agregarPreguntasMultipleChoicePenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();

        RecuperadorMultipleChoicePenalizable unRecuperador = new RecuperadorMultipleChoicePenalizable();
        preguntasMultipleChoicePenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoicePenalizable);
    }
    public void agregarPreguntasOrderedChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasOrderedChoice = new ArrayList<>();

        RecuperadorOrderedChoice unRecuperador = new RecuperadorOrderedChoice();
        preguntasOrderedChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasOrderedChoice);
    }
    public void agregarPreguntasGroupChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasGroupChoice = new ArrayList<>();

        RecuperadorGroupChoice unRecuperador = new RecuperadorGroupChoice();
        preguntasGroupChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasGroupChoice);
    }

}