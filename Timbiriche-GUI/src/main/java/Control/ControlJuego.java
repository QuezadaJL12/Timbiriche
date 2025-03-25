/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Cuadro;
import Model.EstadoJuego;
import Model.Linea;
import View.FrmJuego;

/**
 * Controlador para el juego Dots and Boxes
 *
 * @author Serva (Mejorado)
 */
public class ControlJuego {

    private Linea[][] lineas;
    private Cuadro[][] cuadros;
    private int gridSize = 3;
    private String jugadorActual = "X";
    private FrmJuego vista;
    private int puntosX = 0;
    private int puntosO = 0;

    /**
     * Constructor del controlador
     *
     * @param vista Referencia a la vista
     */
    public ControlJuego(FrmJuego vista) {
        this.vista = vista;
        inicializarModelo();
    }

    /**
     * Inicializa el modelo del juego
     */
    private void inicializarModelo() {
        lineas = new Linea[gridSize * 2 + 1][gridSize * 2 + 1];
        cuadros = new Cuadro[gridSize][gridSize];

        // Inicializar líneas
        for (int i = 0; i < gridSize * 2 + 1; i++) {
            for (int j = 0; j < gridSize * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0) {
                    lineas[i][j] = new Linea();
                }
            }
        }

        // Inicializar cuadros
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cuadros[i][j] = new Cuadro();
            }
        }
    }

    /**
     * Procesa la selección de una línea por un jugador
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @param respuestaRed Simulación de respuesta de red
     */
    public void seleccionarLinea(int x, int y, String respuestaRed) {
        // Validar respuesta de red (simulada)
        if (respuestaRed == null || !respuestaRed.equals("OK") && !respuestaRed.equals("RED")) {
            System.out.println("Error de comunicación de red (simulado)");
            return;
        }

        if (!lineas[x][y].estaMarcada()) {
            // Actualizar modelo
            lineas[x][y].marcar();

            // Verificar si se completó algún cuadro
            boolean cuadroCompletado = comprobarCuadrosAdyacentes(x, y);

            // Actualizar vista
            vista.actualizarTablero(x, y, cuadroCompletado, jugadorActual);

            // Si no se completó un cuadro, cambiar turno
            if (!cuadroCompletado) {
                cambiarTurno();
            }

            // Notificar a la vista del nuevo estado
            vista.actualizarEstadoJuego(new EstadoJuego(jugadorActual, puntosX, puntosO));
        }
    }

    /**
     * Comprueba si se han completado cuadros adyacentes a la línea
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true si se completó al menos un cuadro
     */
    private boolean comprobarCuadrosAdyacentes(int x, int y) {
        boolean cuadroCompletado = false;

        // Para líneas horizontales
        if (x % 2 == 0) {
            // Comprobar cuadro de arriba
            int filaArriba = (x / 2) - 1;
            int columna = y / 2;

            if (filaArriba >= 0 && filaArriba < gridSize) {
                if (comprobarCuadro(filaArriba, columna)) {
                    cuadroCompletado = true;
                    asignarPuntos();
                }
            }

            // Comprobar cuadro de abajo
            int filaAbajo = x / 2;
            if (filaAbajo < gridSize) {
                if (comprobarCuadro(filaAbajo, columna)) {
                    cuadroCompletado = true;
                    asignarPuntos();
                }
            }
        } // Para líneas verticales
        else {
            // Comprobar cuadro de la izquierda
            int fila = x / 2;
            int columnaIzq = (y / 2) - 1;

            if (columnaIzq >= 0 && columnaIzq < gridSize) {
                if (comprobarCuadro(fila, columnaIzq)) {
                    cuadroCompletado = true;
                    asignarPuntos();
                }
            }

            // Comprobar cuadro de la derecha
            int columnaDer = y / 2;
            if (columnaDer < gridSize) {
                if (comprobarCuadro(fila, columnaDer)) {
                    cuadroCompletado = true;
                    asignarPuntos();
                }
            }
        }

        return cuadroCompletado;
    }

    /**
     * Comprueba si un cuadro específico está completo
     *
     * @param i Fila del cuadro
     * @param j Columna del cuadro
     * @return true si el cuadro se completó
     */
    private boolean comprobarCuadro(int i, int j) {
        if (cuadros[i][j].getJugador().isEmpty()
                && lineas[i * 2][j * 2 + 1].estaMarcada()
                && // Arriba
                lineas[i * 2 + 2][j * 2 + 1].estaMarcada()
                && // Abajo
                lineas[i * 2 + 1][j * 2].estaMarcada()
                && // Izquierda
                lineas[i * 2 + 1][j * 2 + 2].estaMarcada()) { // Derecha

            cuadros[i][j].asignarJugador(jugadorActual);
            return true;
        }
        return false;
    }

    /**
     * Método específico para verificar si un cuadro está completo (Usado por la
     * interfaz para actualizar correctamente los cuadros)
     *
     * @param i Fila del cuadro
     * @param j Columna del cuadro
     * @return true si el cuadro se completó
     */
    public boolean comprobarCuadroUI(int i, int j) {
        return lineas[i * 2][j * 2 + 1].estaMarcada()
                && // Arriba
                lineas[i * 2 + 2][j * 2 + 1].estaMarcada()
                && // Abajo
                lineas[i * 2 + 1][j * 2].estaMarcada()
                && // Izquierda
                lineas[i * 2 + 1][j * 2 + 2].estaMarcada(); // Derecha
    }

    /**
     * Asigna puntos al jugador actual
     */
    private void asignarPuntos() {
        if (jugadorActual.equals("X")) {
            puntosX++;
        } else {
            puntosO++;
        }
    }

    /**
     * Cambia el turno al siguiente jugador
     */
    private void cambiarTurno() {
        jugadorActual = jugadorActual.equals("X") ? "O" : "X";
    }

    /**
     * Obtiene el tamaño de la cuadrícula
     *
     * @return Tamaño de la cuadrícula
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * Obtiene el jugador actual
     *
     * @return Jugador actual
     */
    public String getJugadorActual() {
        return jugadorActual;
    }

    /**
     * Obtiene los puntos del jugador X
     *
     * @return Puntos del jugador X
     */
    public int getPuntosX() {
        return puntosX;
    }

    /**
     * Obtiene los puntos del jugador O
     *
     * @return Puntos del jugador O
     */
    public int getPuntosO() {
        return puntosO;
    }
}
