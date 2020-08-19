package edu.fiuba.algo3.modelo.AsignadorPuntos;

import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;

import java.util.ArrayList;

public class AsignadorPuntos {
    private ArrayList<Exclusividad> modificadores ;
    private ArrayList<Turno> turnos;

    //PRE: -
    //POS: Instancia un AsignadorPuntos sin datos.
    public AsignadorPuntos() {
        this.turnos = new ArrayList<>();
        this.modificadores = new ArrayList<>();
    }

    //PRE: -
    //POS: Aplica los modificadores de tipo Multiplicador al puntaje de los jugadores.
    private void aplicarMultiplicadores(){
        turnos.stream().forEach(t -> t.asignarPuntajeFinal(t.obtenerPuntajeParcial()));
    }

    //PRE: -
    //POS: Asigna los puntos a los jugadores.
    public void asignarPuntos(){
        if ((modificadores.isEmpty())) {
            aplicarMultiplicadores();
        } else {
            aplicarExclusividad();
        }
    }

    //PRE: unTurno es un Turno válido.
    //POS: Añade un Turno a su lista de turnos.
    public void agregarTurno(Turno unTurno){
        turnos.add(unTurno);
    }

    //PRE: -
    //POS: Registra un modificador de tipo Exclusividad a modificadores.
    public void agregarExclusividad(){
        this.modificadores.add(new Exclusividad());
    }

    //PRE: -
    //POS: Aplica los modificadores de tipo Exclusividad en modificadores.
    private void aplicarExclusividad(){
        modificadores.stream().forEach( e -> e.aplicarModificador(turnos));
    }
}