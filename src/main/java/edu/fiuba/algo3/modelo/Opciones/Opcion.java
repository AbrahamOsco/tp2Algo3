package edu.fiuba.algo3.modelo.Opciones;

public abstract class Opcion {
    protected String descripcion;
    protected int ubicacionCorrecta;

    public Opcion(String descripcion){
        this.descripcion = descripcion;
        this.ubicacionCorrecta = 0;
    }

    public abstract int calcularPuntosAdicionales();
    public String getDescripcion(){
        return this.descripcion;
    }
    public int getUbicacionCorrecta(){ return this.ubicacionCorrecta; }
}

