package ChatServiceGUI.ChatClient;


import ChatServiceGUI.TotalAmount;

import java.io.*;
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

    public ClientRunnable(InputStream socketIn, OutputStream socketOut) throws IOException {
        this.input = new DataInputStream(socketIn);
        this.out = new DataOutputStream(socketOut);
        this.msg = "";
        this.msg2 = "";
    }

    @Override
    public void run() {
        try{
            while(true) {
                this.msg = input.readUTF();
                if(msg.equalsIgnoreCase("EXIT")) {
                    input.close();
                    break;
                } else if (!msg.equalsIgnoreCase("")) {
                    List<String> textDivided = Arrays.asList(msg.split(","));
                    TotalAmount.getInstance();
                    float value = TotalAmount.updateValues(Integer.parseInt(textDivided.get(0)), Integer.parseInt(textDivided.get(1)), Integer.parseInt(textDivided.get(2)));
                    this.msg2 = String.valueOf(value);
                    //out.writeUTF(this.msg2);
                    System.out.println("this.msg2 = " + this.msg2);
                }

                System.out.println("3231");
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
    public String getValue() {
        return this.msg2;
    }
}

