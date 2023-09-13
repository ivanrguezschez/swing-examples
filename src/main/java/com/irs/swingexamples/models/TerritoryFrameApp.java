package com.irs.swingexamples.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicación JFrame que prueba el modelo de lista de terrirotorios.
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class TerritoryFrameApp extends JFrame implements ActionListener {

    JComboBox salesCombo = new JComboBox(TerritoryListModel.getSalespersons());
    JList territoryList = new JList();
    TerritoryListModel model = new TerritoryListModel();
    TerritoryListModelFilter exclusionFilter = new TerritoryListModelFilter(model);

    public static void main(String[] args) {
        new TerritoryFrameApp().setVisible(true);
    }

    public TerritoryFrameApp() {
        super("Sales Territories");
        this.setSize(350, 200);
        this.setLocation(150, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the combo box
        this.getContentPane().add(salesCombo, BorderLayout.NORTH);
        salesCombo.addActionListener(this);
        // Add the list in a scroll pane and set the
        // model of the list to be the exclusion filter
        territoryList.setFont(new Font("Dialog", 0, 14));
        this.getContentPane().add(new JScrollPane(territoryList), BorderLayout.CENTER);
        territoryList.setModel(exclusionFilter);
        actionPerformed(null);
    }

    // Invoked when user selects a salesperson from the list
    public void actionPerformed(ActionEvent event) {
        // Get the new salesperson from the combo box and
        // set the value into the filter
        String salesperson = (String)salesCombo.getSelectedItem();
        exclusionFilter.setSalesperson(salesperson);
        territoryList.updateUI();
    }
}
