/*
 * Card.java
 *
 * Created on 19 de febrero de 2007
 * Copyright 2007 Ivan Rodriguez. All rights reserved.
 */
package com.irs.swingexamples.solitaire;

import java.awt.*;

/**
 * Clase que representa una carta de una baraja.
 *
 * @author IRS
 * @version	1.0.0, 19/02/2007
 */
public class Card {

    /** Palo de diamantes. */
    public static final int DIAMOND = 1;    // Diamantes
    /** Palo de treboles. */
    public static final int CLUB = 2;       // Treboles
    /** Palo de picas. */
    public static final int SPADE = 3;      // Picas
    /** Palo de corazones. */
    public static final int HEART = 4;      // Corazones

    /** Nombres descriptivos de los palos de la baraja. */
    public static final String[] SUITS = new String[]
            {"hearts", "clubs", "diamonds", "spades"};
    /** Nombres descriptivos de los valores de las cartas. */
    public static final String[] RANKS = new String[]
            {"ace", "2", "3", "4", "5", "6", "7", "8",
                    "9", "10", "jack", "queen", "king"};

    /** Alto de la carta. */
    public static final int HEIGHT = 100;
    /** Ancho de la carta. */
    public static final int WIDTH = 75;

    /** Palo de la carta. */
    private int suit;
    /** Valor de la carta. */
    private int rank;

    /**
     * Constructor.
     * @param suit El palo de la carta.
     * @param rank El valor de la carta.
     */
    public Card(int suit, int rank) {
        this.setSuit(suit);
        this.setRank(rank);
    }

    /**
     * Metodo que devuelve el color de la carta en funcion del palo.
     * @return El color a emplear para pintar.
     */
    public Color color() {
        if (suit == Card.DIAMOND || suit == Card.HEART) {
            return Color.RED;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * Metodo que pinta la carta.
     * @param g El contexto grafico sobre el que pinta.
     * @param x La coordenada x de la carta.
     * @param y La coordenada y de la carta.
     */
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, Card.WIDTH, Card.HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        String bodyRank = RANKS[rank-1];
        String bodySuit = "";
        switch (suit) {
            case Card.HEART:
                bodySuit = SUITS[0];
                break;
            case Card.CLUB:
                bodySuit = SUITS[1];
                break;
            case Card.DIAMOND:
                bodySuit = SUITS[2];
                break;
            case Card.SPADE:
                bodySuit = SUITS[3];
                break;
        }
        g.drawString(bodySuit, x + 2, y + 15);
        g.drawString(bodyRank, x + 10, y + Card.HEIGHT / 2);
    }

    /**
     * Metodo que devuelve el palo de la carta.
     * @return El palo de la carta.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Metodo que establece el palo de la carta.
     * @param suit El palo de la carta.
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    /**
     * Metodo que devuelve el valor de la carta.
     * @return El valor de la carta.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Metodo que establece el valor de la carta.
     * @param rank El valor de la carta.
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
}
