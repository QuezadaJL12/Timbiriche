/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.EventoIniciarJuego.EventoIniciarJuego;
import com.mycompany.blackboard.KnowledgeSource;
import java.util.function.Consumer;


/**
 *
 * @author joseq
 */
public class KSIniciarJuego extends KnowledgeSource {

    private final Consumer<Void> accionIniciar;

    public KSIniciarJuego(Consumer<Void> accionIniciar) {
        this.accionIniciar = accionIniciar;
    }

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoIniciarJuego) {
            System.out.println("Recibido EventoIniciarJuego. Ejecutando acción...");
            accionIniciar.accept(null);
        }
    }

}
