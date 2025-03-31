/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import mvcRegistro.VistaRegistro;
import mvcRegistro.ModeloRegistro;
import mvcRegistro.ControladorRegistro;

public class Run {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VistaRegistro vista = new VistaRegistro();
            ModeloRegistro modelo = new ModeloRegistro();
            new ControladorRegistro(vista, modelo);
            vista.setVisible(true);
        });
    }
}


