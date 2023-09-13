package com.irs.swingexamples.signozodiaco;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame de los datos para obtener el signo del zodiaco.
 *
 * @author IRS
 * @version 1.0.0
 */
public class SignoZodiacoFrame extends JFrame {

    private JPanel panelContenedor;
    private JLabel labelDia;
    private JLabel labelMes;
    private JTextField textFieldDia;
    private JTextField textFieldMes;
    private JButton buttonVer;

    /**
     * Contructor. Crea una nueva instancia del JFrame SignoZodiacoFrame
     */
    public SignoZodiacoFrame() {
        super();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedor = new JPanel();
        labelDia = new JLabel();
        labelMes = new JLabel();
        textFieldMes = new JTextField();
        buttonVer = new JButton();
        textFieldDia = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signo del Zodiaco");
        setResizable(false);

        panelContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelContenedor.setLayout(new java.awt.GridBagLayout());

        labelDia.setText("Día de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        panelContenedor.add(labelDia, gridBagConstraints);

        labelMes.setText("Mes de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        panelContenedor.add(labelMes, gridBagConstraints);

        textFieldMes.setColumns(4);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContenedor.add(textFieldMes, gridBagConstraints);

        buttonVer.setText("Ver Signo");
        buttonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContenedor.add(buttonVer, gridBagConstraints);

        textFieldDia.setColumns(4);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContenedor.add(textFieldDia, gridBagConstraints);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void buttonVerActionPerformed(java.awt.event.ActionEvent evt) {
        if (textFieldDia.getText() == null || textFieldDia.getText().trim().length() == 0) {
            showError("Debe introducir un día", "Día Requerido", textFieldDia);
            return;
        }
        if (textFieldMes.getText() == null || textFieldMes.getText().trim().length() == 0) {
            showError("Debe introducir un mes", "Mes Requerido", textFieldMes);
            return;
        }
        if (checkDia() && checkMes()) {
            int dia = Integer.parseInt(textFieldDia.getText());
            int mes = Integer.parseInt(textFieldMes.getText());
            calcularSigno(dia, mes);
        }
    }

    private boolean checkDia() {
        boolean diaOk = true;
        try {
            int dia = Integer.parseInt(textFieldDia.getText());
            if (dia < 0 || dia > 31) {
                diaOk = false;
            }
        } catch (Exception e) {
            diaOk = false;
        }
        if (!diaOk) {
            showError("Ha introducido un día incorrecto", "Día Inválido", textFieldDia);
        }

        return diaOk;
    }

    private boolean checkMes() {
        boolean mesOk = true;
        try {
            int mes = Integer.parseInt(textFieldMes.getText());
            if (mes < 0 || mes > 12) {
                mesOk = false;
            }
        } catch (Exception e) {
            mesOk = false;
        }
        if (!mesOk) {
            showError("Ha introducido un mes incorrecto", "Mes Inválido", textFieldMes);
        }

        return mesOk;
    }

    private void calcularSigno(int dia, int mes) {
        String signo = "";
        int numDays = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            default:
                // Mes de febrero (No importa si el año es bisiesto o no
                numDays = 29;
                break;
        }
        if (dia < 0 || dia > numDays) {
            showError("Ha introducido un dia incorrecto", "Día Inválido", textFieldDia);
            return;
        }
        switch (mes) {
            case 1:
                signo = dia > 21 ? SignoZodiacoEnum.ACUARIO.name() : SignoZodiacoEnum.CAPRICORNIO.name();
                break;
            case 2:
                signo = dia > 19 ? SignoZodiacoEnum.PISCIS.name() : SignoZodiacoEnum.ACUARIO.name();
                break;
            case 3:
                signo = dia > 20 ? SignoZodiacoEnum.ARIES.name() : SignoZodiacoEnum.PISCIS.name();
                break;
            case 4:
                signo = dia > 20 ? SignoZodiacoEnum.TAURO.name() : SignoZodiacoEnum.ARIES.name();
                break;
            case 5:
                signo = dia > 21 ? SignoZodiacoEnum.GEMINIS.name() : SignoZodiacoEnum.TAURO.name();
                break;
            case 6:
                signo = dia > 20 ? SignoZodiacoEnum.CANCER.name() : SignoZodiacoEnum.GEMINIS.name();
                break;
            case 7:
                signo = dia > 22 ? SignoZodiacoEnum.LEO.name() : SignoZodiacoEnum.CANCER.name();
                break;
            case 8:
                signo = dia > 21 ? SignoZodiacoEnum.VIRGO.name() : SignoZodiacoEnum.LEO.name();
                break;
            case 9:
                signo = dia > 22 ? SignoZodiacoEnum.LIBRA.name() : SignoZodiacoEnum.VIRGO.name();
                break;
            case 10:
                signo = dia > 22 ? SignoZodiacoEnum.ESCORPION.name() : SignoZodiacoEnum.LIBRA.name();
                break;
            case 11:
                signo = dia > 21 ? SignoZodiacoEnum.SAGITARIO.name() : SignoZodiacoEnum.ESCORPION.name();
                break;
            case 12:
                signo = dia > 21 ? SignoZodiacoEnum.CAPRICORNIO.name() : SignoZodiacoEnum.SAGITARIO.name();
                break;
        }
        JOptionPane.showMessageDialog(this, "Usted es del signo de " + signo, "Signo Zodiacal", JOptionPane.INFORMATION_MESSAGE);
        textFieldDia.setText("");
        textFieldMes.setText("");
    }

    private void showError(String message, String title, Component component) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
        component.requestFocus();
    }
}
