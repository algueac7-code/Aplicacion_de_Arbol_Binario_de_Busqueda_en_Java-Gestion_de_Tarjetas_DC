/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JPanel;
import Logica.Arbol;
import Logica.Nodo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 * Uned Alaljuela - Alonso Guevara
 * Clase Para el manejo de la parte grafica del panel lateral
 * PanelArbol.java fecha de creacion  14/4/2026
 * Para esta parte se uso la ayuda de la IA con el fin de aprender a dibujar graficas en Java
 */
public class PanelArbol extends JPanel {
    
    private Arbol arbol;
    private final int DIAMETRO = 36;
    private final int RADIO = DIAMETRO / 2;
    private final int ESPACIO_VERTICAL = 70;
    private Nodo nodoResaltado; 

    public PanelArbol() {
        setOpaque(true);
        setBackground(java.awt.Color.WHITE);
    }
    
    public void setNodoResaltado(Nodo nodoResaltado){
        this.nodoResaltado = nodoResaltado;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    //Reparacion del bug de pintado del panel.
    //Sobre escritura para ajustar el panel al contenerdo. jPanel no lo ajusto por default
    
    @Override
    public java.awt.Dimension getPreferredSize() {
        int ancho = 600;
        int alto = 600;

        if (arbol != null && arbol.getRaiz() != null) {
            int niveles = arbol.altura();

            alto = Math.max(600, niveles * ESPACIO_VERTICAL + 150);

            ancho = (int) Math.pow(2, niveles - 1) * 80;
            ancho = Math.max(ancho, 800);
        }

        return new java.awt.Dimension(ancho, alto);
    }
  
    //Reescribe el metodo, para ajustar el comportamiento en cada iteracion.
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3f));
        
        //g.drawString("W: " + getWidth() + " H: " + getHeight(), 10, 20);
        //g.drawString("Pref: " + getPreferredSize().width + " x " + getPreferredSize().height, 10, 40);
        
        if (arbol != null && arbol.getRaiz() != null) {
            int xInicial = getPreferredSize().width / 2;
            int yInicial = 80;
            int separacionInicial = 220;

            dibujarArbol(g2, arbol.getRaiz(), xInicial, yInicial, separacionInicial);
        }
    }

    private void dibujarArbol(Graphics2D g, Nodo nodo, int x, int y, int separacion) {
        if (nodo == null) {
            return;
        }

        // Dibuja linea y subarbol izquierdo
        if (nodo.getIzquierdo() != null) {
            int xIzq = x - separacion;
            int yIzq = y + ESPACIO_VERTICAL;

            g.drawLine(x, y + RADIO, xIzq, yIzq - RADIO);
            dibujarArbol(g, nodo.getIzquierdo(), xIzq, yIzq, Math.max(50, separacion / 2));
        }

        // Dibuja linea y subarbol derecho
        if (nodo.getDerecho() != null) {
            int xDer = x + separacion;
            int yDer = y + ESPACIO_VERTICAL;

            g.drawLine(x, y + RADIO, xDer, yDer - RADIO);
            dibujarArbol(g, nodo.getDerecho(), xDer, yDer, Math.max(40, separacion / 2));
        }

        // Dibuja circulo centrado en (x, y)
        
        if (nodo == nodoResaltado){
            
            g.setColor(Color.BLUE);
            g.fillOval(x -RADIO, y - RADIO, DIAMETRO, DIAMETRO);
            
            g.setColor(Color.BLACK);
            g.drawOval(x -RADIO, y - RADIO, DIAMETRO, DIAMETRO);
            
            //texto Blanco
            
            g.setColor(Color.WHITE);
            
        }else{
            g.setColor(Color.BLACK);
            g.drawOval(x -RADIO, y - RADIO, DIAMETRO, DIAMETRO);
        }

        // Dibuja texto del ID
        String texto = String.valueOf(nodo.getDato().getId());

        java.awt.FontMetrics fm = g.getFontMetrics();
        int anchoTexto = fm.stringWidth(texto);

        g.drawString(texto, x - (anchoTexto / 2), y + 5);
        g.setColor(Color.BLACK); 
    }
}
