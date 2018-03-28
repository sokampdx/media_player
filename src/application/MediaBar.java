package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

import static javafx.scene.media.MediaPlayer.*;

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

    handle_play_button();
  }

  private void handle_play_button() {
    playButton.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        Status status = player.getStatus();

        if(status == Status.PLAYING) {
          handle_playing_status();
        }

        if(is_paused(status)) {
          start_playing();
        }
      }

      private boolean is_paused(Status status) {
        return status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED;
      }

      private void start_playing() {
        player.play();
        playButton.setText("||");
      }

      private void handle_playing_status() {
        if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
          player.seek(player.getStartTime());
          player.play();
        } else {
          player.pause();
          playButton.setText(">");
        }
      }
    });
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
