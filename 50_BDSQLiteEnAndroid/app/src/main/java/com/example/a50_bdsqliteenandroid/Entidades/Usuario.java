package com.example.a50_bdsqliteenandroid.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer idUsuario;
    private String nombre;
    private String telefono;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "idUsuario=" + idUsuario +
                "-- nombre='" + nombre ;
    }
}
