package entity;

import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;

public class ItemdropHealth extends Itemdrop {

	public ItemdropHealth() {
		super();
		this.sprite = ImageHolder.getInstance().potionGreen;
		this.element = Elemental.DEFAULT;
	}

	public ItemdropHealth(Point2D id) {
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
			if (collideWith(obj) && obj instanceof Player && !isDestroy) {
				SoundHolder.getInstance().pickItemBgm.play();
				((Player) obj).setElement(this.element);
				((Player) obj).setHealth(((Player) obj).getHealth() + 10);
				GameCanvas.toBeErase(this);

			}
		}

	}
}
