package edu.fiuba.algo3.modelo.Opciones;

public class OpcionCorrecta extends Opcion{

    //PRE: descripcion es un String válido (no amerita Exception).
    //POS: crea una OpcionCorrecta con la descripcion recibida.
    public OpcionCorrecta (String descripcion) {
        super(descripcion);
    }

    //PRE: -
    //POS: Devuelve los puntos que vale seleccionarla.
    @Override
    public int calcularPuntosAdicionales() {
        return 1;
    }

}
