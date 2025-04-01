/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcLobby;

import com.mycompany.blackboard.modelo.Jugador;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import mvcEditarPerfil.ControladorEditarPerfil;
import mvcEditarPerfil.VistaEditarPerfil;
import mvcEditarPerfil.PerfilEditadoListener;


public class VistaLobby extends JFrame {

    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final Set<Color> coloresUsados = new HashSet<>();
    private int tamañoTablero;
    private final Color[] coloresDisponibles = {
        Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA
    };

    private final JLabel lblContador = new JLabel();

    public VistaLobby() {
        initComponents();
        BtnContinuar.setEnabled(false);
        agregarContador();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public VistaLobby(Jugador jugador, int tamanioTablero) {
        initComponents();
        this.tamañoTablero = tamanioTablero;
        agregarContador();
        agregarJugador(jugador);
        BtnContinuar.setEnabled(false);
        LblTablero.setText(tamanioTablero + " x " + tamanioTablero);
    }

    private void agregarContador() {
        lblContador.setBounds(870, 820, 300, 30);
        lblContador.setForeground(Color.WHITE);
        lblContador.setFont(new Font("Segoe UI", Font.BOLD, 18));
        JPaneTamTab.add(lblContador);
    }

    private Color asignarColorDisponible() {
        for (Color color : coloresDisponibles) {
            if (!coloresUsados.contains(color)) {
                coloresUsados.add(color);
                return color;
            }
        }
        return Color.GRAY;
    }

    public void cargarJugador(int index, Jugador jugador) {
        switch (index) {
            case 0 -> {
                LblNombre.setText(jugador.getNombre());
                BtnImgPlayer.setIcon(jugador.getAvatar());
                LblColorP.setBackground(jugador.getColor());
            }
            case 1 -> {
                LblNombre2.setText(jugador.getNombre());
                BtnImgPlayer2.setIcon(jugador.getAvatar());
                LblColorP2.setBackground(jugador.getColor());
            }
            case 2 -> {
                LblNombre3.setText(jugador.getNombre());
                BtnImgPlayer3.setIcon(jugador.getAvatar());
                LblColorP3.setBackground(jugador.getColor());
            }
            case 3 -> {
                LblNombre4.setText(jugador.getNombre());
                BtnImgPlayer4.setIcon(jugador.getAvatar());
                LblColorP4.setBackground(jugador.getColor());
            }
        }
    }

    public void verificarContinuar() {
        long listos = jugadores.stream().filter(Jugador::isListo).count();
        BtnContinuar.setEnabled(listos >= 2);
        lblContador.setText("Jugadores listos: " + listos + "/" + jugadores.size());
    }

    public void actualizarEstadoListo(int index) {
        switch (index) {
            case 0 ->
                LblNombre.setText(LblNombre.getText() + " ✅");
            case 1 ->
                LblNombre2.setText(LblNombre2.getText() + " ✅");
            case 2 ->
                LblNombre3.setText(LblNombre3.getText() + " ✅");
            case 3 ->
                LblNombre4.setText(LblNombre4.getText() + " ✅");
        }
    }

    public void agregarJugadorDemo(String nombre, ImageIcon icono) {
        Color color = asignarColorDisponible();
        Jugador jugador = new Jugador(nombre, color, icono);
        agregarJugador(jugador);
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        cargarJugador(jugadores.size() - 1, jugador);
    }

    public JButton getBtnListo() {
        return BtnListo;
    }

    public JButton getBtnContinuar() {
        return BtnContinuar;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(0);
    }

    public JButton getBtnEditar() {
        return BtnEditar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneTamTab = new javax.swing.JPanel();
        LblTab = new javax.swing.JLabel();
        BtnListo4 = new javax.swing.JButton();
        BtnImgPlayer4 = new javax.swing.JButton();
        LblNombre4 = new javax.swing.JLabel();
        LblColorP4 = new javax.swing.JLabel();
        BtnListo2 = new javax.swing.JButton();
        BtnImgPlayer2 = new javax.swing.JButton();
        LblColorP2 = new javax.swing.JLabel();
        LblNombre2 = new javax.swing.JLabel();
        BtnListo3 = new javax.swing.JButton();
        BtnImgPlayer3 = new javax.swing.JButton();
        LblNombre3 = new javax.swing.JLabel();
        LblColorP3 = new javax.swing.JLabel();
        LblColorP = new javax.swing.JLabel();
        BtnDer1 = new javax.swing.JButton();
        BtnIzq1 = new javax.swing.JButton();
        LblNombre = new javax.swing.JLabel();
        BtnImgPlayer = new javax.swing.JButton();
        BtnListo = new javax.swing.JButton();
        LblContinuar = new javax.swing.JLabel();
        BtnContinuar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        LblTablero = new javax.swing.JLabel();
        riche = new javax.swing.JButton();
        timbi = new javax.swing.JButton();
        LblFondo = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPaneTamTab.setBackground(new java.awt.Color(153, 153, 153));
        JPaneTamTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblTab.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblTab.setForeground(new java.awt.Color(255, 255, 255));
        LblTab.setText("Tablero");
        JPaneTamTab.add(LblTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, -1, -1));

        BtnListo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Palomita.png"))); // NOI18N
        BtnListo4.setContentAreaFilled(false);
        BtnListo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListo4ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnListo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 520, 110, 80));

        BtnImgPlayer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/P11m.png"))); // NOI18N
        BtnImgPlayer4.setContentAreaFilled(false);
        JPaneTamTab.add(BtnImgPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 600, 250, -1));

        LblNombre4.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblNombre4.setForeground(new java.awt.Color(255, 255, 255));
        LblNombre4.setText("(Nombre)");
        JPaneTamTab.add(LblNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 850, -1, 60));

        LblColorP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ColorRosaPlayer.png"))); // NOI18N
        JPaneTamTab.add(LblColorP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 910, 200, 80));

        BtnListo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Palomita.png"))); // NOI18N
        BtnListo2.setContentAreaFilled(false);
        BtnListo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListo2ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnListo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 40, 110, 80));

        BtnImgPlayer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/P8m.png"))); // NOI18N
        BtnImgPlayer2.setContentAreaFilled(false);
        JPaneTamTab.add(BtnImgPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 120, 250, -1));

        LblColorP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ColorAzulPlayer.png"))); // NOI18N
        JPaneTamTab.add(LblColorP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 430, 200, 80));

        LblNombre2.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblNombre2.setForeground(new java.awt.Color(255, 255, 255));
        LblNombre2.setText("(Nombre)");
        JPaneTamTab.add(LblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 370, -1, 60));

        BtnListo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Palomita.png"))); // NOI18N
        BtnListo3.setContentAreaFilled(false);
        BtnListo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListo3ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnListo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 110, 70));

        BtnImgPlayer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/P4m.png"))); // NOI18N
        BtnImgPlayer3.setContentAreaFilled(false);
        JPaneTamTab.add(BtnImgPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 250, -1));

        LblNombre3.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblNombre3.setForeground(new java.awt.Color(255, 255, 255));
        LblNombre3.setText("(Nombre)");
        JPaneTamTab.add(LblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 840, -1, 60));

        LblColorP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ColorVerdePlayer.png"))); // NOI18N
        JPaneTamTab.add(LblColorP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 900, 190, 80));

        LblColorP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ColorRojoPlayer.png"))); // NOI18N
        JPaneTamTab.add(LblColorP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 200, 80));

        BtnDer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FlechaDer.png"))); // NOI18N
        BtnDer1.setContentAreaFilled(false);
        JPaneTamTab.add(BtnDer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 110, 60));

        BtnIzq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FlechaIZQ.png"))); // NOI18N
        BtnIzq1.setContentAreaFilled(false);
        JPaneTamTab.add(BtnIzq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 110, 60));

        LblNombre.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblNombre.setForeground(new java.awt.Color(255, 255, 255));
        LblNombre.setText("(Nombre)");
        JPaneTamTab.add(LblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, 60));

        BtnImgPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/P1m.png"))); // NOI18N
        BtnImgPlayer.setContentAreaFilled(false);
        JPaneTamTab.add(BtnImgPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 250, -1));

        BtnListo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Palomita.png"))); // NOI18N
        BtnListo.setContentAreaFilled(false);
        BtnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListoActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 110, 80));

        LblContinuar.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblContinuar.setForeground(new java.awt.Color(255, 255, 255));
        LblContinuar.setText("Continuar");
        JPaneTamTab.add(LblContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 890, -1, -1));

        BtnContinuar.setBackground(new java.awt.Color(153, 0, 0));
        BtnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnContinuar.setBorder(null);
        BtnContinuar.setContentAreaFilled(false);
        BtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContinuarActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 880, -1, -1));

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EditarImg.png"))); // NOI18N
        BtnEditar.setContentAreaFilled(false);
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 110));

        LblTablero.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        LblTablero.setForeground(new java.awt.Color(255, 255, 255));
        LblTablero.setText("30 x 30");
        JPaneTamTab.add(LblTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, -1, -1));

        riche.setBackground(new java.awt.Color(153, 0, 0));
        riche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RICHE.png"))); // NOI18N
        riche.setBorder(null);
        riche.setContentAreaFilled(false);
        riche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                richeActionPerformed(evt);
            }
        });
        JPaneTamTab.add(riche, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 270, -1));

        timbi.setBackground(new java.awt.Color(153, 0, 0));
        timbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TIMBI.png"))); // NOI18N
        timbi.setBorder(null);
        timbi.setContentAreaFilled(false);
        timbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timbiActionPerformed(evt);
            }
        });
        JPaneTamTab.add(timbi, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 270, -1));

        LblFondo.setForeground(new java.awt.Color(255, 255, 255));
        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        LblFondo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JPaneTamTab.add(LblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        jTextField1.setText("jTextField1");
        JPaneTamTab.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneTamTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneTamTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed


    }//GEN-LAST:event_BtnContinuarActionPerformed

    private void richeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_richeActionPerformed

    }//GEN-LAST:event_richeActionPerformed

    private void timbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timbiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timbiActionPerformed

    private void BtnListo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListo4ActionPerformed

    }//GEN-LAST:event_BtnListo4ActionPerformed

    private void BtnListo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListo2ActionPerformed

    }//GEN-LAST:event_BtnListo2ActionPerformed

    private void BtnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListoActionPerformed

    }//GEN-LAST:event_BtnListoActionPerformed

    private void BtnListo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListo3ActionPerformed

    }//GEN-LAST:event_BtnListo3ActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
      if (!jugadores.isEmpty()) {
        Jugador jugadorActual = jugadores.get(0); // o el jugador seleccionado

        VistaEditarPerfil vistaEditar = new VistaEditarPerfil();

        ControladorEditarPerfil controladorEditar = new ControladorEditarPerfil(
            vistaEditar,
            jugadorActual,
            new PerfilEditadoListener() {
                @Override
                public void perfilEditado(Jugador jugadorActualizado) {
                    cargarJugador(0, jugadorActualizado); // índice 0 si es el host
                }
            }
        );

        vistaEditar.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "No hay jugador para editar.");
    }
    }//GEN-LAST:event_BtnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnContinuar;
    private javax.swing.JButton BtnDer1;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnImgPlayer;
    private javax.swing.JButton BtnImgPlayer2;
    private javax.swing.JButton BtnImgPlayer3;
    private javax.swing.JButton BtnImgPlayer4;
    private javax.swing.JButton BtnIzq1;
    private javax.swing.JButton BtnListo;
    private javax.swing.JButton BtnListo2;
    private javax.swing.JButton BtnListo3;
    private javax.swing.JButton BtnListo4;
    private javax.swing.JPanel JPaneTamTab;
    private javax.swing.JLabel LblColorP;
    private javax.swing.JLabel LblColorP2;
    private javax.swing.JLabel LblColorP3;
    private javax.swing.JLabel LblColorP4;
    private javax.swing.JLabel LblContinuar;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblNombre2;
    private javax.swing.JLabel LblNombre3;
    private javax.swing.JLabel LblNombre4;
    private javax.swing.JLabel LblTab;
    private javax.swing.JLabel LblTablero;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton riche;
    private javax.swing.JButton timbi;
    // End of variables declaration//GEN-END:variables

}
