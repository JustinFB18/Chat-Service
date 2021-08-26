package ChatServiceGUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {
    private final String HOST ="127.0.0.1";
    final int PORT = 5000;
    private DataInputStream incomingMessage;
    private DataOutputStream outgoingMessage;
    private Socket cliente;

    public void openConnectorsForCommunications() throws IOException {
        cliente = new Socket(HOST,PORT);
        incomingMessage = new DataInputStream(cliente.getInputStream());
        outgoingMessage = new DataOutputStream(cliente.getOutputStream());
    }


    public void closeConnection() {
        try {
            cliente.close();
            outgoingMessage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void open() throws IOException{
        openConnectorsForCommunications();
        ClientRunnable clientRun = new ClientRunnable(cliente.getInputStream());
        new Thread(clientRun).start();
    }
    public void openConnection(String Info) throws IOException{
        while (true) {
            outgoingMessage.writeUTF(Info);
            String l1 = "";
            System.out.println("HOLAAAA");
            l1 = incomingMessage.readUTF();
            System.out.println("55555");
        }
    }
}
