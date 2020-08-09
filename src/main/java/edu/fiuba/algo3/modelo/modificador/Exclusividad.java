package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Turno.Turno;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Exclusividad  {

    public void aplicarModificador(ArrayList<Turno> unosTurnos) {
        PriorityQueue<Turno> colaPrioridad = new PriorityQueue<>( (turno1,turno2) -> {
            if(turno1.obtenerPuntajeParcial() < turno2.obtenerPuntajeParcial() )
                return 1;
            else if (turno1.obtenerPuntajeParcial() > turno2.obtenerPuntajeParcial() )
                return -1;
            else
                return 0;
        }  );

        for(Turno unTurno : unosTurnos){
            colaPrioridad.offer(unTurno);
        }
        Turno turnoMaximoPuntaje1 = colaPrioridad.poll();
        Turno turnoMaximoPuntaje2 = colaPrioridad.poll();
        int puntaje1 = turnoMaximoPuntaje1.obtenerPuntajeParcial();
        int puntaje2 = turnoMaximoPuntaje2.obtenerPuntajeParcial();

        if(puntaje1 != puntaje2){
            turnoMaximoPuntaje1.asignarPuntajeFinal(puntaje1*2);
        }

    }



}
