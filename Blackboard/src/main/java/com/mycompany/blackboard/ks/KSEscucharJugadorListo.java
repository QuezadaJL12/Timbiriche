/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackboard.ks;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.Evento;
import com.mycompany.blackboard.eventos.EventoJugadorListo;
import com.mycompany.blackboard.KnowledgeSource;

import com.mycompany.blackboard.modelo.Jugador;
import com.mycompany.blackboard.modelo.JugadorRed;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author joseq
 */
public class KSEscucharJugadorListo extends KnowledgeSource{
    
     @Override
    public void procesarEvento(Evento evento, Blackboard blackboard) {
        if (evento instanceof EventoJugadorListo jugadorEvento) {
            JugadorRed jr = jugadorEvento.getJugador();

            // ✅ Conversión de JugadorRed → Jugador
            Color color = Color.decode(jr.getColorHex());
            ImageIcon avatar = new ImageIcon(getClass().getResource("/Avatares/" + jr.getAvatarPath()));
            Jugador jugador = new Jugador(jr.getNombre(), color, avatar);
            jugador.setListo(jr.isListo());

            // ✅ Aquí puedes usar el jugador en tu lógica de lobby
            System.out.println("👤 Jugador listo recibido desde red:");
            System.out.println("  Nombre: " + jugador.getNombre());
            System.out.println("  Color : " + jugador.getColor());
            System.out.println("  Avatar: " + jr.getAvatarPath());
        }
    }
    
}
