/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;

/**
 *
 * @author Serva
 */
public class Server {

    private static final int PORT = 59336;
    private Blackboard blackboard;

    public Server(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT, 50, InetAddress.getByName("0.0.0.0"));) {
            System.out.println("Servidor Blackboard esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, blackboard).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {

        private Socket socket;
        private Blackboard blackboard;

        public ClientHandler(Socket socket, Blackboard blackboard) {
            this.socket = socket;
            this.blackboard = blackboard;
        }

        @Override
        public void run() {
            try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {

                String nombre = input.readUTF();
                Color color = (Color) input.readObject();
                ImageIcon avatar = (ImageIcon) input.readObject();

                blackboard.setNombre(nombre);
                blackboard.setColor(color);
                blackboard.setAvatar(avatar);

                System.out.println("Jugador registrado en Blackboard: " + nombre);

                output.writeUTF("Registro exitoso");  
                output.flush();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
