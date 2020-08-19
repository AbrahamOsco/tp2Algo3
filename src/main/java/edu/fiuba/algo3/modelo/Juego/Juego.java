package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.LecturaJson.Anotador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.ModificadorMultiplicador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Juego {
	
	private Partida unaPartida;
	private Turno turnoActivo;
	private Pregunta preguntaActiva;
	private AsignadorPuntos unAsignador;
	private Queue<Jugador> jugadoresActivos;
	private int maximoJugadores;
	private int minimoJugadores;
	
	


	//PRE: -
	//POS: Recibe los jugadores participantes en una partida.

	private void cargarJugadoresActivos() {
		unaPartida.getJugadores().stream().forEach(jugador -> jugadoresActivos.offer(jugador));
	}

	//PRE: -
	//POS: instancia un Juego sin datos.
	public Juego() {
		
		unaPartida = new Partida();
		unAsignador = new AsignadorPuntos();
		jugadoresActivos = new LinkedList<>();
		maximoJugadores = 5;
		minimoJugadores = 2;
	}

	//PRE: -
	//POS: Inicia una partida a partir de un grupo de preguntas.
	public void nuevaPartida() throws IOException {
		Anotador anotadorDePreguntas = new Anotador();
		Queue<Pregunta> colaDePreguntas = anotadorDePreguntas.getColaDePreguntas();
		unaPartida.setPreguntas(colaDePreguntas);
	}

	//PRE: -
	//POS: Provoca que una partida comience.
	public void comenzarPartida() {
		
		this.cargarJugadoresActivos();
		preguntaActiva = unaPartida.obtenerSiguientePregunta();
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll());
		
	}

	//PRE: nombreJugador es un String válido.
	//POS: Añade un Jugador a unaPartida.
	public void cargarJugador (String nombreJugador) {
		
		unaPartida.agregarJugador(nombreJugador);
	}

	//PRE: unasOpciones es un ArrayList<Opcion> válido.
	//POS: Recibe un grupo de opciones y las guarda en turnoActivo como opciones elegidas por un jugador.
	public void recibirUnaRespuesta (ArrayList<Opcion> unasOpciones) {
		
		turnoActivo.setOpcionesElejidas(unasOpciones);

	}

	//PRE: -
	//POS: Devuelve el resultado de unaPartida.
	public List <String> obtenerPuntajeFinal (){
		
		return unaPartida.obtenerResultadoPartida();
	}

	//PRE: unMultiplicador es una instancia válida de ModificadorMultiplicador.
	//POS: Recibe y envía un multiplicador para ser activado por turnoActivo.
	public void activarMultiplicador(ModificadorMultiplicador unMultiplicador) {
		
		turnoActivo.setMultiplicadorActivo(unMultiplicador);
	}

	//PRE: -
	//POS: Señala a unAsignador que active sus modificadores de Exclusividad.
	public void activarExclusividad() {
		
		unAsignador.agregarExclusividad();
	}

	//PRE: -
	//POS: Le pasa turnoActivo a unAsignador para que lo procese.
	public void responder() {
		
		unAsignador.agregarTurno(turnoActivo);
	}

	//PRE: -
	//POS: Cambia turnoActivo al siguiente Turno.
	public void siguienteTurno() {
		
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll() );
	}

	//PRE: -
	//POS: Pasa a la siguiente Ronda.
	public void siguienteRonda() {
		
		this.comenzarPartida();
	}

	
	public boolean alcanzoJugadoresMinimos() {
		return !(unaPartida.getJugadores().size() >= this.minimoJugadores);
	}
	
	public boolean alcanzoJugadoresMaximos() {
		return !(unaPartida.getJugadores().size() <= this.maximoJugadores);
	}
	
	public Pregunta obtenerPreguntaActiva() {
		return this.preguntaActiva;
	}
	


	//PRE: -
	//POS: Inicia el proceso de asignar puntos al término de una Ronda.

	public void finDeRonda() {
		
		unAsignador.asignarPuntos();
		unAsignador = new AsignadorPuntos();
	}
}

