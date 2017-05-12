package Handlers;

import javax.sound.midi.Synthesizer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
	private static Media music;
	private static MediaPlayer musicPlayer;
	private static String musicPath;

	private static Media[] sfx = new Media[8];
	private static MediaPlayer[] sfxPlayer = new MediaPlayer[8];
	private static String[] sfxPath = new String[8];


	public static void playMusic() {
		musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicPlayer.setRate(0.5);
		musicPlayer.play();
	}

	public static void setMusic(String resource) {
		musicPath = Audio.class.getResource(resource).toString();
		music = new Media(musicPath);
		musicPlayer = new MediaPlayer(music);
	}

	public static void setMusicVolume(double volume) {
		musicPlayer.setVolume(volume * Options.getMasterVolume());
	}

	public static void playSFX(int index) {
		sfxPlayer[index].stop();
		sfxPlayer[index].play();
	}

	public static void setSFX(int index, String resource) {
		sfxPath[index] = Audio.class.getResource(resource).toString();
		sfx[index] = new Media(sfxPath[index]);
		sfxPlayer[index] = new MediaPlayer(sfx[index]);
	}

	public static void setSFXVolume(double volume) {
		for (int i = 0; i < sfxPlayer.length; i++) {
			if (sfxPlayer[i] != null) {
				sfxPlayer[i].setVolume(volume * Options.getMasterVolume());
			}
		}
	}
}
