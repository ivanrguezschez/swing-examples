package com.irs.swingexamples;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la caja de dialogo Login.
 *
 * @author IRS
 * @version 1.0.0
 */
public class LoginDialog extends javax.swing.JDialog {

    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JCheckBox checkBoxPassword;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JTextField textFieldUsuario;

    /**
     * Constructor.
     */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedor = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        textFieldUsuario = new javax.swing.JTextField();
        checkBoxPassword = new javax.swing.JCheckBox();
        buttonLogin = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        passwordFieldPassword = new javax.swing.JPasswordField();

        // Oculta el diálogo de Login pero no cierra el JFrame que lo contiene
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //Cierra el JFrame que lo contiene
                ((javax.swing.JFrame) getParent()).dispose();
                System.exit(0);
            }
        });

        panelContenedor.setLayout(new java.awt.GridBagLayout());

        panelContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 11, 11));
        labelUsuario.setDisplayedMnemonic('U');
        labelUsuario.setLabelFor(textFieldUsuario);
        labelUsuario.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelUsuario, gridBagConstraints);

        labelPassword.setDisplayedMnemonic('o');
        labelPassword.setLabelFor(passwordFieldPassword);
        labelPassword.setText("Contrase\u00f1a:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelContenedor.add(labelPassword, gridBagConstraints);

        textFieldUsuario.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(textFieldUsuario, gridBagConstraints);

        checkBoxPassword.setMnemonic('R');
        checkBoxPassword.setText("Recordar mi Contrase\u00f1a");
        checkBoxPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkBoxPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContenedor.add(checkBoxPassword, gridBagConstraints);

        buttonLogin.setMnemonic('L');
        buttonLogin.setText("Log in");
        buttonLogin.setActionCommand("Login");
        getRootPane().setDefaultButton(buttonLogin);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelContenedor.add(buttonLogin, gridBagConstraints);

        buttonCancelar.setMnemonic('C');
        buttonCancelar.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        panelContenedor.add(buttonCancelar, gridBagConstraints);

        passwordFieldPassword.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContenedor.add(passwordFieldPassword, gridBagConstraints);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
}
