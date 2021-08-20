package ChatServiceGUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        final int PORT = 5000;
        ServerSocket serverSystem;
        Socket cliente = null;
        DataInputStream incomingMessage;
        DataOutputStream outgoingMessage;
        try {
            serverSystem = new ServerSocket(PORT);
            System.out.println("Servidor Iniciado");
            while (true) {
                cliente = serverSystem.accept();
                incomingMessage = new DataInputStream(cliente.getInputStream());
                outgoingMessage = new DataOutputStream(cliente.getOutputStream());
                outgoingMessage.writeUTF("Hola desde el server");
                String message = "";
                message = incomingMessage.readUTF();
                System.out.println("message = " + message);
                cliente.close();
                System.out.println("Cliente desconectado");
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
