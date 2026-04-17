/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidad.Tarjeta;

/**
 * Uned Alaljuela - Alonso Guevara
 * Clase para el control de los Nodos a travez de un algoritmo de arbol binario de busqueda. 
 * Arbol.java fecha de creacion  10/4/2026
 */
public class Arbol {
    
    private Nodo raiz;
    private String mensajeEliminacion;
    private Nodo nodoMayor;
    private Nodo nodoMenor;
    
    public Arbol(){
        this.raiz = null;
        this.mensajeEliminacion = "";
    }
    
    // Get ans Set
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    // Metodo basicos de control de nodos
    public boolean estaVacio() {
        return raiz == null;
    }
    
    //Inicia la raiz si estavacia sino llama al metodo de insercion recursivo de arbol binario.
    
    public boolean insertar(Tarjeta tarjeta){
        if (raiz == null){
            raiz = new Nodo(tarjeta);
            return true;
        }
        return insertarRecursivo(raiz,tarjeta);
    }
    
    private boolean insertarRecursivo(Nodo actual, Tarjeta tarjeta){
        int idNuevo = tarjeta.getId();
        int idActual = actual.getDato().getId();
        
        if (idNuevo < idActual ){
            if(actual.getIzquierdo() == null){
                actual.setIzquierdo(new Nodo(tarjeta));
                return true;
            }
            return insertarRecursivo(actual.getIzquierdo(),tarjeta);
        }
        
        if (idNuevo > idActual){
            if(actual.getDerecho() == null){
                actual.setDerecho(new Nodo(tarjeta));
                return true;
            }
            return insertarRecursivo(actual.getDerecho(),tarjeta);
        }
        
        return false;
    }
    
    //Metodo para el calculo de la altura
    
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int izq = alturaRecursiva(nodo.getIzquierdo());
        int der = alturaRecursiva(nodo.getDerecho());

