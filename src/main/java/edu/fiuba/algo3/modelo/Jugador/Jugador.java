package edu.fiuba.algo3.modelo.Jugador;

import java.util.HashMap;

public class  Jugador {
    private static final int MENOR_PUNTAJE = 0;
    private String nombre;
    private int puntaje;
    private HashMap<String,Integer> modificadores;

    //PRE: nombre es un String válido.
    //POS: Instancia un Jugador con nombre.
    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        modificadores = new HashMap<>();
        modificadores.put("multiplicadorX2",1);
        modificadores.put("multiplicadorX3",1);
        modificadores.put("puntajeExclusivo",2);
    }

    //PRE: -
    //POS: Devuelve el nombre del Jugador.
    public String getNombre(){
        return this.nombre;
    }

    //PRE: -
    //POS: Devuelve el puntaje de un Jugador.
    public int getPuntaje(){
        return this.puntaje;
    }

    //PRE: puntaje es un int válido.
    //POS: Añade el nuevo puntaje al puntaje del Jugador.
    public void modificarPuntaje(int puntaje){

        this.puntaje += puntaje;
        if (this.puntaje < MENOR_PUNTAJE) {
            this.puntaje = MENOR_PUNTAJE;
        }


    }

    //PRE: unaClave es un String válido.
    //POS: Registra el uso de un modificador, según unaClave.
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
    //POS: Devuelve, a la vez, el nombre y el puntaje de un Jugador en formato String.
    @Override
    public String toString () {
    	return this.nombre + " puntos: " + this.puntaje;
    }

}
