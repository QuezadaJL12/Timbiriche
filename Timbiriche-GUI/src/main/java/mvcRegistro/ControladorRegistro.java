package mvcRegistro;

import com.mycompany.timbirichenetwork.modelo.Jugador;
import mvcTamanoTablero.ControladorTamanoTablero;

import javax.swing.*;

public class ControladorRegistro {

    private final ModeloRegistro modelo;
    private final VistaRegistro vista;

    public ControladorRegistro() {
        this.modelo = new ModeloRegistro();
        this.vista = new VistaRegistro();

        vista.getBtnRegistrar().addActionListener(e -> registrarJugador());
    }

    private void registrarJugador() {
        modelo.setNombre(vista.getNombre());
        modelo.setColorHex(vista.getColorHex());
        modelo.setRutaAvatar(vista.getRutaAvatar());

        if (!modelo.datosValidos()) {
            JOptionPane.showMessageDialog(vista, "Completa todos los campos.");
            return;
        }

        Jugador jugador = new Jugador(modelo.getNombre(), modelo.getColorHex(), modelo.getRutaAvatar(), false);

        vista.dispose();
        new ControladorTamanoTablero(jugador);
    }
}
