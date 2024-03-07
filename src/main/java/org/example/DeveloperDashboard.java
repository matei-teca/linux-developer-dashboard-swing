package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeveloperDashboard extends JFrame {
    private JLabel welcomeLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeveloperDashboard().initializeUI();
        });
    }

    private void initializeUI() {
        setTitle("Developer Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create and customize welcome label
        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add label to content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(welcomeLabel, BorderLayout.CENTER);

        // Update time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeLabel.setText(getWelcomeMessage());
            }
        });
        timer.start();

        setVisible(true); // Make the frame visible
    }

    // Method to generate welcome message with current date and time
    private String getWelcomeMessage() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Welcome! Current Date and Time: " + now.format(formatter);
    }
}
