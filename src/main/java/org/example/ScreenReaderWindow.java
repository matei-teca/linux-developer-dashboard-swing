package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ScreenReaderWindow extends JFrame {
    public ScreenReaderWindow(Color darkBackground, Color buttonHoverColor, Color buttonPressedColor, Color textColor, Font font) {
        setTitle("Screen Reader Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /// for updateScreenReaderMode
        JCheckBox screenReaderCheckBox = new JCheckBox("Screen Reader Mode");
        screenReaderCheckBox.setOpaque(true);
        screenReaderCheckBox.setPreferredSize(new Dimension(100, 75));
        
        screenReaderCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle screen reader mode
                boolean screenReaderMode = screenReaderCheckBox.isSelected();
                updateScreenReaderMode(screenReaderMode);

            }
        });

        mainPanel.add(screenReaderCheckBox);

        /// for speakText
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(200, 100));
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        JButton speakButton = new JButton("Speak");

        speakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textToRead = textArea.getText(); // Read text from JTextArea
                speakText(textToRead);
            }
        });

        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        mainPanel.add(speakButton, BorderLayout.SOUTH);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateScreenReaderMode(boolean enabled) {
        // Implement logic to modify component behavior based on screen reader mode
        if (enabled) {
            // For example, set accessible names and descriptions for components
            // setAccessibleNamesForComponents();
            // setAccessibleDescriptionsForComponents();
            // Modify visual effects or hide non-essential visual elements
            // adjustVisualEffects();
            // Ensure proper keyboard navigation
            // adjustKeyboardNavigation();
            JOptionPane.showMessageDialog(this, "Screen Reader Mode enabled");
        } else {
            // Reset component behavior to default
            JOptionPane.showMessageDialog(this, "Screen Reader Mode disabled");
        }
    }

    // Method to trigger text-to-speech functionality
    private void speakText(String text) {
        try {
            String[] command = {"say", text};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
