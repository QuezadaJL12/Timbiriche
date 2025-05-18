/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.google.gson.Gson;
import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.KnowledgeSource;
import com.mycompany.blackboard.eventos.EventoIniciarPartida;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.timbirichenetwork.Cliente;
import mvcJuego.MainJuego;

import javax.swing.*;
import java.util.List;

public class KSIniciarPartidaEnRed extends KnowledgeSource {

    private final Cliente cliente;
    private final Gson gson;

    public KSIniciarPartidaEnRed(Cliente cliente, Gson gson) {
        this.cliente = cliente;
        this.gson = gson;
    }

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoIniciarPartida ev) {
            List<Jugador> jugadores = ev.getJugadores();
            int tamaño = ev.getTamañoTablero();

            System.out.println("[KSIniciarPartidaEnRed] Iniciando juego en red con " + jugadores.size() + " jugadores");

            SwingUtilities.invokeLater(() ->
                MainJuego.mainCon(jugadores, tamaño, cliente, gson)
            );
        }
    }
}
