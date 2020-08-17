package edu.fiuba.algo3.modelo.Opciones;

public class OpcionPertenencia extends Opcion{
    private int ubicacionActual;

    //PRE: descripcion es un String válido (no amerita Exception), ubicacionCorrecta es un int válido (o 1 o 2, amerita Exception).
    //POS: crea una OpcionCorrecta con la descripcion recibida.
    public OpcionPertenencia (String unaConsigna,  int unaUbicacionCorrecta) {
        super(unaConsigna);
        this.ubicacionCorrecta = unaUbicacionCorrecta;
    }

    //PRE: unaUbicacion es un int válido (o 0 o 1 o 2, amerita Exception).
    //POS: Setea ubicacionActual.
    public void setUbicacionActual(int unaUbicacion) {
        this.ubicacionActual = unaUbicacion;
    }

    //PRE: -
    //POS: Devuelve los puntos que vale seleccionarla.
    @Override
    public int calcularPuntosAdicionales() {
        if(ubicacionActual==ubicacionCorrecta)
            return 1;
        return 0;
    }

}
