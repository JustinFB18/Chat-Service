package ChatServiceGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The Main Java Class that creates two windows which have the same
 * design.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */
public class Main extends Application {
    /**
     * Sets the ambient of the windows and shows them.
     * @param primaryStage recieves the Stage which the App will be implementd.
     * @throws Exception if something happened loading the fxml file with the code for the app.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Creates other stage
        Stage secondStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("ChatServiceApp.fxml"));
        primaryStage.setTitle("Chat Service");
        // Adjust the dimensions of the window.
        primaryStage.setScene(new Scene(root, 500, 426));
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
        secondStage.setScene(new Scene(root2, 500, 426));
        secondStage.setX(800);
        secondStage.setY(200);
        secondStage.setResizable(false);
        secondStage.getIcons().add(icon);
        secondStage.show();
    }

    /**
     * Main method of the Main class to open the GUI
     * @param args stores the incomding command line arguments for the program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
