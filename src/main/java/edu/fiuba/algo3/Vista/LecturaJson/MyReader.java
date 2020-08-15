package edu.fiuba.algo3.Vista.LecturaJson;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioParcial.PreguntaPuntajeParcialSinIncorrectos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;


public class MyReader{


    public static void main(String[] args){
        try {
            String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
            JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

            System.out.println("JSON Leido  ->: " + jsonObject);
            ArrayList<Pregunta> unasPregunta = new ArrayList<>();

            JsonArray arrayPreguntas = jsonObject.getAsJsonArray("GroupChoice");

            for(JsonElement unJson: arrayPreguntas){
                String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
                JsonArray arrayElemntosAsginar= unJson.getAsJsonObject().getAsJsonArray("ElementosAAsignar");
                JsonArray arrayGrupoCorrectos = unJson.getAsJsonObject().getAsJsonArray("GruposCorrectos");
                ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
                ArrayList<String> elementosAOrdenar = new ArrayList<>();
                ArrayList<Integer> ordenCorrecto = new ArrayList<>();


                for(JsonElement unJsonOpciones: arrayElemntosAsginar ){
                    String elementoaOrdenar = unJsonOpciones.getAsString();
                    elementosAOrdenar.add(elementoaOrdenar);
                    System.out.println(elementoaOrdenar);
                }
                for(JsonElement unJsonOpciones: arrayGrupoCorrectos ){
                    int ordenCorrectoElemento = unJsonOpciones.getAsInt();
                    ordenCorrecto.add(ordenCorrectoElemento);
                    System.out.println(ordenCorrectoElemento);
                }
                int tamanio = arrayGrupoCorrectos.size();
                for(int i = 0; i<tamanio ; i++){
                    OpcionPertenencia unaOpcion = new OpcionPertenencia(elementosAOrdenar.get(i),ordenCorrecto.get(i));
                    opcionesAPresentar.add(unaOpcion);
                }

                Pregunta unaPregunta = new PreguntaConTodasOpcionesClasificadas(unaConsigna,opcionesAPresentar);
                unasPregunta.add(unaPregunta);
            }
            for(Pregunta unaPregunta: unasPregunta){
                String consigna1 = unaPregunta.getConsigna();
                System.out.println(consigna1);
                for(Opcion unaOpcion: unaPregunta.getOpciones()){
                    System.out.println(unaOpcion.getUbicacionCorrecta());
                }
            }






        } catch (IOException e) {
            System.out.println("hola");
            e.printStackTrace();
        }

    }

}







