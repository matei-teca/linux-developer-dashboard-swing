package org.example;

import org.example.accessibility.FontSizeSetting;
import org.example.accessibility.cscreen_reader.CScreenReaderWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccessibilitySettingsWindow extends JFrame {

    private CScreenReaderWindow screenReader;

    public AccessibilitySettingsWindow(Color darkBackground, Color buttonHoverColor, Color buttonPressedColor, Color textColor, Font globalFont) {
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

        button1.addActionListener(FontSizeSetting.initialize());

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestingAccessibility settingsWindow = new TestingAccessibility(darkBackground, buttonHoverColor, buttonPressedColor, textColor, globalFont);
                settingsWindow.setVisible(true);

//                Component parent = AccessibilitySettingsWindow.this;
//                settingsWindow.setLocationRelativeTo(null);
//                settingsWindow.setLocation(parent.getX() + 100, parent.getY() -50);
            }
        });

        screenReader = new CScreenReaderWindow();

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CScreenReaderWindow cScreenReaderWindow = new CScreenReaderWindow(darkBackground, buttonHoverColor, buttonPressedColor, textColor, globalFont);
                cScreenReaderWindow.setVisible(true);

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
