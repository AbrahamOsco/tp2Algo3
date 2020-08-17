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
    //POS: Crea una partida sin datos.
    public Partida(){
    	preguntas = new LinkedList<>();
    	jugadores = new ArrayList<>();
    }

    //PRE: unNombre es un string válido.
    //POS: Añade un nuevo Jugador a jugadores, a partir del nombre recibido.
    public void agregarJugador (String unNombre) {
    	jugadores.add(new Jugador(unNombre));
    }

    //PRE: unasPreguntas es un Queue<Pregunta> válido y no vacío (el chequeo de vacío amerita Exception).
    //POS: Carga unasPreguntas a preguntas.
    public void setPreguntas(Queue<Pregunta> unasPreguntas) {
    	preguntas = unasPreguntas;
    }

    //PRE: -
    //POS: Si una pregunta fue utilizada, toma la siguiente de preguntas y la retorna.
    public Pregunta obtenerSiguientePregunta(){
    	return (!preguntas.isEmpty()) ? preguntas.poll():null;
    }

    //PRE: -
    //POS: Devuelve una lista de todos los jugadores de la partida.
    public List<Jugador> getJugadores() {
    	return jugadores;
    }

    //PRE: -
    //POS: Devuelve la tabla de jugadores con sus respectivos puntos como una lista de String.
    public List<String> obtenerResultadoPartida(){
    	return jugadores.stream().sorted((j1, j2) -> j2.getPuntaje() - j1.getPuntaje())
                .map(unJugador -> unJugador.toString()).collect(Collectors.toList());
    }
    
}
