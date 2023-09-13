package com.irs.swingexamples.xml.validator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelConsola extends JPanel {

    private JList listErrores;

    static Insets INSETS_EMPTY = new Insets(0, 0, 0, 0);
    static Insets INSETS_TEXT = new Insets(0, 0, 5, 5);
    static Insets INSETS_LABEL = new Insets(0, 0, 5, 5);
    static Insets INSETS_BUTTON = new Insets(0, 0, 5, 0);
    //static Font DEFAULT_FONT = new Font("Dialog", Font.PLAIN, 12);
    static Font DEFAULT_FONT = new java.awt.Font("Trebuchet MS", Font.PLAIN, 11);

    public PanelConsola() {
        super();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBorder(new javax.swing.border.CompoundBorder(
                new TitledBorder(new LineBorder(Color.BLACK), "Consola", 0, 0 , DEFAULT_FONT),
                new EmptyBorder(0,10,5,10)));

        listErrores = new JList();
        listErrores.setFont(DEFAULT_FONT);

        JScrollPane scrollPane = new JScrollPane(listErrores);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JList getListErrores() {
        return listErrores;
    }

    public void setListErrores(JList listErrores) {
        this.listErrores = listErrores;
    }
}
