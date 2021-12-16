package scene;

import gui.PlayMenu;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class PlayMenuScene extends Scene {
	private StackPane stackPane;

	private PlayMenuScene(final Parent root) {
		super(root);
	}

	public PlayMenuScene() {
		this((Parent) new StackPane());
		this.initialize();
	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(1050, 600);
		this.stackPane.getChildren().add(new PlayMenu());
	}
}
