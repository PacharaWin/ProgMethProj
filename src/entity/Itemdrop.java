package entity;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import object.base.GameObject;

public abstract class Itemdrop extends GameObject {
	protected Point2D position;
	protected boolean isDestroy;
	protected Image sprite;
	protected int radius;
	protected int z;

	public Itemdrop() {
		this.radius = 3;
		this.isDestroy = false;
	}

	public void draw(GraphicsContext gc) {
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);

	}

	protected boolean collideWith(GameObject other) {
		return Math.hypot(this.getCenter().getX() - other.getCenter().getX(),
				this.getCenter().getY() - other.getCenter().getY()) <= this.radius + other.getRadius();
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy(boolean isDestroy) {
		this.isDestroy = isDestroy;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}
