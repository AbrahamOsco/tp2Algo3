package edu.fiuba.algo3.Vista.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

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

    public ArrayList<Pregunta> getPreguntas(){



    }

    public void getPreguntasVoFClasico() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoF = new ArrayList<>();
        RecuperadorVerdaderoOFalso unRecuperador = new RecuperadorVerdaderoOFalso();
        preguntasVoF = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoF);
    }

    public void getPreguntasVoFPenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasVoFPenalizable = new ArrayList<>();

        RecuperadorVerdaderoFalsoPenalizable unRecuperador = new RecuperadorVerdaderoFalsoPenalizable();
        preguntasVoFPenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasVoFPenalizable) ;
    }

    public void getPreguntasMultipleChoiceClasica() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceClasica = new ArrayList<>();

        RecuperadorMultipleChoiceClasico unRecuperador = new RecuperadorMultipleChoiceClasico();
        preguntasMultipleChoiceClasica = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceClasica);
    }

    public void getPreguntasMultipleChoiceParcial() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoiceParcial = new ArrayList<>();

        RecuperadorMultipleChoiceParcial unRecuperador = new RecuperadorMultipleChoiceParcial();
        preguntasMultipleChoiceParcial = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoiceParcial);
    }
    public void getPreguntasMultipleChoicePenalizable() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasMultipleChoicePenalizable = new ArrayList<>();

        RecuperadorMultipleChoicePenalizable unRecuperador = new RecuperadorMultipleChoicePenalizable();
        preguntasMultipleChoicePenalizable = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasMultipleChoicePenalizable);
    }
    public void getPreguntasOrderedChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasOrderedChoice = new ArrayList<>();

        RecuperadorOrderedChoice unRecuperador = new RecuperadorOrderedChoice();
        preguntasOrderedChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasOrderedChoice);
    }
    public void getPreguntasGroupChoice() throws IOException {
        JsonObject unJsonObjeto = aperturadeArchivos();
        ArrayList<Pregunta> preguntasGroupChoice = new ArrayList<>();

        RecuperadorGroupChoice unRecuperador = new RecuperadorGroupChoice();
        preguntasGroupChoice = unRecuperador.recuperarPregunta(unJsonObjeto);
        preguntasCargadas.addAll(preguntasGroupChoice);
    }









}
