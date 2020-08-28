package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Turno.Turno;

import java.util.*;
import java.util.stream.Collectors;

public class Exclusividad  {

    /*
     * PRE: unosTurnos no esta vacío.
     *      unosTurnos es un ArrayList<Turno> válido
     * POS: Se aplica como debe sobre una serie de puntajes guardados en unosTurnos.
     */
    public void aplicarModificador(ArrayList<Turno> unosTurnos) {
        Turno turnoMax = (unosTurnos.stream().max(Comparator.comparing(o -> o.obtenerPuntajeParcial())).get());
        int max = turnoMax.obtenerPuntajeParcial();
        List<Turno> listaMax = unosTurnos.stream().filter(o -> o.obtenerPuntajeParcial() == max).collect(Collectors.toList());

        if(listaMax.size()==1) {
            turnoMax.asignarPuntajeFinal(max*2);
        }
    }
}
