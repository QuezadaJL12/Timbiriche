/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcTamanoTablero;

import com.mycompany.blackboard.eventos.EventoJugadorListo;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.blackboard.modelo.JugadorRed;
import com.mycompany.timbirichenetwork.Cliente;
import com.mycompany.timbirichenetwork.Servidor;
import mvcLobby.VistaLobby;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author joseq
 */
public class ControladorTamanoTablero {

    private final VistaTamanoTablero vista;
    private final ModeloTamanoTablero modelo;

    public ControladorTamanoTablero(VistaTamanoTablero vista, ModeloTamanoTablero modelo) {
        this.vista = vista;
        this.modelo = modelo;

        configurarEventos();
    }

    private void configurarEventos() {
        // 🎮 Botón para iniciar como servidor (host)
        vista.getBtnServidor().addActionListener(e -> {
            int tamaño = vista.getTamañoSeleccionado();
            if (tamaño == 0) {
                JOptionPane.showMessageDialog(vista, "Selecciona un tamaño de tablero.");
                return;
            }

            try {
                // Iniciar servidor
                Servidor servidor = new Servidor();
                servidor.iniciar(1234);

                // Crear y mostrar VistaLobby
                Jugador jugador = vista.getJugadorSeleccionado();
                VistaLobby vistaLobby = new VistaLobby(jugador, tamaño);
                vistaLobby.setVisible(true);

                vista.dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vista, "Error al iniciar el servidor.");
            }
        });

        // 🤝 Botón para unirse como cliente
        vista.getBtnUnirse().addActionListener(e -> {
            try {
                String nombre = vista.getNombreJugador();
                String avatarPath = vista.getAvatarSeleccionado();
                Color color = vista.getColorSeleccionado();
                String colorHex = "#" + Integer.toHexString(color.getRGB()).substring(2);

                // Conectar al servidor
                Cliente cliente = new Cliente();
                cliente.conectar("localhost", 1234); // Cambiar si es remoto

                // Enviar evento del jugador
                JugadorRed jugadorRed = new JugadorRed(nombre, colorHex, avatarPath, true);
                cliente.enviar(new EventoJugadorListo(jugadorRed));

                // Abrir VistaLobby del cliente
                ImageIcon avatar = new ImageIcon(getClass().getResource("/Avatares/" + avatarPath));
                Jugador jugador = new Jugador(nombre, color, avatar);
                VistaLobby vistaLobby = new VistaLobby(jugador, 0); // El tamaño lo define el host
                vistaLobby.setVisible(true);

                vista.dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vista, "Error al unirse al servidor.");
            }
        });
    }

}
