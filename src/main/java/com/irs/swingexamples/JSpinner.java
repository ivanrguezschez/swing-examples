package com.irs.swingexamples;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que crea un componente JSpinner.
 *
 * @author IRS
 * @version 1.0.0
 */
public class JSpinner extends JPanel implements ActionListener {
    private int orientacion = SwingConstants.VERTICAL;
    private BasicArrowButton btnIncrementar;
    private BasicArrowButton btnDecrementar;
    private JTextField tfValor;

    public JSpinner() {
        crearComponentes();
    }

    public JSpinner(int orientacion) {
        this.orientacion = orientacion;
        crearComponentes();
    }

    public void setEnabled(boolean enable) {
        btnIncrementar.setEnabled(enable);
        btnDecrementar.setEnabled(enable);
        tfValor.setEnabled(enable);
    }

    public boolean isEnabled() {
        return (btnIncrementar.isEnabled() &&
                btnDecrementar.isEnabled() &&
                tfValor.isEnabled());
    }

    protected void crearComponentes() {
        tfValor = new JTextField();
        tfValor.setEditable(false);
        tfValor.setBackground(Color.white);

        tfValor.setText("1");
        JPanel panelBtn = new JPanel();
        setLayout(new BorderLayout());
        add(tfValor, BorderLayout.CENTER);

        if (orientacion == SwingConstants.VERTICAL) {
            panelBtn.setLayout(new GridLayout(2, 1));
            btnIncrementar = new BasicArrowButton(SwingConstants.NORTH);
            btnDecrementar = new BasicArrowButton(SwingConstants.SOUTH);

            btnIncrementar.setPreferredSize(new Dimension(10,7));
            btnDecrementar.setPreferredSize(new Dimension(10,7));

            panelBtn.add(btnIncrementar);
            panelBtn.add(btnDecrementar);

            add(panelBtn, BorderLayout.EAST);
        } else if (orientacion == SwingConstants.HORIZONTAL) {
            panelBtn.setLayout(new GridLayout(1, 2));
            btnIncrementar = new BasicArrowButton(SwingConstants.EAST);
            btnDecrementar = new BasicArrowButton(SwingConstants.WEST);
            panelBtn.add(btnDecrementar);
            panelBtn.add(btnIncrementar);

            add(panelBtn, BorderLayout.NORTH);
        }
        btnIncrementar.addActionListener(this);
        btnDecrementar.addActionListener(this);
    }

    public JButton getIncrementButton() {
        return (btnIncrementar);
    }

    public JButton getDecrementButton() {
        return (btnDecrementar);
    }

    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();
        int i = Integer.parseInt(tfValor.getText());
        if (origen == getIncrementButton()) {
            i++;
        }
        if (origen == getDecrementButton()) {
            i--;
        }

        tfValor.setText(Integer.toString(i));
    }

    public static void main(String[] args) {
        JFrame vPpal = new JFrame("Spinner");
        vPpal.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        vPpal.setContentPane(new JSpinner());
        //setContentPane(panelContenedor);

        Dimension d_pantalla = vPpal.getToolkit().getScreenSize();
        // Centro la ventana en la pantalla
        vPpal.setLocation((d_pantalla.width - vPpal.getWidth())/2,
                (d_pantalla.height - vPpal.getHeight())/2);
        vPpal.pack();
        vPpal.show();
    }
}
