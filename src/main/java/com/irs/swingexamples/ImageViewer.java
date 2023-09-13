package com.irs.swingexamples;

import javax.swing.*;

/**
 * Clase que crea muestra una imagen en un panel.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ImageViewer extends JFrame {

    /** Creates a new instance of ImageViewer */
    public ImageViewer() {
        super("Image Viewer");
        ImageIcon ii = new ImageIcon("./src/main/resources/image.jpg");
        JScrollPane sp = new JScrollPane(new JLabel(ii));
        getContentPane().add(sp);
        //setSize(200, 300);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}
