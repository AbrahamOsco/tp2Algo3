package edu.fiuba.algo3.modelo.Evaluable;

public class OpcionIncorrecta implements Evaluable{

    private String consigna;

    public OpcionIncorrecta (String unaConsigna) {
        this.consigna = unaConsigna;
    }

    @Override
    public boolean evaluar() {
        return false;
    }

    @Override
    public void setUbicacionActual(int unaUbicacion) {

    }
}
