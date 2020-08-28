package edu.fiuba.algo3.modelo.Opciones;

public abstract class Opcion {
    protected String descripcion;
    protected int ubicacionCorrecta;

    //PRE: descripción es un String válido.
    //POS: Instancia una Opcion con una descripción y ubicacionCorrecta inválida.
    public Opcion(String descripcion){
        this.descripcion = descripcion;
        this.ubicacionCorrecta = 0;
    }

    public abstract int calcularPuntosAdicionales();

    //PRE: -
    //POS: Devuelve su descripcion.
    public String getDescripcion(){
        return this.descripcion;
    }

    //PRE: -
    //POS: Devuelve su ubicacioncorrecta.
    public int getUbicacionCorrecta(){ return this.ubicacionCorrecta; }
}

