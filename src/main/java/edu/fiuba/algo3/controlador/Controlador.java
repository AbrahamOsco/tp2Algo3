package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controlador {
    private  int contador = 0;
    @FXML
    public TextField fldContador;

    @FXML
    public void contar(ActionEvent event) {
        contador ++;
        fldContador.setText(String.valueOf(contador));
    }

}