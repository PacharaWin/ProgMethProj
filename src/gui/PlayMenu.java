package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import constants.SoundHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import scene.GameCanvasScene;
import scene.MainMenuScene;

public class PlayMenu extends BorderPane {
	private VBox nextBox;
	private VBox prevBox;
	private HBox bottomMenu;
	private ArrayList<ImageView> bossImgList;
	private ArrayList<String> bossNameList;
	private int idx;

	public PlayMenu() {
		bossNameList = new ArrayList<String>();
		bossNameList.add("Ember Wizard");
		bossNameList.add("Hydro Reaper");
		bossNameList.add("Blizzard Golem");
		idx = 0;
		bossImgList = new ArrayList<ImageView>();
		bossImgList.add(getTheImage("res/rogue1.png"));
		bossImgList.add(getTheImage("res/grim1.png"));
		bossImgList.add(getTheImage("res/golem1.png"));
		this.setPrefSize(1050, 600);
		/*
		 * final Media media2 = new
		 * Media(ClassLoader.getSystemResource("sound/bgm/setting.wav").toString());
		 * PlayMenu.mediaPlayer2 = new MediaPlayer(media2); final MediaView mediaView2 =
		 * new MediaView(PlayMenu.mediaPlayer2);
		 * PlayMenu.mediaPlayer2.setAutoPlay(true);
		 * PlayMenu.mediaPlayer2.setCycleCount(-1);
		 */
		try (InputStream is = Files.newInputStream(Paths.get("res/HillsMenu.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		Title title = new Title("Ember Wizard");
		title.setTranslateX(0);
		title.setTranslateY(50);
		this.setTop(title);
		this.bottomMenu = new HBox();
		final Button backBtn = new Button("Back");
		final Button playBtn = new Button("Let's go!!");
		playBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 50));
		backBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 50));
		playBtn.setOnMouseClicked(e -> {
			GameCanvas.setCurrentBoss(idx);
			GameCanvasScene forPlay = new GameCanvasScene();
			Main.sceneHolder.switchScene(forPlay);
			SoundHolder.getInstance().bgmMainMenu.stop();
			SoundHolder.getInstance().bgmFight1.play(0.1);
		});

		backBtn.setOnMouseClicked(e -> {
			MainMenuScene forBack = new MainMenuScene();
			Main.sceneHolder.switchScene(forBack);
		});
		this.bottomMenu.getChildren().addAll(backBtn, playBtn);
		this.bottomMenu.setAlignment(Pos.BOTTOM_CENTER);
		this.bottomMenu.setSpacing(400.0);
		this.bottomMenu.setPadding(new Insets(50.0));
		this.setBottom(bottomMenu);

		InputStream is;
		try {
			is = Files.newInputStream(Paths.get("res/rogue1.png"));
			ImageView image = new ImageView(new Image(is));
			image.setFitWidth(200);
			image.setFitHeight(200);
			this.setCenter(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.nextBox = new VBox();
		this.prevBox = new VBox();
		final Button nextBtn = new Button(">");
		final Button prevBtn = new Button("<");
		// nextBtn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
		// CornerRadii.EMPTY, Insets.EMPTY)));
		// nextBtn.setBorder(new Border(new BorderStroke()))
		nextBox.getChildren().add(nextBtn);
		prevBox.getChildren().add(prevBtn);
		this.nextBox.setAlignment(Pos.CENTER);
		this.nextBox.setSpacing(400.0);
		this.nextBox.setPadding(new Insets(50.0));
		this.prevBox.setAlignment(Pos.CENTER);
		this.prevBox.setSpacing(400.0);
		this.prevBox.setPadding(new Insets(50.0));
		nextBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 50));
		prevBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 50));
		this.setLeft(prevBox);
		this.setRight(nextBox);
		nextBtn.setOnMouseClicked(e -> {
			idx = (idx + 1) % 3;
			change();
		});
		prevBtn.setOnMouseClicked(e -> {
			idx = (idx + 2) % 3;
			change();
		});

	}

	public ImageView getTheImage(String name) {
		try (InputStream is = Files.newInputStream(Paths.get(name))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(300);
			img.setFitHeight(300);
			return img;
		} catch (IOException e) {
			System.out.println("Couldn't load image");
			return null;
		}

	}

	public void change() {
		ImageView image = this.bossImgList.get(idx);
		image.setFitWidth(300);
		image.setFitHeight(300);
		if (idx == 0) {
			image.setFitWidth(200);
			image.setFitHeight(200);
		}
		this.setCenter(image);
		Title title = new Title(this.bossNameList.get(idx));
		title.setTranslateX(0);
		title.setTranslateY(50);
		this.setTop(title);
	}
}
