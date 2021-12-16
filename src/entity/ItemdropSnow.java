package entity;

import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;

public class ItemdropSnow extends Itemdrop {

	public ItemdropSnow() {
		super();
		this.sprite = ImageHolder.getInstance().potionPurple;
		this.element = Elemental.SNOW;
	}

	public ItemdropSnow(Point2D id) {
		this();
		this.position = id;

	}

	@Override
	public void draw(GraphicsContext gc) {
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);

	}

	@Override
	public void update() {
		for (GameObject obj : GameCanvas.gameObjects) {
			// System.out.println(obj.getClass());
			if (collideWith(obj) && obj instanceof Player) {
				SoundHolder.getInstance().pickItemBgm.play();
				// System.out.println("hit");
				((Player) obj).setElement(this.element);
				GameCanvas.toBeErase(this);
			}
		}

	}

}
