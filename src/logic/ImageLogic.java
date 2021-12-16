package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLogic {

	public static void resizeAndsetSprite(Image image, double width, double height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(height);
		imageView.setFitWidth(width);
	}

	public static Image resizeImage(Image image, double width, double height) {
		return new Image(image.getUrl(), width, height, false, false);
	}
}