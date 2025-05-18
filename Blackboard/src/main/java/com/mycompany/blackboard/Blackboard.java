/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.blackboard;

import blackboard.IV;
import com.mycompany.timbirichenetwork.Evento;

import java.util.*;

/**
 *
 * @author joseq
 */
public class Blackboard {

    private final Map<Class<?>, List<IV<?>>> observadores = new HashMap<>();
    private final Map<Class<?>, Object> estadoCompartido = new HashMap<>();
    private static Blackboard instancia;

    private Blackboard() {
    }

    public static Blackboard getInstancia() {
        if (instancia == null) {
            instancia = new Blackboard();
        }
        return instancia;
    }

    public synchronized <T> void registrar(Class<T> tipo, IV<T> observador) {
        observadores.computeIfAbsent(tipo, k -> new ArrayList<>()).add(observador);
        Object actual = estadoCompartido.get(tipo);
        if (actual != null) {
            observador.actualizar(tipo.cast(actual));
        }
    }

    public synchronized <T> void publicar(T nuevoEstado) {
        if (nuevoEstado == null) {
            return;
        }

        Class<?> tipo = nuevoEstado.getClass();
        estadoCompartido.put(tipo, nuevoEstado);

        List<IV<?>> lista = observadores.getOrDefault(tipo, Collections.emptyList());
        for (IV<?> obs : lista) {
            try {
                @SuppressWarnings("unchecked")
                IV<T> observador = (IV<T>) obs;
                observador.actualizar(nuevoEstado);
            } catch (ClassCastException e) {
                // Ignorar incompatibles
            }
        }
    }

    public synchronized <T> Optional<T> obtenerEstado(Class<T> tipo) {
        Object valor = estadoCompartido.get(tipo);
        if (valor != null) {
            return Optional.of(tipo.cast(valor));
        }
        return Optional.empty();
    }

    public synchronized void publicarEvento(Evento evento) {
        if (evento == null) {
            return;
        }
        System.out.println("Evento recibido: " + evento.getClass().getSimpleName());
        publicar(evento);
    }

    public synchronized void limpiar() {
        observadores.clear();
        estadoCompartido.clear();
    }
}
