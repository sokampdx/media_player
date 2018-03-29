package application;

import application.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    MenuItem open = new MenuItem("Open");
    Menu file = new Menu("File");
    MenuBar menu = new MenuBar();

    file.getItems().add(open);
    menu.getMenus().add(file);

    String filename = "file:///Users/" + System.getenv("USER") + "/programs/java_projects/test.mp4";
    Player player = new Player(filename);
    player.setTop(menu);
    Scene scene = new Scene(player, 1280, 760, Color.BLACK);
    primaryStage.setScene(scene);
    primaryStage.show();
  }


    public static void main(String[] args) {
        launch(args);
    }
}
