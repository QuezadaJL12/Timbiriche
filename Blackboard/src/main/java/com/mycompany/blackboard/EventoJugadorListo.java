/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard;

import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.modelo.Jugador;

/**
 *
 * @author joseq
 */
public class EventoJugadorListo extends Evento {

   private final Jugador jugador;

    public EventoJugadorListo(Jugador jugador) {
        super("JugadorListo");
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

}
