/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.modelo.Jugador;
import mvcJuego.VistaJuego;
import java.util.List;

/**
 *
 * @author joseq
 */
public class MainJuego {

    public static void iniciar(List<Jugador> jugadores, int tamañoTablero) {
        Blackboard blackboard = new Blackboard();
        BlackboardBridge.setBlackboard(blackboard);

        VistaJuego vistaJuego = new VistaJuego(jugadores, tamañoTablero);
        vistaJuego.setVisible(true);
    }

}
