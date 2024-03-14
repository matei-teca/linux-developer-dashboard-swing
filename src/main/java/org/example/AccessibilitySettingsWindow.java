package org.example;

import javax.swing.*;
import java.awt.*;

public class AccessibilitySettingsWindow extends JFrame {

    public AccessibilitySettingsWindow() {
        setTitle("Accessibility Settings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create and add your accessibility settings components here

        pack();
        setLocationRelativeTo(null); // Center the window
    }
}
