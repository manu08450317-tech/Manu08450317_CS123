5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and
display the concerned color whenever the specific tab is selected in the Pan

  package Swings;

import java.awt.Color;
import javax.swing.*;

public class TabbedPaneColorsExample {
    JFrame frame;

    TabbedPaneColorsExample() {
        frame = new JFrame("TabbedPane Colors Example");

        // Panels with background colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // Add tabbed pane to frame
        frame.add(tabbedPane);

        // Frame setup
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabbedPaneColorsExample::new);
    }
}
