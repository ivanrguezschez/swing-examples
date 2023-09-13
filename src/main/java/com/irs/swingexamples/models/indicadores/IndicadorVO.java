package com.irs.swingexamples.models.indicadores;

/**
 * Representa un objeto indicador a mostrar en los modelos de combo box y list de swing.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class IndicadorVO {
    private int id;
    private String name;
    private int tipoIndicador;

    public IndicadorVO() {
        super();
        this.name = "";
    }

    public IndicadorVO(int id, String name, int tipoIndicador) {
        super();
        this.id = id;
        this.name = name;
        this.tipoIndicador = tipoIndicador;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTipoIndicador() {
        return tipoIndicador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTipoIndicador(int tipoIndicador) {
        this.tipoIndicador = tipoIndicador;
    }

    public String toString() {
        return name;
    }
}
