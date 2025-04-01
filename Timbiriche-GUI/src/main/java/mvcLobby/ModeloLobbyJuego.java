/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcLobby;

import com.mycompany.blackboard.modelo.Jugador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseq
 */
public class ModeloLobbyJuego {

     private final List<Jugador> jugadores;

    public ModeloLobbyJuego() {
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadoresListos() {
        int listos = 0;
        for (Jugador j : jugadores) {
            if (j.isListo()) listos++;
        }
        return listos;
    }

}
