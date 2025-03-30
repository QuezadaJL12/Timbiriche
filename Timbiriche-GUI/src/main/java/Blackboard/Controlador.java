/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blackboard;

import java.awt.Color;

/**
 *
 * @author Serva
 */
public class Controlador {

    private Blackboard blackboard;

    public Controlador(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public boolean procesarRegistro(String nombre, Color color) {
        if (!ValidadorRegistroKS.validarNombre(nombre)) {
            return false;
        }
        blackboard.setNombre(nombre);
        blackboard.setColor(color);
        return true;
    }
}
