5b. Develop a Swing program in Java to create a Tabbed Pan of RED, BLUE and GREEN and display
the concerned color whenever the specific tab is selected in the Pan.

  package Swings;

import java.awt.Color;
import javax.swing.*;

public class TabbedPaneExample {
    JFrame f;

    TabbedPaneExample() {
        f = new JFrame("TabbedPane Example");

        // Panels with different background colors
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.GREEN);

        // Create tabbed pane
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("BLUE", p1);
        tp.addTab("RED", p2);
        tp.addTab("GREEN", p3);

        // Add tabbed pane to frame
        f.add(tp);

        // Frame setup
        f.setSize(400, 400);
        f.setLocationRelativeTo(null); // Center window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabbedPaneExample::new);
    }
}
