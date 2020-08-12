package edu.fiuba.algo3.modelo.Opciones;

public class OpcionCorrecta extends Opcion{
    public OpcionCorrecta (String descripcion) {
        super(descripcion);
    }

    @Override
    public int calcularPuntosAdicionales() {
        return 1;
    }

}
