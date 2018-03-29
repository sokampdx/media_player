package application;

import application.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {
  Player player;
  FileChooser fileChooser;

  public void start(final Stage primaryStage) throws Exception{
    String filename = "file:///Users/" + System.getenv("USER") + "/programs/java_projects/test.mp4";

    MenuBar menu = create_menu_bar(primaryStage);
    Scene scene = create_scene(menu, filename);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Scene create_scene(MenuBar menu, String filename ) {
    player = new Player(filename);
    player.setTop(menu);
    return new Scene(player, 1280, 760, Color.BLACK);
  }

  private MenuBar create_menu_bar(final Stage primaryStage) {
    MenuItem open = new MenuItem("Open");
    Menu file = new Menu("File");
    MenuBar menu = new MenuBar();

    file.getItems().add(open);
    menu.getMenus().add(file);

    fileChooser = new FileChooser();
    handle_open_file(primaryStage, open, menu);
    return menu;
  }

  private void handle_open_file(final Stage primaryStage, MenuItem open, final MenuBar menu) {
    open.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        player.player.pause();
        File file = fileChooser.showOpenDialog(primaryStage);
        String filename;
        if (file != null) {
          try {
            filename = file.toURI().toURL().toExternalForm();
            Scene scene = create_scene(menu, filename);
            primaryStage.setScene(scene);
          } catch (MalformedURLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
  }


  public static void main(String[] args) {
        launch(args);
    }
}
