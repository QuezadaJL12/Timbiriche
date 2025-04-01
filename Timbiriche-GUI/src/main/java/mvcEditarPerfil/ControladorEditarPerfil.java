/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcEditarPerfil;

import com.mycompany.blackboard.modelo.Jugador;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author joseq
 */
public class ControladorEditarPerfil {

    private final VistaEditarPerfil vista;
    private final Jugador jugador;
    private final PerfilEditadoListener listener;

    public ControladorEditarPerfil(VistaEditarPerfil vista, Jugador jugador, PerfilEditadoListener listener) {
        this.vista = vista;
        this.jugador = jugador;
        this.listener = listener;
        inicializarVista();
        inicializarListeners();
    }

    private void inicializarVista() {
        vista.actualizarAvatarSeleccionado(jugador.getAvatar());
        vista.getTxtNombre().setText(jugador.getNombre());
    }

    private void inicializarListeners() {
        vista.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.getNombreIngresado();
                ImageIcon avatar = vista.getAvatarSeleccionado();

                if (nombre.isEmpty()) {
                    vista.mostrarMensaje("Por favor ingresa tu nombre.");
                    return;
                }

                if (avatar == null) {
                    vista.mostrarMensaje("Por favor selecciona un avatar.");
                    return;
                }

                jugador.setNombre(nombre);
                jugador.setAvatar(avatar);

                if (listener != null) {
                    listener.perfilEditado(jugador);
                }

                vista.dispose();
            }
        });

        vista.getBtnCancelar().addActionListener(e -> vista.dispose());
    }

}
