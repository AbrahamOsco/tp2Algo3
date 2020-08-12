package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrectaPenalizable extends Opcion{
    public OpcionIncorrectaPenalizable(String descripcion) {
        super(descripcion);
    }

    @Override
    public int calcularPuntosAdicionales() {
        return -1;
    }
}
