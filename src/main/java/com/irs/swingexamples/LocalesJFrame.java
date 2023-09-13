package com.irs.swingexamples;

import java.awt.Component;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * Clase que muestra una frame con las diversas localidades disponibles y sus formatos de fecha, hora, etc.
 *
 * @author IRS
 * @version 1.0.0, 09/05/2007
 */
public class LocalesJFrame extends javax.swing.JFrame {

    private javax.swing.JButton buttonCerrar;
    private javax.swing.JComboBox comboBoxLocalidades;
    private javax.swing.JLabel labelFormatoFechaCorto;
    private javax.swing.JLabel labelFormatoFechaDefecto;
    private javax.swing.JLabel labelFormatoFechaLargo;
    private javax.swing.JLabel labelFormatoHora;
    private javax.swing.JLabel labelLenguaje;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelNombreDias;
    private javax.swing.JLabel labelNombreMeses;
    private javax.swing.JLabel labelPais;
    private javax.swing.JList listNombreDias;
    private javax.swing.JList listNombreMeses;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JScrollPane scrollPaneNombreDias;
    private javax.swing.JScrollPane scrollPaneNombreMeses;
    private javax.swing.JTextField textFieldFormatoFechaCorto;
    private javax.swing.JTextField textFieldFormatoFechaDefecto;
    private javax.swing.JTextField textFieldFormatoFechaLargo;
    private javax.swing.JTextField textFieldFormatoHora;
    private javax.swing.JTextField textFieldLenguaje;
    private javax.swing.JTextField textFieldPais;

    public LocalesJFrame() {
        super();
        initComponents();
        loadData();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        java.awt.Insets insetsLabel = new java.awt.Insets(0, 0, 5, 10);
        java.awt.Insets insetsValue = new java.awt.Insets(0, 0, 5, 0);

        panelContenedor = new javax.swing.JPanel();
        panelContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        panelContenedor.setLayout(new java.awt.GridBagLayout());

        labelLocalidad = new javax.swing.JLabel();
        labelLocalidad.setText("Localidades:");

        comboBoxLocalidades = new javax.swing.JComboBox();
        loadLocales();
        comboBoxLocalidades.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                Locale l = (Locale) value;
                setText(l.getDisplayName());
                return this;
            }
        });
        comboBoxLocalidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxLocalidadesItemStateChanged(evt);
            }
        });

        labelPais = new javax.swing.JLabel();
        labelPais.setText("Pais:");

        textFieldPais = new javax.swing.JTextField();
        textFieldPais.setColumns(25);
        textFieldPais.setEditable(false);

        labelLenguaje = new javax.swing.JLabel();
        labelLenguaje.setText("Lenguaje:");

        textFieldLenguaje = new javax.swing.JTextField();
        textFieldLenguaje.setColumns(25);
        textFieldLenguaje.setEditable(false);

        labelNombreMeses = new javax.swing.JLabel();
        labelNombreMeses.setText("Nombre de los meses:");

        listNombreMeses = new javax.swing.JList();
        scrollPaneNombreMeses = new javax.swing.JScrollPane();
        scrollPaneNombreMeses.setMinimumSize(new java.awt.Dimension(200, 80));
        scrollPaneNombreMeses.setPreferredSize(new java.awt.Dimension(200, 80));
        scrollPaneNombreMeses.setViewportView(listNombreMeses);

        labelNombreDias = new javax.swing.JLabel();
        labelNombreDias.setText("Nombre de los d\u00edas:");

        listNombreDias = new javax.swing.JList();
        scrollPaneNombreDias = new javax.swing.JScrollPane();
        scrollPaneNombreDias.setMinimumSize(new java.awt.Dimension(200, 80));
        scrollPaneNombreDias.setPreferredSize(new java.awt.Dimension(200, 80));
        scrollPaneNombreDias.setViewportView(listNombreDias);

        labelFormatoFechaDefecto = new javax.swing.JLabel();
        labelFormatoFechaDefecto.setText("Formato de la fecha por defecto:");

        textFieldFormatoFechaDefecto = new javax.swing.JTextField();
        textFieldFormatoFechaDefecto.setColumns(25);
        textFieldFormatoFechaDefecto.setEditable(false);

        labelFormatoFechaLargo = new javax.swing.JLabel();
        labelFormatoFechaLargo.setText("Formato largo de la fecha:");

        textFieldFormatoFechaLargo = new javax.swing.JTextField();
        textFieldFormatoFechaLargo.setColumns(25);
        textFieldFormatoFechaLargo.setEditable(false);

        labelFormatoFechaCorto = new javax.swing.JLabel();
        labelFormatoFechaCorto.setText("Formato corto de la fecha:");

        textFieldFormatoFechaCorto = new javax.swing.JTextField();
        textFieldFormatoFechaCorto.setColumns(25);
        textFieldFormatoFechaCorto.setEditable(false);

        labelFormatoHora = new javax.swing.JLabel();
        labelFormatoHora.setText("Formato de la hora:");

        textFieldFormatoHora = new javax.swing.JTextField();
        textFieldFormatoHora.setColumns(25);
        textFieldFormatoHora.setEditable(false);

        buttonCerrar = new javax.swing.JButton();
        buttonCerrar.setText("Cerrar");
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Localidades");
        setResizable(false);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelLocalidad, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(comboBoxLocalidades, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelPais, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldPais, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelLenguaje, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldLenguaje, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelNombreMeses, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(scrollPaneNombreMeses, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelNombreDias, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(scrollPaneNombreDias, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelFormatoFechaDefecto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldFormatoFechaDefecto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelFormatoFechaLargo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldFormatoFechaLargo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelFormatoFechaCorto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldFormatoFechaCorto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = insetsLabel;
        panelContenedor.add(labelFormatoHora, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = insetsValue;
        panelContenedor.add(textFieldFormatoHora, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContenedor.add(buttonCerrar, gridBagConstraints);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);
        pack();
    }

    private void comboBoxLocalidadesItemStateChanged(java.awt.event.ItemEvent evt) {
        loadData();
    }

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }

    private void loadLocales() {
        Locale[] localidades = Locale.getAvailableLocales();
        Arrays.sort(localidades, new Comparator<Locale>() {
            @Override
            public int compare(Locale o1, Locale o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });

        ComboBoxModel model = new DefaultComboBoxModel(localidades);
        model.setSelectedItem(Locale.getDefault());
        comboBoxLocalidades.setModel(model);
    }

    private void loadData() {
        Locale selected = (Locale) comboBoxLocalidades.getSelectedItem();

        textFieldPais.setText(selected.getDisplayCountry());
        textFieldLenguaje.setText(selected.getDisplayLanguage());

        Date hoy = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, selected);
        textFieldFormatoFechaDefecto.setText(df.format(hoy));

        df = DateFormat.getDateInstance(DateFormat.FULL, selected);
        textFieldFormatoFechaLargo.setText(df.format(hoy));

        df = DateFormat.getDateInstance(DateFormat.SHORT, selected);
        textFieldFormatoFechaCorto.setText(df.format(hoy));

        df = DateFormat.getTimeInstance(DateFormat.DEFAULT, selected);
        textFieldFormatoHora.setText(df.format(hoy));

        DateFormatSymbols dfs = new DateFormatSymbols(selected);
        loadList(listNombreMeses, dfs.getMonths());
        loadList(listNombreDias, dfs.getWeekdays());
    }

    private void loadList(JList list, String[] data) {
        DefaultListModel model =  new DefaultListModel();
        for (String d : data) {
            model.addElement(d);
        }
        list.setModel(model);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalesJFrame().setVisible(true);
            }
        });
    }






}
