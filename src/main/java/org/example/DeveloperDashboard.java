import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeveloperDashboard extends JFrame {
    private JLabel welcomeLabel;
    private JTextArea terminalTextArea;
    private JScrollPane terminalScrollPane;

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
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create terminal text area
        terminalTextArea = new JTextArea();
        terminalTextArea.setEditable(false);
        terminalTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        terminalScrollPane = new JScrollPane(terminalTextArea);

        // Create panel to hold command input field and execute button
        JPanel inputPanel = new JPanel();
        JTextField commandInputField = new JTextField(30);
        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandInputField.getText().trim();
                if (!command.isEmpty()) {
                    executeCommand(command);
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

    // Method to execute command and display output in terminal
    private void executeCommand(String command) {
        terminalTextArea.append("$ " + command + "\n");
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                terminalTextArea.append(line + "\n");
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException ex) {
            terminalTextArea.append("Error executing command: " + ex.getMessage() + "\n");
        }
    }
}
