/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork.eventos;

import com.mycompany.timbirichenetwork.Evento;
import com.mycompany.timbirichenetwork.modelo.Jugador;

/**
 *
 * @author joseq
 */
public class EventoJugadorListo extends Evento {

    private final Jugador jugador;

    public EventoJugadorListo(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public String toString() {
        return "EventoJugadorListo{jugador=" + jugador.getNombre() + '}';
    }
}
