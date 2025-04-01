/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.EventoIniciarPartida.EventoIniciarPartida;
import com.mycompany.blackboard.EventoJugadorListo;
import com.mycompany.blackboard.KnowledgeSource;

import com.mycompany.blackboard.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseq
 */
public class KSEvaluarJugadoresListos extends KnowledgeSource {

    private final List<Jugador> jugadoresListos = new ArrayList<>();

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoJugadorListo ev) {
            Jugador jugador = ev.getJugador();
            if (!jugadoresListos.contains(jugador)) {
                jugadoresListos.add(jugador);
            }

            System.out.println("Jugadores listos: " + jugadoresListos.size());

            if (jugadoresListos.size() >= 2) {
                System.out.println("¡Suficientes jugadores! Se puede iniciar la partida.");
                blackboard.publicarEvento(new EventoIniciarPartida());
            }
        }
    }

    public List<Jugador> getJugadoresListos() {
        return jugadoresListos;
    }

}
