/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcEditarPerfil;

import com.mycompany.blackboard.modelo.Jugador;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rramirez
 */
public class VistaEditarPerfil extends JFrame {

    private PerfilEditadoListener listener;
    private ImageIcon avatarSeleccionado;

    public VistaEditarPerfil() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public void setPerfilEditadoListener(PerfilEditadoListener listener) {
        this.listener = listener;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public String getNombreIngresado() {
        return txtNombre.getText().trim();
    }

    public ImageIcon getAvatarSeleccionado() {
        return avatarSeleccionado;
    }

    public void actualizarAvatarSeleccionado(ImageIcon iconoOriginal) {
        int ancho = LblAvatarSeleccionado.getWidth();
        int alto = LblAvatarSeleccionado.getHeight();
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        LblAvatarSeleccionado.setIcon(iconoEscalado);
        avatarSeleccionado = iconoOriginal;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public JButton getBtnAceptar() {
        return BtnAceptar;
    }

    public JButton getBtnCancelar() {
        return BtnCancelar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneRegistro = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        BtnAceptar = new javax.swing.JButton();
        avatar = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Lbln = new javax.swing.JLabel();
        LblRegistro = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        LblAvatarSeleccionado = new javax.swing.JLabel();
        LblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPaneRegistro.setBackground(new java.awt.Color(153, 153, 153));
        JPaneRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setText("nick");
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        JPaneRegistro.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 230, 40));

        BtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnAceptar.setContentAreaFilled(false);
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });
        JPaneRegistro.add(BtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 880, -1, 80));

        avatar.setFont(new java.awt.Font("Comic Sans MS", 1, 38)); // NOI18N
        avatar.setForeground(new java.awt.Color(255, 255, 255));
        avatar.setText("Avatar");
        JPaneRegistro.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 130, -1));

        Nombre.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        Nombre.setForeground(new java.awt.Color(204, 204, 204));
        Nombre.setText("Nombre");
        JPaneRegistro.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, -1, -1));

        Lbln.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4 white.png"))); // NOI18N
        JPaneRegistro.add(Lbln, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, 80));

        LblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        LblRegistro.setFont(new java.awt.Font("Comic Sans MS", 1, 60)); // NOI18N
        LblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LblRegistro.setText("Editar Perfil");
        JPaneRegistro.add(LblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 370, 100));

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 4.png"))); // NOI18N
        BtnCancelar.setContentAreaFilled(false);
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        JPaneRegistro.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 880, -1, 80));
        JPaneRegistro.add(LblAvatarSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, -1, -1));

        LblFondo.setForeground(new java.awt.Color(255, 255, 255));
        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        LblFondo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JPaneRegistro.add(LblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 1920, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed

    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed

    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JPanel JPaneRegistro;
    private javax.swing.JLabel LblAvatarSeleccionado;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JLabel LblRegistro;
    private javax.swing.JLabel Lbln;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel avatar;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
