/*
 * Frog.java
 *
 * Created on 19 de febrero de 2007
 * Copyright 2007 Ivan Rodriguez. All rights reserved.
 */
package com.irs.swingexamples.solitaire;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase principal del Solitario de la Rana.
 *
 * @author IRS
 * @version	1.0.0, 19/02/2007
 */
public class Frog extends javax.swing.JFrame {

    /** Baraja de cartas. */
    private CardPile deck;
    /** Baraja de cartas sobrantes. */
    private CardPile stock;
    /** Baraja de cartas base. */
    private CardPile[] foundation;
    /** Baraja de cartas gastadas o empleadas. */
    private CardPile[] waste;

    /**
     * Constructor
     */
    public Frog() {
        super("Solitaire Frog");

        // Inicializacion del Frame
        setSize(500, 300);
        addMouseListener(new MouseKeeper());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Inicializacion de la aplicacion
        deck = new CardPile(20, 175);
        // Añadimos las cartas a la baraja
        List<Card> list = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            list.add(new Card(Card.HEART, i));
            list.add(new Card(Card.CLUB, i));
            list.add(new Card(Card.DIAMOND, i));
            list.add(new Card(Card.SPADE, i));
        }
        // Barajamos las cartas
        Collections.shuffle(list);
        for (Card c : list) {
            deck.addCard(c);
        }

        // Creamos las pila de stock
        stock = new CardPile(20, 40);
        for (int i = 1; i <= 13; i++) {
            stock.addCard(deck.topCard());
        }

        // Creamos las otras pilas
        foundation = new CardPile[4];
        waste = new CardPile[4];
        for (int i = 0; i < 4; i++) {
            foundation[i] = new FoundationPile(115 + 85 * i, 40);
            waste[i] = new WastePile(115 + 85 * i, 175);
        }
    }

    /**
     * Pinta los diversos tacos de cartas y sus valores.
     * @param g El contexto grafico sobre el que pinta.
     */
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 500, 300);
        g.setColor(Color.BLACK);

        deck.draw(g);
        stock.draw(g);
        for (int i = 0; i < 4; i++) {
            foundation[i].draw(g);
            waste[i].draw(g);
        }
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.setVisible(true);
    }


    /*
     * Clase para el tratamiento de los eventos del raton sobre las cartas.
     */
    private class MouseKeeper extends MouseAdapter {
        CardPile sourceDeck = null;

        public void mousePressed(MouseEvent e) {
            sourceDeck = findDeck(e.getX(), e.getY());
        }

        public void mouseReleased(MouseEvent e) {
            if (sourceDeck == null || sourceDeck.isEmpty()) {
                return;
            }

            CardPile toDeck = findDeck(e.getX(), e.getY());
            if (toDeck == null) {
                return;
            }
            Card playCard = sourceDeck.topCard();
            if (playCard == null) {
                return;
            }
            if (toDeck.canTake(playCard)) {
                toDeck.addCard(playCard);
            } else {
                sourceDeck.addCard(playCard);
            }
            repaint();
        }
    }


    /**
     * Busca unas coordenadas (x,y) en una baraja.
     * @param x La coordenada x del tablero.
     * @param y La coordenada y del tablero.
     * @return El monton de cartas.
     */
    public CardPile findDeck(int x, int y) {
        if (deck.include(x, y)) {
            return deck;
        }
        if (stock.include(x, y)) {
            return stock;
        }
        for (int i = 0; i < 4; i++) {
            if (foundation[i].include(x, y)) {
                return foundation[i];
            }
            if (waste[i].include(x, y)) {
                return waste[i];
            }
        }

        // No hat ninguna baraja valida
        return null;
    }
}
