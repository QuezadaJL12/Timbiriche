/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.timbirichenetwork;

import java.io.Serializable;

/**
 *
 * @author joseq
 */
public class EventoRed implements Serializable {

    private String tipo;
    private Object data;

    public EventoRed(String tipo, Object data) {
        this.tipo = tipo;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "EventoRed{tipo='" + tipo + "', data=" + data + '}';
    }

}
