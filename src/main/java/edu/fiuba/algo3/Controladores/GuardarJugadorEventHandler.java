package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Vista.ManejadorTurnos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuardarJugadorEventHandler implements EventHandler<ActionEvent> {
    Partida partida;
    TextField cuadroTexto;
    int contador;
    Stage stage;
    ManejadorTurnos manejador;

    public GuardarJugadorEventHandler(Partida partida, TextField cuadroTexto, Stage stage, ManejadorTurnos manejador) {
        this.partida = partida;
        this.cuadroTexto = cuadroTexto;
        this.contador = 0;
        this.stage = stage;
        this.manejador = manejador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contador++;
        partida.agregarJugador(cuadroTexto.getText());
        if(contador == 2){
            manejador.inicializar();
            manejador.siguienteTurno();
        }
        else{
            cuadroTexto.clear();
            cuadroTexto.requestFocus();
        }
    }
}
