package entity;

import constants.ImageHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;

public class BulletDefault extends Bullet {

	private static int cnt = 0;

	public BulletDefault() {
		this.currentImage = ImageHolder.getInstance().bullet;
		this.sprite = ImageHolder.getInstance().bullet.get(cnt % 4);
		this.element = Elemental.DEFAULT;
		this.speed = 5;
	}

	public BulletDefault(Point2D pos, Elemental e) {
		this();
		this.currentImage = ImageHolder.getInstance().bullet;
		if (e.equals(Elemental.FIRE)) {
			this.sprite = ImageHolder.getInstance().bullet.get(1);
			this.element = Elemental.FIRE;
		} else if (e.equals(Elemental.SNOW)) {
			this.sprite = ImageHolder.getInstance().bullet.get(2);
			this.element = Elemental.SNOW;
		} else if (e.equals(Elemental.WATER)) {
			this.sprite = ImageHolder.getInstance().bullet.get(3);
			this.element = Elemental.WATER;
		} else if (e.equals(Elemental.DEFAULT)) {
			this.sprite = ImageHolder.getInstance().bullet.get(0);
			this.element = Elemental.DEFAULT;
		}
		this.position = pos;
		this.damage = 100;
	}

	@Override
	public void draw(GraphicsContext gc) {
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = this.sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);
		// System.out.println(x);

	}

	@Override
	public void update() {
		this.setPosition(new Point2D(this.getPosition().getX(), this.getPosition().getY() - this.speed));
		for (GameObject obj : GameCanvas.gameObjects) {
			if (collideWith(obj) && obj instanceof Boss) {
				logic.CalDamage.calculateDamage(this, (Boss) obj);
				GameCanvas.toBeErase(this);
			}
		}
		if (this.getPosition().getY() < 0) {
			GameCanvas.toBeErase(this);
		}

	}

}
