package ChatServiceGUI.ChatClient;


import java.io.*;

/**
 * Creates clients with the ability of run in separate thread at the same time
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class ClientRunnable implements Runnable{

    private final DataInputStream input;

    public ClientRunnable(InputStream socket) throws IOException {
        this.input = new DataInputStream(socket);
    }

    @Override
    public void run() {
        try{
            while(true) {
                String msg = input.readUTF();
                if(msg.equalsIgnoreCase("EXIT")) {
                    input.close();
                    break;
                }
                System.out.println(msg);

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
}

