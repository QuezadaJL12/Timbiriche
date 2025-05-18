package com.mycompany.blackboard;

import com.mycompany.timbirichenetwork.Evento;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarPartida;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import javax.swing.ImageIcon;

public class BlackboardBridge {

    private static Blackboard instanciaGlobal;

    public static void setBlackboard(Blackboard blackboard) {
        BlackboardBridge.instanciaGlobal = blackboard;
    }

    public static void recibirEventoDesdeRed(Evento evento) {
        if (instanciaGlobal == null) {
            System.err.println("Blackboard aún no ha sido inicializado.");
            return;
        }

        if (evento instanceof EventoJugadorListo) {
            EventoJugadorListo e = (EventoJugadorListo) evento;
            instanciaGlobal.publicarEvento(e);

        } else if (evento instanceof EventoIniciarJuego) {
            EventoIniciarJuego e = (EventoIniciarJuego) evento;
            for (Jugador j : e.getJugadores()) {
                j.setAvatar(new ImageIcon(j.getRutaAvatar()));
            }
            instanciaGlobal.publicarEvento(e);

        } else if (evento instanceof EventoIniciarPartida) {
            EventoIniciarPartida e = (EventoIniciarPartida) evento;
            instanciaGlobal.publicarEvento(e);

        } else {
            System.out.println("Evento no reconocido: " + evento.getClass().getSimpleName());
        }
    }
}
