package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso implements TipoPregunta{
    @Override
    public int calcularPuntaje(ArrayList<Opcion> opcionesJugador, ArrayList<Opcion> opcionesCorrectas){
        int puntosARetornar = 0;
        Opcion respuestaJugador = opcionesJugador.get(0);
        if(opcionesCorrectas.contains(respuestaJugador))
            puntosARetornar ++;
        return puntosARetornar;
    }
}
