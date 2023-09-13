package com.irs.swingexamples.signozodiaco;

/**
 * Aplicación que introducidos el dia y mes de nacimiento indica el signo del
 * zodiaco.
 *
 * @author IRS
 * @version 1.0.0
 */
public class SignoZodiaco {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignoZodiacoFrame().setVisible(true);
            }
        });
    }
}
