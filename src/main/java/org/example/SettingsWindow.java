package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    public SettingsWindow() {
        setTitle("Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create main buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton accessibilitySettingsButton = new JButton("Accessibility Settings");

        // Add action listeners to main buttons (if needed)

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(accessibilitySettingsButton);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Add action listeners to main buttons (if needed)
        accessibilitySettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccessibilitySettingsWindow settingsWindow = new AccessibilitySettingsWindow();
                settingsWindow.setVisible(true);
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window
    }
}
