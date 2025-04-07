/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcLobby;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.blackboard.ks.KSEvaluarJugadoresListos;
import com.mycompany.blackboard.modelo.Jugador;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author joseq
 */
public class MainLobby {

    public static void main(String[] args) {
        // Crear instancia del Blackboard
        Blackboard blackboard = new Blackboard();

        // Establecerla como global (para Cliente / Servidor)
        BlackboardBridge.setBlackboard(blackboard);

        // Crear vista
        VistaLobby vistaLobby = new VistaLobby();

        // Crear fuente de conocimiento (KS)
        KSEvaluarJugadoresListos ksListos = new KSEvaluarJugadoresListos();
        ksListos.setVistaLobbyListener(vistaLobby);

        // Registrar KS en el blackboard
        blackboard.registrarKnowledgeSource(ksListos);

        // Mostrar vista
        vistaLobby.setVisible(true);

        // (Opcional) Agregar jugador host manualmente para pruebas
        Jugador jugadorHost = new Jugador("MrRobot", Color.RED, new ImageIcon(MainLobby.class.getResource("/Avatares/GATO.png")));
        vistaLobby.agregarJugador(jugadorHost);
    }

}
