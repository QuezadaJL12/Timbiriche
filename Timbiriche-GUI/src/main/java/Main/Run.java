/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import com.mycompany.blackboard.modelo.Jugador;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import mvcJuego.ControladorJuego;

public class Run {

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Player X", Color.RED, new ImageIcon("src/main/resources/Avatares/GATO.png"));
        Jugador jugador2 = new Jugador("Player O", Color.BLUE, new ImageIcon("src/main/resources/Avatares/PINGUINO.png"));

        new ControladorJuego(List.of(jugador1, jugador2), 10); // 10 = tablero 3x3
    }
}
