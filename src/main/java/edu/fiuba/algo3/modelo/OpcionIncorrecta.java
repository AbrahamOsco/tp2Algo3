package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta implements Evaluable{

    private String consigna;

    @Override
    public boolean evaluar() {
        return false;
    }
}
