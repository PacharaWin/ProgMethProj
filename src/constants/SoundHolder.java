
package constants;

import javafx.scene.media.AudioClip;

public class SoundHolder {
	private static final String MP3 = "mp3";
	private static final SoundHolder instance;

	public AudioClip bgmMainMenu;
	public AudioClip bgmFight1;
	public AudioClip bgmFight2;
	public AudioClip bgmFight3;
	public AudioClip shootSound1;
	public AudioClip shootSound2;
	public AudioClip winBgm;
	public AudioClip loseBgm;
	public AudioClip pickItemBgm;

	static {
		instance = new SoundHolder();
	}

	public static SoundHolder getInstance() {
		return SoundHolder.instance;
	}

	public SoundHolder() {

		this.bgmMainMenu = this.loadSound("bgmMainMenu", "mp3");
		this.pickItemBgm = this.loadSound("pickItemBgm", MP3);
		this.bgmFight1 = this.loadSound("bgmFight1", "mp3");
		this.bgmFight2 = this.loadSound("bgmFight2", "mp3");
		this.bgmFight3 = this.loadSound("bgmFight3", "mp3");
		this.winBgm = this.loadSound("gameWinBgm", "mp3");
		this.loseBgm = this.loadSound("gameLoseBgm", "mp3");
		this.shootSound1 = this.loadSound("shootSound1", "mp3");
		this.shootSound2 = this.loadSound("shootSound2", "mp3");

	}

	public AudioClip loadSound(final String prefixName, final String fileType) {
		return new AudioClip(ClassLoader.getSystemResource(prefixName + '.' + fileType).toString());
	}
}
