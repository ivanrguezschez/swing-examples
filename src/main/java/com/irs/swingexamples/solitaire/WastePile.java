/*
 * WastePile.java
 *
 * Created on 19 de febrero de 2007
 * Copyright 2007 Ivan Rodriguez. All rights reserved.
 */
package com.irs.swingexamples.solitaire;

/**
 * Clase que representa un monton o taco de cartas gastadas o empleadas.
 *
 * @author IRS
 * @version	1.0.0, 19/02/2007
 */
public class WastePile extends CardPile {

    /**
     * Constructor.
     * @param x La coordenada x del monton de cartas empleadas.
     * @param y La coordenada y del monton de cartas empleadas.
     */
    public WastePile(int x, int y) {
        super(x, y);
    }

    /**
     * Metodo que indica si se puede tomar una carta del monton empleado.
     * @param card La carta a tomar.
     * @return true si se pude tomar, false en caso contrario.
     */
    public boolean canTake(Card card) {
        return true;
    }
}
