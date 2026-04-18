package Swing;

import java.awt.Color;
import javax.swing.*;

public class ColorTabbedPaneExample {
    JFrame frame;

    ColorTabbedPaneExample() {
        frame = new JFrame("Color TabbedPane Example");

        // Create panels with different background colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs with panels
        tabbedPane.add("Cyan", cyanPanel);
        tabbedPane.add("Magenta", magentaPanel);
        tabbedPane.add("Yellow", yellowPanel);

        // Add tabbed pane to frame
        frame.add(tabbedPane);

        // Frame settings
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ColorTabbedPaneExample();
    }
}
