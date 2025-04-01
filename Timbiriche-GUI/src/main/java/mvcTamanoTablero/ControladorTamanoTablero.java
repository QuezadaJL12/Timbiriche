/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcTamanoTablero;

import mvcLobby.VistaLobby;
import com.mycompany.blackboard.modelo.Jugador;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author joseq
 */
public class ControladorTamanoTablero {

    private final VistaTamanoTablero vista;
    private final ModeloTamanoTablero modelo;

    public ControladorTamanoTablero(VistaTamanoTablero vista, ModeloTamanoTablero modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnServidor().addActionListener(this::iniciarServidor);
        this.vista.getBtnTam1().addActionListener(e -> modelo.setTamanioTablero(10));
        this.vista.getBtnTam2().addActionListener(e -> modelo.setTamanioTablero(20));
        this.vista.getBtnTam3().addActionListener(e -> modelo.setTamanioTablero(30));
    }

    private void iniciarServidor(ActionEvent e) {
        int tam = modelo.getTamanioTablero();
        if (tam == 0) {
            JOptionPane.showMessageDialog(vista, "Selecciona un tamaño de tablero.");
            return;
        }

        Jugador jugador = vista.getJugadorSeleccionado(); 

        VistaLobby lobby = new VistaLobby(jugador, tam);
        lobby.setVisible(true);
        vista.dispose();
    }

}
