package ChatServiceGUI.ChatClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The template to create clients that connect with the server in
 * a specific given port.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */

public class Cliente {

    private final String HOST ="127.0.0.1";
    private final int PORT = 5000;
    private DataInputStream incomingMessage;
    private DataOutputStream outgoingMessage;
    private Socket cliente;
    private ClientRunnable clientRun;

    /**
     * Open the key components to have a connected client with the server and be able to send and get messages from other users since server.
     *
     * @throws IOException if there is an error creating the socket due to the HOST or PORT
     *                     or creating the channels for send and get messages.
     */
    public void openConnectorsForCommunications() throws IOException {
        cliente = new Socket(HOST,PORT);
        incomingMessage = new DataInputStream(cliente.getInputStream());
        outgoingMessage = new DataOutputStream(cliente.getOutputStream());
    }

    /**
     * It kills or closes the channels that allow to the client
     * communicate with other users through the server.
     * @throws IOException if there is an error closing the client or
     *                     channel to send message, such as try to close them
     *                     when they are closed.
     */
    public void closeConnection() throws IOException {
        cliente.close();
        outgoingMessage.close();
    }

    /**
     * Open the socket and the components to communicate with another users
     * through the server. Also, create a ClientRunnable object to start a new thread.
     *
     * @throws IOException if there is an error calling the openConnectorsForCommunicatiosn
     *                      or creating the ClientRunnable object.
     */
    public void open() throws IOException{
        openConnectorsForCommunications();
        clientRun = new ClientRunnable(cliente.getInputStream(),cliente.getOutputStream());
        new Thread(clientRun).start();
    }

    /**
     * After open the components this method starts the interchange of
     * information between users connecting with the server.
     *
     * @param Info The string with the values of weight, tax and value.
     * @throws IOException if there is an error calling writeUFT or readUFT methods for
     *                     the channels components.
     */
    public void openConnection(String Info) throws IOException{
        while (true) {
            outgoingMessage.writeUTF(Info);
            break;
        }
    }

    public String calcularMonto() {
        String l1 = "";
        l1 = clientRun.getValue();
        if (!l1.equalsIgnoreCase("")){
            System.out.println(l1 + "====");
        }
        return l1;
    }

    public String retornar() throws IOException {
        return incomingMessage.readUTF();
    }
}
