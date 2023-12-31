package com.irs.swingexamples.dial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase de ejemplo que usa el Componente swing JDial.
 *
 * @author IRS
 * @version 1.0.0
 */
public class JDialApp {

    public static void main( String[] args ) {
        JFrame f = new JFrame("JDial App");
        f.setSize(150, 150);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        final JLabel statusLabel = new JLabel("Welcome to Dial v1.0.0");
        final JDial dial = new JDial();

        JPanel dialPanel = new JPanel();
        dialPanel.add(dial);

        f.getContentPane().add(dialPanel, BorderLayout.CENTER);
        f.getContentPane().add(statusLabel, BorderLayout.SOUTH);

        dial.addDialListener(new DialListener() {
            @Override
            public void dialAdjusted(DialEvent e) {
                statusLabel.setText("Value is " + e.getValue());
            }
        });

        f.setVisible(true);
    }
}
