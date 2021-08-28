package ChatServiceGUI;

import ChatServiceGUI.ChatClient.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * Control the functions and the interactivity between the user and the app.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class Controller{
    @FXML
    private TextField txtInfo;
    @FXML
    private TextArea txtMessages;
    String text = "";
    float value;
    Cliente client = new Cliente();
    private boolean state = false;

    /**
     * When the button with the text: "Conectar" is clicked this event happens and connects the client
     * with a server.
     * @param actionEvent Receives a event of action connected to the button of connect
     * @throws IOException If is not possible to connect the socket of the client with a server.
     */
    public void btnConnect(ActionEvent actionEvent) throws IOException{
        if (!state) {
            client.open();
            state = true;
        }
    }

    /**
     * When the button with the text: "Enviar" is clicked this event occurs and sends the information
     * to the server for the other client.
     * @param actionEvent Receives a event of action connected to the button of send
     * @throws IOException if something wrong happens with the openConnection method.
     */
    public void btnSendClick(ActionEvent actionEvent) throws IOException {
        String Info = txtInfo.getText();
        text += Info + "\n";
        txtMessages.setText(text);
        client.openConnection(Info);
        // client.calcularMonto()
        txtMessages.setText(text);
        System.out.println("He regresado");
        client.closeConnection();
    }
}
