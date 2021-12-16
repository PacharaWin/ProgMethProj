package entity;

import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Boss2 extends Boss {
	private int cnt = 50;

	public Boss2() {
		super();
		this.maxHealth = 2500;
		this.health = 2500;
		this.speed = 3;
		this.setCurrentImage(ImageHolder.getInstance().grims);
		this.sprite = ImageHolder.getInstance().grims.get(1);
		this.radius = 80;
		this.element = Elemental.WATER;
	}

	public Boss2(Point2D id) {
		this();
		this.position = id;
		this.sprite = ImageHolder.getInstance().grims.get(1);

	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);
		// System.out.println(x);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// System.out.println("Boss");
		if (this.getPosition().getX() >= 950)
			isLeft = true;
		if (this.getPosition().getX() <= 0)
			isLeft = false;
		if (isLeft) {
			this.setPosition(new Point2D(this.getPosition().getX() - this.speed, this.getPosition().getY()));
		}
		if (!isLeft) {
			this.setPosition(new Point2D(this.getPosition().getX() + this.speed, this.getPosition().getY()));
		}
		shoot(this.getCenter(), GameCanvas.getPlayer().getCenter());
	}

	public void shoot(Point2D pos1, Point2D pos2) {
		cnt--;
		if (cnt > 0)
			return;
		BulletBoss2 bul = new BulletBoss2(pos1, pos2);
		SoundHolder.getInstance().shootSound2.stop();
		SoundHolder.getInstance().shootSound2.play(0.7);
		GameCanvas.toBeAdd(bul);
		cnt = 50;

	}

}