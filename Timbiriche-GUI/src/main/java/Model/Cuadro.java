/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Serva
 */
public class Cuadro {
    private String jugador;

    public Cuadro() {
        this.jugador = "";
    }

    public boolean verificarCompleto(Linea[][] lineas, int i, int j) {
        return lineas[i * 2][j * 2 + 1].estaMarcada() && // Arriba
               lineas[i * 2 + 2][j * 2 + 1].estaMarcada() && // Abajo
               lineas[i * 2 + 1][j * 2].estaMarcada() && // Izquierda
               lineas[i * 2 + 1][j * 2 + 2].estaMarcada(); // Derecha
    }

    public void asignarJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getJugador() {
        return jugador;
    }
}
