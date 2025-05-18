package mvcLobby;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.eventos.EventoJugadorListo;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.List;

public class ControladorLobbyJuego {

    private final ModeloLobbyJuego modelo;
    private final VistaLobby vista;
    private final int tamañoTablero;

    public ControladorLobbyJuego(Jugador jugadorHost, int tamañoTablero) {
        this.modelo = new ModeloLobbyJuego();
        this.vista = new VistaLobby();
        this.tamañoTablero = tamañoTablero;

        Blackboard.getInstancia().registrar(ModeloLobbyJuego.class, vista);
        modelo.agregarJugador(jugadorHost);
        Blackboard.getInstancia().publicar(modelo);

        vista.getBtnIniciar().addActionListener(e -> iniciarPartidaSiEsPosible());
        vista.getBtnEditarPerfil().addActionListener(e -> editarPerfil(jugadorHost));
    }

    private void iniciarPartidaSiEsPosible() {
        List<Jugador> jugadores = modelo.getJugadores();
        if (modelo.puedeIniciar()) {
            vista.dispose();
            // Aquí puedes iniciar ControladorJuego si lo tienes
            System.out.println("Iniciando partida con " + jugadores.size() + " jugadores.");
        } else {
            System.out.println("Se requieren al menos 2 jugadores listos.");
        }
    }

    private void editarPerfil(Jugador jugador) {
        jugador.setNombre(jugador.getNombre() + " (editado)");
        Blackboard.getInstancia().publicar(modelo);
    }

    public void marcarJugadorListo(Jugador jugador) {
        modelo.marcarJugadorListo(jugador);
        Blackboard.getInstancia().publicar(modelo);
        Blackboard.getInstancia().publicarEvento(new EventoJugadorListo(jugador));
    }
}
