package com.mycompany.blackboard.ks;

import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;

public class KSEscucharJugadorListo {

    public void procesar(EventoJugadorListo evento) {
        Jugador jugador = evento.getJugador();
        jugador.setListo(true);
        System.out.println("KSEscucharJugadorListo: " + jugador.getNombre() + " está listo.");
    }
}
