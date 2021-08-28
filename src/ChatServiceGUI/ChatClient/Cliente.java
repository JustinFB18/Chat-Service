package ChatServiceGUI.ChatClient;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Cliente {
    /**
     * The template to create clients that connect with the server in
     * a specific given port.
     *
     * @author Justin Fernández
     * @version 1
     */

    private final String HOST ="127.0.0.1";
    final int PORT = 5000;
    private DataInputStream incomingMessage;
    private DataOutputStream outgoingMessage;
    private Socket cliente;


    public void openConnectorsForCommunications() throws IOException {
        /**
         * Open the key components to have a connected client with the server and be able to send and get messages from other users since server.
         *
         *
         * @param cliente this is the creation of the socket of client
         * @param incomingMessage this is the object that get or read the
         *                        messages that the server send it of others
         *                        clients or itself.
         * @param outgoingMessage this is the object that send the messages to the server
         * @throws IOException if there is an error creating the socket due to the HOST or PORT
         *                     or creating the channels for send and get messages.
         */
        cliente = new Socket(HOST,PORT);
        incomingMessage = new DataInputStream(cliente.getInputStream());
        outgoingMessage = new DataOutputStream(cliente.getOutputStream());
    }


    public void closeConnection() {
        /**
         * It kills or closes the channels that allow to the client
         * communicate with other users through the server.
         * @throws IOException if there is an error closing the client or
         *                     channel to send message, such as try to close them
         *                     when they are closed.
         */
        try {
            cliente.close();
            outgoingMessage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() throws IOException{
        /**
         * Open the socket and the components to communicate with another users
         * through the server. Also, create a ClientRunnable object to start a new thread.
         *
         * @throws IOException if there is an error calling the openConnectorsForCommunicatiosn
         *                      or creating the ClientRunnable object.
         */
        openConnectorsForCommunications();
        ClientRunnable clientRun = new ClientRunnable(cliente.getInputStream());
        new Thread(clientRun).start();
    }

    public void openConnection(String Info) throws IOException{
        /**
         * After open the components this method starts the interchange of
         * information between users connecting with the server.
         * @throws IOException if there is an error calling writeUFT or readUFT methods for
         *                     the channels components.
         */
        while (true) {
            outgoingMessage.writeUTF(Info);
            String l1 = "";
            System.out.println("HOLAAAA");
            l1 = incomingMessage.readUTF();
            System.out.println("55555");
        }
    }
}
