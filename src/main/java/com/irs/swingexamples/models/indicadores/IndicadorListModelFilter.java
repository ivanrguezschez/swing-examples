package com.irs.swingexamples.models.indicadores;

import com.irs.swingexamples.models.AbstractListModelFilter;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Filtro que filtra los indicadores por el tipo de indicador el conjunto de elementos del modelo.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class IndicadorListModelFilter extends AbstractListModelFilter {

    protected ArrayList indexList = new ArrayList();

    protected int tipoIndicador;

    public IndicadorListModelFilter(ListModel delegate) {
        super(delegate);
    }

    public synchronized void setIndicadores(int tipoIndicador) {
        // Assign the property value and clear the collection
        this.tipoIndicador = tipoIndicador;
        indexList.clear();
        // Iterate through the model
        for (int z = 0; z < delegate.getSize(); z++) {
            IndicadorVO indicador = (IndicadorVO) delegate.getElementAt(z);
            if (tipoIndicador == indicador.getTipoIndicador()) {
                indexList.add(new Integer(z));
            }
        }
        // Tell the component that the data have changed
        this.fireContentsChanged(this, 0, indexList.size());
    }

    public int getTipoIndicador() {
        return this.tipoIndicador;
    }

    public int getSize() {
        // Return size of index collection.  If no filter
        // has been set, or the filter refers to a salesman
        // that does not exist, zero may be returned
        return indexList.size();
    }

    public Object getElementAt(int index) {
        // return the filtered data element
        int newIndex = ((Integer)indexList.get(index)).intValue();
        return delegate.getElementAt(newIndex);
    }
}
