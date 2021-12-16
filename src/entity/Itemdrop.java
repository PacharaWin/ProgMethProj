package entity;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import object.base.GameObject;

public abstract class Itemdrop extends GameObject {
	protected Point2D position;
	protected boolean isStatic;
	protected boolean isDestroy;
	protected boolean isVisible;
	protected Image sprite;
	protected int radius;
	protected int z;
	protected Elemental element;

	public Itemdrop() {
		this.radius = 3;
		this.isDestroy = false;
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

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy(boolean isDestroy) {
		this.isDestroy = isDestroy;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
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
