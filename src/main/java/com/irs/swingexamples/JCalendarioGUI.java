package com.irs.swingexamples;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

/**
 * Clase que crea un componente JCalendario.
 *
 * @author IRS
 * @version 1.0.0
 */
public class JCalendarioGUI extends JFrame implements ActionListener {

    private final static String[] MESES = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    private final static String[] DIAS = {"L","M","X","J","V","S","D"};

    int[] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31};

    // Etiquetas
    private JLabel[][] lbl_dias;

    // Listas desplegables
    private JComboBox cb_mes;

    // Cajas de Texto
    private JTextField tf_anno;
    private Spinner sp_anno;

    Calendar calendario;

    public JCalendarioGUI(String titulo) {
        super(titulo);
        iniciarComponentes();
        // Ajustar el tamaño de la ventana al minimo
        pack();
    }

    private void iniciarComponentes() {
        calendario = Calendar.getInstance();

        lbl_dias = new JLabel[7][7];
        for (int i = 0; i < lbl_dias[0].length; i++) {
            lbl_dias[0][i] = new JLabel(DIAS[i],JLabel.CENTER);
            lbl_dias[0][i].setBackground(Color.black);
            lbl_dias[0][i].setForeground(Color.white);
            lbl_dias[0][i].setOpaque(true);
        }
        for (int i = 1; i < lbl_dias.length; i++) {
            for (int j = 0; j < lbl_dias[i].length; j++) {
                lbl_dias[i][j] = new JLabel("   ", JLabel.CENTER);
            }
        }

        cb_mes = new JComboBox(MESES);
        cb_mes.setBackground(Color.white);
        cb_mes.setSelectedIndex(calendario.get(Calendar.MONTH));
        cb_mes.addActionListener(this);

        tf_anno = new JTextField();
        tf_anno.setText(Integer.toString(calendario.get(Calendar.YEAR)));
        tf_anno.addActionListener(this);
        sp_anno = new Spinner();
        sp_anno.getIncrementButton().addActionListener(this);
        sp_anno.getDecrementButton().addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tf_anno, "Center");
        panel.add(sp_anno, "East");

        JPanel p_mesanno = new JPanel();
        p_mesanno.setLayout(new GridLayout(2,2));
        p_mesanno.add(new JLabel("Mes"));
        p_mesanno.add(new JLabel("Año"));
        p_mesanno.add(cb_mes);
        p_mesanno.add(panel);

        JPanel p_dias = new JPanel();
        p_dias.setLayout(new GridLayout(7,7));
        for (int i = 0; i < lbl_dias.length; i++) {
            for (int j = 0; j < lbl_dias[i].length; j++) {
                p_dias.add(lbl_dias[i][j]);
            }
        }

        // Panel Contenedor
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelContenedor.setLayout(new BorderLayout(5,5));
        panelContenedor.add(p_mesanno, BorderLayout.NORTH);
        panelContenedor.add(p_dias, BorderLayout.CENTER);
        setContentPane(panelContenedor);

        obtenerCalendario(calendario.get(Calendar.MONTH), calendario.get(Calendar.YEAR));
        marcarDiaActual(calendario.get(Calendar.MONTH), calendario.get(Calendar.YEAR));
        marcarDomingos();

        // Permitir que la ventana de la aplicacion responda a los eventos de ventanas
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evento){
                cerrarVentana();
            }
        });
    }

    private boolean esBisiesto(int a) {
        return ((a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0));
    }

    private void limpiarDias() {
        for(int i = 1; i < lbl_dias.length; i++) {
            for (int j = 0; j < lbl_dias[i].length; j++) {
                lbl_dias[i][j].setText("");
            }
        }
    }

    private void limpiarDiasOpacos() {
        for (int i = 1; i < lbl_dias.length; i++) {
            for (int j = 0; j < lbl_dias[i].length; j++) {
                lbl_dias[i][j].setOpaque(false);
            }
        }
    }


    private void marcarDiaActual(int m, int a) {
        limpiarDiasOpacos();
        // Si el año y el mes no es el actual marcara el dia 1 del mes
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.MONTH) == m && cal.get(Calendar.YEAR) == a) {
            marcarDia(Integer.toString(cal.get(Calendar.DATE)));
        } else {
            marcarDia("1");
        }
    }

    private void marcarDia(String d) {
        for (int i = 1; i < lbl_dias.length; i++) {
            for (int j = 0; j < lbl_dias[i].length; j++) {
                if (lbl_dias[i][j].getText().equals(d)) {
                    lbl_dias[i][j].setOpaque(true);
                    lbl_dias[i][j].setBackground(new Color(255, 255, 255));
                    break;
                }
            }
        }
    }

    private void marcarDomingos() {
        for (int i = 1; i < lbl_dias.length; i++) {
            if (!lbl_dias[i][lbl_dias[i].length - 1].getText().equals("")) {
                lbl_dias[i][lbl_dias[i].length - 1].setOpaque(true);
                lbl_dias[i][lbl_dias[i].length - 1].setForeground(new Color(255, 0, 0));
            }
        }
    }

    private void obtenerCalendario(int m, int a) {
        calendario.set(a, m, 1);
        DIAS_MES[1] = (esBisiesto(a))?29:28;
        int diasemana = calendario.get(Calendar.DAY_OF_WEEK);
        int numerodia = 1;
        diasemana = diasemana==1?6:diasemana-2;
        limpiarDias();
        for (int i = diasemana; i < 7; i++) {
            lbl_dias[1][i].setText(Integer.toString(numerodia));
            numerodia++;
        }
        for (int i = 2; i < lbl_dias.length && numerodia <= DIAS_MES[m]; i++) {
            for (int j = 0; j < lbl_dias[i].length && numerodia <= DIAS_MES[m]; j++) {
                lbl_dias[i][j].setText(Integer.toString(numerodia));
                numerodia++;
            }
        }
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object origen = e.getSource();
        int i = Integer.parseInt(tf_anno.getText());
        if (origen == sp_anno.getIncrementButton()) {
            i++;
        }
        if (origen == sp_anno.getDecrementButton()) {
            i--;
        }

        tf_anno.setText(Integer.toString(i));
        obtenerCalendario(cb_mes.getSelectedIndex(), Integer.parseInt(tf_anno.getText()));
        marcarDiaActual(cb_mes.getSelectedIndex(), Integer.parseInt(tf_anno.getText()));
    }

    private void cerrarVentana() {
        // Salir de la aplicacion
        System.exit(0);
    }


    // CLASE SPINNER
    public class Spinner extends JPanel {
        private int orientacion = SwingConstants.VERTICAL;
        private BasicArrowButton botonIncrementar;
        private BasicArrowButton botonDecrementar;

        public Spinner() {
            createComponents();
        }

        public Spinner(int orien) {
            orientacion = orien;
            createComponents();
        }

        public void setEnabled(boolean enable){
            botonIncrementar.setEnabled(enable);
            botonDecrementar.setEnabled(enable);
        }

        public boolean isEnabled(){
            return (botonIncrementar.isEnabled() &&	botonDecrementar.isEnabled());
        }

        protected void createComponents(){
            if (orientacion == SwingConstants.VERTICAL) {
                setLayout(new GridLayout(2, 1));
                botonIncrementar = new BasicArrowButton(SwingConstants.NORTH);
                botonDecrementar = new BasicArrowButton(SwingConstants.SOUTH);
                add(botonIncrementar);
                add(botonDecrementar);
            } else if (orientacion == SwingConstants.HORIZONTAL){
                setLayout(new GridLayout(1, 2));
                botonIncrementar = new BasicArrowButton(SwingConstants.EAST);
                botonDecrementar = new BasicArrowButton(SwingConstants.WEST);
                add(botonDecrementar);
                add(botonIncrementar);
            }
        }

        public JButton getIncrementButton() {
            return (botonIncrementar);
        }
        public JButton getDecrementButton() {
            return (botonDecrementar);
        }
    }

    public static void main(String[] args) {
        JCalendarioGUI vPpal = new JCalendarioGUI("Calendario V.2.0");
        Dimension d_pantalla = vPpal.getToolkit().getScreenSize();
        // Centro la ventana en la pantalla
        vPpal.setLocation((d_pantalla.width - vPpal.getWidth())/2,
                (d_pantalla.height - vPpal.getHeight())/2);
        vPpal.setVisible(true);
    }
}