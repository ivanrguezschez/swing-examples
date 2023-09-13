package com.irs.swingexamples.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Clase de utilidad para el tratamiento y manipulacion de frames y swing.
 *
 * @author IRS
 * @version 1.0.0, 27/02/2007
 */
public final class SwingUtil {

    /** Crea una nueva instancia de SwingUtil */
    private SwingUtil() {
    }

    public static void center(JFrame frame) {
        // center on display
        Dimension display = frame.getToolkit().getScreenSize();
        Dimension bounds = frame.getSize();

        int x = (display.width - bounds.width) / 2;
        int y = (display.height - bounds.height) / 2;
        if (x < 0) {
            x = 10;
        }
        if (y < 0) {
            y = 15;
        }
        frame.setLocation(x, y);
    }

    public static void exitDialog(JFrame frame) {
        int response = 0;
        Toolkit.getDefaultToolkit().beep();
        // Muestra un dialogo de confirmacion
        response = JOptionPane.showConfirmDialog(frame,
                "¿Desea realmente salir?", "Salir",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            frame.setVisible(false); // Oculta el Frame
            frame.dispose(); // Libera los recursos del sistema
            System.exit(0); // Cierra la aplicacion
        }
    }
}
