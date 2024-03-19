package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DeveloperDashboard extends JFrame {

    // Set IntelliJ-like colors
    Color darkBackground = new Color(43, 43, 43);
    Color buttonColor = new Color(91, 94, 99);
    static Color buttonHoverColor = new Color(117, 120, 125);
    Color buttonPressedColor = new Color(75, 78, 82);
    Color textColor = new Color(214, 215, 216);
    Color toolbarBorderColor = new Color(60, 63, 65);
    Color toolbarBackground = new Color(60, 63, 65);

    private static int globalFontSize = 16;
    private static Font globalFont = new Font("Arial", Font.PLAIN, globalFontSize);

    private static JButton terminalButton; // Declare terminalButton as an instance variable

    public static Font getGlobalFont() {
        return globalFont;
    }

    public static void setGlobalFont(Font globalFont) {
        DeveloperDashboard.globalFont = globalFont;
    }

    public static int getGlobalFontSize() {
        return globalFontSize;
    }
    public static void setGlobalFontSize(int newSize) {
        globalFontSize = newSize;
    }


    public DeveloperDashboard() {
        setTitle("Developer Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        setLocation(0, 0);

        UIManager.put("Panel.background", darkBackground);
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Button.foreground", textColor);
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(10, 20, 10, 20));
        UIManager.put("Label.foreground", textColor);
        UIManager.put("ToolBar.background", darkBackground);
        UIManager.put("ToolBar.border", BorderFactory.createMatteBorder(0, 0, 1, 0, toolbarBorderColor));

        // Set layout
        getContentPane().setLayout(new BorderLayout());

        // Create panel to hold buttons with GridLayout
//        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 35, 5));
        buttonPanel.setBackground(darkBackground); // Set background color
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        // Create buttons
        terminalButton = new JButton("");
        JButton resourceButton = new JButton("Resource Monitoring");
        JButton documentationButton = new JButton("Documentation");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");
        JButton button6 = new JButton("Button 6");
        JButton button7 = new JButton("Button 7");
        JButton button8 = new JButton("Button 8");

        ArrayList<JButton> mainButtons = new ArrayList<>();

        mainButtons.add(documentationButton);
        mainButtons.add(terminalButton);
        mainButtons.add(button4);
        mainButtons.add(resourceButton);
        mainButtons.add(button5);
        mainButtons.add(button7);
        mainButtons.add(button6);
        mainButtons.add(button8);

        for (int i = 0; i < mainButtons.size(); i++) {

            JButton currentBttn = mainButtons.get(i);
            currentBttn.setOpaque(true);
            currentBttn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            currentBttn.setFont(globalFont);
            currentBttn.setBackground(darkBackground);
            currentBttn.setForeground(textColor);
            currentBttn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            buttonPanel.add(currentBttn);
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
        terminalButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        resourceButton.setBackground(Color.BLUE);

        // Create toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setForeground(new Color(0, 0, 0));
        toolBar.setBackground(toolbarBackground);
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        Icon settingsIcon = new ImageIcon("src/main/resources/images/Screenshot 2024-03-14 at 19.23.03.png");

        JButton settingsButton = new JButton(settingsIcon);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setToolTipText("Settings");

        // Add filler to create padding
        Component rigidArea = Box.createRigidArea(new Dimension(20, 0));

        JButton action1 = new JButton("Action 1");
        JButton action2 = new JButton("Action 2");
        JButton action3 = new JButton("Action 3");

        ArrayList<JButton> toolbarButtons = new ArrayList<>();
        toolbarButtons.add(settingsButton);
        toolbarButtons.add(action1);
        toolbarButtons.add(action2);
        toolbarButtons.add(action3);

        for (int i = 0; i < toolbarButtons.size(); i++) {

            JButton currentButton = toolbarButtons.get(i);

            currentButton.setBackground(toolbarBackground);
            currentButton.setOpaque(true);
            currentButton.setFont(globalFont);
            toolBar.add(currentButton);
            if (i == 0) {
                toolBar.add(rigidArea);
            }

            if(currentButton != settingsButton){
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

            currentButton.addMouseListener(new CustomCursorAdapter());
        }

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsWindow settingsWindow = new SettingsWindow(darkBackground, buttonHoverColor, buttonPressedColor, textColor, globalFont);
                settingsWindow.setVisible(true);
            }
        });

        // Minimize/Maximize button
        JButton minimizeMaximizeButton = new JButton("-");
        minimizeMaximizeButton.setForeground(textColor);
        minimizeMaximizeButton.setBackground(toolbarBackground);
        minimizeMaximizeButton.setFocusPainted(false);
        minimizeMaximizeButton.setBorderPainted(false);
        minimizeMaximizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Font globalFont = DeveloperDashboard.getGlobalFont();
                Font newFont;

                if (getSize().width == 800) {
                    setPreferredSize(new Dimension(550, 250));
                    toolBar.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
                    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//                    buttonPanel.setLayout(new GridLayout(2, 3, 35, 5));
                    minimizeMaximizeButton.setText("+");
                    pack();

                    newFont = globalFont.deriveFont(Font.PLAIN, 14);

                    ImageIcon resizedSettingsIcon = new ImageIcon(((ImageIcon) settingsIcon).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                    settingsButton.setIcon(resizedSettingsIcon);

                } else {
                    setPreferredSize(new Dimension(800, 500));
                    toolBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//                    buttonPanel.setLayout(new GridLayout(2, 3, 35, 5));
                    minimizeMaximizeButton.setText("-");
                    pack();

                    newFont = globalFont.deriveFont(Font.PLAIN, 16);
                    ImageIcon resizedSettingsIcon = new ImageIcon(((ImageIcon) settingsIcon).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                    settingsButton.setIcon(resizedSettingsIcon);
                }

                DeveloperDashboard.setGlobalFont(newFont);

                // Update UI for already displayed components
                for (Window window : Window.getWindows()) {
                    SwingUtilities.updateComponentTreeUI(window);
                    window.repaint();
                    recursivelyRepaintComponents(window, newFont);
                }

                repaintCustomButtons();

            }
        });

        minimizeMaximizeButton.addMouseListener(new CustomCursorAdapter());

        // Add minimize/maximize button to toolbar
        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(minimizeMaximizeButton);

        // Add grid button panel below
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(toolBar, BorderLayout.NORTH);

        pack();
//        setLocationRelativeTo(null); // Center the frame
    }

    public static class CustomCursorAdapter extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            ((javax.swing.JButton) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((javax.swing.JButton) e.getSource()).setCursor(Cursor.getDefaultCursor());
        }
    }

    public static void recursivelyRepaintComponents(Component component, Font font) {
        if (component instanceof JComponent) {
            JComponent jComponent = (JComponent) component;
            jComponent.setFont(font);
            jComponent.repaint();
        }

        if (component instanceof Container) {
            Container container = (Container) component;
            Component[] components = container.getComponents();
            for (Component child : components) {
                recursivelyRepaintComponents(child, font);
            }
        }
    }

    public static void repaintCustomButtons(){
        // Reapply custom UI for terminalButton
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/terminal-icon-b.png");
        CustomButtonUI.applyCustomUI(terminalButton, backgroundImage.getImage(), buttonHoverColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeveloperDashboard dashboard = new DeveloperDashboard();
            dashboard.setVisible(true);
        });
    }
}
