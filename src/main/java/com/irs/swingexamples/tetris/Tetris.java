package com.irs.swingexamples.tetris;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase principal del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Tetris extends Frame implements KeyListener {
    private Pieza pieza;

    public static final int POSICION_INICIAL = 20;

    public Tetris(String name) {
        setTitle(name);
    }

    public void init() {
        setSize(200,300);
        setBackground(Color.white);
        addKeyListener(this);
        show();
        nueva_pieza();
    }

    public void paint(Graphics g) {
        g.setColor(pieza.color());
        pieza.dibujar(g);
    }

    public void nueva_pieza() {
        int numero = (int)(Math.random() * 4);
        switch(numero) {
            case 0:
                pieza = new Barra(POSICION_INICIAL, POSICION_INICIAL);
                break;
            case 1:
                pieza = new L(POSICION_INICIAL, POSICION_INICIAL);
                break;
            case 2:
                pieza = new Z(POSICION_INICIAL, POSICION_INICIAL);
                break;
            case 3:
                pieza = new Cuadrado(POSICION_INICIAL, POSICION_INICIAL);
                break;
        }
    }
    /*
    public boolean keyDown (Event evt, int key) {
       switch(key) {
          case Event.UP:
             pieza.arriba();
             break;
          case Event.DOWN:
             pieza.abajo();
             break;
          case Event.RIGHT:
             pieza.derecha();
             break;
          case Event.LEFT:
             pieza.izquierda();
             break;
          case 10: // Barra espaciadora
             nueva_pieza();
             break;
          case 32: // Enter
             pieza.rotacion();
             break;
       }
       repaint();
       return true;
    }
     */
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 38: //e.VK_UP
                pieza.arriba();
                break;
            case 40: //e.VK_DOWN
                pieza.abajo();
                break;
            case 39: //e.VK_RIGHT
                pieza.derecha();
                break;
            case 37: //e.VK_LEFT
                pieza.izquierda();
                break;
            case 32: //e.VK_SPACE // Barra espaciadora
                nueva_pieza();
                break;
            case 10: //e.VK_ENTER // Enter
                pieza.rotacion();
                break;
        }
        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}


    public static void main(String args[]) {
        Tetris prueba = new Tetris("Fichas del Tetris");
        prueba.init();
        prueba.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}

