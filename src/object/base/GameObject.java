package object.base;

import entity.Elemental;
import interfaces.Renderable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject implements Renderable {
	protected Point2D position;
	protected boolean isDestroy;
	protected Elemental element;
	protected Image sprite;
	protected double radius;
	protected int z;
	
	public abstract void draw(GraphicsContext gc);
	
	public abstract void update();

	public Elemental getElement() {
		return element;
	}

	public void setElement(Elemental element) {
		this.element = element;
	}

	public void setDestroy(boolean isDestroy) {
		this.isDestroy = isDestroy;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point2D getCenter() {
		return new Point2D(this.getPosition().getX() + this.getRadius(), this.getPosition().getY() + this.getRadius());

	}

	public GameObject() {
		this.position = new Point2D(0.0, 0.0);
		// this.sprite = ImageHolder.getInstance().nothing;
		this.isDestroy = false;
	}

	public Point2D getPosition() {
		return this.position;
	}

	public void setPosition(final Point2D position) {
		this.position = position;
	}

	@Override
	public boolean isDestroy() {
		return this.isDestroy;
	}

	public void destroy() {
		this.isDestroy = true;
	}

	public Image getSprite() {
		return this.sprite;
	}

	public void setSprite(final Image sprite) {
		this.sprite = sprite;
	}

	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
