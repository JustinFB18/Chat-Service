package ChatServiceGUI;

import ChatServiceGUI.ChatClient.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Optional;

/**
 * Control the functions and the interactivity between the user and the app.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class Controller {
    @FXML
    private TextField txtInfo;
    @FXML
    private TextArea txtMessages;
    String text = "";
    float value;
    private boolean state = false;
    Cliente client;
    /**
     * This method occurs when the window is opened and connects the client with a server.
     *
     * @throws IOException if it is not possible to connect with the server.
     */
    @FXML
    public void initialize() throws IOException {
        client = new Cliente();
        if (!state) {
            client.open();
            state = true;
        }
    }

    /**
     * When the button with the text: "Enviar" is clicked this event occurs and sends the information
     * to the server for the other client.
     *
     * @param actionEvent Receives a event of action connected to the button of send
     * @throws IOException if something wrong happens with the openConnection method.
     */
    public void btnSendClick(ActionEvent actionEvent) throws IOException {
        String Info = txtInfo.getText();
        txtInfo.setText("");
        String monto_aux = "";
        text += "\n";
        try {
            client.openConnection(Info);
            monto_aux = client.retornarMonto();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!monto_aux.equals("")){
                text += monto_aux+"\n";
                txtMessages.setText(text);
            }
            if (!Info.equals("")){
                text += Info+"\n";
                txtMessages.setText(text);
            }
        }
    }

}
