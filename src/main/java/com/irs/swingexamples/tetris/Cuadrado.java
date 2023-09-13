package com.irs.swingexamples.tetris;

import java.awt.*;

/**
 * Clase que representa la pieza cuadrado del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Cuadrado extends Pieza {
    // Constructor
    public Cuadrado(int x, int y) {
        super(x,y);
    }

    public Color color() {
        return Color.blue;
    }

    public void rotacion() {}

    public void dibujar(Graphics g) {
        cuadrado(px+10, py+10, g);
        cuadrado(px+32, py+10, g);
        cuadrado(px+10, py+32, g);
        cuadrado(px+32, py+32, g);
    }
}
