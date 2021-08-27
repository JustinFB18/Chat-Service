package ChatServiceGUI;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    /**
     * Create the server which the users will connect to interchange
     * information among them.
     *
     * @author Justin Fernández
     * @version 1
     */
    private ArrayList<ClientHandler> clientela;
    private ServerSocket serverSystem;

    public Server() {
        /**
         * Creates an ArrayList of ClientHandler that will allow to
         * choose which client send the information.
         *
         * @param clientela this is the ArrayList of ClientHandler
         */
        clientela = new ArrayList<ClientHandler>();
    }

    public void ServerCreate() throws IOException {
        /**
         * Creates the Server and waits for clients to connect.
         * Adds the connected clients to ClientHandler object to manage easy, also
         * start the thread of ClientHandler.
         *
         * @param serverSystem this is the ServerSocket that creates the system for using later.
         * @param client this is the return value when the server accept a new user.
         * @param ClientHandler this is a object that gestionate the connected clients from a server.
         */
        final int PORT = 5000;
        serverSystem = new ServerSocket(PORT);

        while (true) {
            Socket client = serverSystem.accept();
            System.out.println("Cliente Conectado...");
            ClientHandler clientsHandler = new ClientHandler(client, clientela);
            clientela.add(clientsHandler);
            clientsHandler.start();
        }
    }

    public void kill() throws IOException {
        /**
         * Closes or kills the created server system.
         */
        serverSystem.close();
    }

    public static void main(String[] args) {
        /**
         * Main method of the Server Class that start running when the program is executed.
         * @param myServer this is the instance of the class.
         */
        Server myServer = new Server();
        try {
            myServer.ServerCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
