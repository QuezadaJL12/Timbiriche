// ✅ ControladorLobbyJuego.java
package mvcLobby;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.ks.KSEvaluarJugadoresListos;
import com.mycompany.timbirichenetwork.Cliente;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.List;

public class ControladorLobbyJuego {

    private final ModeloLobbyJuego modelo;
    private final VistaLobby vista;
    private final int tamañoTablero;
    private final Cliente cliente;

    public ControladorLobbyJuego(Jugador jugadorHost, int tamañoTablero, Cliente cliente) {
        this.tamañoTablero = tamañoTablero;
        this.cliente = cliente;
        this.vista = new VistaLobby();

        Blackboard bb = Blackboard.getInstancia();

        this.modelo = bb.obtenerEstado(ModeloLobbyJuego.class)
                .orElseGet(() -> {
                    ModeloLobbyJuego nuevo = new ModeloLobbyJuego();
                    System.out.println("✅ ModeloLobbyJuego nuevo creado y publicado por " + jugadorHost.getNombre());
                    bb.publicar(nuevo);
                    return nuevo;
                });

        bb.registrar(ModeloLobbyJuego.class, vista);
        bb.publicar(modelo);

        boolean yaExiste = modelo.getJugadores().stream()
                .anyMatch(j -> j.getNombre().trim().equalsIgnoreCase(jugadorHost.getNombre().trim()));

        if (!yaExiste) {
            System.out.println("? Agregando jugador local al modelo: " + jugadorHost.getNombre());
            jugadorHost.setListo(false);
            modelo.agregarJugador(jugadorHost);
            bb.publicar(modelo);

            EventoJugadorListo evento = new EventoJugadorListo(jugadorHost);
            bb.publicarEvento(evento);
            cliente.enviarEvento(evento);
        }

        vista.getBtnIniciar().addActionListener(e -> iniciarPartidaSiEsPosible());
        vista.getBtnEditarPerfil().addActionListener(e -> editarPerfil(jugadorHost));
    }

    private void iniciarPartidaSiEsPosible() {
        List<Jugador> jugadores = modelo.getJugadores();
        KSEvaluarJugadoresListos ks = new KSEvaluarJugadoresListos();

        System.out.println(">>> ESTADO ACTUAL DE JUGADORES:");
        jugadores.forEach(j -> System.out.println("- " + j.getNombre() + " | listo=" + j.isListo()));

        if (ks.validar(jugadores)) {
            vista.dispose();
            System.out.println("✅ Iniciando partida con " + jugadores.size() + " jugadores.");

            EventoIniciarJuego evento = new EventoIniciarJuego(jugadores, tamañoTablero);
            Blackboard.getInstancia().publicarEvento(evento);
            cliente.enviarEvento(evento);

            System.out.println("🚀 EventoIniciarJuego enviado a todos los clientes.");
        } else {
            System.out.println("❌ Se requieren al menos 2 jugadores listos.");
        }
    }

    private void editarPerfil(Jugador jugador) {
        jugador.setListo(true);
        Blackboard.getInstancia().publicar(modelo);

        EventoJugadorListo evento = new EventoJugadorListo(jugador);
        Blackboard.getInstancia().publicarEvento(evento);
        cliente.enviarEvento(evento);

        System.out.println("? Jugador marcado como listo: " + jugador.getNombre());
    }
}