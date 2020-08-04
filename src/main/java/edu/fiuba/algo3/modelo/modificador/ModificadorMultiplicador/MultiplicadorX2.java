package edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador;

public class MultiplicadorX2 implements ModificadorMultiplicador {

    @Override
    public int aplicarModificador(int unPuntaje) {
        return unPuntaje *2;
    }
}
