/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.*;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Serva
 */
public class RegistroCliente {

    private static final String SERVER_ADDRESS = "127.0.0.1"; 
    private static final int PORT = 59336;

    public static boolean registrarJugador(String nombre, Color color, ImageIcon avatar) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT); ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeUTF(nombre);
            output.writeObject(color);
            output.writeObject(avatar);
            output.flush();  // Asegura que se envían los datos antes de leer la respuesta

            String response = input.readUTF();  // Ahora lee la respuesta correctamente
            System.out.println("Respuesta del servidor: " + response);
            return response.equals("Registro exitoso");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
