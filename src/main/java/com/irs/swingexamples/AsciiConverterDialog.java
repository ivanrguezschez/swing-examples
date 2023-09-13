package com.irs.swingexamples;

/**
 * Clase que muestra una caja de diálogo para convertir caracteres a su valor ascii.
 *
 * @author IRS
 * @version 1.0.0
 */
public class AsciiConverterDialog extends javax.swing.JDialog {

    private javax.swing.JButton buttonCerrar;
    private javax.swing.JLabel labelBinario;
    private javax.swing.JLabel labelCaracter;
    private javax.swing.JLabel labelDecimal;
    private javax.swing.JLabel labelHexadecimal;
    private javax.swing.JLabel labelOctal;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTextField textFieldBinario;
    private javax.swing.JTextField textFieldCaracter;
    private javax.swing.JTextField textFieldDecimal;
    private javax.swing.JTextField textFieldHexadecimal;
    private javax.swing.JTextField textFieldOctal;

    /** Creates new form AsciiConverterDialog */
    public AsciiConverterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedor = new javax.swing.JPanel();
        labelCaracter = new javax.swing.JLabel();
        labelDecimal = new javax.swing.JLabel();
        labelBinario = new javax.swing.JLabel();
        labelOctal = new javax.swing.JLabel();
        labelHexadecimal = new javax.swing.JLabel();
        textFieldCaracter = new javax.swing.JTextField();
        textFieldDecimal = new javax.swing.JTextField();
        textFieldBinario = new javax.swing.JTextField();
        textFieldOctal = new javax.swing.JTextField();
        textFieldHexadecimal = new javax.swing.JTextField();
        buttonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ASCII Converter");
        panelContenedor.setLayout(new java.awt.GridBagLayout());

        panelContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 11, 11));
        labelCaracter.setText("Caracter ASCII:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelCaracter, gridBagConstraints);

        labelDecimal.setText("Valor Decimal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelDecimal, gridBagConstraints);

        labelBinario.setText("Valor Binario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelBinario, gridBagConstraints);

        labelOctal.setText("Valor Octal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelOctal, gridBagConstraints);

        labelHexadecimal.setText("Valor Hexadecimal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelHexadecimal, gridBagConstraints);

        textFieldCaracter.setColumns(10);
        textFieldCaracter.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textFieldCaracterCaretUpdate(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldCaracter, gridBagConstraints);

        textFieldDecimal.setColumns(10);
        textFieldDecimal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldDecimal, gridBagConstraints);

        textFieldBinario.setColumns(10);
        textFieldBinario.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldBinario, gridBagConstraints);

        textFieldOctal.setColumns(10);
        textFieldOctal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldOctal, gridBagConstraints);

        textFieldHexadecimal.setColumns(10);
        textFieldHexadecimal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldHexadecimal, gridBagConstraints);

        buttonCerrar.setText("Cerrar");
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelContenedor.add(buttonCerrar, gridBagConstraints);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void textFieldCaracterCaretUpdate(javax.swing.event.CaretEvent evt) {
        if (textFieldCaracter.getText().length() <= 0) {
            cleanAll();
        } else {
            updateValue();
        }
    }

    private void updateValue() {
        String value = textFieldCaracter.getText();
        char car = value.charAt(value.length() - 1);
        if (value.length() > 1) {
            if (value.charAt(value.length() - 2) == '\\') {
                if (car == 't') {
                    car = '\t';
                } else if (car == 'n') {
                    car = '\n';
                } else if (car == 'r') {
                    car = '\r';
                }
            }
        }
        textFieldDecimal.setText(String.valueOf((int) car));
        textFieldBinario.setText(Integer.toBinaryString((int) car));
        textFieldOctal.setText(Integer.toOctalString((int) car));
        textFieldHexadecimal.setText(Integer.toHexString((int) car).toUpperCase());
    }

    private void cleanAll() {
        textFieldDecimal.setText("");
        textFieldBinario.setText("");
        textFieldOctal.setText("");
        textFieldHexadecimal.setText("");
    }

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsciiConverterDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
}
