package edu.fiuba.algo3.modelo.Opciones;

public class OpcionPertenencia extends Opcion{
    private int ubicacionActual;


    public OpcionPertenencia (String unaConsigna,  int unaUbicacionCorrecta) {
        super(unaConsigna);
        this.ubicacionCorrecta = unaUbicacionCorrecta;
    }

    public void setUbicacionActual(int unaUbicacion) {
        this.ubicacionActual = unaUbicacion;
    }

    @Override
    public int calcularPuntosAdicionales() {
        if(ubicacionActual==ubicacionCorrecta)
            return 1;
        return 0;
    }

}
