package mvcLobby;

import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ModeloLobbyJuego {

    private final List<Jugador> jugadores = new ArrayList<>();

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean puedeIniciar() {
        long listos = jugadores.stream().filter(Jugador::isListo).count();
        return listos >= 2 && listos <= 4;
    }

    public void marcarJugadorListo(Jugador jugador) {
        jugador.setListo(true);
    }
}
