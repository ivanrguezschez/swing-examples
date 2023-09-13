package com.irs.swingexamples.xml.validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

public class PanelTransformar extends JPanel {

    private JLabel lblXml;
    private JLabel lblXsl;
    private JLabel lblOutType;
    private JLabel lblOut;

    private JTextField tfXml;
    private JTextField tfXsl;
    private JTextField tfOut;

    private JButton btnExaminarXml;
    private JButton btnExaminarXsl;
    private JButton btnExaminarOut;
    private JButton btnTransformar;

    private JComboBox listTipoSalida;

    private File xmlFile;
    private File xslFile;
    private File outFile;

    private PanelConsola consola;

    static JFileChooser fc = new JFileChooser();
    static Insets INSETS_EMPTY = new Insets(0, 0, 0, 0);
    static Insets INSETS_TEXT = new Insets(0, 0, 5, 5);
    static Insets INSETS_LABEL = new Insets(0, 0, 5, 5);
    static Insets INSETS_BUTTON = new Insets(0, 0, 5, 0);
    //static Font DEFAULT_FONT = new Font("Dialog", Font.PLAIN, 12);
    static Font DEFAULT_FONT = new java.awt.Font("Trebuchet MS", Font.PLAIN, 11);

    public PanelTransformar(PanelConsola consola) {
        super();
        this.consola = consola;
        xmlFile = null;
        xslFile = null;
        outFile = null;
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


        lblXsl = new JLabel("Fichero XSLT");
        lblXsl.setFont(DEFAULT_FONT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_LABEL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(lblXsl, gridBagConstraints);

        tfXsl = new JTextField(30);
        tfXsl.setEditable(false);
        tfXsl.setBackground(Color.WHITE);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_TEXT;
        add(tfXsl, gridBagConstraints);

        btnExaminarXsl = new JButton(new ImageIcon("./src/main/resources/Open24.gif"));
        btnExaminarXsl.setActionCommand("xsl");
        btnExaminarXsl.setMargin(INSETS_EMPTY);
        btnExaminarXsl.setFont(DEFAULT_FONT);
        btnExaminarXsl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedExaminar(e);
            }
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = INSETS_BUTTON;
        add(btnExaminarXsl, gridBagConstraints);


        lblOutType = new JLabel("Tipo de Salida");
        lblOutType.setFont(DEFAULT_FONT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = INSETS_LABEL;
        //gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(lblOutType, gridBagConstraints);

        String[] data = {"html", "pdf"};
        listTipoSalida = new JComboBox(data);
        listTipoSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String outName = outFile.getAbsolutePath().substring(0, outFile.getAbsolutePath().lastIndexOf('.')+1) + (String)listTipoSalida.getSelectedItem();
                outFile = new File(outName);
                tfOut.setText(outFile.getAbsolutePath());
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = INSETS_TEXT;
        add(listTipoSalida, gridBagConstraints);


        lblOut = new JLabel("Fichero de Salida");
        lblOut.setFont(DEFAULT_FONT);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = INSETS_LABEL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(lblOut, gridBagConstraints);

        tfOut = new JTextField(30);
        tfOut.setEditable(false);
        tfOut.setBackground(Color.WHITE);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = INSETS_TEXT;
        add(tfOut, gridBagConstraints);

        btnExaminarOut = new JButton(new ImageIcon("./src/main/resources/Open24.gif"));
        btnExaminarOut.setEnabled(false);
        btnExaminarOut.setActionCommand("out");
        btnExaminarOut.setMargin(INSETS_EMPTY);
        btnExaminarOut.setFont(DEFAULT_FONT);
        btnExaminarOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedExaminar(e);
            }
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = INSETS_BUTTON;
        add(btnExaminarOut, gridBagConstraints);


        btnTransformar = new JButton("Transformar");
        btnTransformar.setEnabled(false);
        btnTransformar.setFont(DEFAULT_FONT);
        btnTransformar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XsltTransformer transformer = null;
                String tipoSalida = (String)listTipoSalida.getSelectedItem();
                if (tipoSalida.equals(XMLFilter.HTML)) {
                    transformer = XsltTransformerFactory.getXsltTransformer(XsltTransformerFactory.TRANSFORMADOR_HTML);
                } else {
                    transformer = XsltTransformerFactory.getXsltTransformer(XsltTransformerFactory.TRANSFORMADOR_PDF);
                }
                transformer.transformar(xmlFile.getAbsolutePath(), xslFile.getAbsolutePath(), outFile.getAbsolutePath());
                DefaultListModel model = new DefaultListModel();
                if (transformer.isValid()) {
                    model.addElement("Transformacion realizada correctamente");
                } else {
                    model.addElement("Transformacion realizada incorrectamente");
                    for (Iterator it = transformer.getErrors().iterator(); it.hasNext(); ) {
                        model.addElement(it.next());
                    }
                    transformer.showErrors();
                }
                consola.getListErrores().setModel(model);
                consola.updateUI();
            }
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.EAST;

        add(btnTransformar, gridBagConstraints);
    }


    private void actionPerformedExaminar(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        XMLFilter filter;
        int returnValue;
        if (source.getActionCommand().equals("xml")) {
            filter = new XMLFilter(XMLFilter.XML);
            fc.setFileFilter(filter);
            returnValue = fc.showOpenDialog(PanelTransformar.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                xmlFile = fc.getSelectedFile();
                tfXml.setText(xmlFile.getAbsolutePath());

                String outName = xmlFile.getAbsolutePath().substring(0, xmlFile.getAbsolutePath().lastIndexOf('.')+1) + (String)listTipoSalida.getSelectedItem();
                outFile = new File(outName);
                tfOut.setText(outFile.getAbsolutePath());
            }
        } else if (source.getActionCommand().equals("xsl")) {
            filter = new XMLFilter(XMLFilter.XSLT);
            fc.setFileFilter(filter);
            returnValue = fc.showOpenDialog(PanelTransformar.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                xslFile = fc.getSelectedFile();
                tfXsl.setText(xslFile.getAbsolutePath());
            }
        } else if (source.getActionCommand().equals("out")) {
            String tipoSalida = (String)listTipoSalida.getSelectedItem();
            if (tipoSalida.equals(XMLFilter.HTML)) {
                filter = new XMLFilter(XMLFilter.HTML);
            } else {
                filter = new XMLFilter(XMLFilter.PDF);
            }
            fc.setFileFilter(filter);
            returnValue = fc.showOpenDialog(PanelTransformar.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                outFile = fc.getSelectedFile();
                tfOut.setText(outFile.getAbsolutePath());
            }
        }
        if (!tfXml.getText().equals("") && !tfXsl.getText().equals("")) {
            btnTransformar.setEnabled(true);
        }
    }
}

