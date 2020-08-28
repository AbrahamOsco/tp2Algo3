package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrectaPenalizable extends Opcion{

    //PRE: descripción es un String válido.
    //POS: Instancia una OpcionIncorrectaPenalizable con una descripción.
    public OpcionIncorrectaPenalizable(String descripcion) {
        super(descripcion);
    }

    //PRE: -
    //POS: Calcula y devuelve los puntos que le corresponden a un Jugador si la selecciona.
    @Override
    public int calcularPuntosAdicionales() {
        return -1;
    }
}
