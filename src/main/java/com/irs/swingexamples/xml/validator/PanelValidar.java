package com.irs.swingexamples.xml.validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

public class PanelValidar extends JPanel {

    private JLabel lblXml;
    private JLabel lblXsd;

    private JTextField tfXml;
    private JTextField tfXsd;

    private JButton btnExaminarXml;
    private JButton btnExaminarXsd;
    private JButton btnValidar;

    private File xmlFile;
    private File xsdFile;

    private PanelConsola consola;

    static JFileChooser fc = new JFileChooser();
    static Insets INSETS_EMPTY = new Insets(0, 0, 0, 0);
    static Insets INSETS_TEXT = new Insets(0, 0, 5, 5);
    static Insets INSETS_LABEL = new Insets(0, 0, 5, 5);
    static Insets INSETS_BUTTON = new Insets(0, 0, 5, 0);
    //static Font DEFAULT_FONT = new Font("Dialog", Font.PLAIN, 12);
    static Font DEFAULT_FONT = new java.awt.Font("Trebuchet MS", Font.PLAIN, 11);

    public PanelValidar(PanelConsola consola) {
        super();
        this.consola = consola;
        xmlFile = null;
        xsdFile = null;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(10,10,10,10));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        lblXml = new JLabel("Fichero XML");
        lblXml.setFont(DEFAULT_FONT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = INSETS_LABEL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(lblXml, gridBagConstraints);

        tfXml = new JTextField(30);
        tfXml.setEditable(false);
        tfXml.setBackground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = INSETS_TEXT;
        add(tfXml, gridBagConstraints);

        btnExaminarXml = new JButton(new ImageIcon("./src/main/resources/Open24.gif"));
        btnExaminarXml.setActionCommand("xml");
        btnExaminarXml.setMargin(INSETS_EMPTY);
        btnExaminarXml.setFont(DEFAULT_FONT);
        btnExaminarXml.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedExaminar(e);
            }
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = INSETS_BUTTON;
        add(btnExaminarXml, gridBagConstraints);

        lblXsd = new JLabel("Fichero XSD");
        lblXsd.setFont(DEFAULT_FONT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_LABEL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(lblXsd, gridBagConstraints);

        tfXsd = new JTextField(30);
        tfXsd.setEditable(false);
        tfXsd.setBackground(Color.WHITE);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_TEXT;
        add(tfXsd, gridBagConstraints);

        btnExaminarXsd = new JButton(new ImageIcon("./src/main/resources/Open24.gif"));
        btnExaminarXsd.setActionCommand("xsd");
        btnExaminarXsd.setMargin(INSETS_EMPTY);
        btnExaminarXsd.setFont(DEFAULT_FONT);
        btnExaminarXsd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedExaminar(e);
            }
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_BUTTON;
        add(btnExaminarXsd, gridBagConstraints);

        btnValidar = new JButton("Validar");
        btnValidar.setEnabled(false);
        btnValidar.setFont(DEFAULT_FONT);
        btnValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XmlSchemaValidator validator = new XmlSchemaValidator(XmlSchemaValidator.SCHEMA_LOCAL);
                validator.validate(xmlFile.getAbsolutePath(), xsdFile.getAbsolutePath());
                DefaultListModel model = new DefaultListModel();
                if (validator.isValid()) {
                    model.addElement("Documento XML valido");
                } else {
                    model.addElement("Documento XML no valido");
                    for (Iterator it = validator.getErrors().iterator(); it.hasNext(); ) {
                        model.addElement(it.next());
                    }
                    validator.showErrors();
                }
                consola.getListErrores().setModel(model);
                consola.updateUI();
            }
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        add(btnValidar, gridBagConstraints);
    }



    private void actionPerformedExaminar(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        XMLFilter filter;
        int returnValue;
        if (source.getActionCommand().equals("xml")) {
            filter = new XMLFilter(XMLFilter.XML);
            fc.setFileFilter(filter);
            returnValue = fc.showOpenDialog(PanelValidar.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                xmlFile = fc.getSelectedFile();
                tfXml.setText(xmlFile.getAbsolutePath());
            }
        } else if (source.getActionCommand().equals("xsd")) {
            filter = new XMLFilter(XMLFilter.XSD);
            fc.setFileFilter(filter);
            returnValue = fc.showOpenDialog(PanelValidar.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                xsdFile = fc.getSelectedFile();
                tfXsd.setText(xsdFile.getAbsolutePath());
            }
        }
        if (!tfXml.getText().equals("") && !tfXsd.getText().equals("")) {
            btnValidar.setEnabled(true);
        }
    }
}

