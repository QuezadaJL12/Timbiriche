package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcJuego.ModeloJuego;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class KSIniciarJuego {

    private static final AtomicBoolean iniciado = new AtomicBoolean(false);

    public void procesar(EventoIniciarJuego evento) {
        List<Jugador> jugadores = evento.getJugadores();

        for (Jugador j : jugadores) {
            if (j.getAvatar() == null && j.getRutaAvatar() != null) {
                j.setAvatar(new ImageIcon(j.getRutaAvatar()));
            }
        }

        ModeloJuego modelo = new ModeloJuego(jugadores, evento.getTamañoTablero());
        Blackboard.getInstancia().publicar(modelo);

        if (iniciado.compareAndSet(false, true)) {
            SwingUtilities.invokeLater(() -> new mvcJuego.ControladorJuego());
        }
    }
}
