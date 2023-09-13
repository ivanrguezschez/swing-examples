package com.irs.swingexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Plantilla de ventana.
 *
 * @author IRS
 * @version 1.0.0
 */
public class PlantillaJFrame extends javax.swing.JFrame {

    // Panel Contenedor
    JPanel panelContenedor;
    JLabel lblEtiqueta;
    JButton btnBoton;

    public PlantillaJFrame() {
        super("PlantillaJFrame");
        iniciarComponentes();
        centrarVentana(this);
        pack();
    }

    private void iniciarComponentes() {
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                salirAplicacion(evt);
            }
        });

        lblEtiqueta = new JLabel("0", JLabel.CENTER);

        btnBoton = new JButton("Boton");
        btnBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnBoton_actionPerformed(e);
            }
        });

        panelContenedor.add(lblEtiqueta, BorderLayout.CENTER);
        panelContenedor.add(btnBoton, BorderLayout.SOUTH);
        setContentPane(panelContenedor);
    }

    private void btnBoton_actionPerformed(ActionEvent e) {
        int valor = Integer.parseInt(lblEtiqueta.getText());
        valor++;
        lblEtiqueta.setText(Integer.toString(valor));
    }

    public void salirAplicacion(WindowEvent evt) {
        Toolkit.getDefaultToolkit().beep();
        // Muestra dialogo de confirmación
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Quiere Salir?",
                "PlantillaJFrame - Salir",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        // Si la respuesta es afirmativa, maneja la salida
        if (respuesta == JOptionPane.YES_OPTION) {
            this.setVisible(false); // Oculta el JFrame
            this.dispose(); // Libera los recursos del sistema
            System.exit(0); // Cierra la aplicacion
        }
    }

    private void centrarVentana(javax.swing.JFrame f) {
        // Obtengo el tamaño de la pantalla
        Dimension sizePantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtengo el tamaño del Frame
        Dimension sizeFrame = f.getSize();
        if (sizeFrame.width > sizePantalla.width) {
            sizeFrame.width = sizePantalla.width;
        }
        if (sizeFrame.height > sizePantalla.height) {
            sizeFrame.height = sizePantalla.height;
        }
        // Centro la ventana en la pantalla
        this.setLocation((sizePantalla.width - sizeFrame.width) / 2,
                (sizePantalla.height - sizeFrame.height) / 2);
    }

    public static void main(String args[]) {
        /*
	    // Establece el Look and Feel del Sistema Nativo
	    try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
            e.printStackTrace();
	    }
        */
        new PlantillaJFrame().show();
    }
}

