package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class  Jugador {
    private String nombre;
    private int puntaje;
    private HashMap<String,Integer> modificadores;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
        modificadores = new HashMap<>();
        modificadores.put("multiplicadorX2",1);
        modificadores.put("multiplicadorX3",1);
        modificadores.put("puntajeExclusivo",2);
    }


    public String getNombre(){
        return this.nombre;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void modificarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }
    boolean activarMultiplicador(String unaClave){
        boolean retorno = false;
        int valor = modificadores.get(unaClave);
        if(valor > 0){
            retorno = true;
            modificadores.put(unaClave, (valor-1));
        }
        return retorno;
    }

}
