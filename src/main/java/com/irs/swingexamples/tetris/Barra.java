package com.irs.swingexamples.tetris;

import java.awt.*;

/**
 * Clase que representa la pieza barra del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Barra extends Pieza {
    // Constructor
    public Barra(int x, int y) {
        super(x,y);
    }

    public Color color() {
        return Color.red;
    }

    public void rotacion() {
        if (mov == 0) {
            mov = 1;
        } else {
            mov = 0;
        }
    }

    public void dibujar (Graphics g) {
        for (int i = 0; i < 4; i++) {
            switch (mov) {
                case 0:
                    cuadrado(px - 15 + (22 * i), py + 10, g);
                    break;
                case 1:
                    cuadrado(px + 10, py - 15 + (22 * i), g);
                    break;
            }
        }
    }
}

