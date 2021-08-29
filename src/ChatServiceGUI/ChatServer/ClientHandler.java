package ChatServiceGUI.ChatServer;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Gestionates the clients connected to a server and helps the server to access to the clients.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class ClientHandler extends Thread{

    private final Socket client;
    private final ArrayList<ClientHandler> clientsList;
    private DataOutputStream output;
    private DataInputStream input;

    public ClientHandler(Socket client, ArrayList<ClientHandler> clientsList) {
        this.client = client;
        this.clientsList = clientsList;
    }

    public void openConnectorsForCommunications() throws IOException {
        input = new DataInputStream(client.getInputStream());
        output = new DataOutputStream(client.getOutputStream());
    }

    private void notifyOtherClients(String msg) throws IOException {
        for (ClientHandler cliente : clientsList) {
            if (!cliente.equals(this.client)) {
                cliente.output.writeUTF(msg);
                System.out.println("cliente ");
            }
        }
    }

    private void kill() throws IOException {
        input.close();
        output.close();
        client.close();
    }

    @Override
    public void run(){
        try {
            openConnectorsForCommunications();
            while (true) {
                String msg = input.readUTF();
                if (msg.equalsIgnoreCase("EXIT")) {
                    break;
                }
                notifyOtherClients(msg);
            }
            kill();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
