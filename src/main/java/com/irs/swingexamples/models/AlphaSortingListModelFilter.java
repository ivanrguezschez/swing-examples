package com.irs.swingexamples.models;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Filtro que ordena alfabeticamente el conjunto de elementos del modelo.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class AlphaSortingListModelFilter extends AbstractListModelFilter {
    // Array to sorted indices
    protected ArrayList sortedIndex;

    public AlphaSortingListModelFilter(ListModel delegate) {
        super(delegate);
        resort();
    }

    // This sort algorithm is called an 'insertion sort' and is suitable
    // for dealing with data of less than a couple of hundred records.
    // It a 'stackless' sort.
    protected synchronized void resort() {
        // No ordena los elementos en si sino que reindexa los indices
        // ordena alfabeticamente pero los elementos no los toca, toca sus
        // indices
        sortedIndex = new ArrayList();
        for (int i = 0; i < delegate.getSize(); i++) {
            for (int j = 0; j < i; j++) {
                String current = delegate.getElementAt(i).toString();
                int compareIndex = ((Integer)sortedIndex.get(j)).intValue();
                String compare = delegate.getElementAt(compareIndex).toString();
                if (current.compareTo(compare) < 0) {
                    sortedIndex.add(j, new Integer(i));
                    break;
                }
            }
            // Si no existe en la lista lo insertamos
            if (!sortedIndex.contains(new Integer(i))) {
                sortedIndex.add(new Integer(i));
            }
        }

      /*
      // Ejemplo del algoritmo usado en el articulo, usa ETIQUETAS que no
      // es muy aconsejable
      nextElement:
                        for (int i=0; i<delegate.getSize(); i++) {
            for (int j=0; j<i; j++) {
                String current = delegate.getElementAt(i).toString();
               int compareIndex = ((Integer)sortedIndex.get(j)).intValue();
               String compare = delegate.getElementAt(compareIndex).toString();
               if (current.compareTo(compare) < 0) {
                  sortedIndex.add(j, new Integer(i));
                  continue nextElement;
               }
            }
            sortedIndex.add(new Integer(i));
         }
       */

        // Tell the component that the data have changed
        this.fireContentsChanged(this, 0, sortedIndex.size());
    }

    public Object getElementAt(int index) {
        // delegate to filter target, but use the sorted index
        int newIndex = ((Integer)sortedIndex.get(index)).intValue();
        return delegate.getElementAt(newIndex);
    }
}