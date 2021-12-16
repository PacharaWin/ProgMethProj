package scene;

import gui.Lose;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class LoseScene extends Scene {
	private StackPane stackPane;

	private LoseScene(final Parent root) {
		super(root);
	}

	public LoseScene() {

		this((Parent) new StackPane());
		this.initialize();

	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(1050, 600);
		this.stackPane.getChildren().add(new Lose());
	}
}
