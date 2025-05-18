/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork.eventos;

import com.mycompany.timbirichenetwork.Evento;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.List;

/**
 *
 * @author joseq
 */
public class EventoIniciarJuego extends Evento {

    private final List<Jugador> jugadores;
    private final int tamañoTablero;

    public EventoIniciarJuego(List<Jugador> jugadores, int tamañoTablero) {
        this.jugadores = jugadores;
        this.tamañoTablero = tamañoTablero;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTamañoTablero() {
        return tamañoTablero;
    }

    @Override
    public String toString() {
        return "EventoIniciarJuego{jugadores=" + jugadores.size() + ", tamañoTablero=" + tamañoTablero + '}';
    }
}
