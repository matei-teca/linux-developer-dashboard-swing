package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeveloperDashboard extends JFrame {

    public DeveloperDashboard() {
        setTitle("Developer Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create a button to open the terminal widget
        JButton openTerminalButton = new JButton("Open Terminal Widget");
        openTerminalButton.setBackground(new Color(255, 147, 0));
        openTerminalButton.setForeground(Color.BLACK);
        openTerminalButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Add ActionListener to the button
        openTerminalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the DeveloperDashboard
                new TerminalWidget().initializeUI();
                dispose(); // Close the landing screen
            }
        });

        // Add the button to the content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(openTerminalButton);
        
        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeveloperDashboard();
        });
    }
}
