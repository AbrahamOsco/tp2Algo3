package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class OpcionElegidaEventHandler implements EventHandler<ActionEvent> {
    Opcion opcion;
    ArrayList<Opcion> opcionesElegidas;

    public OpcionElegidaEventHandler(Opcion opcion, ArrayList<Opcion> opcionesElegidas) {
        this.opcion = opcion;
        this.opcionesElegidas = opcionesElegidas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        opcionesElegidas.add(opcion);
    }
}
