package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import constants.SoundHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import scene.MainMenuScene;

public class Win extends BorderPane {
	private HBox bottomMenu;

	public Win() {
		this.setPrefSize(1050, 600);

		SoundHolder.getInstance().bgmFight1.stop();
		SoundHolder.getInstance().winBgm.play(0.1);
		// System.out.println("win");
		this.bottomMenu = new HBox();
		try (InputStream is = Files.newInputStream(Paths.get("res/GameBg3.jpg"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		final Button backBtn = new Button("Back to main menu");
		this.bottomMenu.getChildren().add(backBtn);
		this.setBottom(bottomMenu);
		InputStream is;
		try {
			is = Files.newInputStream(Paths.get("res/win.png"));
			ImageView image = new ImageView(new Image(is));
			image.setFitWidth(600);
			image.setFitHeight(300);
			this.setCenter(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		backBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 50));
		backBtn.setOnMouseClicked(e -> {
			System.out.println("click");
			MainMenuScene forBack = new MainMenuScene();
			Main.sceneHolder.switchScene(forBack);
		});
		this.bottomMenu.setAlignment(Pos.BOTTOM_CENTER);
		this.bottomMenu.setSpacing(400.0);
		this.bottomMenu.setPadding(new Insets(50.0));

	}

	public ImageView getTheImage(String name) {
		try (InputStream is = Files.newInputStream(Paths.get(name))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(800);
			img.setFitHeight(300);
			return img;
		} catch (IOException e) {
			System.out.println("Couldn't load image");
			return null;
		}

	}
}
