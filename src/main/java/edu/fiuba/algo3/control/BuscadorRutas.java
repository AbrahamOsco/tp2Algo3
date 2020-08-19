package edu.fiuba.algo3.control;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

public class BuscadorRutas {
	
	private HashMap<String,String> rutasFXML;
	
	public BuscadorRutas() {
		rutasFXML = new HashMap<>();
		rutasFXML.put("VerdaderoOFalsoClasico", "/Vistas/Pantalla/PantallaVF.fxml");
		rutasFXML.put("VerdaderoOFalsoPenalizable", "/Vistas/Pantalla/PantallaVF.fxml");
		rutasFXML.put("MultipleChoiceClasico", "/Vistas/Pantalla/PantallaMChoice.fxml");
		rutasFXML.put("MultipleChoiceConPuntajeParcial", "/Vistas/Pantalla/PantallaMChoice.fxml");
		rutasFXML.put("MultipleChoiceConPenalidad", "/Vistas/Pantalla/PantallaMChoice.fxml");
		rutasFXML.put("OrderedChoice", "/Vistas/Pantalla/PantallaGroupChoice.fxml");
		rutasFXML.put("GroupChoice", "/Vistas/Pantalla/PantallaGroupChoice.fxml");
	}
	
	public String buscarRutaDePregunta(Pregunta unaPregunta) {
		
		return rutasFXML.get(unaPregunta.getIdentificador());
	}
}
