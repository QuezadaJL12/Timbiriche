/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.EventoIniciarPartida.EventoIniciarPartida;
import com.mycompany.blackboard.KnowledgeSource;


import javax.swing.JButton;

/**
 *
 * @author joseq
 */
public class KSActivarBotonIniciar extends KnowledgeSource {
    
    private final JButton botonIniciar;

    public KSActivarBotonIniciar(JButton botonIniciar) {
        this.botonIniciar = botonIniciar;
    }

    @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoIniciarPartida) {
            botonIniciar.setEnabled(true);
            System.out.println("Botón 'Iniciar partida' habilitado.");
        }
    }
    
}
