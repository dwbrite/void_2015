package GameState;

//import javafx.application.Platform;

import javafx.scene.paint.Color;
import Entities.Actor;
import Handlers.Backgrounds;
import Handlers.Options;
import Handlers.TextDisplay;
import Main.VoidMain;

public class Story {
	public static Actor player = new Actor("You", new Color(1, 1, 1, 1));
	private static int r, g, b, y, w;
	public static Actor universe = new Actor("Universe", new Color(1, 1, 1, 1));

	public static void draw() {
		VoidMain.getGraphicsContext().setFill(Color.BLACK);
		VoidMain.getGraphicsContext().fillRect(0, 0, Options.getRealWidth(), Options.getRealHeight());
		Backgrounds.drawBackground();
		TextDisplay.renderText();
	}

	public static void introSwitch() {
		universe.say("Void is currently under development.");

		universe.say("You will reach the 'end' of the game fairly quickly.");
		universe.say("Thank you for playing anyway!");
		TextDisplay.clear();
		universe.say("Welcome to Void... ");
		universe.say("Before we start, please fill out this quick questionnaire.");
		universe.say("...");
		TextDisplay.clear();
		switch (universe.ask("Your best friend is stuck inside a game world. What do you do?", new String[]{"Attack him!", "Call the police.", "Beat the game to see what happens.", "Walk away. It's obviously a prank."})) {
			case 0:
				r += 2;
				y += 1;
				g -= 1;
				b -= 3;
				break;
			case 1:
				b += 3;
				w += 1;
				y += 1;
				break;
			case 2:
				w += 1;
				b += 1;
				y += 1;
				break;
			case 3:
				r -= 1;
				b += 1;
				break;
		}
		Options.setMusicVolume(0.6);
		updatePlayerColor();
		switch (universe.ask("How would you spend your last day of break before school?", new String[]{"Tending to a personal hobby.", "Hanging out with friends.", "Sleeping.", "Browsing the internet."})) {
			case 0:
				b += 2;
				r += 1;
				break;
			case 1:
				b += 2;
				g += 1;
				break;
			case 2:
				w += 1;
				g += 1;
				break;
			case 3:
				y += 1;
				g += 1;
				break;
		}
		updatePlayerColor();
		switch (universe.ask("A stranger asks you to draw anything. What do you draw?", new String[]{"A random animal.", "A circle.", "My favorite pet.", "A flower."})) {
			case 0:
				y += 2;
				r += 1;
				break;
			case 1:
				b += 1;
				w += 1;
				break;
			case 2:
				w += 1;
				r += 1;
				break;
			case 3:
				y += 2;
				g += 2;
				break;
		}
		Options.setMusicVolume(0.5);
		updatePlayerColor();
		switch (universe.ask("How do you like your coffee?", new String[]{"Extra extra.", "Decaf.", "Black.", "I don't like coffee."})) {
			case 0:
				y += 1;
				r += 2;
				break;
			case 1:
				y += 1;
				w += 1;
				break;
			case 2:
				w += 2;
				y += 1;
				break;
			case 3:
				g += 3;
				b += 1;
				break;
		}
		Options.setMusicVolume(0.4);
		updatePlayerColor();
		switch (universe.ask("What is your favorite genre of music?", new String[]{"Pop.", "Hip hop.", "Rock.", "Electronic."})) {
			case 0:
				b += 1;
				r += 1;
				break;
			case 1:
				y += 1;
				r += 1;
				b -= 2;
				break;
			case 2:
				w += 1;
				r += 1;
				break;
			case 3:
				r += 1;
				y += 2;
				b -= 1;
				break;
		}
		Options.setMusicVolume(0.3);
		updatePlayerColor();
		switch (universe.ask("What is your favorite color?", new String[]{"Red.", "Green.", "Blue.", "Yellow."})) {
			case 0:
				r += 2;
				break;
			case 1:
				g += 2;
				break;
			case 2:
				b += 2;
				break;
			case 3:
				y += 2;
				break;
		}
		Options.setMusicVolume(0.2);
		updatePlayerColor();
		switch (universe.ask("How do you feel about travelling?", new String[]{"I love it!", "It's alright.", "I'd rather not.", "I really don't like travelling."})) {
			case 0:
				b += 1;
				r += 2;
				break;
			case 1:
				w += 1;
				break;
			case 2:
				y += 1;
				break;
			case 3:
				b += 1;
				y += 2;
				w += 1;
				break;
		}
		Options.setMusicVolume(0.1);
		updatePlayerColor();

		String s = universe.prompt("What is your name?");

		player = new Actor(s, player.getTextColor());

		universe.say("...");

		Options.setMusicVolume(0);
		TextDisplay.clear();
		recursiveSwitch(0);
	}

	public static void menu() {
		r = 0;
		g = 0;
		b = 0;
		w = 0;
		y = 0;
		switch (universe.menu(new String[]{"Play", "Help", "Options"})) {
			case 0:
				introSwitch();
				break;
			case 1:
				menu();
				break;
			case 2:
				universe.options();
				
				/*/
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	Options.setScale(Options.getScale() + 1);
				    }
				});
				//*/


				//menu();
				break;
		}
	}

