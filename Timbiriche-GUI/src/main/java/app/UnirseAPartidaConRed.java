/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import com.google.gson.Gson;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.timbirichenetwork.Cliente;
import com.mycompany.timbirichenetwork.EventoRed;
import mvcLobby.ControladorLobbyJuego;
import mvcLobby.ModeloLobbyJuego;
import mvcLobby.VistaLobby;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class UnirseAPartidaConRed {

    /**
     * Se conecta como cliente a una partida existente.
     *
     * @param perfil Perfil del jugador.
     * @param host   Dirección IP o hostname del servidor.
     * @param puerto Puerto del servidor.
     */
    public static void iniciar(Jugador perfil, String host, int puerto) {
        try {
            Gson gson = new Gson();
            Cliente cliente = new Cliente(host, puerto, null);
            cliente.connect();
            cliente.send(EventoRed.join(gson.toJson(perfil)));

            ModeloLobbyJuego modelo = new ModeloLobbyJuego(10, perfil);
            VistaLobby vista = new VistaLobby();
            ControladorLobbyJuego ctrl = new ControladorLobbyJuego(modelo, vista, cliente, gson, false);

            cliente.setListener(ev -> {
                switch (ev.getTipo()) {
                    case START -> {
                        Jugador[] jugadores = gson.fromJson(ev.getJugadorJson(), Jugador[].class);
                        ctrl.onStart(List.of(jugadores), ev.getTamañoTablero());
                    }
                    case TURN -> ctrl.onContinuar();
                }
            });

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar: " + e.getMessage());
        }
    }
}
