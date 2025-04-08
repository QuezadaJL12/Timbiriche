/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.modelo;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.io.Serializable;

/**
 *
 * @author joseq
 */
public class Jugador implements Serializable {

    private String nombre;
    private Color color;
    private String rutaAvatar; // Ahora guardamos la ruta
    private transient ImageIcon avatar; // Evitamos que se serialice directamente
    private boolean listo;

    public Jugador(String nombre, String colorHex, String rutaAvatar, boolean listo) {
        this.nombre = nombre;
        this.color = Color.decode(colorHex);
        this.rutaAvatar = rutaAvatar;
        this.avatar = new ImageIcon(getClass().getResource("/Avatares/" + rutaAvatar));
        this.listo = listo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getRutaAvatar() {
        return rutaAvatar;
    }

    public void setRutaAvatar(String rutaAvatar) {
        this.rutaAvatar = rutaAvatar;
        this.avatar = new ImageIcon(getClass().getResource("/Avatares/" + rutaAvatar));
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Jugador jugador = (Jugador) obj;
        return nombre.equals(jugador.nombre)
                && color.equals(jugador.color)
                && rutaAvatar.equals(jugador.rutaAvatar);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + rutaAvatar.hashCode();
        return result;
    }

}
