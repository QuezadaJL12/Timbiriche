package mvcEditarPerfil;

import com.mycompany.timbirichenetwork.modelo.Jugador;

public class ControladorEditarPerfil {

    private final VistaEditarPerfil vista;

    public ControladorEditarPerfil(Jugador jugadorOriginal) {
        this.vista = new VistaEditarPerfil(jugadorOriginal);

        vista.setPerfilEditadoListener(jugadorActualizado -> {
            System.out.println("Perfil actualizado: " + jugadorActualizado.getNombre());
            // Aquí puedes volver a publicar en el Blackboard si es necesario
            // Blackboard.getInstancia().publicar(modeloLobby);
        });
    }
}
