package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SettingsWindow extends JFrame {

    public SettingsWindow() throws HeadlessException {
    }

    public SettingsWindow(Color darkBackground, Color buttonHoverColor, Color buttonPressedColor, Color textColor, Font globalFont) {
        setTitle("Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create main buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        JButton accessibilitySettingsButton = new JButton("Accessibility Settings");

        ArrayList<JButton> settingsButtons = new ArrayList<>();
        settingsButtons.add(button1);
        settingsButtons.add(button2);
        settingsButtons.add(button3);
        settingsButtons.add(button4);
        settingsButtons.add(accessibilitySettingsButton);

        for(int i = 0; i < settingsButtons.size(); i++) {
            JButton currentBttn = settingsButtons.get(i);

            currentBttn.setOpaque(true);
            currentBttn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            currentBttn.setFont(globalFont);
            currentBttn.setBackground(darkBackground);
            currentBttn.setForeground(textColor);
            currentBttn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            mainPanel.add(currentBttn);
            currentBttn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    currentBttn.setBackground(buttonHoverColor);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    currentBttn.setBackground(darkBackground);
                }

                public void mousePressed(java.awt.event.MouseEvent evt) {
                    currentBttn.setBackground(buttonPressedColor);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    currentBttn.setBackground(buttonHoverColor);
                }
            });
        }

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Add action listeners to main buttons (if needed)
        accessibilitySettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccessibilitySettingsWindow settingsWindow = new AccessibilitySettingsWindow(darkBackground, buttonHoverColor, buttonPressedColor, textColor, globalFont);
                settingsWindow.setVisible(true);

//                Component parent = SettingsWindow.this;
//                settingsWindow.setLocationRelativeTo(null);
//                settingsWindow.setLocation(parent.getX() + 100, parent.getY() -50);
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public void changeTextSize(int newSize) {
        Font globalFont = DeveloperDashboard.getGlobalFont();
        Font newFont = globalFont.deriveFont(Font.PLAIN, newSize);
        DeveloperDashboard.setGlobalFont(newFont);

        // Update UI for already displayed components
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
            window.repaint();
            DeveloperDashboard.recursivelyRepaintComponents(window, newFont);
        }
    }

}
