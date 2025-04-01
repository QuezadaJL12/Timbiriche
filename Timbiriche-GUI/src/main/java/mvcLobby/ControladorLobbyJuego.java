/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcLobby;


import com.mycompany.blackboard.modelo.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvcEditarPerfil.ControladorEditarPerfil;
import mvcEditarPerfil.PerfilEditadoListener;
import mvcEditarPerfil.VistaEditarPerfil;

/**
 *
 * @author joseq
 */
public class ControladorLobbyJuego {

   private VistaLobby vistaLobby;
    private Jugador jugador;

    public ControladorLobbyJuego(VistaLobby vistaLobby, Jugador jugador) {
        this.vistaLobby = vistaLobby;
        this.jugador = jugador;

        inicializarListeners();
    }

    private void inicializarListeners() {
        vistaLobby.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEdicionPerfil();
            }
        });
    }

    private void abrirEdicionPerfil() {
        VistaEditarPerfil vistaEditar = new VistaEditarPerfil();

        ControladorEditarPerfil controladorEditar = new ControladorEditarPerfil(
            vistaEditar,
            jugador,
            new PerfilEditadoListener() {
                @Override
                public void perfilEditado(Jugador jugadorActualizado) {
                    // Actualiza la vista del lobby con la nueva información
                    vistaLobby.cargarJugador(0, jugadorActualizado); // índice 0 si es el host
                }
            }
        );

        vistaEditar.setVisible(true);
    }
}
