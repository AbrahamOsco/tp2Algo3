package Test.TestJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJson {
    @Test
    public void test01SeLeeElArchivoJsonCon4PreguntaVerdaderoOFalsoySeDevuelveUnaListaCon4PreguntaDeEseTipo() throws IOException {
        String texto = Files.readString(Path.of("src/main/java/preguntas.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        System.out.println("JSON Leido  ->: " + jsonObject);
        ArrayList<Pregunta> unasPregunta = new ArrayList<>();
        ArrayList<String> unasConsignas = new ArrayList<>();
        ArrayList<Opcion> unasOpciones = new ArrayList<>();
        JsonArray arrayPreguntas = jsonObject.getAsJsonArray("VerdaderoOFalsoClasico");
        for(JsonElement unJson: arrayPreguntas){
            String unaConsigna = unJson.getAsJsonObject().get("Consigna").getAsString();
            unasConsignas.add(unaConsigna);
            String opcionCorrecta =unJson.getAsJsonObject().get("OpcionesCorrecta").getAsString();
            String opcionIncorrecta = unJson.getAsJsonObject().get("OpcionesIncorrecta").getAsString();
            Opcion correcta = new OpcionCorrecta(opcionCorrecta);
            Opcion incorrecta = new OpcionIncorrecta(opcionIncorrecta);
            unasOpciones.add(correcta);
            unasOpciones.add(incorrecta);
        }
        assertEquals(9, arrayPreguntas.size());
        assertEquals(9,unasConsignas.size());
        assertEquals(18,unasOpciones.size());

    }

}
