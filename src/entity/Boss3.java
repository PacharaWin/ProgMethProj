package entity;

import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;

public class Boss3 extends Boss {

	private int cnt = 100;

	public Boss3() {
		super();
		this.speed = 3;
		this.maxHealth = 4500;
		this.health = 4500;
		this.setCurrentImage(ImageHolder.getInstance().golems);
		this.sprite = ImageHolder.getInstance().golems.get(0);
		this.radius = 80;
		this.element = Elemental.SNOW;
	}

	public Boss3(Point2D id) {
		this();
		this.position = id;
		this.sprite = ImageHolder.getInstance().golems.get(0);
	}


	@Override
	public void shoot(Point2D pos1, Point2D pos2) {
		cnt--;
		if (cnt > 0)
			return;
		BulletBoss3 bul = new BulletBoss3(pos1, pos2);
		SoundHolder.getInstance().shootSound2.stop();
		SoundHolder.getInstance().shootSound2.play(0.7);
		GameCanvas.toBeAdd(bul);
		cnt = 100;

	}

}
