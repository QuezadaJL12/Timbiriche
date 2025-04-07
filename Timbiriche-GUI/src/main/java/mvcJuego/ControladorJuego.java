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
    private final List<Jugador> jugadores;
    private final int tamañoTablero;
    private int turnoActual = 0;

    private final int[][] tableroLineas; // 0 = vacío, 1 = ocupado
    private final int[][] tableroPuntos; // para cuadros reclamados

    private final int[] puntuaciones;

    public ControladorJuego(VistaJuego vista, List<Jugador> jugadores, int tamañoTablero) {
        this.vista = vista;
        this.jugadores = jugadores;
        this.tamañoTablero = tamañoTablero;

        int size = tamañoTablero * 2 + 1;
        this.tableroLineas = new int[size][size];
        this.tableroPuntos = new int[tamañoTablero][tamañoTablero];
        this.puntuaciones = new int[jugadores.size()];
    }

    public void iniciarJuego() {
        actualizarVista();
    }

    public void seleccionarLinea(int i, int j) {
        if (tableroLineas[i][j] == 1) return; // Ya está ocupada

        tableroLineas[i][j] = 1;
        boolean hizoCuadro = marcarCuadrosSiCorresponde(i, j);

        if (!hizoCuadro) {
            turnoActual = (turnoActual + 1) % jugadores.size();
        }

        actualizarVista();
        verificarFinDelJuego();
    }

    private boolean marcarCuadrosSiCorresponde(int i, int j) {
        boolean marco = false;

        int[][] posibles = {
            {i - 1, j - 1}, {i - 1, j + 1}, {i + 1, j - 1}, {i + 1, j + 1}
        };

        for (int[] punto : posibles) {
            int fila = punto[0] / 2;
            int col = punto[1] / 2;

            if (fila >= 0 && fila < tamañoTablero && col >= 0 && col < tamañoTablero) {
                if (tieneCuadro(fila, col)) {
                    if (tableroPuntos[fila][col] == 0) {
                        tableroPuntos[fila][col] = turnoActual + 1;
                        puntuaciones[turnoActual]++;
                        marco = true;
                    }
                }
            }
        }

        return marco;
    }

    private boolean tieneCuadro(int fila, int col) {
        int i = fila * 2 + 1;
        int j = col * 2 + 1;

        return tableroLineas[i - 1][j] == 1 &&
               tableroLineas[i + 1][j] == 1 &&
               tableroLineas[i][j - 1] == 1 &&
               tableroLineas[i][j + 1] == 1;
    }

    private void actualizarVista() {
        String nombreTurno = jugadores.get(turnoActual).getNombre();
        int puntosX = puntuaciones.length > 0 ? puntuaciones[0] : 0;
        int puntosO = puntuaciones.length > 1 ? puntuaciones[1] : 0;

        vista.actualizarEstado(nombreTurno, puntosX, puntosO);
    }

    private void verificarFinDelJuego() {
        int totalCuadros = tamañoTablero * tamañoTablero;
        int suma = 0;
        for (int puntos : puntuaciones) {
            suma += puntos;
        }

        if (suma == totalCuadros) {
            // Juego terminado
            int max = -1;
            String ganador = "Empate";
            for (int i = 0; i < jugadores.size(); i++) {
                if (puntuaciones[i] > max) {
                    max = puntuaciones[i];
                    ganador = jugadores.get(i).getNombre();
                }
            }
            vista.mostrarGanador(ganador);
        }
    }

}
