package ChatServiceGUI.ChatServer;

import ChatServiceGUI.TotalAmount;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private void notifyAllClients(String msg) throws IOException{
        if (msg.equalsIgnoreCase("EXIT")) {
            this.output.writeUTF("EXIT");
        }else{
            System.out.println(String.valueOf(clientsList.size()));
            for (ClientHandler cliente : clientsList){
                if (!cliente.equals(this)){
                    cliente.output.writeUTF(msg);
                }
            }
        }
        System.out.println("3");
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
                // The logic
                List<String> textDivided = Arrays.asList(msg.split(","));
                TotalAmount.getInstance();
                float value = TotalAmount.updateValues(Integer.parseInt(textDivided.get(0)), Integer.parseInt(textDivided.get(1)), Integer.parseInt(textDivided.get(2)));
                System.out.println("value = " + value);
                msg = " El monto total a pagar es: ";
                notifyAllClients(msg);
            }
            kill();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
