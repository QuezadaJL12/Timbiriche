package mvcJuego;


import com.mycompany.blackboard.Blackboard;

public class ControladorJuego {

    private final VistaJuego vista;

    public ControladorJuego() {
        this.vista = new VistaJuego();
        Blackboard.getInstancia().registrar(ModeloJuego.class, vista);
    }
}
