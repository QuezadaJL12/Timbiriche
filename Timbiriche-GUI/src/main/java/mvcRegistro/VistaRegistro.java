/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mvcRegistro;

import javax.swing.*;

/**
 *
 * @author joseq
 */
public class VistaRegistro extends javax.swing.JFrame {

    
    public VistaRegistro() {
        initComponents();
        this.setLocationRelativeTo(null); // Centrar ventana
    }

    // Getters para el controlador
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JPanel getPanelAvatares() {
        return panelAvatares;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneRegistro = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelAvatares = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        LblFondoReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setText("Nick");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPaneRegistroLayout = new javax.swing.GroupLayout(JPaneRegistro);
        JPaneRegistro.setLayout(JPaneRegistroLayout);
        JPaneRegistroLayout.setHorizontalGroup(
            JPaneRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPaneRegistroLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        JPaneRegistroLayout.setVerticalGroup(
            JPaneRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPaneRegistroLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        getContentPane().add(JPaneRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 420, 240));

        jLabel1.setText("REGISTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        javax.swing.GroupLayout panelAvataresLayout = new javax.swing.GroupLayout(panelAvatares);
        panelAvatares.setLayout(panelAvataresLayout);
        panelAvataresLayout.setHorizontalGroup(
            panelAvataresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelAvataresLayout.setVerticalGroup(
            panelAvataresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        getContentPane().add(panelAvatares, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 400, 250));

        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 640, 210, 50));

        LblFondoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        getContentPane().add(LblFondoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPaneRegistro;
    private javax.swing.JLabel LblFondoReg;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelAvatares;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables


}
