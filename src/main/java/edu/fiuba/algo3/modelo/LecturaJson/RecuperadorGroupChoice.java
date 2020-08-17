package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesClasificadas;

import java.util.ArrayList;

public class RecuperadorGroupChoice extends RecuperadorDePreguntas{

    //PRE: unObjetoJson es un JsonObject válido.
    //POS: Devuelve un ArrayList<Pregunta> cargado con todas las preguntas de tipo GroupChoice dentro de unObjetoJson.
    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {
        ArrayList<Pregunta> preguntasGroupChoice = new ArrayList<>();

        JsonArray arrayPreguntasGroupChoice= unObjetoJson.getAsJsonArray("GroupChoice");

        for(JsonElement unJson: arrayPreguntasGroupChoice){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            JsonArray arrayElementosAsginar= unJson.getAsJsonObject().getAsJsonArray("ElementosAAsignar");
            JsonArray arrayGrupoCorrectos = unJson.getAsJsonObject().getAsJsonArray("GruposCorrectos");
            ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
            ArrayList<String> elementosAOrdenar = new ArrayList<>();
            ArrayList<Integer> GruposCorrectos = new ArrayList<>();


            for(JsonElement unJsonOpciones: arrayElementosAsginar ){
                String elementoaOrdenar = unJsonOpciones.getAsString();
                elementosAOrdenar.add(elementoaOrdenar);
            }
            for(JsonElement unJsonOpciones: arrayGrupoCorrectos ){
                int ordenCorrectoElemento = unJsonOpciones.getAsInt();
                GruposCorrectos.add(ordenCorrectoElemento);
            }
            int tamanio = arrayElementosAsginar.size();

            for(int i = 0; i<tamanio ; i++){
                OpcionPertenencia unaOpcion = new OpcionPertenencia(elementosAOrdenar.get(i),GruposCorrectos.get(i));
                opcionesAPresentar.add(unaOpcion);
            }
            Pregunta unaPregunta = new PreguntaConTodasOpcionesClasificadas(unaConsigna,opcionesAPresentar);
            preguntasGroupChoice.add(unaPregunta);
        }
       return preguntasGroupChoice;
    }

}
