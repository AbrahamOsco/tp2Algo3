package edu.fiuba.algo3.modelo.AsignadorPuntos;

import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;

import java.util.ArrayList;

public class AsignadorPuntos {
    private ArrayList<Exclusividad> modificadores ;
    private ArrayList<Turno> turnos;

    //PRE: -
    //POS: Genera un nuevo AsignadorPuntos, sin turnos ni modificadores.
    public AsignadorPuntos() {
        this.turnos = new ArrayList<>();
        this.modificadores = new ArrayList<>();
    }

    //PRE: -
    //POS: Se aplican los multiplicadores sobre cada turno.
    private void aplicarMultiplicadores(){
        turnos.stream().forEach(t -> t.asignarPuntajeFinal(t.obtenerPuntajeParcial()));
    }

    //PRE: -
    //POS: Asigna puntos a los jugadores.
    public void asignarPuntos(){
        if ((modificadores.isEmpty())) {
            aplicarMultiplicadores();
        } else {
            aplicarExclusividad();
        }
    }

    //PRE: unTurno es un objeto de clase Turno, válido.
    //POS: Guarda un turno en turnos.
    public void agregarTurno(Turno unTurno){
        turnos.add(unTurno);
    }

    //PRE: -
    //POS: Añade un modificador de tipo Exclusividad a modificadores.
    public void agregarExclusividad(){
        this.modificadores.add(new Exclusividad());
    }

    //PRE: -
    //POS: Aplica los multiplicadores de Exclusividad guardados en modificadores.
    private void aplicarExclusividad(){
        modificadores.stream().forEach( e -> e.aplicarModificador(turnos));
    }
}