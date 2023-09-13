package com.irs.swingexamples;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la caja de dialogo Seleccionar Fuente (Font).
 *
 * @author IRS
 * @version 1.0.0
 */
public class FontDialog extends JFrame {

    /**
     * Constructor.
     */
    public FontDialog() {
        super("Seleccionar Fuente");
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Panel Contenedor
        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(12,12,11,11));

        // Panel de Datos
        JPanel pDatos = new JPanel();
        pDatos.setLayout(new GridBagLayout());
        pDatos.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        EmptyBorder border = new EmptyBorder(new Insets(0,0,0,10));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 5, 0);
        c.anchor = GridBagConstraints.WEST;

        JLabel lblFont = new JLabel("Font:");
        lblFont.setBorder(border);
        pDatos.add(lblFont, c);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        JComboBox cbFont = new JComboBox(fontNames);
        c.gridx = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        pDatos.add(cbFont, c);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setBorder(border);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        pDatos.add(lblSize, c);

        Object[] tamaños = {"8","10","12","14","16","18","20","24","26","28","32"};
        JComboBox cbSize = new JComboBox(tamaños);
        c.gridx = 1;
        pDatos.add(cbSize, c);

        JLabel lblStyle = new JLabel("Style:");
        lblStyle.setBorder(border);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.NORTH;
        pDatos.add(lblStyle, c);

        JPanel panelCheck = new JPanel();
        panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.Y_AXIS));

        JCheckBox cbBold = createCheckBox("Bold", 'B');
        JCheckBox cbItalic = createCheckBox("Italic", 'I');
        JCheckBox cbUnderline = createCheckBox("Underline", 'U');
        panelCheck.add(cbBold);
        panelCheck.add(cbItalic);
        panelCheck.add(cbUnderline);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 2;
        pDatos.add(panelCheck, c);

        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.Y_AXIS));
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton rbNormal = createRadioButton("Normal", 'N', true);
        JRadioButton rbSuperscript = createRadioButton("Superscript", 'P', false);
        JRadioButton rbSubscript = createRadioButton("Subscript", 'T', false);
        grupo.add(rbNormal);
        grupo.add(rbSuperscript);
        grupo.add(rbSubscript);
        panelRadio.add(rbNormal);
        panelRadio.add(rbSuperscript);
        panelRadio.add(rbSubscript);
        c.gridx = 2;
        c.anchor = GridBagConstraints.EAST;
        pDatos.add(panelRadio, c);

        // Panel Botones
        JButton btnApply = createButton("Apply", 'A');
        JButton btnReset = createButton("Reset", 'R');
        JButton btnClose = createButton("Close", 'C');
        JPanel pBotones = new JPanel();
        pBotones.setLayout(new BoxLayout(pBotones, BoxLayout.X_AXIS));
        pBotones.add(Box.createHorizontalGlue());
        pBotones.add(btnApply);
        pBotones.add(Box.createRigidArea(new Dimension(10,0)));
        pBotones.add(btnReset);
        pBotones.add(Box.createRigidArea(new Dimension(10,0)));
        pBotones.add(btnClose);

        // Establecer boton por defecto de la ventana
        getRootPane().setDefaultButton(btnApply);

        // Añado los controles
        panelContenedor.add(pDatos, BorderLayout.CENTER);
        panelContenedor.add(pBotones, BorderLayout.SOUTH);
        this.getContentPane().add(panelContenedor);

        setVisible(true);
        setResizable(false);
        pack();
    }

    private static JCheckBox createCheckBox(String text, char mnemonic) {
        JCheckBox cb = new JCheckBox(text);
        cb.setMnemonic(mnemonic);
        cb.setPreferredSize(new Dimension((int) cb.getPreferredSize().getWidth(),18));
        return cb;
    }

    private static JRadioButton createRadioButton(String text, char mnemonic, boolean selected) {
        JRadioButton rb = new JRadioButton(text, selected);
        rb.setMnemonic(mnemonic);
        rb.setPreferredSize(new Dimension((int) rb.getPreferredSize().getWidth(),18));
        return rb;
    }

    private static JButton createButton(String text, char mnemonic) {
        JButton btn = new JButton(text);
        btn.setMnemonic(mnemonic);
        btn.setActionCommand(text);
        return btn;
    }

    public static void main(String args[]) {
        JFrame frame = new FontDialog();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
