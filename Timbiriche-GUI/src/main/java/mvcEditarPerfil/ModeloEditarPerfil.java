/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcEditarPerfil;

import javax.swing.*;
import com.mycompany.blackboard.modelo.Jugador;

/**
 *
 * @author joseq
 */
public class ModeloEditarPerfil {

    private Jugador jugador;

    public ModeloEditarPerfil(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void actualizarPerfil(String nuevoNombre, ImageIcon nuevoAvatar) {
    jugador.setNombre(nuevoNombre);
    jugador.setAvatar(nuevoAvatar);
}


}
