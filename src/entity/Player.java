package entity;

import java.util.ArrayList;
import java.util.List;

import constants.GameConstant;
import constants.ImageHolder;
import constants.SoundHolder;
import gui.GameCanvas;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import object.base.GameObject;

public class Player extends GameObject {
	protected String name;
	protected String description;
	protected double health;
	protected double maxHealth;
	protected int attack;
	protected int speed;
	protected List<Image> currentImage;
	private int cnt = 28;

	public Player() {
		this.name = "witch";
		this.health = 100;
		this.maxHealth = 100;
		this.attack = 50;
		this.speed = 10;
		this.sprite = ImageHolder.getInstance().players.get(0);
		this.element = Elemental.DEFAULT;

	}

	public Player(Point2D pos) {
		this();
		this.setPosition(pos);
		this.radius = 40;
		this.speed = 5;
	}

	@Override
	public void draw(final GraphicsContext gc) {
		final double x = this.getPosition().getX();
		final double y = this.getPosition().getY();

		final double imgX = sprite.getWidth();
		final double imgY = sprite.getHeight();
		gc.drawImage(this.getSprite(), x, y, imgX, imgY);
		// System.out.println(x);

	}

	@Override
	public void update() {
		ArrayList<KeyCode> keyPressed = GameConstant.keyPressed;
		// System.out.println("Test");
		if (keyPressed.contains(KeyCode.A) && this.getPosition().getX() > -20) {
			this.setPosition(new Point2D(this.getPosition().getX() - this.speed, this.getPosition().getY()));
		}
		if (keyPressed.contains(KeyCode.S) && this.getPosition().getY() < 520) {
			this.setPosition(new Point2D(this.getPosition().getX(), this.getPosition().getY() + this.speed));
		}
		if (keyPressed.contains(KeyCode.W) && this.getPosition().getY() > 300) {
			this.setPosition(new Point2D(this.getPosition().getX(), this.getPosition().getY() - this.speed));
		}
		if (keyPressed.contains(KeyCode.D) && this.getPosition().getX() < 980) {
			this.setPosition(new Point2D(this.getPosition().getX() + this.speed, this.getPosition().getY()));
		}
		if (keyPressed.contains(KeyCode.SPACE)) {
			shoot();

		}

	}

	private void shoot() {
		cnt--;
		if (cnt > 0)
			return;
		if (this.element.equals(Elemental.DEFAULT)) {
			BulletDefault bul = new BulletDefault(this.getPosition(), Elemental.DEFAULT);
			SoundHolder.getInstance().shootSound1.stop();
			SoundHolder.getInstance().shootSound1.play(0.7);
			GameCanvas.toBeAdd(bul);
			cnt = 28;
		} else if (this.element.equals(Elemental.FIRE)) {
			BulletDefault bul = new BulletDefault(this.getPosition(), Elemental.FIRE);
			SoundHolder.getInstance().shootSound1.stop();
			SoundHolder.getInstance().shootSound1.play(0.7);
			GameCanvas.toBeAdd(bul);
			cnt = 28;
		} else if (this.element.equals(Elemental.WATER)) {
			BulletDefault bul = new BulletDefault(this.getPosition(), Elemental.WATER);
			SoundHolder.getInstance().shootSound1.stop();
			SoundHolder.getInstance().shootSound1.play(0.7);
			GameCanvas.toBeAdd(bul);
			cnt = 28;
		} else if (this.element.equals(Elemental.SNOW)) {
			BulletDefault bul = new BulletDefault(this.getPosition(), Elemental.SNOW);
			SoundHolder.getInstance().shootSound1.stop();
			SoundHolder.getInstance().shootSound1.play(0.7);
			GameCanvas.toBeAdd(bul);
			cnt = 28;
		}

	}

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

	public void setHealth(double d) {
		if (d >= this.maxHealth) {
			this.health = maxHealth;
		} else {
			this.health = d;
		}

	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
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

	public List<Image> getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(List<Image> currentImage) {
		this.currentImage = currentImage;
	}

}
