/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import com.google.gson.Gson;
import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.ks.KSEvaluarJugadoresListos;
import com.mycompany.blackboard.ks.KSIniciarPartidaEnRed;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.timbirichenetwork.Cliente;
import com.mycompany.timbirichenetwork.EventoRed;
import com.mycompany.timbirichenetwork.Servidor;
import mvcLobby.ControladorLobbyJuego;
import mvcLobby.ModeloLobbyJuego;
import mvcLobby.VistaLobby;

import javax.swing.*;
import java.io.IOException;

public class CrearPartidaConRed {

    /**
     * Inicia una nueva partida actuando como host.
     *
     * @param perfil Perfil del jugador que crea la partida (el host).
     * @param puerto Puerto en el que se inicia el servidor.
     */
    public static void iniciar(Jugador perfil, int puerto) {
        try {
            // 1. Iniciar servidor
            Servidor servidor = new Servidor(puerto);
            servidor.start();

            // 2. Cliente local (host) se conecta a su propio servidor
            Gson gson = new Gson();
            Cliente cliente = new Cliente("localhost", puerto, null);
            cliente.connect();
            cliente.send(EventoRed.join(gson.toJson(perfil)));

            // 3. Blackboard y fuentes de conocimiento
            Blackboard blackboard = new Blackboard();
            blackboard.registrarKnowledgeSource(new KSEvaluarJugadoresListos());
            blackboard.registrarKnowledgeSource(new KSIniciarPartidaEnRed(cliente, gson));
            BlackboardBridge.setBlackboard(blackboard);

            // 4. Lobby
            ModeloLobbyJuego modelo = new ModeloLobbyJuego(10, perfil);
            VistaLobby vista = new VistaLobby();
            ControladorLobbyJuego ctrl = new ControladorLobbyJuego(modelo, vista, cliente, gson, true);

            // 5. Escuchar conexiones JOIN
            cliente.setListener(ev -> {
                if (ev.getTipo() == EventoRed.Tipo.JOIN) {
                    Jugador nuevo = gson.fromJson(ev.getJugadorJson(), Jugador.class);
                    ctrl.onJugadorConectado(nuevo);
                }
            });

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo iniciar el servidor: " + e.getMessage());
        }
    }
}
