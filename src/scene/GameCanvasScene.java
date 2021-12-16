package scene;

import gui.GameCanvas;
import constants.GameConstant;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class GameCanvasScene extends Scene {
	private StackPane stackPane;

	private GameCanvasScene(final Parent root) {
		super(root);
	}

	public GameCanvasScene() {

		this((Parent) new StackPane());
		this.initialize();

	}

	private void initialize() {
		// this.setCursor(Cursor.NONE);
		this.addKeyEvents();
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.setPrefSize(1050, 600);
		this.stackPane.getChildren().add(new GameCanvas());
	}

	private void addKeyEvents() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				if (!(GameConstant.keyPressed.contains(k))) {
					GameConstant.keyPressed.add(k);
				}
			}
		});

		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				KeyCode k = arg0.getCode();
				GameConstant.keyPressed.remove(k);
			}
		});
	}
}
