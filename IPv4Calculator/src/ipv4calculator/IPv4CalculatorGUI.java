/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipv4calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPv4CalculatorGUI extends JFrame {

    private JTextField ipField;
    private JTextField maskField;
    private JTextArea resultArea;
    private JButton calculateButton;

    public IPv4CalculatorGUI() {
        setTitle("Calculadora IPv4");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta y campo para Dirección IP
        JLabel ipLabel = new JLabel("Dirección IP:");
        ipLabel.setBounds(10, 10, 100, 25);
        add(ipLabel);

        ipField = new JTextField();
        ipField.setBounds(120, 10, 150, 25);
        add(ipField);

        // Etiqueta y campo para Máscara
        JLabel maskLabel = new JLabel("Máscara (CIDR):");
        maskLabel.setBounds(10, 40, 100, 25);
        add(maskLabel);

        maskField = new JTextField();
        maskField.setBounds(120, 40, 50, 25);
        add(maskField);

        // Botón Calcular
        calculateButton = new JButton("Calcular");
        calculateButton.setBounds(10, 70, 100, 25);
        add(calculateButton);

        // Área de texto para resultados
        resultArea = new JTextArea();
        resultArea.setBounds(10, 100, 600, 250);
        resultArea.setEditable(false);
        add(resultArea);

        // Acción del botón "Calcular"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        try {
            String ip = ipField.getText();
            String mask = maskField.getText();

            // Crear una instancia de IPv4Address
            IPv4Address ipv4 = new IPv4Address(ip, mask);

            // Mostrar los resultados
            resultArea.setText(
                    "Dirección IP: " + ipv4.getIPAddress() + " (" + ipv4.getBinaryAddress() + ")\n" +
                    "Máscara de Red: " + ipv4.getDecimalMask() + " (" + ipv4.getBinaryMask() + ") /" + ipv4.getCIDRMask() + "\n" +
                    "Dirección de Red: " + ipv4.getDecimalNetwork() + " (" + ipv4.getBinaryNetwork() + ")\n" +
                    "Dirección de Broadcast: " + ipv4.getDecimalBroadcast() + " (" + ipv4.getBinaryBroadcast() + ")\n" +
                    "Primer Host: " + ipv4.getDecimalFirstHost() + " (" + ipv4.getBinaryFirstHost() + ")\n" +
                    "Último Host: " + ipv4.getDecimalLastHost() + " (" + ipv4.getBinaryLastHost() + ")\n" +
                    "Máximo Número de Hosts: " + ipv4.getMaxHosts() + "\n" +
                    "Tipo de Red: " + ipv4.getType()
            );
        } catch (Exception ex) {
            resultArea.setText("Error: Verifica los datos ingresados.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IPv4CalculatorGUI app = new IPv4CalculatorGUI();
            app.setVisible(true);
        });
    }
}
