package mvcJuego;

import com.mycompany.blackboard.Blackboard;
import com.mycompany.timbirichenetwork.eventos.EventoIniciarJuego;
import com.mycompany.timbirichenetwork.modelo.Jugador;
import java.util.Optional;

public class ControladorJuego {

    private final VistaJuego vista;
    private final Blackboard blackboard;

    public ControladorJuego() {
        this.blackboard = Blackboard.getInstancia();
        this.vista = new VistaJuego();
        
        // Registrar la vista como observador del modelo
        this.blackboard.registrar(ModeloJuego.class, vista);
        
        // Intentar obtener el modelo existente
        Optional<ModeloJuego> modeloExistente = blackboard.obtenerEstado(ModeloJuego.class);
        
        if (modeloExistente.isPresent()) {
            System.out.println("? [ControladorJuego] ModeloJuego encontrado, actualizando vista inmediatamente");
            // Actualizar la vista con el modelo existente
            vista.actualizar(modeloExistente.get());
        } else {
            System.out.println("? [ControladorJuego] ModeloJuego no encontrado, esperando publicación");
            
            // Intentar crear el modelo a partir del evento si está disponible
            blackboard.obtenerEstado(EventoIniciarJuego.class).ifPresent(evento -> {
                System.out.println("? [ControladorJuego] Creando ModeloJuego a partir de EventoIniciarJuego");
                ModeloJuego nuevoModelo = new ModeloJuego(evento.getJugadores(), evento.getTamañoTablero());
                blackboard.publicar(nuevoModelo);
            });
        }
    }
}