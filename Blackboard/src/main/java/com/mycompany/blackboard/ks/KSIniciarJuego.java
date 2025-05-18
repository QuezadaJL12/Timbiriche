package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcJuego.ModeloJuego;

import java.util.List;

public class KSIniciarJuego {

    public void iniciar(List<Jugador> jugadores, int tamañoTablero) {
        ModeloJuego modelo = new ModeloJuego(jugadores, tamañoTablero);
        Blackboard.getInstancia().publicar(modelo);
    }
}
