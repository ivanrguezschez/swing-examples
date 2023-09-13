package com.irs.swingexamples.tetris;

import java.awt.*;

/**
 * Clase que representa la pieza ele (L) del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public class L extends Pieza {
    // Constructor
    public L(int x, int y) {
        super(x,y);
    }

    public Color color() {
        return Color.orange;
    }

    public void rotacion() {
        if (mov == 3) {
            mov = 0;
        } else {
            mov++;
        }
    }

    public void dibujar(Graphics g) {
        int i;
        switch (mov)
        {
            case 0:
                for (i = 0; i < 3; i++) {
                    cuadrado(px - 10 + (i * 20), py + 10, g);
                }
                cuadrado(px-10, py+30, g);
                break;
            case 1:
                for (i = 0; i < 3; i++) {
                    cuadrado(px + 10, py - 10 + (i * 20), g);
                }
                cuadrado(px-10, py-10, g);
                break;
            case 2:
                for (i = 0; i < 3; i++) {
                    cuadrado(px - 10 + (i * 20), py + 10, g);
                }
                cuadrado(px+30, py-10, g);
                break;
            case 3:
                for(i = 0; i < 3; i++) {
                    cuadrado(px + 10, py - 10 + (i * 20), g);
                }
                cuadrado(px+30, py+30, g);
                break;
        }
    }
}