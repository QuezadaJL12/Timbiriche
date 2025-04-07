/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcTamanoTablero;

import com.mycompany.blackboard.modelo.Jugador;
import java.awt.Color;
import javax.swing.*;

public class VistaTamanoTablero extends javax.swing.JFrame {

    private int tamañoSeleccionado = 0;
    private Jugador jugador;

    public VistaTamanoTablero(Jugador jugador) {
        initComponents();
        this.jugador = jugador;
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public String getNombreJugador() {
        return jugador.getNombre(); // El nombre que se registró
    }

    public String getAvatarSeleccionado() {
        String path = jugador.getAvatar().toString();
        // Extraer solo el nombre del archivo, ej: "GATO.png"
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public Color getColorSeleccionado() {
        return jugador.getColor();
    }

    // Getters necesarios para el controlador
    public JButton getBtnServidor() {
        return BtnServidor;
    }

    public JButton getBtnUnirse() {
        return BtnUnirse;
    }

    public JButton getBtnContinuar() {
        return BtnContinuar;
    }

    public JButton getBtnTam1() {
        return BtnTam1;
    }

    public JButton getBtnTam2() {
        return BtnTam2;
    }

    public JButton getBtnTam3() {
        return BtnTam3;
    }

    public void setTamañoSeleccionado(int tamaño) {
        this.tamañoSeleccionado = tamaño;
    }

    public int getTamañoSeleccionado() {
        return tamañoSeleccionado;
    }

    // Getter para el jugador
    public Jugador getJugadorSeleccionado() {
        return jugador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneTamTab = new javax.swing.JPanel();
        LblSelec = new javax.swing.JLabel();
        LblUnirse = new javax.swing.JLabel();
        LblContinuar = new javax.swing.JLabel();
        BtnUnirse = new javax.swing.JButton();
        BtnContinuar = new javax.swing.JButton();
        LblServidor = new javax.swing.JLabel();
        BtnServidor = new javax.swing.JButton();
        Lbl30x30 = new javax.swing.JLabel();
        BtnTam3 = new javax.swing.JButton();
        Lbl20x = new javax.swing.JLabel();
        BtnTam2 = new javax.swing.JButton();
        Lbl10x = new javax.swing.JLabel();
        BtnTam1 = new javax.swing.JButton();
        LblRegistro = new javax.swing.JLabel();
        LblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPaneTamTab.setBackground(new java.awt.Color(153, 153, 153));
        JPaneTamTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblSelec.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblSelec.setForeground(new java.awt.Color(255, 255, 255));
        LblSelec.setText("Seleccione");
        JPaneTamTab.add(LblSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, -1, -1));

        LblUnirse.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblUnirse.setForeground(new java.awt.Color(255, 255, 255));
        LblUnirse.setText("Unirse");
        JPaneTamTab.add(LblUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 740, -1, -1));

        LblContinuar.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblContinuar.setForeground(new java.awt.Color(255, 255, 255));
        LblContinuar.setText("Continuar");
        JPaneTamTab.add(LblContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 890, -1, -1));

        BtnUnirse.setBackground(new java.awt.Color(153, 0, 0));
        BtnUnirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnUnirse.setBorder(null);
        BtnUnirse.setContentAreaFilled(false);
        BtnUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUnirseActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 730, -1, -1));

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

        LblServidor.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        LblServidor.setText("Servidor");
        JPaneTamTab.add(LblServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 740, -1, 50));

        BtnServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 3.png"))); // NOI18N
        BtnServidor.setContentAreaFilled(false);
        BtnServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnServidorActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 730, 430, 80));

        Lbl30x30.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        Lbl30x30.setForeground(new java.awt.Color(255, 255, 255));
        Lbl30x30.setText("30 x 30");
        JPaneTamTab.add(Lbl30x30, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, -1, -1));

        BtnTam3.setBackground(new java.awt.Color(153, 0, 0));
        BtnTam3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnTam3.setBorder(null);
        BtnTam3.setContentAreaFilled(false);
        BtnTam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTam3ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnTam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, -1, -1));

        Lbl20x.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        Lbl20x.setForeground(new java.awt.Color(255, 255, 255));
        Lbl20x.setText("20 x 20");
        JPaneTamTab.add(Lbl20x, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        BtnTam2.setBackground(new java.awt.Color(153, 0, 0));
        BtnTam2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnTam2.setBorder(null);
        BtnTam2.setContentAreaFilled(false);
        BtnTam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTam2ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnTam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, -1, -1));

        Lbl10x.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        Lbl10x.setForeground(new java.awt.Color(255, 255, 255));
        Lbl10x.setText("10 x 10");
        JPaneTamTab.add(Lbl10x, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, -1, -1));

        BtnTam1.setBackground(new java.awt.Color(153, 0, 0));
        BtnTam1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnTam1.setBorder(null);
        BtnTam1.setContentAreaFilled(false);
        BtnTam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTam1ActionPerformed(evt);
            }
        });
        JPaneTamTab.add(BtnTam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, -1, -1));

        LblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        LblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        LblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LblRegistro.setText("Seleccionar Tamaño Del Tablero");
        JPaneTamTab.add(LblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 910, 100));

        LblFondo.setForeground(new java.awt.Color(255, 255, 255));
        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        LblFondo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JPaneTamTab.add(LblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

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

    private void BtnTam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTam1ActionPerformed

    }//GEN-LAST:event_BtnTam1ActionPerformed

    private void BtnTam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTam2ActionPerformed

    }//GEN-LAST:event_BtnTam2ActionPerformed

    private void BtnTam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTam3ActionPerformed

    }//GEN-LAST:event_BtnTam3ActionPerformed


    private void BtnServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnServidorActionPerformed


    }//GEN-LAST:event_BtnServidorActionPerformed

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed

    }//GEN-LAST:event_BtnContinuarActionPerformed

    private void BtnUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUnirseActionPerformed


    }//GEN-LAST:event_BtnUnirseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnContinuar;
    private javax.swing.JButton BtnServidor;
    private javax.swing.JButton BtnTam1;
    private javax.swing.JButton BtnTam2;
    private javax.swing.JButton BtnTam3;
    private javax.swing.JButton BtnUnirse;
    private javax.swing.JPanel JPaneTamTab;
    private javax.swing.JLabel Lbl10x;
    private javax.swing.JLabel Lbl20x;
    private javax.swing.JLabel Lbl30x30;
    private javax.swing.JLabel LblContinuar;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JLabel LblRegistro;
    private javax.swing.JLabel LblSelec;
    private javax.swing.JLabel LblServidor;
    private javax.swing.JLabel LblUnirse;
    // End of variables declaration//GEN-END:variables

}
