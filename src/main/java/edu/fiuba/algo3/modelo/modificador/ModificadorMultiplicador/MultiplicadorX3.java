package edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador;

public class MultiplicadorX3 implements ModificadorMultiplicador{
    @Override
    public int aplicarModificador(int unPuntaje) {
        return unPuntaje * 3;
    }
}
