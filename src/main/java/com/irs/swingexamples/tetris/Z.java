package com.irs.swingexamples.tetris;

import java.awt.*;

/**
 * Clase que representa la pieza zeta (Z) del tetris.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Z extends Pieza {
    // Constructor
    public Z(int x, int y) {
        super(x,y);
    }

    public Color color() {
        return Color.green;
    }

    public void rotacion() {
        if (mov == 1) {
            mov = 0;
        } else {
            mov = 1;
        }
    }

    public void dibujar(Graphics g) {
        cuadrado(px+10, py+10, g);
        cuadrado(px+10, py+30, g);

        switch (mov) {
            case 0:
                cuadrado(px+30, py+10, g);
                cuadrado(px-10, py+30, g);
                break;
            case 1:
                cuadrado(px-10, py+10, g);
                cuadrado(px-10, py-10, g);
                break;
        }
    }
}
