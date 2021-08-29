package ChatServiceGUI.ChatClient;


import ChatServiceGUI.TotalAmount;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates clients with the ability of run in separate thread at the same time
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class ClientRunnable implements Runnable{

    private final DataInputStream input;
    private final DataOutputStream out;
    public String msg;
    public String msg2;

    /**
     * Initialize the components for the communication.
     * @param socketIn allows to read messages from other clients.
     * @param socketOut allows to send messages to other clients.
     * @throws IOException if something happens to create elements for communication.
     */
    public ClientRunnable(InputStream socketIn, OutputStream socketOut) throws IOException {
        this.input = new DataInputStream(socketIn);
        this.out = new DataOutputStream(socketOut);
        this.msg = "";
        this.msg2 = "";
    }

    /**
     * This method executes when start is called in cliente class.
     */
    @Override
    public void run() {
        try{
            while(true) {
                this.msg = input.readUTF();
                if(msg.equalsIgnoreCase("EXIT")) {
                    input.close();
                    break;
                } else if (!msg.equalsIgnoreCase("")) {
                    List<String> textDivided_full = Arrays.asList(msg.split("\n"));
                    List<String> textDivided = Arrays.asList(textDivided_full.get(0).split(","));
                    TotalAmount.getInstance();
                    float value = TotalAmount.updateValues(Integer.parseInt(textDivided.get(0)), Integer.parseInt(textDivided.get(1)), Integer.parseInt(textDivided.get(2)));
                    this.msg2 = textDivided_full.get(textDivided_full.size()-1) + "\n" +String.valueOf(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Getter to the msg2 attribute which works like a aux string.
     *
     * @return msg2 It contains the sended messages and the total amount.
     */
    public String getMsg2() {
        return msg2;
    }
}

