package mvcLobby;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModeloLobbyJuego {
    private final List<Jugador> jugadores = new ArrayList<>();
    
    public void agregarJugador(Jugador jugador) {
        String nombreNuevo = jugador.getNombre().trim().toLowerCase();
        boolean yaExiste = jugadores.stream()
                .anyMatch(j -> j.getNombre().trim().toLowerCase().equals(nombreNuevo));
        
        if (!yaExiste) {
            jugadores.add(jugador);
            System.out.println("? [Modelo] Jugador AGREGADO: " + jugador.getNombre() + " | listo=" + jugador.isListo());
        } else {
            System.out.println("? [Modelo] Jugador DUPLICADO ignorado: " + jugador.getNombre());
        }
        imprimirEstado();
    }
    
    // Método auxiliar para depuración
    public void imprimirJugadores() {
        System.out.println(">>> ESTADO ACTUAL DE JUGADORES:");
        for (Jugador j : jugadores) {
            System.out.println("- " + j.getNombre() + " | listo=" + j.isListo());
        }
    }
    
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
    public boolean puedeIniciar() {
        imprimirJugadores(); // Depuración
        long listos = jugadores.stream().filter(Jugador::isListo).count();
        return listos >= 2 && listos <= 4;
    }
    
    public void marcarJugadorListo(Jugador jugador) {
        boolean actualizado = false;
        for (Jugador j : jugadores) {
            if (j.getNombre().trim().equalsIgnoreCase(jugador.getNombre().trim())) {
                j.setListo(true);
                actualizado = true;
                System.out.println("? Jugador marcado como listo: " + jugador.getNombre());
                break;
            }
        }
        
        if (!actualizado) {
            // El jugador no existe, así que lo agregamos
            jugador.setListo(true);
            jugadores.add(jugador);
            System.out.println("? Jugador agregado y marcado como listo: " + jugador.getNombre());
        }
        
        imprimirEstado();
    }
    
    public void actualizarJugador(Jugador jugador) {
        boolean actualizado = false;
        for (Jugador j : jugadores) {
            if (j.getNombre().trim().equalsIgnoreCase(jugador.getNombre().trim())) {
                j.setListo(jugador.isListo());
                actualizado = true;
                System.out.println("? [Modelo] Jugador ACTUALIZADO: " + jugador.getNombre() + " | listo=" + jugador.isListo());
                break;
            }
        }
        
        if (!actualizado) {
            // Si no existe, lo agregamos
            jugadores.add(jugador);
            System.out.println("? [Modelo] Jugador no encontrado, AGREGADO: " + jugador.getNombre() + " | listo=" + jugador.isListo());
        }
        
        imprimirEstado();
    }
    
    public void eliminarDuplicados() {
        List<Jugador> sinDuplicados = jugadores.stream()
                .collect(Collectors.toMap(
                        j -> j.getNombre().trim().toLowerCase(),
                        j -> j,
                        (j1, j2) -> j1))
                .values().stream().toList();
        
        jugadores.clear();
        jugadores.addAll(sinDuplicados);
        System.out.println("? [Modelo] Duplicados eliminados");
        imprimirEstado();
    }
    
    public void imprimirEstado() {
        System.out.println("? [Modelo] Estado actual de jugadores:");
        jugadores.forEach(j ->
                System.out.println("   - " + j.getNombre() + " | listo=" + j.isListo()));
    }
}