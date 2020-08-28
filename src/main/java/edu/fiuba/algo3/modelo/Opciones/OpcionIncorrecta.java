package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrecta extends Opcion{

    //PRE: descripción es un String válido.
    //POS: Instancia una OpcionIncorrecta con una descripción.
    public OpcionIncorrecta (String descripcion) {
        super(descripcion);
    }

    //PRE: -
    //POS: Calcula y devuelve los puntos que le corresponden a un Jugador si la selecciona.
    @Override
    public int calcularPuntosAdicionales() {
        return 0;
    }
}
