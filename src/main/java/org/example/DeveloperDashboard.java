package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeveloperDashboard extends JFrame {

    // Set IntelliJ-like colors
    Color darkBackground = new Color(43, 43, 43);
    Color buttonColor = new Color(91, 94, 99);
    Color buttonHoverColor = new Color(117, 120, 125);
    Color buttonPressedColor = new Color(75, 78, 82);
    Color textColor = new Color(214, 215, 216);
    Color toolbarBorderColor = new Color(60, 63, 65);

    Color toolbarBackground = new Color(60, 63, 65);

    public DeveloperDashboard() {
        setTitle("Developer Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        UIManager.put("Panel.background", darkBackground);
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Button.foreground", textColor);
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(10, 20, 10, 20));
        UIManager.put("Label.foreground", textColor);
        UIManager.put("ToolBar.background", darkBackground);
        UIManager.put("ToolBar.border", BorderFactory.createMatteBorder(0, 0, 1, 0, toolbarBorderColor));

        // Apply IntelliJ font
        Font font = new Font("JetBrains Mono", Font.PLAIN, 14);

        // Create buttons
        JButton terminalButton = new JButton("Terminal");
        JButton resourceButton = new JButton("Resource Monitoring");
        JButton documentationButton = new JButton("Documentation");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");
        JButton button6 = new JButton("Button 6");
        JButton button7 = new JButton("Button 7");
        JButton button8 = new JButton("Button 8");

        ArrayList<JButton> mainButtons = new ArrayList<>();
        mainButtons.add(terminalButton);
        mainButtons.add(resourceButton);
        mainButtons.add(documentationButton);
        mainButtons.add(button4);
        mainButtons.add(button5);
        mainButtons.add(button6);
        mainButtons.add(button7);
        mainButtons.add(button8);

        for(int i = 0; i < mainButtons.size(); i++){

            JButton currentBttn = mainButtons.get(i);
            currentBttn.setOpaque(true);
            currentBttn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            currentBttn.setFont(font);
            currentBttn.setBackground(darkBackground);
            currentBttn.setForeground(textColor);
            currentBttn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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

        terminalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TerminalWidget().initializeUI();
            }
        });

        // Load the image
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/terminal-icon-b.png"); // Adjust the path to your image
        CustomButtonUI.applyCustomUI(terminalButton, backgroundImage.getImage(), buttonHoverColor);

        // Set the background image
        //        terminalButton.setIcon(backgroundImage);

        resourceButton.setBackground(Color.BLUE);

        // Create toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setForeground(new Color(0, 0, 0));
        toolBar.setBackground(toolbarBackground);
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        Icon settingsIcon = new ImageIcon("src/main/resources/images/Screenshot 2024-03-14 at 19.23.03.png");

        JButton settingsButton = new JButton(settingsIcon);
        settingsButton.setMaximumSize(new Dimension(31, 32));
        settingsButton.setToolTipText("Settings");
        toolBar.add(settingsButton);

        JButton action1 = new JButton("Action 1");
        JButton action2 = new JButton("Action 2");
        JButton action3 = new JButton("Action 3");

        ArrayList<JButton> toolbarButtons = new ArrayList<>();
        toolbarButtons.add(settingsButton);
        toolbarButtons.add(action1);
        toolbarButtons.add(action2);
        toolbarButtons.add(action3);

        for(int i = 0; i < toolbarButtons.size(); i++) {

            JButton currentButton = toolbarButtons.get(i);

            currentButton.setBackground(toolbarBackground);
            currentButton.setOpaque(true);
            currentButton.setFont(font);
            toolBar.add(currentButton);

            currentButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    currentButton.setBackground(buttonHoverColor);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    currentButton.setBackground(toolbarBackground);
                }

                public void mousePressed(java.awt.event.MouseEvent evt) {
                    currentButton.setBackground(buttonPressedColor);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    currentButton.setBackground(buttonHoverColor);
                }
            });
        }

        // Set layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(toolBar, BorderLayout.NORTH);

        // Create panel to hold buttons with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(darkBackground); // Set background color
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

// Add buttons with IntelliJ font
        buttonPanel.add(documentationButton);
        buttonPanel.add(terminalButton);
        buttonPanel.add(button4);
        buttonPanel.add(resourceButton); // Adding Resource Monitoring button as the 3rd button
        buttonPanel.add(button5);
        buttonPanel.add(button7);
        buttonPanel.add(button6);
        buttonPanel.add(button8);

        // Add grid button panel below
        getContentPane().add(buttonPanel, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeveloperDashboard dashboard = new DeveloperDashboard();
            dashboard.setVisible(true);
        });
    }
}
