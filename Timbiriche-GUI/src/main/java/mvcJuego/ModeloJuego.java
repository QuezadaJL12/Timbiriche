package mvcJuego;

import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.List;

public class ModeloJuego {

    private final List<Jugador> jugadores;
    private final int tamañoTablero;

    public ModeloJuego(List<Jugador> jugadores, int tamañoTablero) {
        this.jugadores = jugadores;
        this.tamañoTablero = tamañoTablero;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTamañoTablero() {
        return tamañoTablero;
    }
}
