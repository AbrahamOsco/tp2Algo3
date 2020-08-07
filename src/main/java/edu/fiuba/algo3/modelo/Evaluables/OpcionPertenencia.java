package edu.fiuba.algo3.modelo.Evaluables;

public class OpcionPertenencia implements Evaluable{
    private String consigna;
    private int ubicacionActual;
    private int ubicacionCorrecta;

    public OpcionPertenencia (String unaConsigna,  int unaUbicacionCorrecta) {
        this.consigna = unaConsigna;
        this.ubicacionActual = 0;
        this.ubicacionCorrecta = unaUbicacionCorrecta;
    }

    @Override
    public boolean evaluar() {
        return this.ubicacionActual == this.ubicacionCorrecta;
    }


    public void setUbicacionActual(int unaUbicacion) {
        this.ubicacionActual = unaUbicacion;
    }

    public int getUbicacionCorrecta() {
        return ubicacionCorrecta;
    }
}
