package com.irs.swingexamples.hanoi;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * Clase que resuelve el problema de recursidad de Las Torres de Hanoi.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Hanoi extends JFrame {

    /**
     * Numero de discos a procesar.
     */
    private static final int NUMBER_DISK = 10;

    /**
     * Pila que representa el primer palo.
     */
    private Stack<Integer> poleOne = new Stack<>();

    /**
     * Pila que representa el segundo palo.
     */
    private Stack<Integer> poleTwo = new Stack<>();

    /**
     * Pila que representa el tercer palo.
     */
    private Stack<Integer> poleThree = new Stack<>();

    /**
     * Constructor
     */
    public Hanoi() {
        super("Towers Of Hanoi");

        // Inicializa los discos
        for (int i = NUMBER_DISK; i > 0; i--) {
            poleOne.push(new Integer(i));
        }

        setResizable(false);
        setSize(400, 200);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Inicia la ejecución de la resolución del problema.
     */
    public void run() {
        // Resolvemos el puzle
        solveHanoi(NUMBER_DISK, poleOne, poleTwo, poleThree);
    }

    /**
     * Pinta los diversos palos con sus discos.
     *
     * @param g El contexto grafico sobre el que pinta.
     */
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, 400, 200);
        g.setColor(Color.RED);
        g.fillRect(25, 180, 100, 10);
        g.fillRect(150, 180, 100, 10);
        g.fillRect(275, 180, 100, 10);
        g.setColor(Color.BLACK);

        // Los numeros localizan la base de cada pila
        paintStack(poleOne, g, 75, 170);
        paintStack(poleTwo, g, 200, 170);
        paintStack(poleThree, g, 325, 170);
    }

    private void paintStack(Stack<Integer> stk, Graphics g, int x, int y) {
        for (Integer v : stk) {
            int value = v.intValue();
            // Cada disco tiene 10 pixels de alto por 4 * size de ancho
            g.fillRect(x - 4 * value, y, 8 * value, 10);
            y -= 10;
        }
    }

    private void solveHanoi(int n, Stack a, Stack b, Stack c) {
        if (n > 0) {
            // Primera llamada recursiva mueve un disco
            solveHanoi(n - 1, a, c, b);
            b.push(a.pop());
            // Repinta
            repaint();

            try {
                //Thread.sleep(200);
                Thread.sleep(50);
            } catch (Exception e) {
            }

            // Segunda llamada recursiva
            solveHanoi(n - 1, c, b, a);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.setVisible(true);
        hanoi.run();
    }
}
