package com.irs.swingexamples.models;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Filtro de modelo de lista abstracto.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public abstract class AbstractListModelFilter extends AbstractListModel {

    // Almacena una referencia al modelo que será filtrado.
    protected ListModel delegate;

    /**
     * Constructor.
     * Toma un parámetro simple que contiene una referencia al modelo que será filtrado.
     * @param delegate Objeto que contiene una referencia al modelo que será filtrado.
     */
    public AbstractListModelFilter(ListModel delegate) {
        super();
        this.delegate = delegate;
    }

    public ListModel getDelegate() {
        return this.delegate;
    }

    public int getSize() {
        // delegate to filter target
        return delegate.getSize();
    }

    public Object getElementAt(int index) {
        // delegate a filter target
        return delegate.getElementAt(index);
    }

    public void addListDataListener(ListDataListener listener) {
        // delegate a filter target
        delegate.addListDataListener(listener);
    }

    public void removeListDataListener(ListDataListener listener) {
        // delegate a filter target
        delegate.removeListDataListener(listener);
    }
}
