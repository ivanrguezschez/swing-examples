package com.irs.swingexamples.models.indicadores;

import javax.swing.*;
import java.util.List;

/**
 * Modelo de List de los indicadores.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class IndicadorListModel extends AbstractListModel {

    List tipoIndicador;
    List indicadores;

    public IndicadorListModel() {
        super();
        if (tipoIndicador == null) {
            tipoIndicador = DAOIndicadores.findTiposIndicador();
        }
        if (indicadores == null) {
            indicadores = DAOIndicadores.findIndicadores();
        }
    }

    public int getSize() {
        return indicadores.size();
    }

    public Object getElementAt(int index) {
        return indicadores.get(index);
    }

    public String[] getTipoIndicador() {
        String[] ids = new String[tipoIndicador.size()];
        for (int i = 0; i < tipoIndicador.size(); i++) {
            ids[i] = new String(((TipoIndicadorVO) tipoIndicador.get(i)).getName());
        }

        return ids;
    }

    public IndicadorVO getIndicador(int index) {
        IndicadorVO indicador = (IndicadorVO) indicadores.get(index);
        return indicador;
    }

    public int getId(String name) {
        for (int i = 0; i < tipoIndicador.size(); i++) {
            if (((TipoIndicadorVO) tipoIndicador.get(i)).getName().equals(name)) {
                return ((TipoIndicadorVO) tipoIndicador.get(i)).getId();
            }
        }

        return 0;
    }
}
