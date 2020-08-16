package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ContenedorTurno;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuardarJugadorEventHandler implements EventHandler<ActionEvent> {
    Partida partida;
    TextField cuadroTexto;
    int contador;
    Stage stage;

    public GuardarJugadorEventHandler(Partida partida, TextField cuadroTexto, Stage stage) {
        this.partida = partida;
        this.cuadroTexto = cuadroTexto;
        this.contador = 0;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contador++;
        partida.agregarJugador(cuadroTexto.getText());
        if(contador==2){
            ContenedorTurno  turnoVista = new ContenedorTurno(partida.getJugadores().get(0),partida.obtenerSiguientePregunta(), stage);
            Scene escenaTurno = new Scene(turnoVista,500,500);
            stage.setScene(escenaTurno);
        }
        else{
            cuadroTexto.clear();
            cuadroTexto.requestFocus();
        }
    }
}
