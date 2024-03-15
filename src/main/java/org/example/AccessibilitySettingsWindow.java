package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccessibilitySettingsWindow extends JFrame {

    public AccessibilitySettingsWindow(Color darkBackground, Color buttonHoverColor, Color buttonPressedColor, Color textColor, Font font) {
        setTitle("Accessibility Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create accessibility settings buttons
        JButton button1 = new JButton("Setting 1");
        JButton button2 = new JButton("Setting 2");
        JButton button3 = new JButton("Setting 3");

        ArrayList<JButton> aSettingsButtons = new ArrayList<>();
        aSettingsButtons.add(button1);
        aSettingsButtons.add(button2);
        aSettingsButtons.add(button3);


        for(int i = 0; i < aSettingsButtons.size(); i++) {
            JButton currentBttn = aSettingsButtons.get(i);

            currentBttn.setOpaque(true);
            currentBttn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            currentBttn.setFont(font);
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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a spinner for input
                JSpinner spinner = new JSpinner(new SpinnerNumberModel(16, 6, 72, 1));

                // Create a custom OK button
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int newSize = (int) spinner.getValue();
                        new SettingsWindow().changeTextSize(newSize);
                    }
                });

                // Create a reset button
                JButton resetButton = new JButton("Reset");
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Reset the font size to default value
                        new SettingsWindow().changeTextSize(16);
                    }
                });

                // Create the option pane with custom buttons
                int option = JOptionPane.showOptionDialog(
                        null,
                        spinner,
                        "Enter the new font size:",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{okButton, resetButton},
                        null);
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


        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the window
    }

}
