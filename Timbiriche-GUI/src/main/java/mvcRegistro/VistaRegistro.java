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
        this.setExtendedState(this.MAXIMIZED_BOTH);
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

        jLabel1 = new javax.swing.JLabel();
        JPaneRegistro = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        panelAvatares = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        LblFondoReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REGISTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 260, -1));

        txtNombre.setBackground(new java.awt.Color(225, 225, 225));
        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setText("Nick");
        txtNombre.setToolTipText("Nick");
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nick", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(204, 255, 255));
        txtNombre.setName("Nick"); // NOI18N
        txtNombre.setOpaque(true);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPaneRegistroLayout = new javax.swing.GroupLayout(JPaneRegistro);
        JPaneRegistro.setLayout(JPaneRegistroLayout);
        JPaneRegistroLayout.setHorizontalGroup(
            JPaneRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPaneRegistroLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        JPaneRegistroLayout.setVerticalGroup(
            JPaneRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPaneRegistroLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        txtNombre.getAccessibleContext().setAccessibleName("Nick");

        getContentPane().add(JPaneRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 420, 240));

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

        getContentPane().add(panelAvatares, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 400, 250));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrarse");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 780, 220, 50));

        LblFondoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        getContentPane().add(LblFondoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
