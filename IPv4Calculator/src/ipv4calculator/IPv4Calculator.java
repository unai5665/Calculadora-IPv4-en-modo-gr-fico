/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipv4calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Calculadora IPv4.
 * Recibe una dirección IPv4 y una máscara y devuelve:
 * - La dirección de red.
 * - La dirección de broadcast.
 * - La dirtección del primer host.
 * - La dirección del último host.
 * @author javiers
 */
public class IPv4Calculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Solicitar IP y máscara.
        System.out.println("Calculadora de direcciones IPv4.");
        System.out.println("--------------------------------");
        System.out.print("Dirección IP y máscara: ");
        String entrada = br.readLine();
        System.out.println("");
        // Crear un objeto de la clase IPv4Address.
        IPv4Address dir = new IPv4Address(entrada.split("/")[0], entrada.split("/")[1]);
        // Mostrar los resultados.
        // Mostrar la dirección en binario y en decimal.
        System.out.printf("          Dirección IP: %s, %s. \n",
                dir.getBinaryAddress(), dir.getIPAddress());
        // Mostrar la máscara en binario, en decimal y en CIDR.
        System.out.printf("        Máscara de red: %s, %s, %s. \n",
                dir.getBinaryMask(), dir.getDecimalMask(), dir.getCIDRMask());
        
        // Mostrar la dirección de red en binario y en decimal.
        System.out.printf("      Dirección de red: %s, %s. \n",
                dir.getBinaryNetwork(), dir.getDecimalNetwork());

        // Mostrar la dirección de broadcast en binario y en decimal.
        System.out.printf("Dirección de broadcast: %s, %s. \n",
                dir.getBinaryBroadcast(), dir.getDecimalBroadcast());

        // Mostrar la dirección del primer equipo en binario y en decimal.
        System.out.printf("         Primer equipo: %s, %s. \n",
                dir.getBinaryFirstHost(), dir.getDecimalFirstHost());

        // Mostrar la dirección del último equipo en binario y en decimal.
        System.out.printf("         Último equipo: %s, %s. \n",
                dir.getBinaryLastHost(), dir.getDecimalLastHost());
        
        // Mostrar el nº máximo de equipos.
        System.out.printf("  Máximo nº de equipos: %.0f. \n",
                dir.getMaxHosts());
        
        // Mostrar el tipo de dirección: Pública o Privada.
        System.out.printf("           Tipo de red: %s. \n",
                dir.getType());
        
    }
    
}