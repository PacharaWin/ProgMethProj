package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import constants.ImageHolder;
import constants.SoundHolder;
import main.Main;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import scene.HowToPlayScene;
import scene.PlayMenuScene;

public class MainMenu extends Pane {
	private static Stage primaryStage;

	public MainMenu() {
		if (!SoundHolder.getInstance().bgmMainMenu.isPlaying()) {
			SoundHolder.getInstance().bgmMainMenu.play(0.3);
			SoundHolder.getInstance().bgmMainMenu.setCycleCount(MediaPlayer.INDEFINITE);
		}
		this.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("res/HillsMenu.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		Title title = new Title("Art  of  Elements");
		title.setTranslateX(287.5);
		title.setTranslateY(200);
		MenuItem play = new MenuItem("Play");
		MenuItem howToPlay = new MenuItem("How to Play");
		MenuItem exit = new MenuItem("Exit");
		MenuBox vbox = new MenuBox(play, howToPlay, exit);
		vbox.setTranslateX(425);
		vbox.setTranslateY(300);
		howToPlay.setOnMousePressed(event -> {
			Scene forPlay = new HowToPlayScene();
			Main.sceneHolder.switchScene(forPlay);
		});
		play.setOnMousePressed(event -> {
			Scene forPlay = new PlayMenuScene();
			Main.sceneHolder.switchScene(forPlay);
		});
		exit.setOnMousePressed(event -> {
			System.exit(0);
		});

		this.getChildren().addAll(title, vbox);

	}
}