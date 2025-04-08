/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.KnowledgeSource;
import com.mycompany.blackboard.eventos.EventoIniciarPartida;
import com.mycompany.blackboard.modelo.Jugador;
import mvcJuego.VistaJuego;

import java.util.List;

/**
 *
 * @author joseq
 */
public class KSIniciarJuego extends KnowledgeSource {

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoIniciarPartida ev) {
            List<Jugador> jugadores = ev.getJugadores();
            int tamañoTablero = ev.getTamañoTablero();

            System.out.println("Iniciando juego con " + jugadores.size() + " jugadores.");

            Jugador jugadorLocal = jugadores.get(0);

            VistaJuego vistaJuego = new VistaJuego(jugadores, tamañoTablero, jugadorLocal);
            vistaJuego.setVisible(true);
        }
    }

}
