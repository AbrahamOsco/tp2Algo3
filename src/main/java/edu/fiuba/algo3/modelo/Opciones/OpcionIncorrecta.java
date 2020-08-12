package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrecta extends Opcion{

    public OpcionIncorrecta (String descripcion) {
        super(descripcion);
    }

    @Override
    public int calcularPuntosAdicionales() {
        return 0;
    }
}
