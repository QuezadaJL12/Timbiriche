package com.mycompany.blackboard;
import com.mycompany.timbirichenetwork.Evento;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarPartida;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcJuego.ControladorJuego;
import mvcLobby.ModeloLobbyJuego;
import javax.swing.*;

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

        System.out.println("? Evento recibido desde red: " + evento.getClass().getSimpleName());

        if (evento instanceof EventoJugadorListo e) {
            Jugador jugador = e.getJugador();
            System.out.println(">>> Cliente recibió jugador: " + jugador.getNombre() + " | listo=" + jugador.isListo());
            
            // Asegurarnos de que el modelo existe en el blackboard
            ModeloLobbyJuego modelo;
            if (!instanciaGlobal.obtenerEstado(ModeloLobbyJuego.class).isPresent()) {
                modelo = new ModeloLobbyJuego();
                instanciaGlobal.publicar(modelo);
            } else {
                modelo = instanciaGlobal.obtenerEstado(ModeloLobbyJuego.class).get();
            }
            
            // SOLUCIÓN DIRECTA: Agregar o actualizar el jugador directamente en el modelo
            boolean existeJugador = modelo.getJugadores().stream()
                .anyMatch(j -> j.getNombre().trim().equalsIgnoreCase(jugador.getNombre().trim()));
                
            if (!existeJugador) {
                System.out.println("? [Bridge] Agregando jugador remoto: " + jugador.getNombre());
                modelo.agregarJugador(jugador);
            } else {
                System.out.println("? [Bridge] Actualizando jugador remoto: " + jugador.getNombre());
                for (Jugador j : modelo.getJugadores()) {
                    if (j.getNombre().trim().equalsIgnoreCase(jugador.getNombre().trim())) {
                        j.setListo(jugador.isListo());
                        break;
                    }
                }
            }
            
            // Republicar el modelo actualizado
            System.out.println("? [Bridge] Republicando modelo actualizado");
            instanciaGlobal.publicar(modelo);
            
            // Y para el Knowledge Source que pueda estar escuchando
            instanciaGlobal.publicarEvento(e);
            
        } else if (evento instanceof EventoIniciarJuego e) {
            System.out.println("? [Bridge] Recibido EventoIniciarJuego");
            for (Jugador j : e.getJugadores()) {
                j.setAvatar(new ImageIcon(j.getRutaAvatar()));
            }
            instanciaGlobal.publicarEvento(e);
            
            // IMPORTANTE: Crear el controlador del juego cuando se recibe este evento
            // esto hará que todos los clientes abran la pantalla de juego
            SwingUtilities.invokeLater(() -> {
                System.out.println("? [Bridge] Iniciando pantalla de juego para todos los jugadores");
                new ControladorJuego();
            });
            
        } else if (evento instanceof EventoIniciarPartida e) {
            instanciaGlobal.publicarEvento(e);
            
        } else {
            System.out.println("⚠ Evento no reconocido: " + evento.getClass().getSimpleName());
        }
    }
}