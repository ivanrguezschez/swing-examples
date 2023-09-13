package com.irs.swingexamples.models;

import javax.swing.*;
import java.awt.*;

/**
 * Aplicación JFrame que prueba el modelo de lista de terrirotorios con el filtro de ordenación alfabética.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class SortFrameApp extends JFrame {

    JList territoryList = new JList();
    TerritoryListModel model = new TerritoryListModel();
    AlphaSortingListModelFilter inclusionFilter = new AlphaSortingListModelFilter(model);

    public static void main(String[] args) {
        new SortFrameApp().setVisible(true);
    }

    public SortFrameApp() {
        super("Sort Territories");
        this.setSize(350, 200);
        this.setLocation(150, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the list in a scroll pane and set the
        // model of the list to be the inclusion filter
        this.getContentPane().add(new JScrollPane(territoryList), BorderLayout.CENTER);
        territoryList.setModel(inclusionFilter);
    }
}

