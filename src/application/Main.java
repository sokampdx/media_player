package sample;

import application.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Player player = new Player("file:///Users/anthonyso/Documents/programs/java_projects/test.mp4");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
