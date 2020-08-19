package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;

public class BotonOpcion extends Button {
    ArrayList<Opcion> opcionesElegidas;
    Opcion opcion;
    public BotonOpcion(Opcion opcion, ArrayList<Opcion> opcionesElegidas){
        this.opcion = opcion;
        this.setText(opcion.getDescripcion());
        this.setOnAction(new OpcionElegidaEventHandler(opcion, opcionesElegidas));
        //this.setStyle("-fx-focus-color: transparent;");
        //this.setFocused(false);

    }
    public Opcion entregarOpcion(){
        return opcion;
    }

}
