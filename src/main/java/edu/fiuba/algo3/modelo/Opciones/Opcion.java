package edu.fiuba.algo3.modelo.Opciones;

public abstract class Opcion {
    protected String descripcion;
    protected int ubicacionCorrecta;

    //PRE: descripcion es un string válido (debatir si amerita Exception).
    //POS: Crea una nueva opcion con descripcion y una ubicacion correcta nula.
    public Opcion(String descripcion){
        this.descripcion = descripcion;
        this.ubicacionCorrecta = 0;
    }

    public abstract int calcularPuntosAdicionales();

    //PRE: -
    //POS: Devuelve la descripcion de la opcion.
    public String getDescripcion(){
        return this.descripcion;
    }

    //PRE: -
    //POS: Devuelve la ubicacion correcta de la opcion.
    public int getUbicacionCorrecta(){ return this.ubicacionCorrecta; }
}

