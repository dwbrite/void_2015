package Handlers;

import Handlers.Text.Text;
import Handlers.Text.TextDisplay;
import Main.VoidMain;

public class Options {
	private static final int HEIGHT = 288;
	private static int realHeight;
	private static int realWidth;
	private static double scale = 1;
	private static final int WIDTH = 512;
	private static double masterVolume = 1;
	private static double musicVolume = 1;
	private static double sfxVolume = 1;

	static {
		updateSize();
	}

	public static void setScale(double i) {
		scale = i;
		notifySizeUpdate();
	}

	private static void notifySizeUpdate() {
		updateSize();
		VoidMain.notifySizeUpdate();
		Text.notifySizeUpdate();
		TextDisplay.notifySizeUpdate();
		Backgrounds.notifySizeUpdate();
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getRealHeight() {
		return realHeight;
	}

	public static int getRealWidth() {
		return realWidth;
	}

	public static double getScale() {
		return scale;
	}

	public static int getWidth() {
		return WIDTH;
	}

	private static void updateSize() {
		realHeight = (int) (HEIGHT * scale);
		realWidth = (int) (WIDTH * scale);
	}

	public static double getMasterVolume() {
		return masterVolume;
	}

	public static double getMusicVolume() {
		return musicVolume;
	}

	public static double getSFXVolume() {
		return sfxVolume;
	}

	public static void setMasterVolume(double volume) {
		masterVolume = volume;
		Audio.setMusicVolume(musicVolume);
		Audio.setSFXVolume(sfxVolume);
	}

	public static void setMusicVolume(double volume) {
		musicVolume = volume;
		Audio.setMusicVolume(volume);
	}

	public static void setSFXVolume(double volume) {
		sfxVolume = volume;
		Audio.setSFXVolume(volume);
	}


}