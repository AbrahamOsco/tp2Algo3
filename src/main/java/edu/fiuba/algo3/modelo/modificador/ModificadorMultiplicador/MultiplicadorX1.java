package edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador;

public class MultiplicadorX1 implements ModificadorMultiplicador{

    //PRE: unPuntaje es un int válido.
    //POS: Se aplica a sí mismo a unPuntaje y lo devuelve.
    @Override
    public int aplicarModificador(int unPuntaje) {
        return unPuntaje;
    }
}
