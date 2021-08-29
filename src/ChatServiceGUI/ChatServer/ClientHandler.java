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

    /**
     *
     * @param client it is a socket of a specific client
     * @param clientsList it is the list of clients
     */
    public ClientHandler(Socket client, ArrayList<ClientHandler> clientsList) {
        this.client = client;
        this.clientsList = clientsList;
    }

    /**
     * Opens the elements that the system will need to communicate.
     *
     * @throws IOException If it is not possible to create DataInputStream or DataOutputStream.
     */
    public void openConnectorsForCommunications() throws IOException {
        input = new DataInputStream(client.getInputStream());
        output = new DataOutputStream(client.getOutputStream());
    }

    /**
     * Notify or send to other clients a message for one client.
     *
     * @param msg This is the message that other clients would need to receive.
     * @throws IOException If something happens with the writeUTF.
     */
    private void notifyOtherClients(String msg) throws IOException {
        for (ClientHandler cliente : clientsList) {
            if (!cliente.equals(this.client)) {
                cliente.output.writeUTF(msg);
            }
        }
    }

    /**
     * Closes or kills the created elements for communications.
     * @throws IOException if the server is impossible to close.
     */
    private void kill() throws IOException {
        input.close();
        output.close();
        client.close();
    }

    /**
     * This method executes when start is called in server class.
     *
     */
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
