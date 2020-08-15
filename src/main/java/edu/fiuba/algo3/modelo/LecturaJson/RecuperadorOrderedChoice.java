package edu.fiuba.algo3.modelo.LecturaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionPertenencia;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaCriterioSinErrores.PreguntaConTodasOpcionesCorrectas;

import java.util.ArrayList;

public class RecuperadorOrderedChoice extends RecuperadorDePreguntas{
    @Override
    public ArrayList<Pregunta> recuperarPregunta(JsonObject unObjetoJson) {

        JsonArray arrayOrderedChoice = unObjetoJson.getAsJsonArray("OrderedChoice");
        ArrayList<Pregunta> preguntasOrderedChoice = new ArrayList<>();


        for(JsonElement unJson: arrayOrderedChoice){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            JsonArray arrayGrupoAOrdenar= unJson.getAsJsonObject().getAsJsonArray("GrupoAOrdenar");
            JsonArray arrayOrdenCorrecto = unJson.getAsJsonObject().getAsJsonArray("OrdenCorrecto");
            ArrayList<Opcion> opcionesAPresentar = new ArrayList<>();
            ArrayList<String> elementosAOrdenar = new ArrayList<>();
            ArrayList<Integer> ordenCorrecto = new ArrayList<>();


            for(JsonElement unJsonOpciones: arrayGrupoAOrdenar ){
                String elementoaOrdenar = unJsonOpciones.getAsString();
                elementosAOrdenar.add(elementoaOrdenar);
                System.out.println(elementoaOrdenar);
            }
            for(JsonElement unJsonOpciones: arrayOrdenCorrecto ){
                int ordenCorrectoElemento = unJsonOpciones.getAsInt();
                ordenCorrecto.add(ordenCorrectoElemento);
                System.out.println(ordenCorrectoElemento);
            }
            int tamanio = arrayGrupoAOrdenar.size();

            for(int i = 0; i<tamanio ; i++){
                OpcionPertenencia unaOpcion = new OpcionPertenencia(elementosAOrdenar.get(i),ordenCorrecto.get(i));
                opcionesAPresentar.add(unaOpcion);
            }
            Pregunta unaPregunta = new PreguntaConTodasOpcionesCorrectas(unaConsigna,opcionesAPresentar);
            preguntasOrderedChoice.add(unaPregunta);

        }
        return preguntasOrderedChoice;
    }
}
