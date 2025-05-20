package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcLobby.ModeloLobbyJuego;

public class KSEscucharJugadorListo {

    public void procesar(EventoJugadorListo evento) {
        Jugador jugador = evento.getJugador();
        // Asegurar que el jugador está marcado como listo
        jugador.setListo(true);
        Blackboard bb = Blackboard.getInstancia();

        bb.obtenerEstado(ModeloLobbyJuego.class).ifPresent(modelo -> {
            System.out.println("? [KS] EventoJugadorListo procesado: " + jugador.getNombre() + " | listo=" + jugador.isListo());

            boolean yaExiste = modelo.getJugadores().stream()
                    .anyMatch(j -> j.getNombre().trim().equalsIgnoreCase(jugador.getNombre().trim()));

            if (!yaExiste) {
                // Agregar nuevo jugador
                modelo.agregarJugador(jugador);
            } else {
                // Actualizar estado del jugador existente
                modelo.actualizarJugador(jugador);
            }

            System.out.println("? Publicando nuevo estado: ModeloLobbyJuego (post KS)");
            modelo.imprimirEstado(); // Agregar esto para validar el estado del modelo antes de publicar
            bb.publicar(modelo);
        });
    }
}