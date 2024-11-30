/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipv4calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPv4CalculatorGUI extends JFrame {
    // Definición de los componentes gráficos.
    private JTextField ipField;
    private JTextField maskField;
    private JTextArea resultArea;
    private JButton calculateButton;

    // Constructor.
    public IPv4CalculatorGUI() {
        // Configuración de la ventana.
        setTitle("Calculadora IPv4");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada y el botón.
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        // Etiquetas y campos para Dirección IP y Máscara.
        inputPanel.add(new JLabel("Dirección IP y Máscara (ej. 192.168.0.1/24):"));
        ipField = new JTextField();
        inputPanel.add(ipField);

        // Botón para calcular.
        calculateButton = new JButton("Calcular");
        inputPanel.add(calculateButton);

        // Área de texto para mostrar resultados.
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Agregar panel de entrada y área de resultados a la ventana.
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Acción del botón Calcular.
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultados();
            }
        });
    }

    // Método para realizar los cálculos y mostrar los resultados en la interfaz.
    private void calcularResultados() {
        try {
            // Obtener IP y máscara ingresados por el usuario.
            String input = ipField.getText();

            // Crear un objeto IPv4Address.
            IPv4Address ip = new IPv4Address(input.split("/")[0], input.split("/")[1]);

            // Mostrar los resultados en el área de texto.
            resultArea.setText("Dirección IP: " + ip.getIPAddress() + " (" + ip.getBinaryAddress() + ")\n");
            resultArea.append("Máscara: " + ip.getDecimalMask() + " (" + ip.getBinaryMask() + "), CIDR: " + ip.getCIDRMask() + "\n");
            resultArea.append("Dirección de red: " + ip.getDecimalNetwork() + " (" + ip.getBinaryNetwork() + ")\n");
            resultArea.append("Dirección de broadcast: " + ip.getDecimalBroadcast() + " (" + ip.getBinaryBroadcast() + ")\n");
            resultArea.append("Primer host: " + ip.getDecimalFirstHost() + " (" + ip.getBinaryFirstHost() + ")\n");
            resultArea.append("Último host: " + ip.getDecimalLastHost() + " (" + ip.getBinaryLastHost() + ")\n");
            resultArea.append("Número máximo de hosts: " + (int) ip.getMaxHosts() + "\n");
            resultArea.append("Tipo de red: " + ip.getType());
        } catch (Exception ex) {
            resultArea.setText("Error: Verifica la dirección IP y la máscara.");
        }
    }

    // Método principal para ejecutar la aplicación.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IPv4CalculatorGUI app = new IPv4CalculatorGUI();
            app.setVisible(true);
        });
    }
}
