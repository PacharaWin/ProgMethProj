package gui;

import java.util.ArrayList;
import java.util.List;

import constants.ImageHolder;
import constants.RenderableHolder;
import constants.SoundHolder;
import entity.Boss;
import entity.Boss1;
import entity.Boss2;
import entity.Boss3;
import entity.ItemdropFire;
import entity.ItemdropHealth;
import entity.ItemdropSnow;
import entity.ItemdropWater;
import entity.Player;
import interfaces.Renderable;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Main;
import object.base.GameObject;
import scene.LoseScene;
import scene.WinScene;

public class GameCanvas extends Canvas {
	public static final int PIXEL_CELLSIZE = 16;
	private static GraphicsContext gc;
	public static List<GameObject> gameObjects;
	public static List<GameObject> toAdd;
	public static List<GameObject> toErase;
	private AnimationTimer gameLoop;
	private static int currentBoss;
	private static Boss boss;
	private static Player player;
	public long time;
	public static final long STARTTIME = System.nanoTime();
	public static boolean isSpawned1;
	public static boolean isSpawned2;
	public static boolean isSpawned3;
	public static boolean isSpawned4;

	public GameCanvas() {
		this.setup();
//        this.buildGame();
		this.loop();
//        this.wave();
	}

	public static void playShootSound() {
		SoundHolder.getInstance().shootSound1.play(0.3);
	}

	public static void setCurrentBoss(int idx) {
		currentBoss = idx;
	}

	private static void createBoss() {
		if (currentBoss == 0)
			boss = new Boss1(new Point2D(500, 20));
		if (currentBoss == 1)
			boss = new Boss2(new Point2D(500, 20));
		if (currentBoss == 2)
			boss = new Boss3(new Point2D(500, 20));

	}

	public void setup() {
		isSpawned1 = false;
		isSpawned2 = false;
		isSpawned3 = false;
		isSpawned4 = false;
		GameCanvas.gc = this.getGraphicsContext2D();
		GameCanvas.gameObjects = new ArrayList<GameObject>();
		GameCanvas.toAdd = new ArrayList<GameObject>();
		GameCanvas.toErase = new ArrayList<GameObject>();
		this.setWidth(1050.0);
		this.setHeight(600.0);
		player = new Player(new Point2D(525, 500));
		createBoss();
		addGameObject(boss);
		addGameObject(player);
		drawBoss();

	}

	public static Player getPlayer() {
		return player;
	}

	public void loop() {
		(this.gameLoop = new AnimationTimer() {
			public void handle(final long now) {
				time = (long) (((now - STARTTIME) / 1000000000.0));
				GameCanvas.this.drawGameObject();
				GameCanvas.this.update();
			}

		}).start();
	}

	public static void addGameObject(GameObject obj) {
		RenderableHolder.getInstance().add(obj);
		gameObjects.add(obj);
	}

	private void update() {
		if (time % 28 == 7 && !isSpawned1) {
			isSpawned4 = false;
			isSpawned1 = true;
			ItemdropFire drop = new ItemdropFire(new Point2D(50, 550));
			toBeAdd(drop);
		}
		if (time % 28 == 14 && !isSpawned2) {
			isSpawned1 = false;
			isSpawned2 = true;
			ItemdropWater drop = new ItemdropWater(new Point2D(1000, 550));
			toBeAdd(drop);
		}
		if (time % 28 == 21 && !isSpawned3) {
			isSpawned2 = false;
			isSpawned3 = true;
			ItemdropSnow drop = new ItemdropSnow(new Point2D(50, 350));
			toBeAdd(drop);
		}
		if (time % 28 == 0 && time != 0 && !isSpawned4) {
			isSpawned3 = false;
			isSpawned4 = true;
			ItemdropHealth drop = new ItemdropHealth(new Point2D(1000, 350));
			toBeAdd(drop);
		}
		if (RenderableHolder.getInstance().getEntities() != null) {
			for (Renderable obj : RenderableHolder.getInstance().getEntities()) {
				obj.update();
			}
			for (GameObject obj : toAdd) {
				RenderableHolder.getInstance().add(obj);
			}
			for (GameObject obj : toErase) {
				RenderableHolder.getInstance().remove(obj);
			}
			toAdd.clear();
			toErase.clear();
		}
		if (boss.getHealth() <= 0) {
			WinScene forPlay = new WinScene();
			RenderableHolder.getInstance().getEntities().clear();
			Main.sceneHolder.switchScene(forPlay);
			this.gameLoop.stop();
		} else if (player.getHealth() <= 0) {
			LoseScene forPlay = new LoseScene();
			RenderableHolder.getInstance().getEntities().clear();
			Main.sceneHolder.switchScene(forPlay);
			this.gameLoop.stop();
		}
		drawBoss();
		drawPlayer();
	}

	public static void toBeAdd(GameObject obj) {
		toAdd.add(obj);
	}

	public static void toBeErase(GameObject obj) {
		toErase.add(obj);
	}

	public void drawGameObject() {
		gc.drawImage(ImageHolder.getInstance().gameBg3, 0, 0);
		for (Renderable go : RenderableHolder.getInstance().getEntities()) {
			go.draw(GameCanvas.gc);

		}
	}

	public void drawBoss() {
		gc.setLineWidth(2.0);
		gc.setFill(Color.RED);
		// x, y, width, height, arcWidth, arcHeight
		gc.fillRoundRect(15, 15, 400, 30, 10, 10);
		// gc.setLineWidth(1.0);
		gc.setFill(Color.GREEN);
		// x, y, width, height, arcWidth, arcHeight
		gc.fillRoundRect(15, 15, (boss.getHealth() / boss.getMaxHealth()) * 400, 30, 10, 10);
		// gc.setFill(Color.WHITE);
		gc.setStroke(Color.WHITE);
		gc.strokeRoundRect(15, 15, 400, 30, 10, 10);
	}

	public void drawPlayer() {
		gc.setLineWidth(2.0);
		gc.setFill(Color.RED);
		// x, y, width, height, arcWidth, arcHeight
		gc.fillRoundRect(835, 10, 200, 30, 10, 10);
		// gc.setLineWidth(1.0);
		gc.setFill(Color.GREEN);
		// x, y, width, height, arcWidth, arcHeight
		gc.fillRoundRect(835, 10, (player.getHealth() / player.getMaxHealth()) * 200, 30, 10, 10);
		// gc.setFill(Color.WHITE);
		gc.setStroke(Color.WHITE);
		gc.strokeRoundRect(835, 10, 200, 30, 10, 10);
	}
}
