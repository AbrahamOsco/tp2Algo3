package edu.fiuba.algo3.modelo.Evaluable;

public class OpcionPertenencia implements Evaluable{

    private String consigna;
    private int ubicacionActual;
    private int ubicacionCorrecta;

    public OpcionPertenencia (String unaConsigna, int unaUbicacionActual, int unaUbicacionCorrecta) {

        this.consigna = unaConsigna;
        this.ubicacionActual = unaUbicacionActual;
        this.ubicacionCorrecta = unaUbicacionCorrecta;

    }


    @Override
    public boolean evaluar() {
        return false;
    }
}
