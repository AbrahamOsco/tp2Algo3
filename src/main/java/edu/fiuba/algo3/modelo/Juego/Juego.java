package edu.fiuba.algo3.modelo.Juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

public class Juego {
	
	private Partida unaPartida;
	private Turno turnoActivo;
	private Pregunta preguntaActiva;
	private AsignadorPuntos unAsignador;
	private Queue<Jugador> jugadoresActivos;
	
	
	private void cargarJugadoresActivos() {
		
		for (Jugador unJugador: unaPartida.getJugadores()) {
			jugadoresActivos.offer(unJugador);
		}
	}
	
	public Juego() {
		
		unaPartida = new Partida();
		unAsignador = new AsignadorPuntos();
		jugadoresActivos = new LinkedList<>();
	}
	
	public void nuevaPartida(/*unArchivoDePreguntas*/) {
		
		/*aca se cargan las preguntasa a la partida*/
	}
	
	public void comenzarPartida() {
		
		this.cargarJugadoresActivos();
		preguntaActiva = unaPartida.obtenerSiguientePregunta();
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll());
		
	}
	
	public void cargarJugador (String nombreJugador) {
		
		unaPartida.agregarJugador(nombreJugador);
	}
	
	public void recibirUnaRespuesta (ArrayList<Opcion> unasOpciones) {
		
		turnoActivo.setOpcionesElejidas(unasOpciones);
		/*agregarOpcionesDeAUna*/
	}
	
	public List <String> obtenerPuntajeFinal (){
		
		return unaPartida.obtenerResultadoPartida();
	}
	
	/*public Pantalla obtenerUnaPantalla() {
		Se pide la pantalla a alguien, supongo.
	}*/
	
	public void activarMultiplicador(ModificadorMultiplicador unMultiplicador) {
		
		turnoActivo.setMultiplicadorActivo(unMultiplicador);
	}
	
	public void activarExclusividad() {
		
		unAsignador.agregarExclusividad();
	}
	
	public void responder() {
		
		unAsignador.agregarTurno(turnoActivo);
	}
	
	public void siguienteTurno() {
		
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll() );
	}
	
	public void siguienteRonda() {
		
		this.comenzarPartida();
	}
	
	public void finDeRonda() {
		
		unAsignador.asignarPuntos();
		unAsignador = new AsignadorPuntos();
	}
}
