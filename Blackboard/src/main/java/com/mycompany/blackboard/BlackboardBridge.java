package com.mycompany.blackboard;
import com.mycompany.timbirichenetwork.Evento;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarPartida;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcJuego.ControladorJuego;
import mvcJuego.ModeloJuego;
import mvcLobby.ModeloLobbyJuego;
import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlackboardBridge {
    private static Blackboard instanciaGlobal;
    // Flag para controlar si ya se ha iniciado el juego
    private static final AtomicBoolean juegoIniciado = new AtomicBoolean(false);

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
            procesarEventoJugadorListo(e);
        } else if (evento instanceof EventoIniciarJuego e) {
            procesarEventoIniciarJuego(e);
        } else if (evento instanceof EventoIniciarPartida e) {
            instanciaGlobal.publicarEvento(e);
        } else {
            System.out.println("⚠ Evento no reconocido: " + evento.getClass().getSimpleName());
        }
    }
    
    private static void procesarEventoJugadorListo(EventoJugadorListo e) {
        Jugador jugador = e.getJugador();
        // Asegurar que el jugador está marcado como listo
        jugador.setListo(true);
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
    }
    
    private static void procesarEventoIniciarJuego(EventoIniciarJuego e) {
        System.out.println("? [Bridge] Recibido EventoIniciarJuego");
        
        // Cargar avatares para cada jugador
        for (Jugador j : e.getJugadores()) {
            if (j.getAvatar() == null && j.getRutaAvatar() != null && !j.getRutaAvatar().isEmpty()) {
                j.setAvatar(new ImageIcon(j.getRutaAvatar()));
            }
        }
        
        // Publicar el evento para que otros componentes lo procesen
        instanciaGlobal.publicarEvento(e);
        
        // Crear y publicar el modelo de juego si no existe
        if (!instanciaGlobal.obtenerEstado(ModeloJuego.class).isPresent()) {
            ModeloJuego modeloJuego = new ModeloJuego(e.getJugadores(), e.getTamañoTablero());
            System.out.println("? [Bridge] Creando y publicando ModeloJuego");
            instanciaGlobal.publicar(modeloJuego);
        } else {
            System.out.println("? [Bridge] ModeloJuego ya existe, forzando republicación");
            instanciaGlobal.forzarPublicacion(ModeloJuego.class);
        }
        
        // IMPORTANTE: Usamos un flag atómico para evitar múltiples creaciones de la interfaz
        if (juegoIniciado.compareAndSet(false, true)) {
            // Solo el primer hilo que llegue aquí iniciará la pantalla
            SwingUtilities.invokeLater(() -> {
                System.out.println("? [Bridge] Iniciando pantalla de juego para este cliente");
                new ControladorJuego();
            });
        } else {
            System.out.println("? [Bridge] La pantalla de juego ya ha sido iniciada");
        }
    }
}