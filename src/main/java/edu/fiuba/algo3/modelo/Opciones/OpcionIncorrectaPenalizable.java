package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrectaPenalizable extends Opcion{

    //PRE: descripcion es un String válido (no amerita Exception).
    //POS: crea una OpcionCorrecta con la descripcion recibida.
    public OpcionIncorrectaPenalizable(String descripcion) {
        super(descripcion);
    }

    //PRE: -
    //POS: Devuelve los puntos que vale seleccionarla.
    @Override
    public int calcularPuntosAdicionales() {
        return -1;
    }
}
