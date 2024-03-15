package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessibilitySettingsWindow extends JFrame {

    public AccessibilitySettingsWindow() {
        setTitle("Accessibility Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create accessibility settings buttons
        JButton button1 = new JButton("Setting 1");
        JButton button2 = new JButton("Setting 2");
        JButton button3 = new JButton("Setting 3");
        JButton button4 = new JButton("Setting 4");
        JButton button5 = new JButton("Setting 5");

        // Add action listeners to accessibility settings buttons (if needed)
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement action for Setting 1
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement action for Setting 2
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement action for Setting 3
            }
        });

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the window
    }
}
