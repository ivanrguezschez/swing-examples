package com.irs.swingexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la caja de dialogo Cerrar.
 *
 * @author IRS
 * @version 1.0.0
 */
public class CloseDialog extends JFrame {

    /**
     * Constructor.
     */
    public CloseDialog() {
        super("Close");
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Panel Contenedor
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(12,12,11,11));

        JButton btnClose = new JButton("Cerrar");
        btnClose.setMnemonic('C');
        btnClose.setActionCommand("Cerrar");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accionCerrar();
            }
        });

        // Añado los controles
        panelContenedor.add(btnClose, BorderLayout.CENTER);
        this.getContentPane().add(panelContenedor);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                accionCerrar();
            }
        });

        setVisible(true);
        setResizable(false);
        pack();
    }

    private void accionCerrar() {
        int confirm = JOptionPane.showOptionDialog(this,
                "¿Desea salir de la aplicación?",
                "Salir",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CloseDialog();
            }
        });
    }
}