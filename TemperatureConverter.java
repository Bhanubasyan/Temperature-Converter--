import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField temperatureInput;
    private JComboBox<String> unitSelection;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverter() {
        // Set up the frame
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        temperatureInput = new JTextField(10);
        String[] units = {"Celsius", "Fahrenheit"};
        unitSelection = new JComboBox<>(units);
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Temperature:"));
        panel.add(temperatureInput);
        panel.add(unitSelection);
        panel.add(convertButton);
        panel.add(resultLabel);
        
        add(panel);

        // Add action listener to the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            // Get input values
            double temperature = Double.parseDouble(temperatureInput.getText());
            String unit = (String) unitSelection.getSelectedItem();
            double convertedTemperature;

            // Perform conversion
            if ("Celsius".equals(unit)) {
                convertedTemperature = (temperature * 9 / 5) + 32; // Celsius to Fahrenheit
                resultLabel.setText(String.format("Result: %.2f °F", convertedTemperature));
            } else {
                convertedTemperature = (temperature - 32) * 5 / 9; // Fahrenheit to Celsius
                resultLabel.setText(String.format("Result: %.2f °C", convertedTemperature));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}
