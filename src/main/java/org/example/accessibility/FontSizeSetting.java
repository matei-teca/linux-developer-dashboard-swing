package org.example.accessibility;

import org.example.DeveloperDashboard;
import org.example.SettingsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeSetting {
    public FontSizeSetting() {}

    public static ActionListener initialize() {

        return new ActionListener() {
            Font increasedFont = new Font("Arial", Font.PLAIN, 20);
            @Override
            public void actionPerformed(ActionEvent e) {

                // Create a spinner for input with default globalFont size 20
                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(20, 6, 72, 1);
                JSpinner spinner = new JSpinner(spinnerModel);
                JComponent editor = spinner.getEditor();
                if (editor instanceof JSpinner.DefaultEditor) {
                    ((JSpinner.DefaultEditor) editor).getTextField().setFont(increasedFont);
                }

                // Create a custom OK button
                JButton okButton = new JButton("OK");
                okButton.setFont(increasedFont);
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int newSize = (int) spinner.getValue();
                        new SettingsWindow().changeTextSize(newSize);
                    }
                });

                // Create a reset button
                JButton resetButton = new JButton("Reset");
                resetButton.setFont(increasedFont);
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Reset the globalFont size to default value
                        new SettingsWindow().changeTextSize(16);
                        spinner.setValue(16);

                        DeveloperDashboard.setIsAccessibilityActivated(false);
                    }
                });

                // Create the option pane with custom buttons
                int option = JOptionPane.showOptionDialog(
                        null,
                        spinner,
                        "Enter the new globalFont size:",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{okButton, resetButton},
                        null);
            }
        };
    }
}
