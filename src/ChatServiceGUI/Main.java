package ChatServiceGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    /**
     * The Main Java Class that creates two windows which have the same
     * design.
     *
     * @author Justin Fernández
     * @version 1
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        /**
         *
         */
        // Creates other stage
        Stage secondStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("ChatServiceApp.fxml"));
        primaryStage.setTitle("Chat Service");
        // Adjust the dimensions of the window.
        primaryStage.setScene(new Scene(root, 500, 400));
        // Adjust the window or desktop position to appear the window
        primaryStage.setX(200);
        primaryStage.setY(200);
        // Avoid to change the initial dimmensions of a window.
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("Images/Icon.png"));
        // Adds a personalize icon for the window
        primaryStage.getIcons().add(icon);
        primaryStage.show();

        // Code for the second window, it is the same, only different initial postion.
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
