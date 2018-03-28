package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox {
  Slider time = new Slider();
  Slider vol = new Slider();

  Button playButton = new Button("||");
  Label volume = new Label("Volume: ");

  MediaPlayer player;

  public MediaBar(MediaPlayer play) {
    player = play;
    setup_volume_slider();
    setup_player_frame();
    build_media_components();
  }

  private void build_media_components() {
    getChildren().add(playButton);
    getChildren().add(time);
    getChildren().add(volume);
    getChildren().add(vol);
  }

  private void setup_player_frame() {
    setAlignment(Pos.CENTER);
    setPadding(new Insets(5, 10, 5, 10));
    HBox.setHgrow(time, Priority.ALWAYS);
    playButton.setPrefWidth(30);
  }

  private void setup_volume_slider() {
    vol.setPrefWidth(70);
    vol.setMinWidth(30);
    vol.setValue(100);
  }
}
