/*
 * CardPile.java
 *
 * Created on 19 de febrero de 2007
 * Copyright 2007 Ivan Rodriguez. All rights reserved.
 */
package com.irs.swingexamples.solitaire;

import java.awt.*;
import java.util.Stack;

/**
 * Clase que representa un monton o taco de cartas.
 *
 * @author IRS
 * @version	1.0.0, 19/02/2007
 */
public class CardPile {

    /** La coordenada x del monton de cartas. */
    private int x;
    /** La coordenada y del monton de cartas. */
    private int y;
    /** La pila que almacena las cartas del monton. */
    protected Stack cards;

    /**
     * Constructor.
     * @param x La coordenada x del monton.
     * @param y La coordenada x del monton.
     */
    public CardPile(int x, int y) {
        this.x = x;
        this.y = y;
        cards = new Stack();
    }

    /**
     * Metodo que añade una carta a la pila de cartas del monton.
     * @param card La carta a añadir.
     */
    public void addCard(Card card) {
        cards.push(card);
    }

    /**
     * Metodo que indica si el monton de cartas esta vacio.
     * @return true si el monton esta vacio, false en caso contrario.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Metodo que indica si se puede tomar una carta del monton.
     * @param card La carta a tomar.
     * @return true si se pude tomar, false en caso contrario.
     */
    public boolean canTake(Card card) {
        return false;
    }

    /**
     * Metodo que devuelve la carta que se encuentra en la cima del monton.
     * @return La carta que se encuentra en la cima del monton.
     */
    public Card topCard() {
        Card result = (Card) cards.pop();
        return result;
    }

    /**
     * Metodo que indica si unas determinadas coordenas estan incluidas en el
     * espacio que ocupa el monton de cartas.
     * @param tx La coordenada x a coomprobar.
     * @param ty La coordenada y a coomprobar.
     * @return true si las coordenadas estan incluidas en el espacio del monton,
     * false en caso contrario.
     */
    public boolean include(int tx, int ty) {
        return ((tx > x) && (ty > y) &&
                (tx <= x + Card.WIDTH) && (ty <= y + Card.HEIGHT));
    }

    /**
     * Metodo que pinta el monton de cartas.
     * @param g El contexto grafico sobre el que pinta.
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        if (cards.isEmpty()) {
            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {
            Card card = (Card) cards.peek();
            card.draw(g, x, y);
        }
    }
}

