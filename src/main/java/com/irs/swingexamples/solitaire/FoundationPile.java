/*
 * FoundationPile.java
 *
 * Created on 19 de febrero de 2007
 * Copyright 2007 Ivan Rodriguez. All rights reserved.
 */
package com.irs.swingexamples.solitaire;

/**
 * Clase que representa un monton o taco de cartas base.
 *
 * @author IRS
 * @version	1.0.0, 19/02/2007
 */
public class FoundationPile extends CardPile {

    /**
     * Constructor.
     * @param x La coordenada x del monton de cartas base.
     * @param y La coordenada y del monton de cartas base.
     */
    public FoundationPile(int x, int y) {
        super(x, y);
    }

    /**
     * Metodo que indica si se puede tomar una carta del monton base.
     * @param card La carta a tomar.
     * @return true si se pude tomar, false en caso contrario.
     */
    public boolean canTake(Card card) {
        if (isEmpty()) {
            return card.getRank() == 1;
        }
        Card top = (Card) cards.peek();
        if (card.getRank() == 1 + top.getRank()) {
            return true;
        }
        return false;
    }
}
