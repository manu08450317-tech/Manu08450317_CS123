5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the
countries on console whenever the countries are selected on the list.

// JList Example developed by Dr. S.M. Badhusha
package Swings;

import java.util.List;
import javax.swing.*;

public class JListExample extends JFrame {
    private JList<String> countryList;
    private JLabel selectedLabel;

    public JListExample() {
        // Create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        // Create the list
        countryList = new JList<>(listModel);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Label to show selected countries
        selectedLabel = new JLabel("Selected: None");
        selectedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add selection listener
        countryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                List<String> selectedValuesList = countryList.getSelectedValuesList();
                selectedLabel.setText("Selected: " + selectedValuesList);
                System.out.println("Selected: " + selectedValuesList);
            }
        });

        // Layout with scroll pane and label
        setLayout(new java.awt.BorderLayout());
        add(new JScrollPane(countryList), java.awt.BorderLayout.CENTER);
        add(selectedLabel, java.awt.BorderLayout.SOUTH);

        // Frame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JList Example");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JListExample::new);
    }
}

