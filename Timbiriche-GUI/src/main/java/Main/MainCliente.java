/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.mycompany.blackboard.eventos.EventoJugadorListo;
import com.mycompany.blackboard.modelo.JugadorRed;
import com.mycompany.timbirichenetwork.Cliente;


/**
 *
 * @author joseq
 */
public class MainCliente {

    public static void main(String[] args) {
        try {
            // 1. Crear y conectar el cliente al servidor
            Cliente cliente = new Cliente();
            cliente.conectar("localhost", 1234); // Cambia IP si es remoto

            // 2. Crear jugador simulado para enviar
            JugadorRed jugador = new JugadorRed("Jugador2", "#0000FF", "PINGUINO.png", true);

            // 3. Enviar evento al servidor
            EventoJugadorListo evento = new EventoJugadorListo(jugador);
            cliente.enviar(evento);

            System.out.println("EventoJugadorListo enviado desde cliente");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    
}
