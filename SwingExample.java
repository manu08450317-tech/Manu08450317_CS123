
/*5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the
countries on console whenever the countries are selected on the list.*/




package Swing;


import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class SwingExample {
	
	    SwingExample() {
	        // Create a new JFrame container.
	        JFrame jfrm = new JFrame("A Simple Swing Application");

	        // Give the frame an initial size.
	        jfrm.setSize(600, 150);

	        // Terminate the program when the user closes the application.
	        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create a text-based label.
	        JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming!");

	        // Set properties for label
	        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));
	        jlab.setForeground(new Color(0, 0, 255));

	        // Add the label to the content pane.
	        jfrm.add(jlab);

	        // Display the frame.
	        jfrm.setVisible(true);
	    }

	    public static void main(String args[]) {
	        // Create the frame on the event dispatching thread.
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new SwingExample();
	            }
	        });
	    
	}

}
