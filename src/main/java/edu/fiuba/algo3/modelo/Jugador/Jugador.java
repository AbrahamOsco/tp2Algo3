package edu.fiuba.algo3.modelo.Jugador;

import java.util.HashMap;

public class  Jugador {
    private String nombre;
    private int puntaje;
    private HashMap<String,Integer> modificadores;

    //PRE: Nombre es un String válido.
    //POS: Instancia un objeto Jugador, con el nombre recibido.
    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        modificadores = new HashMap<>();
        modificadores.put("multiplicadorX2",1);
        modificadores.put("multiplicadorX3",1);
        modificadores.put("puntajeExclusivo",2);
    }

    //PRE: -
    //POS: Devuelve el nombre del jugador.
    public String getNombre(){
        return this.nombre;
    }

    //PRE: -
    //POS: Devuelve el puntaje del jugador.
    public int getPuntaje(){
        return this.puntaje;
    }

    //PRE: puntaje es un int válido.
    //POS: Modifica el puntaje acorde a un nuevo puntaje recibido.
    public void modificarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }

    //PRE: unaClave es válida (es "multiplicadorX2" o "multiplicadorX3" o "puntajeExclusivo"). Amerita Exception.
    //POS: Registra el uso de un tipo de modificador.
    public boolean activarMultiplicador(String unaClave){
        boolean retorno = false;
        int valor = modificadores.get(unaClave);
        if(valor > 0){
            retorno = true;
            modificadores.put(unaClave, (valor-1));
        }
        return retorno;
    }

    //PRE: -
    //POS: Devuelve, como String, el nombre y los puntos del jugador.
    @Override
    public String toString () {
    	return this.nombre + " puntos: " + this.puntaje;
    }

}
