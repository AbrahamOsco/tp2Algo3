package edu.fiuba.algo3.modelo;

public class  Jugador {
    private String nombre;
    private int puntaje;
    //modificadorActivo

    public Jugador(String nombre){
        this.nombre = nombre;
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
}
