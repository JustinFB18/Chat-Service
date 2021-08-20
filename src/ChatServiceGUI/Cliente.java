package ChatServiceGUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        final String HOST ="127.0.0.1";
        final int PORT = 5000;
        DataInputStream incomingMessage;
        DataOutputStream outgoingMessage;
        try {
            Socket cliente = new Socket(HOST,PORT);
            incomingMessage = new DataInputStream(cliente.getInputStream());
            outgoingMessage = new DataOutputStream(cliente.getOutputStream());
            outgoingMessage.writeUTF("Hola desde el cliente");
            String message = incomingMessage.readUTF();
            System.out.println("message = " + message);
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
