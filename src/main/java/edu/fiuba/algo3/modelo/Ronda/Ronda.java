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
        turnos.stream().forEach(t -> t.asignarPuntajeFinal(t.obtenerPuntajeParcial()));
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
        modificadores.stream().forEach( e -> e.aplicarModificador(turnos));
    }
}