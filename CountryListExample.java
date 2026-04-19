package Swing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CountryListExample extends JFrame {
    private JList<String> countryList;
    private Map<String, String> capitals;

    public CountryListExample() {
        // Initialize country-capital mapping
        capitals = new HashMap<>();
        capitals.put("USA", "Washington, D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Pretoria (South Africa)"); // Example
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // Create list model and add countries
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : capitals.keySet()) {
            listModel.addElement(country);
        }

        // Create JList
        countryList = new JList<>(listModel);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add listener to display capitals on console
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    for (String selectedCountry : countryList.getSelectedValuesList()) {
                        String capital = capitals.get(selectedCountry);
                        System.out.println("Capital of " + selectedCountry + " is " + capital);
                    }
                }
            }
        });

        // Add list to scroll pane
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Frame settings
        this.add(scrollPane, BorderLayout.CENTER);
        this.setTitle("Country List Example");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryListExample());
    }
}