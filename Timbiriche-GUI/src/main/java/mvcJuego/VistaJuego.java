/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcJuego;

import com.mycompany.blackboard.modelo.Jugador;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Serva
 */
public class VistaJuego extends javax.swing.JFrame {

    private ControladorJuego controlador;
    private JPanel panelJuego;
    private JLabel lblJugadorActual;
    private JLabel lblPuntuacionX;
    private JLabel lblPuntuacionO;

    private List<Jugador> jugadores;
    private int tamañoTablero;

    // Constructor cuando ya tienes el controlador externo (opcional)
    public VistaJuego(ControladorJuego controlador) {
        this.controlador = controlador;
        initComponents();
        configurarInterfaz();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                controlador.iniciarJuego();
            }
        });
    }

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {
        long listos = jugadores.stream().filter(Jugador::isListo).count();

        if (listos >= 2) {
            List<Jugador> jugadoresListos = jugadores.stream()
                    .filter(Jugador::isListo)
                    .toList();

            Main.MainJuego.iniciar(jugadoresListos, tamañoTablero);
            this.dispose(); // Cierra la ventana del lobby

        } else {
            JOptionPane.showMessageDialog(this, "Se requieren al menos 2 jugadores listos.");
        }
    }

    // Constructor principal: crea controlador y genera tablero
    public VistaJuego(List<Jugador> jugadores, int tamañoTablero) {
        initComponents();
        this.jugadores = jugadores;
        this.tamañoTablero = tamañoTablero;

        configurarInterfaz();

        // Crear controlador automáticamente
        this.controlador = new ControladorJuego(this, jugadores, tamañoTablero);

        // Mostrar el tablero generado
        mostrarTablero(tamañoTablero);

        // Iniciar juego cuando abre
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                controlador.iniciarJuego();
            }
        });
    }

    private void configurarInterfaz() {
        JPanel panelInfo = new JPanel(new GridLayout(1, 4));
        panelInfo.setBackground(Color.WHITE);

        lblJugadorActual = new JLabel("Turno: Jugador X", SwingConstants.CENTER);
        lblPuntuacionX = new JLabel("Jugador X: 0", SwingConstants.CENTER);
        lblPuntuacionO = new JLabel("Jugador O: 0", SwingConstants.CENTER);

        panelInfo.add(lblPuntuacionX);
        panelInfo.add(lblJugadorActual);
        panelInfo.add(lblPuntuacionO);

        panelJuego = new JPanel();
        panelJuego.setBackground(Color.WHITE);
        panelJuego.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelInfo, BorderLayout.NORTH);
        panelCentral.add(panelJuego, BorderLayout.CENTER);

        JButton btnSalir = new JButton("Salir del juego");
        btnSalir.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "¿Deseas salir?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        jPanel1.setLayout(new BorderLayout());

        JPanel panelInferior = new JPanel();
        panelInferior.setOpaque(false);
        panelInferior.add(btnSalir);
        panelCentral.add(panelInferior, BorderLayout.SOUTH);

        jPanel1.add(panelCentral, BorderLayout.CENTER);

        setTitle("Timbiriche - En partida");
        setSize(900, 800);
        setLocationRelativeTo(null);
    }

    public void mostrarTablero(int gridSize) {
        panelJuego.removeAll();
        panelJuego.setLayout(new GridLayout(gridSize * 2 + 1, gridSize * 2 + 1));

        for (int i = 0; i < gridSize * 2 + 1; i++) {
            for (int j = 0; j < gridSize * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    JLabel punto = new JLabel("•", SwingConstants.CENTER);
                    punto.setFont(new Font("Arial", Font.BOLD, 24));
                    panelJuego.add(punto);
                } else if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    JButton btnLinea = new JButton();
                    btnLinea.setBackground(Color.LIGHT_GRAY);
                    final int x = i, y = j;
                    btnLinea.addActionListener(e -> controlador.seleccionarLinea(x, y));
                    panelJuego.add(btnLinea);
                } else {
                    JLabel cuadro = new JLabel();
                    cuadro.setOpaque(true);
                    cuadro.setBackground(Color.WHITE);
                    cuadro.setHorizontalAlignment(SwingConstants.CENTER);
                    cuadro.setFont(new Font("Arial", Font.BOLD, 16));
                    panelJuego.add(cuadro);
                }
            }
        }

        panelJuego.revalidate();
        panelJuego.repaint();
    }

    public void actualizarEstado(String jugador, int puntosX, int puntosO) {
        lblJugadorActual.setText("Turno: Jugador " + jugador);
        lblPuntuacionX.setText("Jugador X: " + puntosX);
        lblPuntuacionO.setText("Jugador O: " + puntosO);
    }

    public void mostrarGanador(String ganador) {
        JOptionPane.showMessageDialog(this,
                "¡Fin del juego!\nGanador: " + ganador,
                "Juego terminado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTamañoTablero() {
        return tamañoTablero;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1245, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1248, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
