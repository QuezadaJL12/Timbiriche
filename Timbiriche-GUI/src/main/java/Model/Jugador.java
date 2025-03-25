/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author joseq
 */
public class Jugador {
    
     private String nombreUsuario;
    private Color color;
    private ImageIcon avatar;

    public Jugador(String nombreUsuario, Color color, ImageIcon avatar) {
        this.nombreUsuario = nombreUsuario;
        this.color = color;
        this.avatar = avatar;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }
    
      @Override
    public String toString() {
        return "Jugador{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", color=" + color +
                ", avatar=" + (avatar != null ? avatar.getDescription() : "null") +
                '}';
    }
    
}
