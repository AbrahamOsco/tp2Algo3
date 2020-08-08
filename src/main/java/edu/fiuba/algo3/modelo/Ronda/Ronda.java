package edu.fiuba.algo3.modelo.Ronda;

import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorGlobal;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;

import java.util.ArrayList;

public class Ronda {
    private ModificadorGlobal modificadorGlobal;
    private ArrayList<Turno> turnos;

    public Ronda() {
        this.turnos = new ArrayList<>();
    }

    private void aplicarMultiplicadores(){
        for(Turno unTurno: turnos){
            ModificadorMultiplicador unMultiplicador = unTurno.getMultiplicadorActivo();
            int unPuntaje = unTurno.obtenerPuntajeParcial();
            int puntajeFinal = unMultiplicador.aplicarModificador(unPuntaje);
            unTurno.asignarPuntajeFinal(puntajeFinal);
        }
    }
    public void acumularActivacionesGlobales(){
        this.modificadorGlobal.aumentarActivaciones();
    }
    private void aplicarModificadoresGlobales(){}

    public void asignarPuntos(){
        aplicarMultiplicadores();
    }

    public void agregarTurno(Turno unTurno){
        turnos.add(unTurno);
    }
}