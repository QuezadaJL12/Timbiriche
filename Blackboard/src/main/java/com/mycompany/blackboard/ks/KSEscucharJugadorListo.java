package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcLobby.ModeloLobbyJuego;

public class KSEscucharJugadorListo {
    public void procesar(EventoJugadorListo evento) {
        Jugador jugador = evento.getJugador();
        jugador.setListo(true);

        Blackboard bb = Blackboard.getInstancia();
        ModeloLobbyJuego modelo = bb.obtenerEstado(ModeloLobbyJuego.class)
            .orElseGet(() -> {
                ModeloLobbyJuego nuevo = new ModeloLobbyJuego();
                bb.publicar(nuevo);
                return nuevo;
            });

        modelo.agregarJugador(jugador);
        bb.publicar(modelo);
    }
}
