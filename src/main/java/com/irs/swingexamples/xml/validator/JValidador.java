package com.irs.swingexamples.xml.validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class JValidador extends JFrame {

    private JTabbedPane tabbedpane;
    private JLabel lblXml;
    private JLabel lblXsd;
    private JTextField tfXml;
    private JTextField tfXsd;
    private JButton btnExaminarXml;
    private JButton btnExaminarXsd;
    private JButton btnValidar;
    private JList listErrores;

    static JFileChooser fc = new JFileChooser();
    static Insets INSETS_EMPTY = new Insets(0, 0, 0, 0);
    static Insets INSETS_TEXT = new Insets(0, 0, 5, 5);
    static Insets INSETS_LABEL = new Insets(0, 0, 5, 5);
    static Insets INSETS_BUTTON = new Insets(0, 0, 5, 0);
    //static Font DEFAULT_FONT = new Font("Dialog", Font.PLAIN, 12);
    static Font DEFAULT_FONT = new java.awt.Font("Trebuchet MS", Font.PLAIN, 11);

    private File xmlFile;
    private File xsdFile;

    public JValidador() {
        super("Validador XML");
        xmlFile = null;
        xsdFile = null;
        initComponents();
    }


    private void initComponents() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BorderLayout());
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(DEFAULT_FONT);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitForm();
            }
        });
        panelBotones.add(btnCerrar, BorderLayout.EAST);

        PanelConsola panelConsola = new PanelConsola();
        PanelValidar panelValidar = new PanelValidar(panelConsola);
        PanelTransformar panelTransformar = new PanelTransformar(panelConsola);

        tabbedpane = new JTabbedPane();
        tabbedpane.addTab("Validar", panelValidar);
        tabbedpane.addTab("Transformar", panelTransformar);

        JPanel panelContenedor = new JPanel();
        panelContenedor.setBorder(new EmptyBorder(10,10,10,10));
        panelContenedor.setLayout(new BorderLayout(0, 10));
        panelContenedor.add(tabbedpane, BorderLayout.NORTH);
        panelContenedor.add(panelConsola, BorderLayout.CENTER);
        panelContenedor.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelContenedor);
        pack();
    }


    private void exitForm() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new JValidador().show();
    }
}
