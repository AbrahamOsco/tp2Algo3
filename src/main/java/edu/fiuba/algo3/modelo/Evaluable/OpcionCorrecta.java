package edu.fiuba.algo3.modelo.Evaluable;

public class OpcionCorrecta implements Evaluable{

    private String consigna;

    public OpcionCorrecta (String unaConsigna) {
        this.consigna = unaConsigna;
    }

    @Override
    public boolean evaluar() {
        return true;
    }

    @Override
    public void setUbicacionActual(int unaUbicacion) {

    }
}
