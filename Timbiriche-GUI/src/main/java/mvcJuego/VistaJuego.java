package mvcJuego;

import blackboard.IV;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaJuego extends JFrame implements IV<ModeloJuego> {

    private final JPanel panelTablero;
    private int tamaño;

    public VistaJuego() {
        setTitle("Juego Timbiriche");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelTablero = new JPanel();
        add(panelTablero, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actualizar(ModeloJuego modelo) {
        this.tamaño = modelo.getTamañoTablero();
        construirTablero(tamaño, modelo.getJugadores());
    }

    private void construirTablero(int tamaño, List<Jugador> jugadores) {
        panelTablero.removeAll();
        panelTablero.setLayout(new GridLayout(tamaño, tamaño));
        for (int i = 0; i < tamaño * tamaño; i++) {
            JButton btn = new JButton();
            btn.setBackground(Color.LIGHT_GRAY);
            panelTablero.add(btn);
        }
        panelTablero.revalidate();
        panelTablero.repaint();
    }
}
