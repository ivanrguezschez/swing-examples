package com.irs.swingexamples.models;

import javax.swing.*;

/**
 * Filtro que obtiene el todal de ventas de el conjunto de elementos del modelo.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class SalesTotalListModelFilter extends AbstractListModelFilter {
    protected String totalElement;

    public SalesTotalListModelFilter(ListModel delegate) {
        super(delegate);
        // Calculate the total sales across all elements
        int total = 0;
        for (int z = 0; z < delegate.getSize(); z++) {
            Territory terr = (Territory)delegate.getElementAt(z);
            total += terr.sales;
        }
        totalElement = "*** Total Sales:  " + Integer.toString(total);
    }

    public int getSize() {
        // Add one to the delegate size to reserve a
        // place for the total
        return delegate.getSize() + 1;
    }

    public Object getElementAt(int index) {
        // If the index is within the delegate, return the
        // value.  Otherwise return the ‘total’ string we
        // calculated in the constructor
        if (index < delegate.getSize()) {
            Territory terr = (Territory)delegate.getElementAt(index);
            String element = terr.name + " - " + Integer.toString(terr.sales);
            return element;
        }
        return totalElement;
    }
}
