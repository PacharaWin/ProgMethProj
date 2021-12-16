package entity;

import java.util.List;

import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import object.base.GameObject;

public abstract class Boss extends GameObject {
	protected String name;
	protected String description;
	protected double health;
	protected double maxHealth;
	protected int attack;
	protected int speed;
	protected int idx;
	protected List<Image> currentImage;
	protected boolean isLeft;

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Boss() {
		this.name = "Boss";
		this.radius = 100;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);
		// System.out.println(x);

	}
	
	@Override
	public void update() {
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

	public abstract void shoot(Point2D pos1, Point2D pos2);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public List<Image> getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(List<Image> currentImage) {
		this.currentImage = currentImage;
	}

}
