package com.irs.swingexamples;

import com.irs.swingexamples.utils.SwingUtil;

/**
 * Aplicacion para el tratamiento de los operadores de bits de java.
 *
 * @author IRS
 * @version	1.0.0
 */
public class BitShift extends javax.swing.JFrame {

    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;

    /**
     * Constructor.
     */
    public BitShift() {
        super("BitShift");
        initComponents();
        SwingUtil.center(this);
    }

    private void initComponents() {
        panelContenedor = new javax.swing.JPanel();
        panelContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        panelContenedor.setLayout(new java.awt.BorderLayout());

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel1.setText("N\u00fameros a Cambiar");
        jPanel1.add(jLabel1);

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1);

        jLabel2.setText("Versi\u00f3n Binaria");
        jPanel1.add(jLabel2);

        jTextField2.setText("jTextField2");
        jPanel1.add(jTextField2);

        jLabel3.setText("Versi\u00f3n Cambiada");
        jPanel1.add(jLabel3);

        jTextField3.setText("jTextField3");
        jPanel1.add(jTextField3);

        jLabel4.setText("Versi\u00f3n Decimal Cambiada");
        jPanel1.add(jLabel4);

        jTextField4.setText("jTextField4");
        jPanel1.add(jTextField4);

        //getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        panelContenedor.add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel5.setText("Numero de Lugares");
        jPanel2.add(jLabel5);

        jTextField5.setText("jTextField5");
        jPanel2.add(jTextField5);

        jButton1.setText(">>>");
        jPanel2.add(jButton1);

        jButton2.setText(">>");
        jPanel2.add(jButton2);

        jButton3.setText("<<");
        jPanel2.add(jButton3);

        //getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);
        panelContenedor.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BitShift().setVisible(true);
            }
        });
    }
}
