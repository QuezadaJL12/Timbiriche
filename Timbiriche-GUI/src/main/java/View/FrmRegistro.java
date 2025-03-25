/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Jugador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;



/**
 *
 * @author rramirez
 */
public class FrmRegistro extends JFrame {

    private JTextField txtNombre;
    private JPanel panelAvatares;
    private ImageIcon avatarSeleccionado;
    private static final ArrayList<Color> colores = new ArrayList<>();
    private static int colorIndex = 0;

    public FrmRegistro() {
       setTitle("Registro de Jugador");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarColores();
        initUI();
        setVisible(true);

    }

    private void initUI() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(180, 40, 70));

        JLabel lblTitulo = new JLabel("Registro");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtNombre = new JTextField("Usuario", 20);
        txtNombre.setMaximumSize(new Dimension(300, 40));
        txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtNombre.getText().equals("Usuario")) {
                    txtNombre.setText("");
                    txtNombre.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNombre.getText().trim().isEmpty()) {
                    txtNombre.setText("Usuario");
                    txtNombre.setForeground(Color.GRAY);
                }
            }
        });
        
                panelAvatares = new JPanel(new GridLayout(2, 4, 10, 10));
        panelAvatares.setOpaque(false);
        panelAvatares.setMaximumSize(new Dimension(400, 200));
        panelAvatares.setAlignmentX(Component.CENTER_ALIGNMENT);
        cargarAvatares();

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.addActionListener(this::registrarJugador);

        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));
        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(txtNombre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panelAvatares);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnRegistrar);

        add(panelPrincipal, BorderLayout.CENTER);
    }

        
    private void cargarAvatares() {
       String[] nombresAvatares = {
            "GATO.png", "LEIA.png", "LOBO.png", "PINGUINO.png",
            "RANA.png", "ROBOCOB.png"
        };

        for (String nombre : nombresAvatares) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Avatares/" + nombre));
            JButton btnAvatar = new JButton(icon);
            btnAvatar.setContentAreaFilled(false);
            btnAvatar.setBorderPainted(false);
            btnAvatar.setFocusPainted(false);

            btnAvatar.addActionListener(e -> {
                avatarSeleccionado = icon;
                JOptionPane.showMessageDialog(this, "Avatar seleccionado: " + nombre);
            });

            panelAvatares.add(btnAvatar);
        }
    }

    private void registrarJugador(ActionEvent e) {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty() || nombre.equals("Usuario")) {
            JOptionPane.showMessageDialog(this, "Ingresa un nombre válido.");
            return;
        }

        if (avatarSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un avatar.");
            return;
        }

        Color colorAsignado = colores.get(colorIndex++ % colores.size());
        Jugador jugador = new Jugador(nombre, colorAsignado, avatarSeleccionado);

        FrmJuego frmJuego = new FrmJuego(jugador);
        frmJuego.setVisible(true);
        this.dispose();
    }

    private void inicializarColores() {
        colores.add(Color.BLUE);
        colores.add(Color.RED);
        colores.add(Color.GREEN.darker());
        colores.add(Color.ORANGE.darker());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneRegistro = new javax.swing.JPanel();
        LblRegistrar = new javax.swing.JLabel();
        LblRegistro = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        LblFondoReg = new javax.swing.JLabel();
        LblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPaneRegistro.setBackground(new java.awt.Color(153, 153, 153));
        JPaneRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LblRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        LblRegistrar.setText("Registrar");
        JPaneRegistro.add(LblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 810, -1, -1));

        LblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        LblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        LblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LblRegistro.setText("Registro");
        JPaneRegistro.add(LblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 240, 100));

        TxtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        TxtUsuario.setText("Usuario");
        TxtUsuario.setToolTipText("Usuario");
        TxtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TxtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TxtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtUsuarioFocusLost(evt);
            }
        });
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });
        JPaneRegistro.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 480, 70));

        LblFondoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 5.png"))); // NOI18N
        LblFondoReg.setAlignmentY(0.0F);
        LblFondoReg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LblFondoReg.setPreferredSize(new java.awt.Dimension(623, 1000));
        JPaneRegistro.add(LblFondoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 630, 910));

        LblFondo.setBackground(new java.awt.Color(76, 76, 76));
        LblFondo.setForeground(new java.awt.Color(68, 68, 68));
        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        LblFondo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JPaneRegistro.add(LblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

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

    private void TxtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtUsuarioFocusGained
        // TODO add your handling code here:
        if (TxtUsuario.getText().equals("Usuario")) {
            TxtUsuario.setText("");
            TxtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtUsuarioFocusGained

    private void TxtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtUsuarioFocusLost
        // TODO add your handling code here:
        if (TxtUsuario.getText().equals("")) {
            TxtUsuario.setText("Usuario");
            TxtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtUsuarioFocusLost

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPaneRegistro;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JLabel LblFondoReg;
    private javax.swing.JLabel LblRegistrar;
    private javax.swing.JLabel LblRegistro;
    private javax.swing.JTextField TxtUsuario;
    // End of variables declaration//GEN-END:variables
}
