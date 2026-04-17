4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).
  package Swings;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageButtonExample {
    JLabel messageLabel;

    ImageButtonExample() {
        // Create frame
        JFrame frame = new JFrame("Image Button Example");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label to display messages
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setBounds(50, 50, 500, 50);
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        // Buttons with images
        JButton digitalClockButton = new JButton("Digital Clock", new ImageIcon("digital_clock.png"));
        JButton hourGlassButton = new JButton("Hour Glass", new ImageIcon("hour_glass.png"));

        // Set button positions
        digitalClockButton.setBounds(100, 150, 180, 80);
        hourGlassButton.setBounds(320, 150, 180, 80);

        // Add action listeners
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
        frame.add(messageLabel);
        frame.add(digitalClockButton);
        frame.add(hourGlassButton);

        // Center window and make visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageButtonExample::new);
    }
}
