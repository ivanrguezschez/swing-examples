package com.irs.swingexamples.tetris;

import java.awt.*;

/**
 * Clase abstracta que representa una pieza del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public abstract class Pieza {
    protected int px;
    protected int py;
    protected int mov;

    public Pieza(int x, int y) {
        super();
        this.px = x;
        this.py = y;
        this.mov = 0;
    }

    public void abajo() {
        this.py += 20;
    }

    public void arriba() {
        this.py -= 20;
    }

    public void derecha() {
        this.px += 20;
    }

    public void izquierda() {
        this.px -= 20;
    }

    public abstract void dibujar(Graphics g);
    public abstract void rotacion();
    public abstract Color color();
    public void cuadrado(int posx, int posy, Graphics g) {
        g.fillRoundRect(posx, posy, 20, 20, 5, 5);
    }
}
