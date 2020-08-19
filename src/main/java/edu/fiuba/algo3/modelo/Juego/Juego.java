package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.AsignadorPuntos.AsignadorPuntos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.LecturaJson.Anotador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno.Turno;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.modificador.ModificadorMultiplicador.MultiplicadorX3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Juego {
	
	private Partida unaPartida;
	private Jugador jugadorActivo;
	private Turno turnoActivo;
	private Pregunta preguntaActiva;
	private AsignadorPuntos unAsignador;
	private Queue<Jugador> jugadoresActivos;
	private int maximoJugadores;
	private int minimoJugadores;
	private int totalPreguntas;



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
		totalPreguntas = colaDePreguntas.size();
		unaPartida.setPreguntas(colaDePreguntas);
	}



	//PRE: -
	//POS: Provoca que una partida comience.
	public void comenzarRonda() {

		this.cargarJugadoresActivos();
		this.preguntaActiva = unaPartida.obtenerSiguientePregunta();
		this.totalPreguntas --;
		this.jugadorActivo = jugadoresActivos.poll();
		turnoActivo = new Turno (preguntaActiva, jugadorActivo);
		
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

	public void activarMultiplicadorX2() {
		this.jugadorActivo.activarMultiplicador("multiplicadorX2");
		turnoActivo.setMultiplicadorActivo(new MultiplicadorX2());
	}
	
	public void activarMultiplicadorX3() {
		this.jugadorActivo.activarMultiplicador("multiplicadorX3");
		turnoActivo.setMultiplicadorActivo(new MultiplicadorX3());
	}

	//PRE: -
	//POS: Señala a unAsignador que active sus modificadores de Exclusividad.
	public void activarExclusividad() {
		this.jugadorActivo.activarMultiplicador("puntajeExclusivo");
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
		this.jugadorActivo = jugadoresActivos.poll();
		turnoActivo = new Turno (preguntaActiva, jugadorActivo);
	}

	//PRE: -
	//POS: Pasa a la siguiente Ronda.
	public void siguienteRonda() {
		this.comenzarRonda();
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
	

	public boolean sinJugadores() {
		return (jugadoresActivos.size() == 0);
	}
	
	public boolean sinPreguntas() {
		return (totalPreguntas == 0);
	}
	
	public String nombreDelJugadorActivo() {
		return this.jugadorActivo.getNombre();
	}

	public void finDeRonda() {
		unAsignador.asignarPuntos();
		unAsignador = new AsignadorPuntos();
	}
	
	public boolean jugadorPuedeUsarModificador(String nombreModificador) {
		return this.jugadorActivo.puedeUsarMultiplicador(nombreModificador);
	}
	
	public boolean preguntaEsPenalizable() {
		return (this.preguntaActiva.getIdentificador().contains("Penal"));
	}
}

