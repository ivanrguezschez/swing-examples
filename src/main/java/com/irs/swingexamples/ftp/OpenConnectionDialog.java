package com.irs.swingexamples.ftp;

import com.irs.swingexamples.mail.MailClientDialog;

import javax.swing.*;

/**
 * Aplicacion Java Swing para conectarse a un servidor FTP.
 *
 * @author IRS
 * @version	1.0.0
 */
public class OpenConnectionDialog extends javax.swing.JDialog {

    private JFtp jftp;

    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConnect;
    private javax.swing.JLabel labelHostname;
    private javax.swing.JLabel labelLocalDir;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelRemoteDir;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField textFieldHostname;
    private javax.swing.JTextField textFieldLocalDir;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldRemoteDir;
    private javax.swing.JTextField textFieldUsername;

    public OpenConnectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.jftp = (JFtp) parent;
        initComponents();
    }

    private void initComponents() {
        labelHostname = new javax.swing.JLabel();
        textFieldHostname = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JTextField();
        labelLocalDir = new javax.swing.JLabel();
        textFieldLocalDir = new javax.swing.JTextField();
        labelRemoteDir = new javax.swing.JLabel();
        textFieldRemoteDir = new javax.swing.JTextField();
        buttonCancel = new javax.swing.JButton();
        buttonConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open Connection");
        labelHostname.setText("Host Name:");

        labelUsername.setText("User Name:");

        labelPassword.setText("Password:");

        labelLocalDir.setText("Local Directory:");

        labelRemoteDir.setText("Remote Directory:");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonConnect.setText("Connect");
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelHostname)
                                        .addComponent(labelUsername)
                                        .addComponent(labelPassword)
                                        .addComponent(labelLocalDir)
                                        .addComponent(labelRemoteDir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldRemoteDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldLocalDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(buttonConnect)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(buttonCancel))
                                                .addComponent(textFieldHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] {textFieldHostname, textFieldLocalDir, textFieldPassword, textFieldRemoteDir, textFieldUsername});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelHostname)
                                        .addComponent(textFieldHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUsername)
                                        .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPassword)
                                        .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelLocalDir)
                                        .addComponent(textFieldLocalDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelRemoteDir)
                                        .addComponent(textFieldRemoteDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonCancel)
                                        .addComponent(buttonConnect))
                                .addContainerGap())
        );
        pack();
    }

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {
        if( !((textFieldHostname.getText()).equals("") ||
                (textFieldUsername.getText()).equals("") ||
                (textFieldPassword.getText()).equals("") )) {
            jftp.hostname = textFieldHostname.getText();
            jftp.username = textFieldUsername.getText();
            jftp.password = textFieldPassword.getText();
            if(!(textFieldLocalDir.getText()).equals("")) {
                jftp.local_dir = textFieldLocalDir.getText();
            }
            if(!(textFieldRemoteDir.getText()).equals("")) {
                jftp.remote_dir = textFieldRemoteDir.getText();
            }

            jftp.open_connection();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, rellene los datos solicitados", "Fields empty", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
}
