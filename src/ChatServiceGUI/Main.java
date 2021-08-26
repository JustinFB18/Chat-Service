package ChatServiceGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ChatServiceApp.fxml"));
        primaryStage.setTitle("Chat Service");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setX(200);
        primaryStage.setY(200);
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("Images/Icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
        Parent root2 = FXMLLoader.load(getClass().getResource("ChatServiceApp.fxml"));
        secondStage.setTitle("Chat Service");
        secondStage.setScene(new Scene(root2, 500, 400));
        secondStage.setX(800);
        secondStage.setY(200);
        secondStage.setResizable(false);
        secondStage.getIcons().add(icon);
        secondStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
