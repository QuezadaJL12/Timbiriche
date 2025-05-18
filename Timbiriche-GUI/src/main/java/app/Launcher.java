package app;

import com.mycompany.blackboard.modelo.Jugador;
import util.ProfileStorage;
import mvcEditarPerfil.ControladorEditarPerfil;

import javax.swing.*;
import java.awt.*;

/**
 * Menú principal del proyecto Timbiriche con soporte de red.
 */
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jugador perfil = ProfileStorage.loadProfile();

            if (perfil == null) {
                new ControladorEditarPerfil(); // Si no hay perfil, editar
            } else {
                mostrarMenu(perfil);
            }
        });
    }

    private static void mostrarMenu(Jugador perfil) {
        JFrame frame = new JFrame("Timbiriche - Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lbl = new JLabel("Bienvenido, " + perfil.getNombre(), SwingConstants.CENTER);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(lbl);

        JButton btnCrear = new JButton("Crear Partida (Host)");
        btnCrear.addActionListener(e -> {
            frame.dispose();
            pedirPuertoYCrear(perfil);
        });

        JButton btnUnirse = new JButton("Unirse a Partida (Cliente)");
        btnUnirse.addActionListener(e -> {
            frame.dispose();
            pedirHostPuertoYUnirse(perfil);
        });

        JButton btnEditar = new JButton("Editar Perfil");
        btnEditar.addActionListener(e -> {
            frame.dispose();
            new ControladorEditarPerfil(perfil);
        });

        frame.add(btnCrear);
        frame.add(btnUnirse);
        frame.add(btnEditar);
        frame.setVisible(true);
    }

    private static void pedirPuertoYCrear(Jugador perfil) {
        String input = JOptionPane.showInputDialog(null, "Puerto para crear la partida (ej. 12345):", "12345");
        if (input == null || input.isBlank()) return;

        try {
            int puerto = Integer.parseInt(input);
            CrearPartidaConRed.iniciar(perfil, puerto); // Llamamos una clase personalizada
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Puerto inválido.");
        }
    }

    private static void pedirHostPuertoYUnirse(Jugador perfil) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField campoIP = new JTextField("localhost");
        JTextField campoPuerto = new JTextField("12345");

        panel.add(new JLabel("Dirección IP del host:"));
        panel.add(campoIP);
        panel.add(new JLabel("Puerto:"));
        panel.add(campoPuerto);

        int result = JOptionPane.showConfirmDialog(null, panel, "Unirse a partida", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return;

        String host = campoIP.getText().trim();
        int puerto;
        try {
            puerto = Integer.parseInt(campoPuerto.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Puerto inválido.");
            return;
        }

        UnirseAPartidaConRed.iniciar(perfil, host, puerto);// Clase personalizada
    }
}
