package com.irs.swingexamples.models;

import javax.swing.*;

/**
 * Modelo de List de los territorios.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class TerritoryListModel extends AbstractListModel {

    static String[] salespersons = {
            "Wanda Pinnick",
            "Robert Taylor",
            "Jay Goldberg"
    };

    static Territory[] territories = new Territory[] {
            new Territory("Winslow County", salespersons[0], 4000),
            new Territory("Kashden County", salespersons[2], 5100),
            new Territory("Beaver Falls County", salespersons[1], 3250),
            new Territory("Hamilton County", salespersons[1], 11216),
            new Territory("Parris County", salespersons[0], 4773),
            new Territory("Belvedere County", salespersons[2], 8820),
            new Territory("Gossage County", salespersons[2], 1230),
            new Territory("Renfrew County", salespersons[2], 7360),
            new Territory("Davis County", salespersons[1], 13080)
    };

    public int getSize() {
        // return size of static data
        return territories.length;
    }

    public Object getElementAt(int index) {
        // return static data element
        return territories[index];
    }

    public static String[] getSalespersons() {
        return salespersons;
    }
}
