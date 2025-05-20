package com.mycompany.timbirichenetwork;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Servidor {

    private final List<ObjectOutputStream> clientes = new CopyOnWriteArrayList<>();

    public Servidor(int puerto) {
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("🟢 Servidor escuchando en puerto " + puerto);

            while (true) {
                Socket clienteSocket = servidor.accept();
                System.out.println("✅ Cliente conectado: " + clienteSocket.getInetAddress());

                ObjectOutputStream salida = new ObjectOutputStream(clienteSocket.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream());
                clientes.add(salida);

                new Thread(() -> manejarCliente(entrada)).start();
            }
        } catch (Exception e) {
            System.err.println("❌ Error en servidor:");
            e.printStackTrace();
        }
    }

    private void manejarCliente(ObjectInputStream entrada) {
        try {
            while (true) {
                Object recibido = entrada.readObject();
                if (recibido instanceof Evento) {
                    Evento evento = (Evento) recibido;
                    System.out.println("📥 Evento recibido del cliente: " + evento.getClass().getSimpleName());
                    reenviarEvento(evento);
                }
            }
        } catch (Exception e) {
            System.out.println("🔴 Cliente desconectado.");
        }
    }

    private void reenviarEvento(Evento evento) {
        for (ObjectOutputStream out : clientes) {
            try {
                out.writeObject(evento);
                out.flush();
                System.out.println("📤 Evento reenviado a un cliente: " + evento.getClass().getSimpleName());
            } catch (Exception e) {
                System.out.println("⚠ Error enviando evento a cliente.");
            }
        }
    }
}
