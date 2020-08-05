package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.*;
import java.util.ArrayList;


public class Partida {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;

    public Partida(){}
    public void  comenzarPartida(){

        /*for(Pregunta preguntaActual: preguntas){
            Ronda rondaActual = new Ronda(preguntaActual, this.jugadores);
            rondaActual.comenzarRonda();
            rondaActual.terminarRonda();
        }*/
    }
    public void terminarPartida(){
        //determina al jugador de mayo puntaje y lo informa
        //permite volver al menu
    }
}
