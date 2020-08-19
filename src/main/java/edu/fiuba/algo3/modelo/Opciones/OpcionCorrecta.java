package edu.fiuba.algo3.modelo.Opciones;

public class OpcionCorrecta extends Opcion{

    //PRE: descripción es un String válido.
    //POS: Instancia una OpcionCorrecta con una descripción.
    public OpcionCorrecta (String descripcion) {
        super(descripcion);
    }

    //PRE: -
    //POS: Calcula y devuelve los puntos que le corresponden a un Jugador si la selecciona.
    @Override
    public int calcularPuntosAdicionales() {
        return 1;
    }

}
