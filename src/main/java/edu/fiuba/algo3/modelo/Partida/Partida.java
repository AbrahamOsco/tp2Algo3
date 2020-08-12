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

    public Partida(){
    	preguntas = new LinkedList<>();
    	jugadores = new ArrayList<>();
    }
    
    public void agregarJugador (String unNombre) {
    	jugadores.add(new Jugador(unNombre));
    }
    
    public void setPreguntas(Queue<Pregunta> unasPreguntas) {
    	preguntas = unasPreguntas;
    }
    
    public Pregunta obtenerSiguientePregunta(){
    	return (!preguntas.isEmpty()) ? preguntas.poll():null;
    }
    
    public List<Jugador> getJugadores() {
    	return jugadores;
    }
    
    public List<String> obtenerResultadoPartida(){
    	return jugadores.stream().sorted((j1, j2) -> Integer.valueOf(j1.getPuntaje()).compareTo(Integer.valueOf (j2.getPuntaje()) ))
                .map(unJugador -> unJugador.toString()).collect(Collectors.toList());
    }
    
}
