package com.irs.swingexamples.models;

/**
 * Representa un objeto territorio a mostrar en los modelos de combo box y list de swing.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class Territory {
    public String name;
    public String salesperson;
    public int sales;

    public Territory(String name, String salesperson, int sales) {
        super();
        this.name = name;
        this.salesperson = salesperson;
        this.sales = sales;
    }

    public String toString() {
        return this.name;
    }
}
