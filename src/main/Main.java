package main;

import scene.SceneHolder;
import constants.ImageHolder;
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application {

	public static SceneHolder sceneHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {

		(sceneHolder = new SceneHolder(primaryStage)).initialize();
		primaryStage.setTitle("Art of Elements");
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.getIcons().add(ImageHolder.getInstance().players.get(3));

	}

	public static void main(String[] args) {

		launch(args);
	}
}