	public static void recursiveSwitch(int switchNum) {
		switch (switchNum) {
			case 0:
				try {
					Thread.sleep(1000);
				} catch (final Exception e) {
				}
				universe.say("...");
				universe.say("The /^universe/^ is silent.");
				recursiveSwitch(1);
				break;
			case 1:
				///universe.say("...");
				universe.say(".../n/pWhat's /^that?/^");
				universe.say("A faint murmur /^masquerades/^ amongst the /^silence/^.");
				universe.say("It's /#you/#.");
				universe.say("...");
				Options.setMusicVolume(0.1);
				universe.say("But wait -- who /^are/^ you?...");
				universe.say("You have no memories...");
				Options.setMusicVolume(0.2);
				universe.say("You just... exist.");
				Options.setMusicVolume(0.25);
				universe.say("You /*just/*... are.");
				Options.setMusicVolume(0.3);
				//universe.say("You have no /^beginning/^ nor ending.");
				universe.say("No /#past/#...");
				Options.setMusicVolume(0.35);
				universe.say("/#Just/# the present.");
				universe.say("Just /#now/#.");
				Options.setMusicVolume(0.4);
				universe.say("...");
				recursiveSwitch(10);
				break;
			case 10:
				switch (universe.ask("Well/p...?", new String[]{"What am I?", "Where am I?", "What are you?"})) {
					case 0: // What am I
						recursiveSwitch(11);
						break;
					case 1: // Where am I
						recursiveSwitch(12);
						break;
					case 2: // What are you
						recursiveSwitch(13);
						break;
				}
				break;
			case 11:
				universe.say("./p./p./p");
				//universe.say("Just...think.");
				//universe.say("...");
				universe.say("I can't say I know...");
				universe.say("What is it that you're /#here/# for?");
				switch (universe.ask("Or...is there even a reason for your existence?", new String[]{"...", "What?"})) {
					case 0:
						recursiveSwitch(110);
						break;
					case 1:
						recursiveSwitch(111);
						break;
				}
				break;
			case 12:
				universe.say("There's nothing here.");
				switch (universe.ask("Nowhere to /#go/#...", new String[]{"Let's explore anyways.", "Nevermind."})) {
					case 0:// Explore
						recursiveSwitch(120);
						break;
					// Nevermind
					case 1:
						recursiveSwitch(10);
						break;
				}
				break;
			case 13:
				/* Love this, going to use it in the future.
				universe.say("You doze off for eternity.");
				universe.say("And yet, you awake.");
				universe.say("...");
				universe.say("A familiar silence permeates the universe.");
				recursiveSwitch(1);
				*/
				break;
			case 110:
				switch (universe.ask("What is it?", new String[]{"To live a successful life.", "To ensure the happiness of others.", "To make something amazing."})) {
				}
				break;
			case 111:
				universe.say("Your existence is meaningless.");
				universe.say("...");
				universe.say("But you can make your own meaning.");
				break;
			case -2147483648:
			case 2147483647:
		}
		TextDisplay.clear();
	}

	private static void updatePlayerColor() {
		int highestIndex = 5;
		int secondIndex = 5;
		final int[] colors = {r, g, b, y, w, -100};
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] >= colors[highestIndex]) {
				secondIndex = highestIndex;
				highestIndex = i;
			} else if (colors[i] > colors[secondIndex] && secondIndex != highestIndex) {
				secondIndex = i;
			}
		}
		Color A;
		Color B;
		switch (highestIndex) {
			case 0:
				A = new Color(1, 1 - r / 15d, 1 - r / 15d, 1);
				break;
			case 1:
				A = new Color(1 - g / 10d, 1, 1 - g / 10d, 1);
				break;
			case 2:
				A = new Color(1 - b / 11d, 1 - b / 11d, 1, 1);
				break;
			case 3:
				A = new Color(1, 1, 1 - y / 15d, 1);
				break;
			case 4:
				A = new Color(1, 1, 1, 1);
				break;
			default:
				A = new Color(1, 1, 1, 0);
				break;
		}
		switch (secondIndex) {
			case 0:
				B = new Color(1, 1 - r / 15d, 1 - r / 15d, 1);
				break;
			case 1:
				B = new Color(1 - g / 10d, 1, 1 - g / 10d, 1);
				break;
			case 2:
				B = new Color(1 - b / 11d, 1 - b / 11d, 1, 1);
				break;
			case 3:
				B = new Color(1, 1, 1 - y / 15d, 1);
				break;
			case 4:
				B = new Color(1, 1, 1, 1);
				break;
			default:
				B = new Color(1, 1, 1, 0);
				break;
		}
		final Color temp = A.interpolate(B, (float) colors[secondIndex] / colors[highestIndex]);
		player = new Actor("You", temp);
	}

}
