/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork;

import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.Evento;

import java.io.*;
import java.net.*;

/**
 *
 * @author joseq
 */
public class Cliente {

     private Socket socket;
    private ObjectOutputStream out;

    public void conectar(String host, int puerto) throws IOException {
        socket = new Socket(host, puerto);
        out = new ObjectOutputStream(socket.getOutputStream());

        // Inicia el hilo para recibir mensajes del servidor
        new Thread(() -> escucharServidor()).start();
    }

    public void enviar(Evento evento) throws IOException {
        out.writeObject(evento);
        out.flush();
    }

    private void escucharServidor() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            while (true) {
                Evento evento = (Evento) in.readObject();
                System.out.println("Evento recibido del servidor: " + evento.getTipo());
                BlackboardBridge.recibirEventoDesdeRed(evento); 
            }
        } catch (Exception e) {
            System.err.println("Error al recibir evento del servidor");
            e.printStackTrace();
        }
    }

}
