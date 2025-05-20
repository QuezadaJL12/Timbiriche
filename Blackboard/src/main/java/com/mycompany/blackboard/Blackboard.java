// ✅ Blackboard.java
package com.mycompany.blackboard;

import blackboard.IV;
import com.mycompany.timbirichenetwork.Evento;

import java.util.*;

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
            System.out.println("? Enviando estado actual a nuevo observador de " + tipo.getSimpleName());
            observador.actualizar(tipo.cast(actual));
        }
    }

    public synchronized <T> void publicar(T nuevoEstado) {
        if (nuevoEstado == null) {
            return;
        }

        Class<?> tipo = nuevoEstado.getClass();
        estadoCompartido.put(tipo, nuevoEstado);

        System.out.println("? Publicando nuevo estado: " + tipo.getSimpleName());

        if (tipo == mvcLobby.ModeloLobbyJuego.class) {
            mvcLobby.ModeloLobbyJuego modelo = (mvcLobby.ModeloLobbyJuego) nuevoEstado;
            System.out.println("? Contenido del estado actual de ModeloLobbyJuego:");
            modelo.getJugadores().forEach(j
                    -> System.out.println("   - " + j.getNombre() + " | listo=" + j.isListo()));
        }

        List<IV<?>> lista = observadores.getOrDefault(tipo, Collections.emptyList());
        for (IV<?> obs : lista) {
            try {
                @SuppressWarnings("unchecked")
                IV<T> observador = (IV<T>) obs;
                System.out.println("? Notificando a observador: " + observador.getClass().getSimpleName());
                observador.actualizar(nuevoEstado);
            } catch (ClassCastException e) {
                System.out.println("⚠ Error de casting en observador para " + tipo.getSimpleName());
            }
        }
    }

    public synchronized <T> Optional<T> obtenerEstado(Class<T> tipo) {
        Object valor = estadoCompartido.get(tipo);
        System.out.println(valor == null ? "?? Estado no encontrado para: " + tipo.getSimpleName() : "? Estado obtenido para: " + tipo.getSimpleName());
        return Optional.ofNullable(tipo.cast(valor));
    }

    public synchronized void publicarEvento(Evento evento) {
        if (evento == null) {
            return;
        }
        System.out.println("? Evento recibido: " + evento.getClass().getSimpleName());
        publicar(evento);
    }

    public void forzarPublicacion(Class<?> claseModelo) {
        Optional<?> estado = this.obtenerEstado(claseModelo);
        estado.ifPresent(obj -> {
            System.out.println("? Forzando publicación manual del modelo: " + claseModelo.getSimpleName());
            this.publicar(obj);
        });
    }

    public synchronized void limpiar() {
        observadores.clear();
        estadoCompartido.clear();
    }
}
