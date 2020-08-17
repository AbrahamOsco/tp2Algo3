package edu.fiuba.algo3.modelo.Opciones;

public class OpcionPertenencia extends Opcion{
    private int ubicacionActual;

    //PRE: descripción es un String válido.
    //POS: Instancia una OpcionPertenencia con una descripción y unaUbicacionCorrecta.
    public OpcionPertenencia (String unaConsigna,  int unaUbicacionCorrecta) {
        super(unaConsigna);
        this.ubicacionCorrecta = unaUbicacionCorrecta;
    }

    //PRE: unaUbicacion es un int válido (discutir si amerita Exception).
    //POS: Modifica la ubicacionActual de la OpcionPertenencia.
    public void setUbicacionActual(int unaUbicacion) {
        this.ubicacionActual = unaUbicacion;
    }

    //PRE: -
    //POS: Calcula y devuelve los puntos que le corresponden a un Jugador si la selecciona.
    @Override
    public int calcularPuntosAdicionales() {
        if(ubicacionActual==ubicacionCorrecta)
            return 1;
        return 0;
    }

}
