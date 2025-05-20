/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork;

import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author joseq
 */
public class Cliente {

    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public Cliente(String host, int puerto) {
        try {
            socket = new Socket(host, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            System.out.println("Cliente conectado a servidor en " + host + ":" + puerto);

            new Thread(this::escucharEventos).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void escucharEventos() {
        try {
            while (true) {
                Object recibido = entrada.readObject();
                if (recibido instanceof Evento) {
                    Evento evento = (Evento) recibido;

                    if (evento instanceof EventoJugadorListo) {
                        Jugador j = ((EventoJugadorListo) evento).getJugador();
                        System.out.println(">>> Cliente recibió jugador: " + j.getNombre() + " | listo=" + j.isListo());
                    }

                    BlackboardBridge.recibirEventoDesdeRed(evento);
                }
            }
        } catch (Exception e) {
            System.out.println("Conexión cerrada.");
        }
    }

    public void enviarEvento(Evento evento) {
        try {
            salida.writeObject(evento);
            salida.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
