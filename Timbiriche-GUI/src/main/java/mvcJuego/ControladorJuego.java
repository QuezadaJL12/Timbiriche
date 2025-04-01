/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcJuego;

import com.mycompany.blackboard.modelo.Jugador;
import java.util.List;

/**
 *
 * @author joseq
 */
public class ControladorJuego {

    private final VistaJuego vista;
    private final ModeloJuego modelo;

    public ControladorJuego(List<Jugador> jugadores, int tamanioTablero) {
        this.modelo = new ModeloJuego(jugadores, tamanioTablero);
        this.vista = new VistaJuego(this);
        this.vista.setVisible(true);
    }

    public void iniciarJuego() {
        modelo.inicializarTablero();
        vista.mostrarJugadores(modelo.getJugadores());
        vista.mostrarTablero(modelo.getGridSize());
    }

    public void seleccionarLinea(int x, int y) {
        boolean cuadroCompletado = modelo.procesarJugada(x, y);

        vista.actualizarEstado(
                modelo.getJugadorActual(),
                modelo.getPuntosX(),
                modelo.getPuntosO()
        );

        if (modelo.estaJuegoTerminado()) {
            String ganador;
            if (modelo.getPuntosX() > modelo.getPuntosO()) {
                ganador = "Jugador X";
            } else if (modelo.getPuntosO() > modelo.getPuntosX()) {
                ganador = "Jugador O";
            } else {
                ganador = "Empate";
            }
            vista.mostrarGanador(ganador);
        }
    }

    public ModeloJuego getModelo() {
        return modelo;
    }

}
