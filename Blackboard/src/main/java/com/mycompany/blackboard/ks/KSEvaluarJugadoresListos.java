/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.eventos.EventoIniciarPartida;
import com.mycompany.blackboard.eventos.EventoJugadorListo;
import com.mycompany.blackboard.KnowledgeSource;
import com.mycompany.blackboard.interfaces.VistaLobbyListener;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.blackboard.modelo.JugadorRed;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseq
 */
public class KSEvaluarJugadoresListos extends KnowledgeSource {

    private final List<Jugador> jugadoresListos = new ArrayList<>();
    private VistaLobbyListener listener;

    public void setVistaLobbyListener(VistaLobbyListener listener) {
        this.listener = listener;
    }

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoJugadorListo ev) {
            JugadorRed jr = ev.getJugador();

            // Convertir JugadorRed → Jugador
            Color color = Color.decode(jr.getColorHex());
            ImageIcon avatar = new ImageIcon(getClass().getResource("/Avatares/" + jr.getAvatarPath()));
            Jugador jugador = new Jugador(jr.getNombre(), color, avatar);
            jugador.setListo(jr.isListo());

            //  Agregar solo si no está repetido
            if (!jugadoresListos.contains(jugador)) {
                jugadoresListos.add(jugador);

                //  Notificar a la vista si está conectada
                if (listener != null) {
                    listener.jugadorListoRecibido(jugador);
                }
            }

            System.out.println("👥 Jugadores listos: " + jugadoresListos.size());

            //  Evaluar inicio de partida
            if (jugadoresListos.size() >= 2) {
                System.out.println("🚀 ¡Listos para iniciar partida!");
                blackboard.publicarEvento(new EventoIniciarPartida());
            }
        }
    }

    public List<Jugador> getJugadoresListos() {
        return jugadoresListos;
    }

}
