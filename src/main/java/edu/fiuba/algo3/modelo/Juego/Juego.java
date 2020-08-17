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
	
	//PRE: -
	//POS: Toma jugadores de unaPartida y los guarda en JugadoresActivos.
	private void cargarJugadoresActivos() {
		unaPartida.getJugadores().stream().forEach(jugador -> jugadoresActivos.offer(jugador));
	}

	//PRE: -
	//POS: Crea un Juego sin datos.
	public Juego() {
		
		unaPartida = new Partida();
		unAsignador = new AsignadorPuntos();
		jugadoresActivos = new LinkedList<>();
	}

	//PRE: -
	//POS: Carga una serie de preguntas en una Partida.
	public void nuevaPartida() throws IOException {
		Anotador anotadorDePreguntas = new Anotador();
		Queue colaDePreguntas = anotadorDePreguntas.getColaDePreguntas();
		unaPartida.setPreguntas(colaDePreguntas);
	}

	//PRE: -
	//POS: Inicia una Partida.
	public void comenzarPartida() {
		
		this.cargarJugadoresActivos();
		preguntaActiva = unaPartida.obtenerSiguientePregunta();
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll());
		
	}

	//PRE: nombreJugador es un string válido.
	//POS: Añade un Jugador a una Partida.
	public void cargarJugador (String nombreJugador) {
		
		unaPartida.agregarJugador(nombreJugador);
	}

	//PRE: unasOpciones es un ArrayList<Opcion> válido.
	//POS: Carga a un turno una lista de opciones elegidas por el jugador.
	// + El caso en que unasOpciones este vacío no amerita exception, ya que eso está contemplado en otra clase.
	public void recibirUnaRespuesta (ArrayList<Opcion> unasOpciones) {
		
		turnoActivo.setOpcionesElejidas(unasOpciones);
		/*agregarOpcionesDeAUna*/
	}

	//PRE: -
	//POS: Obtiene el resultado final de una partida.
	public List <String> obtenerPuntajeFinal (){
		
		return unaPartida.obtenerResultadoPartida();
	}

	//PRE: unMultiplicador es un ModificadorMultiplicador válido.
	//POS: Indica a turno que active un ModificadorMultiplicador.
	public void activarMultiplicador(ModificadorMultiplicador unMultiplicador) {
		
		turnoActivo.setMultiplicadorActivo(unMultiplicador);
	}

	//PRE: -
	//POS: Añade una Exclusividad a un AsignadorPuntos.
	public void activarExclusividad() {
		
		unAsignador.agregarExclusividad();
	}

	//PRE: -
	//POS: Pasa un turno a asignador para procesar las respuestas de un jugador.
	public void responder() {
		
		unAsignador.agregarTurno(turnoActivo);
	}

	//PRE: -
	//POS: Cambia turnoActivo al turno siguiente.
	public void siguienteTurno() {
		
		turnoActivo = new Turno (preguntaActiva, jugadoresActivos.poll() );
	}

	//PRE: -
	//POS: Pasa a la siguiente Ronda, renovando la pregunta y los jugadores.
	public void siguienteRonda() {
		
		this.comenzarPartida();
	}

	//PRE: -
	//POS: Finaliza una Ronda, procesando los puntos obtenidos en esta.
	public void finDeRonda() {
		
		unAsignador.asignarPuntos();
		unAsignador = new AsignadorPuntos();
	}
}
