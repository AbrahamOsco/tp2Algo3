package edu.fiuba.algo3.modelo.Evaluables;

public class OpcionCorrecta implements Evaluable{
    private String consigna;

    public OpcionCorrecta (String unaConsigna) {
        this.consigna = unaConsigna;
    }

    @Override
    public boolean evaluar() {
        return true;
    }

}
