package ChatServiceGUI;

import ChatServiceGUI.ChatClient.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller{
    @FXML
    private TextField txtInfo;
    @FXML
    private TextArea txtMessages;
    String text = "";
    float value;
    Cliente client = new Cliente();
    private boolean state = false;

    public void btnConnect(ActionEvent actionEvent) throws IOException{
        if (!state) {
            client.open();
            state = true;
        }
    }

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
