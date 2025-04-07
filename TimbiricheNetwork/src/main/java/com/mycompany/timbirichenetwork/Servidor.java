/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.Evento;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author joseq
 */
public class Servidor {

    private ServerSocket serverSocket;
    private final List<Socket> clientes = new ArrayList<>();

    public void iniciar(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en el puerto " + puerto);

        new Thread(() -> {
            while (true) {
                try {
                    Socket cliente = serverSocket.accept();
                    clientes.add(cliente);
                    new Thread(() -> escucharCliente(cliente)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void escucharCliente(Socket cliente) {
        try (ObjectInputStream in = new ObjectInputStream(cliente.getInputStream())) {
            while (true) {
                Evento evento = (Evento) in.readObject();
                System.out.println("Evento recibido del cliente: " + evento.getTipo());
                BlackboardBridge.recibirEventoDesdeRed(evento); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarATodos(Evento evento) {
        for (Socket cliente : clientes) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                out.writeObject(evento);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
