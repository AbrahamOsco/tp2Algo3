package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Turno.Turno;

import java.util.ArrayList;

public abstract class ModificadorGlobal {
    protected int activaciones;

    public ModificadorGlobal(){
        this.activaciones = 0;
    }
    public  void aumentarActivaciones(){
        this.activaciones++;
    }
    public abstract void aplicarModificador(ArrayList<Turno> unasRespuestas);
}
