/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcRegistro;

import Model.Jugador;
import View.FrmTamanoTablero;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author joseq
 */
public class ControladorRegistro {
   private final VistaRegistro vista;
    private final ModeloRegistro modelo;
    private static final ArrayList<Color> colores = new ArrayList<>();
    private static int colorIndex = 0;

    public ControladorRegistro(VistaRegistro vista, ModeloRegistro modelo) {
        this.vista = vista;
        this.modelo = modelo;

        inicializarColores();
        cargarAvatares();

        // Enlazar botón registrar
        this.vista.getBtnRegistrar().addActionListener(this::registrarJugador);
    }

    private void inicializarColores() {
        colores.add(Color.BLUE);
        colores.add(Color.RED);
        colores.add(Color.GREEN.darker());
        colores.add(Color.MAGENTA.darker());
    }

    private void cargarAvatares() {
        String[] nombresAvatares = {
            "GATO.png", "LEIA.png", "LOBO.png", "PINGUINO.png",
            "RANA.png", "ROBOCOB.png"
        };

        JPanel panel = vista.getPanelAvatares();
        panel.removeAll(); // Limpiar por si ya hay algo
        panel.setLayout(new java.awt.GridLayout(2, 3, 10, 10)); // Organiza los botones

        for (String nombre : nombresAvatares) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Avatares/" + nombre));
            JButton btn = new JButton(icon);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);

            btn.addActionListener(e -> {
                modelo.setAvatarSeleccionado(icon);
                JOptionPane.showMessageDialog(vista, "Avatar seleccionado: " + nombre);
            });

            panel.add(btn);
        }

        panel.revalidate();
        panel.repaint();
    }

    private void registrarJugador(ActionEvent e) {
        String nombre = vista.getTxtNombre().getText().trim();

        if (nombre.isEmpty() || nombre.equalsIgnoreCase("Nick") || nombre.equalsIgnoreCase("Name")) {
            JOptionPane.showMessageDialog(vista, "Ingresa un nombre válido.");
            return;
        }

        if (modelo.getAvatarSeleccionado() == null) {
            JOptionPane.showMessageDialog(vista, "Selecciona un avatar.");
            return;
        }

        Color colorAsignado = colores.get(colorIndex++ % colores.size());
        Jugador jugador = new Jugador(nombre, colorAsignado, modelo.getAvatarSeleccionado());

        // Abre la siguiente ventana
        FrmTamanoTablero tablero = new FrmTamanoTablero(jugador);
        tablero.setVisible(true);
        vista.dispose();
    }
}
