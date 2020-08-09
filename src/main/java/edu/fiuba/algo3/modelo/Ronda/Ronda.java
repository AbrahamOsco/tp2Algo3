package edu.fiuba.algo3.modelo.Ronda;

import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;

import java.util.ArrayList;

public class Ronda {
    private ArrayList<Exclusividad> modificadores ;
    private ArrayList<Turno> turnos;


    public Ronda() {
        this.turnos = new ArrayList<>();
        this.modificadores = new ArrayList<>();
    }

    private void aplicarMultiplicadores(){
        for(Turno unTurno: turnos){
            unTurno.asignarPuntajeFinal(unTurno.obtenerPuntajeParcial());
        }
    }

    public void asignarPuntos(){
        if ((modificadores.isEmpty())) {
            aplicarMultiplicadores();
        } else {
            aplicarExclusividad();
        }
    }
    public void agregarTurno(Turno unTurno){
        turnos.add(unTurno);
    }

    public void agregarExclusividad(){
        this.modificadores.add(new Exclusividad());
    }

    private void aplicarExclusividad(){
        for (Exclusividad unaExclusividad :modificadores) {
            unaExclusividad.aplicarModificador(this.turnos);
        }
    }
}