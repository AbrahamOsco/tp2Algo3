package edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador;

public class MultiplicadorX2 implements ModificadorMultiplicador {

    //PRE: unPuntaje es un int válido.
    //POS: Se aplica a si mismo sobre unPuntaje.
    @Override
    public int aplicarModificador(int unPuntaje) {
        return unPuntaje *2;
    }
}
