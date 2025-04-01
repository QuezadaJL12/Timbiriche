/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcJuego;

import Model.Cuadro;
import Model.Linea;
import com.mycompany.blackboard.modelo.Jugador;
import java.util.List;

/**
 *
 * @author joseq
 */
public class ModeloJuego {

    private final List<Jugador> jugadores;
    private final int gridSize;
    private final Linea[][] lineas;
    private final Cuadro[][] cuadros;

    private int puntosX = 0;
    private int puntosO = 0;
    private String jugadorActual = "X";

    public ModeloJuego(List<Jugador> jugadores, int tamanioTablero) {
        this.jugadores = jugadores;

        switch (tamanioTablero) {
            case 10 ->
                this.gridSize = 3;
            case 20 ->
                this.gridSize = 6;
            case 30 ->
                this.gridSize = 9;
            default ->
                this.gridSize = 3;
        }

        this.lineas = new Linea[gridSize * 2 + 1][gridSize * 2 + 1];
        this.cuadros = new Cuadro[gridSize][gridSize];
    }

    public void inicializarTablero() {
        for (int i = 0; i < gridSize * 2 + 1; i++) {
            for (int j = 0; j < gridSize * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0) {
                    lineas[i][j] = new Linea();
                }
            }
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cuadros[i][j] = new Cuadro();
            }
        }
    }

    public boolean procesarJugada(int x, int y) {
        if (lineas[x][y] == null || lineas[x][y].estaMarcada()) {
            return false;
        }

        lineas[x][y].marcar();

        boolean cuadroCompletado = comprobarCuadrosAdyacentes(x, y);

        if (!cuadroCompletado) {
            cambiarTurno();
        }

        return cuadroCompletado;
    }

    private boolean comprobarCuadrosAdyacentes(int x, int y) {
        boolean completado = false;

        if (x % 2 == 0) { // línea horizontal
            int filaSup = (x / 2) - 1;
            int filaInf = x / 2;
            int col = y / 2;

            if (filaSup >= 0 && filaSup < gridSize) {
                completado |= comprobarCuadro(filaSup, col);
            }
            if (filaInf < gridSize) {
                completado |= comprobarCuadro(filaInf, col);
            }

        } else { // línea vertical
            int fila = x / 2;
            int colIzq = (y / 2) - 1;
            int colDer = y / 2;

            if (colIzq >= 0 && colIzq < gridSize) {
                completado |= comprobarCuadro(fila, colIzq);
            }
            if (colDer < gridSize) {
                completado |= comprobarCuadro(fila, colDer);
            }
        }

        return completado;
    }

    private boolean comprobarCuadro(int i, int j) {
        if (cuadros[i][j].getJugador().isEmpty()
                && lineas[i * 2][j * 2 + 1].estaMarcada()
                && lineas[i * 2 + 2][j * 2 + 1].estaMarcada()
                && lineas[i * 2 + 1][j * 2].estaMarcada()
                && lineas[i * 2 + 1][j * 2 + 2].estaMarcada()) {

            cuadros[i][j].asignarJugador(jugadorActual);

            if (jugadorActual.equals("X")) {
                puntosX++;
            } else {
                puntosO++;
            }

            return true;
        }
        return false;
    }

    private void cambiarTurno() {
        jugadorActual = jugadorActual.equals("X") ? "O" : "X";
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getGridSize() {
        return gridSize;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }

    public int getPuntosX() {
        return puntosX;
    }

    public int getPuntosO() {
        return puntosO;
    }

    public boolean estaJuegoTerminado() {
        return (puntosX + puntosO) == (gridSize * gridSize);
    }
}
