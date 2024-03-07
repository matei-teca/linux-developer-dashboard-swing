package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeveloperDashboard extends JFrame {

    // used Window Builder
	public DeveloperDashboard() {
		getContentPane().setBackground(new Color(0, 252, 255));
	}

    private JLabel welcomeLabel;
    private JTextArea terminalTextArea;
    private JScrollPane terminalScrollPane;

    // checked ok practice
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeveloperDashboard().initializeUI();
        });
    }

    private void initializeUI() {
        setTitle("Developer Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create and customize welcome label
        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create terminal text area
        terminalTextArea = new JTextArea();
        terminalTextArea.setBackground(Color.darkGray);
        terminalTextArea.setForeground(Color.white); // Set text color to white
        terminalTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        terminalTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        terminalTextArea.setEditable(false);
        terminalScrollPane = new JScrollPane(terminalTextArea);

        // Create panel to hold command input field and execute button
        JPanel inputPanel = new JPanel();
        JTextField commandInputField = new JTextField(30);
        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userCommand = commandInputField.getText().trim();
                if (!userCommand.isEmpty()) {
                    executeCommand(userCommand);
                    commandInputField.setText("");
                }
            }
        });
        inputPanel.add(commandInputField);
        inputPanel.add(executeButton);

        // Add components to content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(welcomeLabel, BorderLayout.NORTH);
        getContentPane().add(terminalScrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        // Update time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeLabel.setText(getWelcomeMessage());
            }
        });
        timer.start();

        setVisible(true); // Make the frame visible
    }

    // Method to generate welcome message with current date and time
    private String getWelcomeMessage() {
        return "Welcome! Current Date and Time: " + java.time.LocalDateTime.now();
    }

    // Maintain the current directory
    private File currentDirectory = new File(System.getProperty("user.home"));

    // Method to execute command and display output in terminal
    private void executeCommand(String userCommand) {
        terminalTextArea.append("$ " + userCommand + "\n");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", "cd " + currentDirectory.getAbsolutePath() + " && " + userCommand);
            processBuilder.directory(currentDirectory);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                terminalTextArea.append(line + "\n");
            }
            reader.close();
            process.waitFor();

            // cd command
            if (userCommand.startsWith("cd ")) {
                String[] parts = userCommand.split("\\s+", 2); // Split by whitespace, limit to 2 parts
                String directoryPath = parts[1];
                File newDirectory = new File(currentDirectory, directoryPath);
                if (newDirectory.isDirectory()) {
                    currentDirectory = newDirectory.getCanonicalFile();
                } else {
                    terminalTextArea.append("Invalid directory: " + directoryPath + "\n");
                }
            }

            // open command for macOS
            else if (userCommand.startsWith("open ")) {
                String[] parts = userCommand.split("\\s+", 2); // Split by whitespace, limit to 2 parts
                String filePath = parts[1];
                File fileToOpen = new File(currentDirectory, filePath);
                if (fileToOpen.isFile()) {
                    Process openProcess = Runtime.getRuntime().exec(new String[]{"open", fileToOpen.getAbsolutePath()});
                    openProcess.waitFor();
                } else {
                    terminalTextArea.append("Invalid file: " + filePath + "\n");
                }
            }

            // open command for Linux
            else if (userCommand.startsWith("xdg-open ")) {
                String[] parts = userCommand.split("\\s+", 2); // Split by whitespace, limit to 2 parts
                String filePath = parts[1];
                File fileToOpen = new File(currentDirectory, filePath);
                if (fileToOpen.isFile()) {
                    Process openProcess = Runtime.getRuntime().exec(new String[]{"xdg-open", fileToOpen.getAbsolutePath()});
                    openProcess.waitFor();
                } else {
                    terminalTextArea.append("Invalid file: " + filePath + "\n");
                }
            }
        } catch (IOException | InterruptedException ex) {
            terminalTextArea.append("Error executing command: " + ex.getMessage() + "\n");
        }
    }

}
