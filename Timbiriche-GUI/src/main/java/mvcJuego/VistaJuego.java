package mvcJuego;

import blackboard.IV;
import com.mycompany.timbirichenetwork.modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaJuego extends JFrame implements IV<ModeloJuego> {

    private final JPanel panelTablero;
    private final JPanel panelJugadores;
    private int tamaño;
    private ModeloJuego modeloActual;

    public VistaJuego() {
        setTitle("Juego Timbiriche");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para mostrar información de los jugadores
        panelJugadores = new JPanel();
        panelJugadores.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelJugadores.setBorder(BorderFactory.createTitledBorder("Jugadores"));
        add(panelJugadores, BorderLayout.NORTH);

        // Panel para el tablero de juego
        panelTablero = new JPanel();
        panelTablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panelTablero);
        add(scrollPane, BorderLayout.CENTER);
        
        // Mensaje inicial
        JLabel labelInicial = new JLabel("Esperando datos del juego...", SwingConstants.CENTER);
        panelTablero.add(labelInicial);
        
        setVisible(true);
        System.out.println("? [VistaJuego] Vista inicializada y visible");
    }

    @Override
    public void actualizar(ModeloJuego modelo) {
        if (modelo == null) {
            System.err.println("? [VistaJuego] Se recibió un modelo nulo");
            return;
        }
        
        this.modeloActual = modelo;
        this.tamaño = modelo.getTamañoTablero();
        
        System.out.println("? [VistaJuego] Actualizando vista con tamaño: " + tamaño + 
                          " y " + modelo.getJugadores().size() + " jugadores");
        
        // Actualizar el panel de jugadores
        actualizarPanelJugadores(modelo.getJugadores());
        
        // Construir el tablero
        construirTablero(tamaño, modelo.getJugadores());
        
        // Refrescar la interfaz
        revalidate();
        repaint();
    }

    private void actualizarPanelJugadores(List<Jugador> jugadores) {
        panelJugadores.removeAll();
        
        for (Jugador jugador : jugadores) {
            JPanel panelJugador = new JPanel();
            panelJugador.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            // Añadir avatar si está disponible
            if (jugador.getAvatar() != null) {
                ImageIcon icon = jugador.getAvatar();
                // Redimensionar si es necesario
                if (icon.getIconWidth() > 30 || icon.getIconHeight() > 30) {
                    icon = new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                }
                panelJugador.add(new JLabel(icon));
            }
            
            // Añadir nombre del jugador con su color
            JLabel lblNombre = new JLabel(jugador.getNombre());
            try {
                lblNombre.setForeground(Color.decode(jugador.getColorHex()));
            } catch (Exception e) {
                System.err.println("Error al decodificar color: " + jugador.getColorHex());
            }
            panelJugador.add(lblNombre);
            
            // Añadir estado listo
            JLabel lblListo = new JLabel(jugador.isListo() ? "✓" : "...");
            panelJugador.add(lblListo);
            
            panelJugadores.add(panelJugador);
        }
        
        panelJugadores.revalidate();
        panelJugadores.repaint();
    }

    private void construirTablero(int tamaño, List<Jugador> jugadores) {
        panelTablero.removeAll();
        
        // Configurar el layout del tablero
        panelTablero.setLayout(new GridLayout(tamaño, tamaño, 2, 2));
        panelTablero.setBackground(Color.DARK_GRAY);
        
        // Crear el tablero con celdas visibles
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                JPanel celda = new JPanel();
                celda.setBackground(Color.WHITE);
                celda.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                
                // Mostrar coordenadas para depuración
                celda.setToolTipText("Celda (" + i + "," + j + ")");
                
                // Añadir listeners para marcar la celda (se implementará en una versión futura)
                final int fila = i;
                final int columna = j;
                celda.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println("Celda clickeada: (" + fila + "," + columna + ")");
                        // Aquí se implementará la lógica de marcar la celda
                    }
                });
                
                panelTablero.add(celda);
            }
        }
        
        System.out.println("? [VistaJuego] Tablero construido con tamaño " + tamaño + "x" + tamaño);
        panelTablero.revalidate();
        panelTablero.repaint();
    }
}