/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 * Uned Alaljuela - Alonso Guevara
 * Entidad general para la recoleccion de datos
 * Tarjeta.java fecha de creacion  10/4/2026
 */
public class Tarjeta {
    
    private int id;
    private String descripcion;
    private String categoria;
    
    public Tarjeta (int id, String descripcion, String categoria ){
        
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id= " + id + ", descripcion= " + descripcion + ", categoria= " + categoria + '}';
    }
    
    
}
