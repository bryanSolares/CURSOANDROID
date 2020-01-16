package com.example.patromaestrodetalle.Entidades;

import java.io.Serializable;

public class PersonajeVO implements Serializable {

    private String nombre;
    private String descripcion;
    private int imagen;
    private String informacion;
    private int imagenDetalle;

    public PersonajeVO() {
    }

    /*
    public PersonajeVO(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }*/

    public PersonajeVO(String nombre, String descripcion, int imagen, String informacion, int imagenDetalle) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.informacion = informacion;
        this.imagenDetalle = imagenDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String info) {
        this.descripcion = info;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }
}
