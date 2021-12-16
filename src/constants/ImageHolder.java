// 
// Decompiled by Procyon v0.5.36
// 

package constants;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import logic.ImageLogic;

public class ImageHolder {
	private static final String PNG = "png";
	private static final ImageHolder instance;
	public List<Image> bullet;
	public Image win;
	public Image lose;
	public List<Image> grims;
	public List<Image> golems;
	public List<Image> players;
	public Image potionBlue;
	public Image potionRed;
	public Image potionPurple;
	public Image potionGreen;
	public Image gameBg1;
	public Image gameBg2;
	public Image gameBg3;
	public Image gameBg4;
	public Image emeraldDragon;
	public List<Image> wizards;
	public List<Image> bulletBoss;

	static {
		instance = new ImageHolder();
	}

	public static ImageHolder getInstance() {
		return ImageHolder.instance;
	}

	public ImageHolder() {
		this.win = this.loadImage("win", PNG);
		this.lose = this.loadImage("lose", PNG);
		this.emeraldDragon = this.loadImage("EmeraldDragon", "png");
		this.grims = this.loadImageList("grim", PNG, 5);
		this.golems = this.loadImageList("golem", PNG, 4);
		this.wizards = this.loadImageList("rogue", PNG, 8);
		this.players = this.loadImageList("player", PNG, 5);
		this.bulletBoss = this.loadImageList("bulletBoss", PNG, 3);
		this.gameBg1 = this.loadImage("GameBg1", "jpg");
		this.gameBg2 = ImageLogic.resizeImage(loadImage("GameBg2", "jpg"), 1050.0, 600.0);
		this.gameBg3 = ImageLogic.resizeImage(loadImage("GameBg3", "jpg"), 1050.0, 600.0);
		this.gameBg4 = this.loadImage("GameBg4", "jpg");
		this.potionBlue = ImageLogic.resizeImage(loadImage("blue1", "png"), 30.0, 30.0);
		this.potionRed = ImageLogic.resizeImage(loadImage("red1", "png"), 30.0, 30.0);
		this.potionPurple = ImageLogic.resizeImage(loadImage("purple1", "png"), 30.0, 30.0);
		this.potionGreen = ImageLogic.resizeImage(loadImage("green1", "png"), 30.0, 30.0);
		this.bullet = this.loadImageList("bullet", PNG, 4);

	}

	private Image loadImage(String name, String fileType) {
		String path = name + "." + fileType;
		return new Image(ClassLoader.getSystemResource(path).toString());
	}

	public List<Image> loadImageList(final String prefixName, final String fileType, final int number) {
		final List<Image> list = new ArrayList<Image>();
		for (int i = 1; i <= number; ++i) {
			if (prefixName.equals("player")) {
				Image tmp = this.loadImage(String.valueOf(prefixName) + i, fileType);
				tmp = ImageLogic.resizeImage(loadImage("player" + i, "png"), 80.0, 80.0);
				list.add(tmp);
			}
			if (prefixName.equals("rogue")) {
				Image tmp = this.loadImage(String.valueOf(prefixName) + i, fileType);
				tmp = ImageLogic.resizeImage(loadImage("rogue" + i, "png"), 180.0, 180.0);
				list.add(tmp);
			}
			if (prefixName.equals("golem")) {
				Image tmp = this.loadImage(String.valueOf(prefixName) + i, fileType);
				tmp = ImageLogic.resizeImage(loadImage("golem" + i, "png"), 220.0, 220.0);
				list.add(tmp);
			}
			if (prefixName.equals("grim")) {
				Image tmp = this.loadImage(String.valueOf(prefixName) + i, fileType);
				tmp = ImageLogic.resizeImage(loadImage("grim" + i, "png"), 220.0, 220.0);
				list.add(tmp);
			} else {
				list.add(this.loadImage(String.valueOf(prefixName) + i, fileType));
			}
		}
		return list;
	}
}
