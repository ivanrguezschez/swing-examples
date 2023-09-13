package com.irs.swingexamples.models.indicadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicación JFrame de prueba del modelo de lista de indicadores con el filtro de tipo de indicador.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class IndicadorFrameApp extends JFrame implements ActionListener {

    IndicadorListModel modelTipoIndicador = new IndicadorListModel();
    JComboBox tipoIndicadorCombo = new JComboBox(modelTipoIndicador.getTipoIndicador());
    JList indicadorList = new JList();
    IndicadorListModel model = new IndicadorListModel();
    IndicadorListModelFilter exclusionFilter = new IndicadorListModelFilter(model);

    public static void main(String[] args) {
        new IndicadorFrameApp().setVisible(true);
    }

    public IndicadorFrameApp() {
        super("Indicadores");
        this.setSize(400, 200);
        this.setLocation(150, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pContenedor =new JPanel();
        pContenedor.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(12, 12, 11, 11)));
        pContenedor.setLayout(new BorderLayout(0, 5));
        // Add the combo box
        pContenedor.add(tipoIndicadorCombo, BorderLayout.NORTH);
        tipoIndicadorCombo.setFont(new java.awt.Font("MS Sans Serif", 0, 10));
        tipoIndicadorCombo.addActionListener(this);
        // Add the list in a scroll pane and set the
        // model of the list to be the exclusion filter
        indicadorList.setFont(new Font("MS Sans Seri", 0, 10));
        pContenedor.add(new JScrollPane(indicadorList), BorderLayout.CENTER);
        indicadorList.setModel(exclusionFilter);
        actionPerformed(null);

        JPanel pBotones = new JPanel();
        pBotones.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 0, 0, 0)));
        pBotones.setLayout(new BoxLayout(pBotones, BoxLayout.X_AXIS));
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new java.awt.Font("MS Sans Serif", 0, 10));
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new java.awt.Font("MS Sans Serif", 0, 10));

        pBotones.add(Box.createHorizontalGlue());
        pBotones.add(btnAceptar);
        pBotones.add(Box.createRigidArea(new Dimension(10, 0)));
        pBotones.add(btnCancelar);
        pContenedor.add(pBotones, BorderLayout.SOUTH);

        this.setContentPane(pContenedor);
    }

    public void actionPerformed(ActionEvent event) {
        // Get the new salesperson from the combo box and
        // set the value into the filter
        String i = (String) tipoIndicadorCombo.getSelectedItem();
        int tipoIndicador = modelTipoIndicador.getId(i);
        exclusionFilter.setIndicadores(tipoIndicador);
        indicadorList.updateUI();
    }
}
