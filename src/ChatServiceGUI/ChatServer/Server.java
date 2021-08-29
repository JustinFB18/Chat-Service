package ChatServiceGUI.ChatServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Create the server which the users will connect to interchange
 * information among them.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */

public class Server {
    private ArrayList<ClientHandler> clientela;
    private ServerSocket serverSystem;

    /**
     * Creates an ArrayList of ClientHandler that will allow to
     * choose which client send the information.
     */
    public Server() {
        clientela = new ArrayList<ClientHandler>();
    }

    /**
     * Creates the Server and waits for clients to connect.
     * Adds the connected clients to ClientHandler object to manage easy, also
     * start the thread of ClientHandler.
     * @throws IOException if the server is not created or if the server can not accept a client.
     */
    public void ServerCreate() throws IOException {
        final int PORT = 5000;
        serverSystem = new ServerSocket(PORT);

        while (true) {
            // this is the return value when the server accept a new user.
            Socket client = serverSystem.accept();
            // gestionate the connected clients from a server.
            ClientHandler clientsHandler = new ClientHandler(client, clientela);
            clientela.add(clientsHandler);
            clientsHandler.start();
        }
    }

    /**
     * Closes or kills the created server system.
     * @throws IOException if the server is impossible to close.
     */
    public void kill() throws IOException {
        serverSystem.close();
    }

    /**
     * Main method of the Server Class that start running when the program is executed.
     * @param args stores the incomding command line arguments for the program
     */
    public static void main(String[] args) {
        // this is the instance of the class.
        Server myServer = new Server();
        try {
            // open the server
            myServer.ServerCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}