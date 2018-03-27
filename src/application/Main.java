package application;

import application.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    String file = "file:///Users/" + System.getenv("USER") + "/programs/java_projects/media_player/src/application/test.mp4";
    Player player = new Player(file);
    Scene scene = new Scene(player, 1280, 760, Color.BLACK);
    primaryStage.setScene(scene);
    primaryStage.show();
  }


    public static void main(String[] args) {
        launch(args);
    }
}
