/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).*/




package Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageButtonExample {
    JLabel messageLabel;

    ImageButtonExample() {
        // Create frame
        JFrame frame = new JFrame("Image Button Example");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label to display messages
        messageLabel = new JLabel();
        messageLabel.setBounds(50, 250, 400, 50);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Load images (ensure these files exist in your project folder)
        ImageIcon digitalClockIcon = new ImageIcon("digital_clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hour_glass.png");

        // Buttons with images
        JButton digitalClockButton = new JButton(digitalClockIcon);
        digitalClockButton.setBounds(50, 50, 150, 150);

        JButton hourGlassButton = new JButton(hourGlassIcon);
        hourGlassButton.setBounds(250, 50, 150, 150);

        // Event handling
        digitalClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Digital Clock is pressed");
            }
        });

        hourGlassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Hour Glass is pressed");
            }
        });

        // Add components to frame
        frame.add(digitalClockButton);
        frame.add(hourGlassButton);
        frame.add(messageLabel);

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}
