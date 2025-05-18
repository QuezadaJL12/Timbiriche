package mvcLobby;

import blackboard.IV;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaLobby extends JFrame implements IV<ModeloLobbyJuego> {

    private final JPanel panelJugadores;
    private final JButton btnIniciar;
    private final JButton btnEditarPerfil;

    public VistaLobby() {
        setTitle("Lobby de Jugadores");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelJugadores = new JPanel();
        panelJugadores.setLayout(new BoxLayout(panelJugadores, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(panelJugadores);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnIniciar = new JButton("Iniciar Partida");
        btnEditarPerfil = new JButton("Editar Perfil");
        panelBotones.add(btnEditarPerfil);
        panelBotones.add(btnIniciar);

        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public JButton getBtnEditarPerfil() {
        return btnEditarPerfil;
    }

    @Override
    public void actualizar(ModeloLobbyJuego modelo) {
        actualizarVista(modelo.getJugadores());
    }

    private void actualizarVista(List<Jugador> jugadores) {
        panelJugadores.removeAll();
        for (Jugador j : jugadores) {
            JLabel lbl = new JLabel(j.getNombre() + (j.isListo() ? " ✅" : " ⏳"));
            lbl.setForeground(Color.decode(j.getColorHex()));
            panelJugadores.add(lbl);
        }
        panelJugadores.revalidate();
        panelJugadores.repaint();
    }
}
