package org.example.cscreen_reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CScreenReaderWindow extends JFrame {
//    private Toolkit toolkit;

    public CScreenReaderWindow() {}

    public CScreenReaderWindow(Color darkBackground, Color buttonHoverColor, Color buttonPressedColor, Color textColor, Font globalFont) {

        setTitle("Custom Screen Reader Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        toolkit = Toolkit.getDefaultToolkit();

        JButton readButton = new JButton("Recite");
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readText("Testing");
            }
        });

        mainPanel.add(readButton, BorderLayout.SOUTH);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    // Method to read out text using the system's default screen reader
    public void readText(String text) {
//        toolkit.getSystemEventQueue().postEvent(new CScreenReaderEvent(text));

        String osName = System.getProperty("os.name").toLowerCase();
        String[] command;
        if (osName.contains("mac") || osName.contains("darwin")) {
            // macOS
            command = new String[]{"say", text};
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            // Linux
            command = new String[]{"espeak", text};
        } else {
            // Unsupported OS
            System.err.println("Unsupported operating system: " + osName);
            System.out.println("problem");

            return; // Exit the method or handle accordingly
        }

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
