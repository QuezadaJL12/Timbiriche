/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.eventos;

import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.modelo.JugadorRed;
import java.io.Serializable;

/**
 *
 * @author joseq
 */
public class EventoJugadorListo extends Evento implements Serializable {

    private final JugadorRed jugador;

    public EventoJugadorListo(JugadorRed jugador) {
        super("JUGADOR_LISTO");
        this.jugador = jugador;
    }

    public JugadorRed getJugador() {
        return jugador;
    }

}
