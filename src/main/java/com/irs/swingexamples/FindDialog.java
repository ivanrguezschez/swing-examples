package com.irs.swingexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que representa la caja de dialogo Buscar.
 *
 * @author IRS
 * @version 1.0.0
 */
public class FindDialog extends JFrame {

    /**
     * Constructor.
     */
    public FindDialog() {
        super("Find");
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
        pDatos.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 5, 5);
        c.gridheight = 3;
        c.anchor = GridBagConstraints.NORTH;
        pDatos.add(new JLabel("Find:"), c);

        JTextField tfFind = new JTextField(20);
        c.insets = new Insets(0, 0, 5, 0);
        c.gridx = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        pDatos.add(tfFind, c);

        JPanel panelCheck = new JPanel();
        panelCheck.setLayout(new BoxLayout(panelCheck, BoxLayout.Y_AXIS));
        JCheckBox cbMatch = createCheckBox("Match Case", 'M');
        JCheckBox cbWhole = createCheckBox("Whole Word", 'W');
        panelCheck.add(cbMatch);
        panelCheck.add(cbWhole);
        c.gridwidth = 1;
        c.gridy = 1;
        pDatos.add(panelCheck, c);

        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.Y_AXIS));
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton rbStart = createRadioButton("Start at Top", 'S', true);
        JRadioButton rbAround = createRadioButton("Wrap Around", 'A', false);
        grupo.add(rbStart);
        grupo.add(rbAround);
        panelRadio.add(rbStart);
        panelRadio.add(rbAround);
        c.gridx = 2;
        c.anchor = GridBagConstraints.EAST;
        pDatos.add(panelRadio, c);

        // Panel Botones
        JButton btnFind = createButton("Find", 'F');
        JButton btnClose = createButton("Close", 'C');
        JPanel pBotones = new JPanel();
        pBotones.setLayout(new BoxLayout(pBotones, BoxLayout.X_AXIS));
        pBotones.add(Box.createHorizontalGlue());
        pBotones.add(btnFind);
        pBotones.add(Box.createRigidArea(new Dimension(10,0)));
        pBotones.add(btnClose);

        getRootPane().setDefaultButton(btnFind);

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
        JFrame frame = new FindDialog();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
