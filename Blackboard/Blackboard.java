/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

import javax.swing.*;
import java.awt.*;

public class Blackboard {
    private String nombre;
    private ImageIcon avatar;
    private Color color;
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAvatar(ImageIcon avatar) { this.avatar = avatar; }
    public void setColor(Color color) { this.color = color; }
    
    public String getNombre() { return nombre; }
    public ImageIcon getAvatar() { return avatar; }
    public Color getColor() { return color; }
}