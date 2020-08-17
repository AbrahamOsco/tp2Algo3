package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;


public class Partida {
	private List<Jugador> jugadores;
    private Queue<Pregunta> preguntas;

    //PRE: -
    //POS: Instancia una Partida sin datos.
    public Partida(){
    	preguntas = new LinkedList<>();
    	jugadores = new ArrayList<>();
    }

    //PRE: unNombre es un String válido.
    //POS: Añade un Jugador cn unNombre a jugadores.
    public void agregarJugador (String unNombre) {
    	jugadores.add(new Jugador(unNombre));
    }

    /*
     * PRE: unasPreguntas no es vacío.
     *      unasPreguntas es un Queue<Pregunta> válido.
     * POS: Carga preguntas con unasPreguntas.
     */
    public void setPreguntas(Queue<Pregunta> unasPreguntas) {
    	preguntas = unasPreguntas;
    }

    //PRE: -
    //POS: Recibe la pregunta siguiente a la utilizada.
    public Pregunta obtenerSiguientePregunta(){
    	return (!preguntas.isEmpty()) ? preguntas.poll():null;
    }

    //PRE: -
    //POS: Devuelve a jugadores.
    public List<Jugador> getJugadores() {
    	return jugadores;
    }

    //PRE: -
    //POS: Devuelve, en forma de String, los jugadores y sus respectivos puntajes.
    public List<String> obtenerResultadoPartida(){
    	return jugadores.stream().sorted((j1, j2) -> j2.getPuntaje() - j1.getPuntaje())
                .map(unJugador -> unJugador.toString()).collect(Collectors.toList());
    }
    
}
