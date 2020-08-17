package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Turno.Turno;

import java.util.*;
import java.util.stream.Collectors;

public class Exclusividad  {

    //PRE: unosTurnos no es vacío (amerita o Exception o Refactor).
    //POS: Se aplica a si mismo sobre un grupo de puntajes guardados en una lista de turnos.
    public void aplicarModificador(ArrayList<Turno> unosTurnos) {
        Turno turnoMax = (unosTurnos.stream().max(Comparator.comparing(o -> o.obtenerPuntajeParcial())).get());
        int max = turnoMax.obtenerPuntajeParcial();
        List<Turno> listaMax = unosTurnos.stream().filter(o -> o.obtenerPuntajeParcial() == max).collect(Collectors.toList());

        if(listaMax.size()==1) {
            turnoMax.asignarPuntajeFinal(max*2);
        }
    }
}
