package com.irs.swingexamples.models;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Filtro del conjunto de elementos del modelo de territorios.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class TerritoryListModelFilter extends AbstractListModelFilter {

    // Collection of indices that pass the filtering
    // criteria, namely, the territories that have the
    // specified salesperson.
    protected ArrayList indexList = new ArrayList();

    // Current salesperson
    public TerritoryListModelFilter(ListModel delegate) {
        super(delegate);
    }

    protected String salesperson;

    public synchronized void setSalesperson(String salesperson) {
        // Assign the property value and clear the collection
        this.salesperson = salesperson;
        indexList.clear();
        // Iterate through the model
        for (int z = 0; z < delegate.getSize(); z++) {
            // If the salesperson of the element matches
            // the filter value, add the index as an
            // element to the index collection
            Territory terr = (Territory)delegate.getElementAt(z);
            if (salesperson.equals(terr.salesperson)) {
                indexList.add(new Integer(z));
            }
        }
        // Tell the component that the data have changed
        this.fireContentsChanged(this, 0, indexList.size());
    }

    public String getSalesperson() {
        return this.salesperson;
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
