package com.irs.swingexamples.models.indicadores;

/**
 * Representa un objeto tipo indicador a mostrar en los modelos de combo box y list de swing.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class TipoIndicadorVO {

    private int id;
    private String name;

    public TipoIndicadorVO(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
