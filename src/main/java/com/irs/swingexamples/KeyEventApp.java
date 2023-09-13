package com.irs.swingexamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que muestra información sobre las teclas pulsadas.
 *
 * @author IRS
 * @version 1.0.0, 09/05/2007
 */
public class KeyEventApp extends JFrame implements KeyListener, ActionListener {

    static final String NEW_LINE = System.getProperty("line.separator");
    private JButton btn_limpiar;
    private JTextField tf_entrada;
    private JTextArea ta_salida;

    public KeyEventApp(String titulo) {
        super(titulo);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        btn_limpiar = new JButton("Limpiar");
        btn_limpiar.addActionListener(this);

        tf_entrada = new JTextField(20);
        tf_entrada.addKeyListener(this);

        ta_salida = new JTextArea();
        ta_salida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ta_salida);
        scrollPane.setPreferredSize(new Dimension(375, 125));

        JPanel panelContenedor = new JPanel();
        // Introducimos un borde sin pintar alrededor de los controles
        // createEmptyBorder(top, left, botton, right)
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        // Establecer un administrador de diseño de borde
        panelContenedor.setLayout(new BorderLayout(0,5));
        // Añado los controles
        panelContenedor.add(tf_entrada, BorderLayout.NORTH);
        panelContenedor.add(scrollPane, BorderLayout.CENTER);
        panelContenedor.add(btn_limpiar, BorderLayout.SOUTH);

        // Añadir los componentes al contenedor de la aplicacion
        setContentPane(panelContenedor);
    }


    /////////////////////////////////////////////////////////////////
    // EVENTOS DE TECLAS
    /////////////////////////////////////////////////////////////////
    public void keyTyped(KeyEvent e){
        mostrarInfo(e, "KEY TYPED: ");
    }

    public void keyPressed(KeyEvent e){
        mostrarInfo(e, "KEY PRESSED: ");
    }

    public void keyReleased(KeyEvent e){
        mostrarInfo(e, "KEY RELEASED: ");
    }

    /////////////////////////////////////////////////////////////////
    // EVENTO GENERAL
    /////////////////////////////////////////////////////////////////
    // Maneja la pulsacion del boton
    public void actionPerformed(ActionEvent e) {
        // Limpia los componentes de texto
        tf_entrada.setText("");
        ta_salida.setText("");

        // Devuelve el foco al area de entrada
        tf_entrada.requestFocus();
    }

    protected void mostrarInfo(KeyEvent e, String s) {
        String charString, keyCodeString, modString, tmpString;

        char c = e.getKeyChar();
        int keyCode = e.getKeyCode();
        int modifiers = e.getModifiers();

        if (Character.isISOControl(c)) {
            charString = "key character = "
                    + "(an unprintable control character)";
        } else {
            charString = "key character = '" + c + "'";
        }

        keyCodeString = "key code = " + keyCode
                + " (" + KeyEvent.getKeyText(keyCode) + ")";
        modString = "modifiers = " + modifiers;
        tmpString = KeyEvent.getKeyModifiersText(modifiers);

        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no modifiers)";
        }

        ta_salida.append(s + NEW_LINE
                + "    " + charString + NEW_LINE
                + "    " + keyCodeString + NEW_LINE
                + "    " + modString + NEW_LINE);
    }

    public static void main(String args[]) {
        KeyEventApp vPpal = new KeyEventApp("Eventos de Teclado");

        // Permitir que la ventana de la aplicacion responda a los
        // eventos de ventana (p.e. cerrar la ventana)
        vPpal.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        // Ajustar el tamaño de la ventana al minimo
        vPpal.pack();
        vPpal.setVisible(true);
    }
}
