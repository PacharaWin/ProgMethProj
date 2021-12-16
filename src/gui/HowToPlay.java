package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import main.Main;
import scene.MainMenuScene;

public class HowToPlay extends Pane {
	public HowToPlay() {
		Pane root = new Pane();
		root.setPrefSize(1050, 600);
		try (InputStream is = Files.newInputStream(Paths.get("res/HillsMenu.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			this.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		Title title = new Title("How to Play");
		title.setTranslateX(287.5);
		title.setTranslateY(100);
		title.setAlignment(Pos.CENTER);
		Rectangle rect = new Rectangle(820, 310);
		rect.setTranslateX(115);
		rect.setTranslateY(170);
		rect.setOpacity(0.5);
		rect.setFill(Color.WHITE);
		Text massage = new Text("Art of Element is an elemental battle game. \n You are a witch who "
				+ "is going to fight against mythic \ndungeon boss which you can choose in GameMenu.\nIn this game, you "
				+ "can move by using W,A,S,D buttons \n and you can cast your spell by pressing space bar.\n"
				+ "Every 7 seconds there will be item dropped on the map, "
				+ "\n pick it up to change your elemental type or heal yourself.");
		massage.setTranslateX(135);
		massage.setTranslateY(200);
		massage.setTextAlignment(TextAlignment.CENTER);
		massage.setFont(new Font("Comic Sans MS", 30));
		MenuItem back_item = new MenuItem("BACK");
		back_item.setTranslateX(410);
		back_item.setTranslateY(500);
		back_item.setOnMouseReleased(event -> {
			MainMenuScene forBack = new MainMenuScene();
			Main.sceneHolder.switchScene(forBack);
		});
		root.getChildren().addAll(title, rect, massage, back_item);
		this.getChildren().add(root);
	}
}
