/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidad.Tarjeta;
/**
 * Uned Alaljuela - Alonso Guevara
 * Clase Nodo para el manejo de la informacion de las tarjetas
 * Nodo.java fecha de creacion  10/4/2026
 */
public class Nodo {
    
    private Tarjeta dato;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(Tarjeta dato){
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    //Geters
    public Tarjeta getDato(){
        return dato;
    }
    
    public Nodo getIzquierdo(){
        return izquierdo;
    }
    
    public Nodo getDerecho(){
        return derecho;
    }
    
    //Seters
    
    public void setDato(Tarjeta dato){
        this.dato = dato;
    }
    
    public void setIzquierdo(Nodo izquierdo){
        this.izquierdo = izquierdo;
    }
    
    public void setDerecho(Nodo derecho){
        this.derecho = derecho;
    }
    
}
