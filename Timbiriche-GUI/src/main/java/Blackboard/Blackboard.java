/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Blackboard {
    private String nombre;
    private ImageIcon avatar;
    private Color color;
    private final List<BlackboardObserver> observers = new ArrayList<>();
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
        notifyObservers();
    }
    
    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
        notifyObservers();
    }
    
    public void setColor(Color color) {
        this.color = color;
        notifyObservers();
    }
    
    public String getNombre() { return nombre; }
    public ImageIcon getAvatar() { return avatar; }
    public Color getColor() { return color; }
    
    public void addObserver(BlackboardObserver observer) {
        observers.add(observer);
    }
    
    private void notifyObservers() {
        for (BlackboardObserver observer : observers) {
            observer.onBlackboardUpdated(this);
        }
    }
}
