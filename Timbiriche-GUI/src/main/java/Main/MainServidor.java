/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.ks.KSEvaluarJugadoresListos;
import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.timbirichenetwork.Servidor;
import mvcLobby.VistaLobby;

import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author joseq
 */
public class MainServidor {

    public static void main(String[] args) {
        try {
            // 1. Instanciar el Blackboard y hacerlo global
            Blackboard blackboard = new Blackboard();
            BlackboardBridge.setBlackboard(blackboard);

            // 2. Crear la vista y el KS
            VistaLobby vistaLobby = new VistaLobby();
            KSEvaluarJugadoresListos ks = new KSEvaluarJugadoresListos();
            ks.setVistaLobbyListener(vistaLobby);
            blackboard.registrarKnowledgeSource(ks);

            // 3. Mostrar la ventana
            vistaLobby.setVisible(true);

            // 4. Agregar el jugador host
            Jugador jugadorHost = new Jugador(
                    "MrRobot",
                    Color.RED,
                    new ImageIcon(MainServidor.class.getResource("/Avatares/GATO.png"))
            );
            vistaLobby.agregarJugador(jugadorHost);

            // 5. Levantar el servidor
            Servidor servidor = new Servidor();
            servidor.iniciar(1234);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
