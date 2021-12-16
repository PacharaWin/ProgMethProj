package entity;

import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import object.base.GameObject;

public class ItemdropFire extends Itemdrop {

	public ItemdropFire() {
		super();
		this.sprite = ImageHolder.getInstance().potionRed;
		this.element = Elemental.FIRE;
	}

	public ItemdropFire(Point2D id) {
		this();
		this.position = id;

	}

	@Override
	public void update() {
		for (GameObject obj : GameCanvas.gameObjects) {
			// System.out.println(obj.getClass());
			if (collideWith(obj) && obj instanceof Player) {
				// System.out.println("hit");
				SoundHolder.getInstance().pickItemBgm.play();
				((Player) obj).setElement(this.element);
				GameCanvas.toBeErase(this);

			}
		}

	}

}
