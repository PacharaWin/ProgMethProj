package entity;

import constants.ImageHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import object.base.GameObject;

public class BulletBoss3 extends Bullet {

	public BulletBoss3() {
		this.currentImage = ImageHolder.getInstance().bulletBoss;
		this.sprite = ImageHolder.getInstance().bulletBoss.get(2);
		this.speed = 7;
		this.element = Elemental.SNOW;
		this.damage = 20;
	}

	public BulletBoss3(Point2D pos1, Point2D pos2) {
		this();
		this.position = pos1;
		this.currentImage = ImageHolder.getInstance().bulletBoss;
		this.sprite = ImageHolder.getInstance().bulletBoss.get(2);
		this.setDirectionToTarget(pos2);
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
		this.setPosition(new Point2D(this.getPosition().getX() + this.getDirection().getX(),
				this.getPosition().getY() + this.getDirection().getY()));
		// System.out.println(this.getDirection().getX());
		for (GameObject obj : GameCanvas.gameObjects) {
			// System.out.println(obj.getClass());
			if (collideWith(obj) && obj instanceof Player) {
				// System.out.println("hit");
				logic.CalDamage.calculateDamage(this, (Player) obj);
				GameCanvas.toBeErase(this);
			}
		}
		if (this.getPosition().getY() > 600) {
			GameCanvas.toBeErase(this);
		}

	}

}