        return 1 + Math.max(izq, der);
    }
    
    //Metodo de eliminacion
    
    public String eliminar(int id){
        
        mensajeEliminacion = "";
        
        if(buscar(id)== null){
            return "No existe un Nodo con este ID";
        }
        
        raiz = eliminarRecursivo(raiz,id);
        return mensajeEliminacion;
        
    }
    
    private Nodo eliminarRecursivo(Nodo actual, int id) {
        
        if (actual == null) {
            return null;
        }
        
        int idActual = actual.getDato().getId();
        
        if(id < idActual){
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(),id));
            return actual;
        }
        
        if(id > idActual){
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(),id));
            return actual;
        }
        
        //Ninguna tarjeta de la categoria de civiles puede eliminarce
        if(actual.getDato().getCategoria().equalsIgnoreCase("Civiles")){
            mensajeEliminacion = "No se premite eliminar tarjetas de Civiles";
            return actual;
        }
        
        boolean tieneIzquierdo = actual.getIzquierdo() != null;
        boolean tieneDerecho = actual.getDerecho() != null;
        
        // Casos segun requemiento del proyecto
        
        if(!tieneIzquierdo && !tieneDerecho){
            mensajeEliminacion = "Nodo eliminado correctamente";
            return null;
        }
        
        if (!tieneIzquierdo && tieneDerecho) {
            mensajeEliminacion = "No se permite eliminar un nodo de subarbol derecho";
            return actual;
        }
        
        if (tieneIzquierdo && !tieneDerecho) {
            mensajeEliminacion = "Nodo eliminado correctamente";
            return actual.getIzquierdo();
        }
        
        //solo queda el caso con dos Hijos
        mensajeEliminacion = "No se permite eliminar un nodo con dos hijos";
        return actual;
    }
    
    //Metodo de busqueda
    
    public Nodo buscar(int id){
        return buscarRecursivo(raiz, id);
    }
    
    private Nodo buscarRecursivo(Nodo actual, int id){
        
        if(actual == null){
            return null;
        }
        
        int idActual = actual.getDato().getId();
        
        if(id == idActual){
            return actual;
        }
        
        if(id < idActual){
            return buscarRecursivo(actual.getIzquierdo(),id);
        }else{
            return buscarRecursivo(actual.getDerecho(), id);
        } 
    }
    
    // Metodo para mostrar el recorrido segun orden
    
    public String preOrden(){
        StringBuilder resultado = new StringBuilder();
        preOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void preOrdenRecursivo(Nodo actual, StringBuilder resultado) {
        
        if(actual == null){
            return;
        }
        
        resultado.append(" → ").append(actual.getDato().getId());
        
        preOrdenRecursivo(actual.getIzquierdo(), resultado);
        preOrdenRecursivo(actual.getDerecho(), resultado);
    }
    
    public String postOrden(){
        StringBuilder resultado = new StringBuilder();
        postOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void postOrdenRecursivo(Nodo actual, StringBuilder resultado) {
        
        if(actual == null){
            return;
        }
        preOrdenRecursivo(actual.getIzquierdo(), resultado);
        preOrdenRecursivo(actual.getDerecho(), resultado);
        resultado.append(" → ").append(actual.getDato().getId());
    }
    
    public String inOrden(){
        StringBuilder resultado = new StringBuilder();
        inOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void inOrdenRecursivo(Nodo actual, StringBuilder resultado) {
        
        if(actual == null){
            return;
        }
        
        inOrdenRecursivo(actual.getIzquierdo(), resultado);
        resultado.append(" → ").append(actual.getDato().getId());
        inOrdenRecursivo(actual.getDerecho(), resultado);
    }

    // Metodo de conteo de nodos
    
    public int contarPorCategoria(String categoria){
        
        return contarCategoriaRecursivo(raiz,categoria);
    }

    private int contarCategoriaRecursivo(Nodo actual, String categoria) {
        
        if(actual == null){
            return 0;
        }
        
        int contador = 0;
        
        if(actual.getDato().getCategoria().equalsIgnoreCase(categoria)){
            contador = 1;
        }
        
        return contador + contarCategoriaRecursivo(actual.getIzquierdo(), categoria) 
                + contarCategoriaRecursivo(actual.getDerecho(), categoria);
    }
    
    //Metodo para listar frases iconicas
    
    public String listarFrIc(){
        
        StringBuilder resultado = new StringBuilder();
        listarFrIcRecursivo(raiz, resultado);
        
        if(resultado.length()== 0){
            return "no existen nodos hoja de Fraces Iconicas";
        }
        
        return resultado.toString();
    }

    private void listarFrIcRecursivo(Nodo actual, StringBuilder resultado) {
        
        if(actual == null){
            return;
        }
        
        boolean esHoja = actual.getIzquierdo() == null && actual.getDerecho() == null;
        boolean esCategoriaFrIc = actual.getDato().getCategoria().equalsIgnoreCase("Frases Iconicas");
        
        if(esHoja && esCategoriaFrIc){
            
            resultado.append("- ").append(actual.getDato().getDescripcion()).append(" -\n");
            
        }
        
        listarFrIcRecursivo(actual.getIzquierdo(), resultado);
        listarFrIcRecursivo(actual.getDerecho(), resultado);
    }
    
    //Metodo para localizar nodo menor y mayor con recorrido del Arbol
    
    public String obtenerMayorYMenor() {
        
        if (raiz == null) {
            return "El arbol esta vacio";
        }

        nodoMayor = raiz;
        nodoMenor = raiz;

        obtenerMayorYMenorRecursivo(raiz);

        return "MENOR ID\n" +
               "ID: " + nodoMenor.getDato().getId() +
               " | Descripcion: " + nodoMenor.getDato().getDescripcion() +
               " | Categoria: " + nodoMenor.getDato().getCategoria() +
               "\n\n" +
               "MAYOR ID\n" +
               "ID: " + nodoMayor.getDato().getId() +
               " | Descripcion: " + nodoMayor.getDato().getDescripcion() +
               " | Categoria: " + nodoMayor.getDato().getCategoria();
    }
    
    private void obtenerMayorYMenorRecursivo(Nodo actual) {
        
        if (actual == null) {
            return;
        }

        if (actual.getDato().getId() < nodoMenor.getDato().getId()) {
            nodoMenor = actual;
        }

        if (actual.getDato().getId() > nodoMayor.getDato().getId()) {
            nodoMayor = actual;
        }

        obtenerMayorYMenorRecursivo(actual.getIzquierdo());
        obtenerMayorYMenorRecursivo(actual.getDerecho());
    }
}
