package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeveloperDashboard extends JFrame {
    public DeveloperDashboard() {
        setTitle("Developer Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        // Set IntelliJ-like colors
        Color darkBackground = new Color(43, 43, 43);
        Color buttonColor = new Color(91, 94, 99);
        Color buttonHoverColor = new Color(117, 120, 125);
        Color buttonPressedColor = new Color(75, 78, 82);
        Color textColor = new Color(214, 215, 216);
        Color toolbarBorderColor = new Color(60, 63, 65);

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

        // Apply IntelliJ font and button effects
        terminalButton.setFont(font);
        terminalButton.setFocusPainted(false);
        terminalButton.setBackground(buttonColor);
        terminalButton.setForeground(textColor);
        terminalButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        terminalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                terminalButton.setBackground(buttonHoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                terminalButton.setBackground(buttonColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                terminalButton.setBackground(buttonPressedColor);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                terminalButton.setBackground(buttonHoverColor);
            }
        });

        terminalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if an instance of TerminalWidget is already open
                if (!TerminalWidget.isDashboardOpen()) {
                    new TerminalWidget().initializeUI();
                }
            }
        });


        // Apply same settings for other buttons
        resourceButton.setFont(font);
        resourceButton.setFocusPainted(false);
        resourceButton.setBackground(buttonColor);
        resourceButton.setForeground(textColor);
        resourceButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        resourceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resourceButton.setBackground(buttonHoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resourceButton.setBackground(buttonColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                resourceButton.setBackground(buttonPressedColor);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resourceButton.setBackground(buttonHoverColor);
            }
        });

        documentationButton.setFont(font);
        documentationButton.setFocusPainted(false);
        documentationButton.setBackground(buttonColor);
        documentationButton.setForeground(textColor);
        documentationButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        documentationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                documentationButton.setBackground(buttonHoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                documentationButton.setBackground(buttonColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                documentationButton.setBackground(buttonPressedColor);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                documentationButton.setBackground(buttonHoverColor);
            }
        });

        // Create toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false); // Make the toolbar non-movable
        toolBar.setOpaque(false); // Make the toolbar transparent
        toolBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding
        // Add toolbar buttons
        toolBar.add(new JLabel("Toolbar: ")); // Add label for clarity
        // Add toolbar buttons with IntelliJ font
        JButton action1 = new JButton("Action 1");
        action1.setFont(font);
        JButton action2 = new JButton("Action 2");
        action2.setFont(font);
        JButton action3 = new JButton("Action 3");
        action3.setFont(font);
        toolBar.add(action1);
        toolBar.add(action2);
        toolBar.add(action3);

        // Set layout
        getContentPane().setLayout(new BorderLayout());

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBackground(darkBackground); // Set background color
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding
        // Add buttons with IntelliJ font
        buttonPanel.add(terminalButton);
        buttonPanel.add(resourceButton);
        buttonPanel.add(documentationButton);

        // Add components to the frame
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(toolBar, BorderLayout.NORTH);

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
