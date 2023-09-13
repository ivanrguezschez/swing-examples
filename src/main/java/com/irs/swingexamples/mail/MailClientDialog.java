package com.irs.swingexamples.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.ConnectionAdapter;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.TransportAdapter;
import javax.mail.event.TransportEvent;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Aplicacion Java Swing para probar el envio de correos electronicos.
 *
 * @author IRS
 * @version	1.0.0
 */
public class MailClientDialog extends javax.swing.JFrame {

    private static final String MAIL_HOST = "jaworski.com";

    private javax.swing.JButton buttonSend;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JLabel labelContent;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelSubject;
    private javax.swing.JLabel labelTo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel panelEmail;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JScrollPane scrollPaneContent;
    private javax.swing.JScrollPane scrollPaneStatus;
    private javax.swing.JTextArea textAreaContent;
    private javax.swing.JTextArea textAreaStatus;
    private javax.swing.JTextField textFieldFrom;
    private javax.swing.JTextField textFieldSubject;
    private javax.swing.JTextField textFieldTo;

    /**
     * Constructor.
     */
    public MailClientDialog() {
        super();
        initComponents();
    }

    private void initComponents() {
        panelEmail = new javax.swing.JPanel();
        labelTo = new javax.swing.JLabel();
        labelFrom = new javax.swing.JLabel();
        labelSubject = new javax.swing.JLabel();
        labelContent = new javax.swing.JLabel();
        textFieldTo = new javax.swing.JTextField();
        buttonSend = new javax.swing.JButton();
        textFieldFrom = new javax.swing.JTextField();
        textFieldSubject = new javax.swing.JTextField();
        scrollPaneContent = new javax.swing.JScrollPane();
        textAreaContent = new javax.swing.JTextArea();
        panelStatus = new javax.swing.JPanel();
        scrollPaneStatus = new javax.swing.JScrollPane();
        textAreaStatus = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileExit = new javax.swing.JMenuItem();

        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("mailclient");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(rb.getString("main.title"));
        setResizable(false);

        panelEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(rb.getString("email.title")));

        labelTo.setText(rb.getString("to.label"));

        labelFrom.setText(rb.getString("from.label"));

        labelSubject.setText(rb.getString("subject.label"));

        labelContent.setText(rb.getString("content.label"));

        textFieldTo.setNextFocusableComponent(textFieldFrom);

        buttonSend.setText(rb.getString("button.send"));
        buttonSend.setLabel(rb.getString("button.send"));
        buttonSend.setNextFocusableComponent(textAreaStatus);
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        textAreaContent.setColumns(20);
        textAreaContent.setRows(5);
        textAreaContent.setNextFocusableComponent(buttonSend);
        scrollPaneContent.setViewportView(textAreaContent);

        javax.swing.GroupLayout panelEmailLayout = new javax.swing.GroupLayout(panelEmail);
        panelEmail.setLayout(panelEmailLayout);
        panelEmailLayout.setHorizontalGroup(
                panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelEmailLayout.createSequentialGroup()
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelEmailLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelTo)
                                                        .addComponent(labelFrom)))
                                        .addGroup(panelEmailLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(labelSubject))
                                        .addGroup(panelEmailLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(labelContent)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelEmailLayout.createSequentialGroup()
                                                .addComponent(textFieldTo, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(buttonSend)))
                                .addContainerGap())
        );

        panelEmailLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] {scrollPaneContent, textFieldFrom, textFieldSubject, textFieldTo});

        panelEmailLayout.setVerticalGroup(
                panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelEmailLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTo)
                                        .addComponent(textFieldTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonSend))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelFrom)
                                        .addComponent(textFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSubject)
                                        .addComponent(textFieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelContent)
                                        .addComponent(scrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(rb.getString("status.title")));
        textAreaStatus.setColumns(20);
        textAreaStatus.setRows(5);
        scrollPaneStatus.setViewportView(textAreaStatus);

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
                panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelStatusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPaneStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelStatusLayout.setVerticalGroup(
                panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelStatusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPaneStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuFile.setText(rb.getString("menu.file"));
        fileExit.setText(rb.getString("menu.file.exit"));

        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });

        menuFile.add(fileExit);

        menuBar.add(menuFile);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {panelEmail, panelStatus});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
    }

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {
        sendMessage();
    }

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void sendMessage() {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", MAIL_HOST);
        propiedades.put("mail.from", textFieldFrom.getText());
        Session sesion = Session.getInstance(propiedades, null);
        try {
            Message mensaje = new MimeMessage(sesion);
            InternetAddress[] direcciones = {new InternetAddress(textFieldTo.getText())};
            mensaje.setRecipients(Message.RecipientType.TO, direcciones);
            mensaje.setFrom(new InternetAddress(textFieldFrom.getText()));
            mensaje.setSubject(textFieldSubject.getText());
            mensaje.setContent(textAreaContent.getText(), "text/plain");
            Transport transporte = sesion.getTransport(direcciones[0]);
            transporte.addConnectionListener(new ConnectionHandler());
            transporte.addTransportListener(new TransportHandler());
            transporte.connect();
            transporte.sendMessage(mensaje, direcciones);
        } catch(Exception e) {
            textAreaStatus.setText(e.toString());
        }
    }

    /*
     * Clase para el manejo de los eventos de conexion.
     */
    class ConnectionHandler extends ConnectionAdapter {
        public void opened(ConnectionEvent e) {
            textAreaStatus.setText("Connection opened.");
        }
        public void disconnected(ConnectionEvent e) {
            textAreaStatus.setText("Connection disconnected.");
        }
        public void closed(ConnectionEvent e) {
            textAreaStatus.setText("Connection closed.");
        }
    }

    /*
     * Clase para el manejo de los eventos de transpotte.
     */
    class TransportHandler extends TransportAdapter {
        public void messageDelivered(TransportEvent e) {
            textAreaStatus.setText("Message delivered.");
        }
        public void messageNotDelivered(TransportEvent e) {
            textAreaStatus.setText("Message NOT delivered.");
        }
        public void messagePartiallyDelivered(TransportEvent e) {
            textAreaStatus.setText("Message partially delivered.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailClientDialog().setVisible(true);
            }
        });
    }
}
