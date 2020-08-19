package edu.fiuba.algo3.control;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InicializadorOpciones {
	private Pregunta unaPregunta;
	private Pane unPanel;
	
	
	public InicializadorOpciones (Pregunta unaPregunta, Pane unPanel) {
		this.unaPregunta = unaPregunta;
		this.unPanel = unPanel;
	}
	
	public void inicializar() {
		String idPregunta = unaPregunta.getIdentificador();
		switch (idPregunta) {
			case "GroupChoice" : this.inicializarGC();
				break;

			case "OrderedChoice" : this.inicializarOC();
				break;

			default : this.inicializarNoPenalizable();
				break;
		}
	}
	
	public void inicializarGC() {
		List<Opcion> listaOpciones = unaPregunta.getOpciones();
		int contador = 0;

		for(Opcion unaOpcion : listaOpciones) {
			Pane otroPanel = (Pane) unPanel.getChildren().get(contador);
			Label unLabel = (Label) otroPanel.getChildren().get(0);
			unLabel.setText(unaOpcion.getDescripcion());
			ChoiceBox<Integer> unaCajaDeOpciones = (ChoiceBox<Integer>) otroPanel.getChildren().get(1);
			ObservableList<Integer> opcionesGC = FXCollections.observableArrayList(1,2);
			unaCajaDeOpciones.setItems(opcionesGC);
			unaCajaDeOpciones.setValue(1);
			otroPanel.setVisible(true);
			contador ++;
		}
	}
	
	public void inicializarOC() {
		List<Opcion> listaOpciones = unaPregunta.getOpciones();
		int contador = 0;
		
		for(Opcion unaOpcion : listaOpciones) {
			List<Integer> rango = IntStream.range(1, listaOpciones.size()+1).boxed().collect(Collectors.toList());
			Pane otroPanel = (Pane) unPanel.getChildren().get(contador);
			Label unLabel = (Label) otroPanel.getChildren().get(0);
			unLabel.setText(unaOpcion.getDescripcion());
			ChoiceBox<Integer> unaCajaDeOpciones = (ChoiceBox<Integer>) otroPanel.getChildren().get(1);
			ObservableList<Integer> opcionesOC = FXCollections.observableArrayList(rango);
			unaCajaDeOpciones.setItems(opcionesOC);
			unaCajaDeOpciones.setValue(contador);
			otroPanel.setVisible(true);
			contador ++;
		}
	}
	
	public void inicializarNoPenalizable() {
		
		List<Opcion> listaOpciones = unaPregunta.getOpciones();
		int contador = 0;
		for(Opcion unaOpcion : listaOpciones) {
			
			Button unBoton = (Button) unPanel.getChildren().get(contador);
			unBoton.setVisible(true);
			unBoton.setText(unaOpcion.getDescripcion());
			unBoton.setDisable(false);
			unBoton.setStyle("-fx-background-color: #B3B4B9; ");
			contador ++;
		}	
	}
}
