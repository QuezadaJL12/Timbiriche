package mvcTamanoTablero;

import com.mycompany.timbirichenetwork.Cliente;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcLobby.ControladorLobbyJuego;

import javax.swing.*;

public class ControladorTamanoTablero {

    private final ModeloTamanoTablero modelo;
    private final VistaTamanoTablero vista;
    private final Jugador jugador;
    private final Cliente cliente;
    

    public ControladorTamanoTablero(Jugador jugador, Cliente cliente) {
        this.cliente = cliente;
        this.jugador = jugador;
        this.modelo = new ModeloTamanoTablero();
        this.vista = new VistaTamanoTablero();

        vista.getBtnContinuar().addActionListener(e -> continuar());
    }

    private void continuar() {
        modelo.setTamañoSeleccionado(vista.getTamañoSeleccionado());

        if (modelo.getTamañoSeleccionado() <= 0) {
            JOptionPane.showMessageDialog(vista, "Selecciona un tamaño válido.");
            return;
        }

        vista.dispose();
        new ControladorLobbyJuego(jugador, modelo.getTamañoSeleccionado(), cliente);
    }
}
