package main;


import com.mycompany.blackboard.Blackboard;
import com.mycompany.blackboard.BlackboardBridge;
import com.mycompany.timbirichenetwork.Cliente;
import mvcRegistro.ControladorRegistro;

public class MainRegistro {

    public static void main(String[] args) {
        // Inicializar Blackboard
        Blackboard blackboard = Blackboard.getInstancia();
        BlackboardBridge.setBlackboard(blackboard);

        // Crear cliente TCP y conectar al servidor
        Cliente cliente = new Cliente("localhost", 5000);  // Ajusta si el servidor no está en localhost

        // Iniciar flujo de registro
        new ControladorRegistro();
    }
}
