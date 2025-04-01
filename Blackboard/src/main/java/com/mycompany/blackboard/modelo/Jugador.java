/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.modelo;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author joseq
 */
public class Jugador {

    private String nombre;
    private Color color;
    private ImageIcon avatar;
    private boolean listo;

    public Jugador(String nombre, Color color, ImageIcon avatar) {
        this.nombre = nombre;
        this.color = color;
        this.avatar = avatar;
        this.listo = false;
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

}
