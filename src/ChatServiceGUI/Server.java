package ChatServiceGUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ArrayList<ClientHandler> clientela;
    private ServerSocket serverSystem;

    public Server() {
        clientela = new ArrayList<ClientHandler>();
    }

    public void ServerCreate() throws IOException {
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
        serverSystem.close();
    }

    public static void main(String[] args) {
        Server myServer = new Server();
        try {
            myServer.ServerCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
