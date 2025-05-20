
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcJuego.ModeloJuego;

import java.util.List;
import javax.swing.ImageIcon;

public class KSIniciarJuego {

    public void iniciar(List<Jugador> jugadores, int tamañoTablero) {
        System.out.println("? [KSIniciarJuego] Iniciando juego con " + jugadores.size() + " jugadores");
        
        // Asegurar que todos los jugadores tengan sus avatares cargados
        for (Jugador j : jugadores) {
            if (j.getAvatar() == null && j.getRutaAvatar() != null && !j.getRutaAvatar().isEmpty()) {
                System.out.println("? [KSIniciarJuego] Cargando avatar para " + j.getNombre());
                j.setAvatar(new ImageIcon(j.getRutaAvatar()));
            }
        }
        
        // Crear el modelo de juego
        ModeloJuego modelo = new ModeloJuego(jugadores, tamañoTablero);
        modelo.imprimirEstado(); // Para depuración
        
        // Publicar el modelo en el Blackboard
        System.out.println("? [KSIniciarJuego] Publicando ModeloJuego en el Blackboard");
        Blackboard.getInstancia().publicar(modelo);
    }
}