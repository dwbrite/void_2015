package Main;

//import GameState.Story;

import GameState.StoryState;
import Handlers.Audio;
import Handlers.Backgrounds;
import Handlers.Options;
//import Handlers.Options;
import Handlers.Text.Text;

public class LogicThread implements Runnable {
	@Override
	public void run() {
		Text.setDefaultSize(8);
		Text.setFont("/Fonts/PressStart2P.ttf");

		Backgrounds.setBackground("/Backgrounds/menu.gif");

		Audio.setMusic("/Audio/test.mp3");

		Options.setMasterVolume(1);
		Options.setMusicVolume(0.4);
		Audio.playMusic();

		//Audio.setSFX(1, "/Audio/1.mp3");
		//Audio.setSFX(2, "/Audio/2.mp3");
		Audio.setSFX(0, "/Audio/blip5.mp3");
		Options.setSFXVolume(0.10);

    //Story story = new Story();
    //story.play();
    //Story.introSwitch();
    //Story.menu();

    StoryState.start();
  }
}
