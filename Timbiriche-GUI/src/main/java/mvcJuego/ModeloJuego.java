package mvcJuego;

import com.mycompany.timbirichenetwork.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ModeloJuego {

    private final List<Jugador> jugadores;
    private final int tamañoTablero;
    private final int[][] tablero; // Matrix para representar el estado del tablero
    private int jugadorActual = 0; // Índice del jugador actual en la lista

    public ModeloJuego(List<Jugador> jugadores, int tamañoTablero) {
        // Hacer una copia de la lista de jugadores para evitar modificaciones externas
        this.jugadores = new ArrayList<>(jugadores);
        this.tamañoTablero = tamañoTablero;
        
        // Inicializar tablero con ceros (0 = celda vacía)
        this.tablero = new int[tamañoTablero][tamañoTablero];
        
        // Log para depuración
        System.out.println("? [ModeloJuego] Modelo creado con " + jugadores.size() + 
                          " jugadores y tablero " + tamañoTablero + "x" + tamañoTablero);
    }

    public List<Jugador> getJugadores() {
        return new ArrayList<>(jugadores); // Devolver copia para evitar modificaciones
    }

    public int getTamañoTablero() {
        return tamañoTablero;
    }
    
    public int[][] getTablero() {
        // Devolver copia para evitar modificaciones directas
        int[][] copia = new int[tamañoTablero][tamañoTablero];
        for (int i = 0; i < tamañoTablero; i++) {
            System.arraycopy(tablero[i], 0, copia[i], 0, tamañoTablero);
        }
        return copia;
    }
    
    public Jugador getJugadorActual() {
        return jugadores.get(jugadorActual);
    }
    
    public void cambiarTurno() {
        jugadorActual = (jugadorActual + 1) % jugadores.size();
    }
    
    public void marcarCasilla(int fila, int columna, int idJugador) {
        if (fila >= 0 && fila < tamañoTablero && columna >= 0 && columna < tamañoTablero) {
            tablero[fila][columna] = idJugador;
        }
    }
    
    /**
     * Verifica si todos los jugadores cargaron correctamente sus avatares
     */
    public boolean jugadoresCompletos() {
        for (Jugador j : jugadores) {
            if (j.getAvatar() == null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Imprime el estado actual del modelo para depuración
     */
    public void imprimirEstado() {
        System.out.println("Estado del ModeloJuego:");
        System.out.println("- Tamaño tablero: " + tamañoTablero + "x" + tamañoTablero);
        System.out.println("- Jugadores (" + jugadores.size() + "):");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println("  " + (i+1) + ". " + j.getNombre() + 
                              " (listo=" + j.isListo() + 
                              ", avatar=" + (j.getAvatar() != null ? "cargado" : "no cargado") + ")");
        }
    }
}