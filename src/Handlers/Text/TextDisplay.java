package Handlers.Text;

import Handlers.Audio;
import Handlers.Controls;
import Handlers.Options;
import javafx.scene.paint.Color;
import Entities.Actor;
import GameState.StoryState;
import Main.VoidMain;

public class TextDisplay {
	private static Actor[] actorArray = new Actor[0];
	private static String[] choices;
	private static String inputString = "";
	private static String[] lineArray = new String[0];
	private static int numLines = (int) (4 * Text.getTextScale());
	private static boolean askOptionsShown = false;
	private static boolean prompted = false;
	private static boolean inOptionsMenu = false;
	private static int tempChoice = 0;
	private static int defaultSpeed = 64;
	private static int letterSpeed = 64;
	private static int fastSpeed = 32;
	private static int slowSpeed = 256;
	private static boolean fastActive = false;
	private static boolean slowActive = false;


	private static boolean next = false;

	private static long flashyThingy = 0;

	static {
		notifySizeUpdate();
	}

	public static int ask(String[] choices) {
		tempChoice = 0;
		askOptionsShown = true;
		TextDisplay.choices = choices;
		while (!Controls.getEnter()) {
			try {
				Thread.sleep(16);
			} catch (final Exception e) {
			}
			if (Controls.getUp() && tempChoice > 0) {
				flashyThingy = 0;
				tempChoice--;
				Controls.setUp(false);
			}
			if (Controls.getDown() && tempChoice < choices.length - 1) {
				flashyThingy = 0;
				tempChoice++;
				Controls.setDown(false);
			}
		}
		Controls.setEnter(false);
		askOptionsShown = false;
    StoryState.player.answer(choices[tempChoice]);//blinkWrite(name + choices[tempChoice], Story.player);
    return tempChoice;
	}

	public static void blinkWrite(String str, Actor actor) {
		for (int i = numLines - 1; i >= 1; i--) {
			lineArray[i] = lineArray[i - 1];
			actorArray[i] = actorArray[i - 1];
		}
		lineArray[0] = "";
		actorArray[0] = actor;
		char temp;
		for (int i = 0; i < str.length(); i++) {
			if (i == 1 && (Options.getRealWidth() / 8) <= str.length()) {
				String s1 = str.substring(0, (int) (Options.getRealWidth() / Text.getDefaultFont().getSize() - 2));
				int index = s1.lastIndexOf(" ");
				s1 = s1.substring(0, (index >= 0) ? index : 0);
				String s2 = str.substring((index >= 0) ? index : 0);

				s2 = s2.replaceFirst(" ", "/n");
				str = s1.concat(s2);
			}

			temp = str.charAt(i);
			if (temp == '/') {
				char temp2 = str.charAt(i + 1);
				if (temp2 == 'p' || temp2 == '*' || temp2 == '#' || temp2 == '^')
					i++;
				else if (temp2 == 'n') {
					i++;
					for (int j = numLines - 1; j >= 1; j--) {
						lineArray[j] = lineArray[j - 1];
						actorArray[j] = actorArray[j - 1];
					}
					lineArray[0] = "";
					actorArray[0] = actor;
					str = str.substring(i);
					i = 0;
				}
			} else {
				lineArray[0] += str.charAt(i);
			}
		}
		Controls.setEnter(false);
		flashyThingy = 0;
		next = true;
		while (!Controls.getEnter()) {
			try {
				Thread.sleep(16);
			} catch (final Exception e) {
			}
		}
		next = false;
		Controls.setEnter(false);
		Audio.playSFX(0);
	}

	public static void clear() {
		for (int i = 0; i < numLines; i++) {
			lineArray[i] = "";
			actorArray[i] = new Actor("", new Color(0, 0, 0, 0));
		}
	}

	public static int menu(String[] choices) {
		tempChoice = 0;
		askOptionsShown = true;
		TextDisplay.choices = choices;
		while (!Controls.getEnter()) {
			try {
				Thread.sleep(16);
			} catch (final Exception e) {
			}
			if (Controls.getUp() && tempChoice > 0) {
				flashyThingy = 0;
				tempChoice--;
				Controls.setUp(false);
			}
			if (Controls.getDown() && tempChoice < choices.length - 1) {
				flashyThingy = 0;
				tempChoice++;
				Controls.setDown(false);
			}
		}
		Controls.setEnter(false);
		askOptionsShown = false;
		return tempChoice;
	}

	public static void options() {
		tempChoice = 0;
		inOptionsMenu = true;

		while (!Controls.getEnter() || tempChoice != 3) {
			try {
				Thread.sleep(16);
			} catch (final Exception e) {
			}
			if (Controls.getUp() && tempChoice > 0) {
				flashyThingy = 0;
				tempChoice--;
				Controls.setUp(false);
			}
			if (Controls.getDown() && tempChoice < lineArray.length - 1) {
				flashyThingy = 0;
				tempChoice++;
				Controls.setDown(false);
			}
			double mv = Options.getMasterVolume();//master volume
			if (Controls.getLeft()) {
				switch (tempChoice) {
					case 0:
						Options.setMasterVolume((mv <= 0) ? 0 : mv - 0.1);//crazy shit: ((int)((mv - ((mv > 0)? 0.1: 0))*10))/10.0);
						break;
				}
				Controls.setLeft(false);
			}
			if (Controls.getRight()) {
				switch (tempChoice) {
					case 0:
						Options.setMasterVolume((mv >= 1) ? 1 : mv + 0.1);
						break;
				}
				Controls.setRight(false);
			}
			//System.out.println("Master: " + Options.getMasterVolume());
			//System.out.println("Music:  " + Options.getMusicVolume());
			//System.out.println("SFX:	" + Options.getSFXVolume());
			//System.out.println();

			String master = "";
			String sfx = "";
			String music = "";

			for (int i = 0; i < 10; i++) {
				master += ((Options.getMasterVolume() * 10 > i) ? "|" : " ");
				music += ((Options.getMusicVolume() * 10 > i) ? "|" : " ");
				sfx += ((Options.getSFXVolume() * 10 > i) ? "|" : " ");
			}

			lineArray = new String[4];
			lineArray[0] = "Master Volume:\t[" + master + "]";
			//lineArray[1] = "Music Volume:	\t[" + music	+ "]";
			//lineArray[2] = "SFX Volume:	\t[" + sfx		+ "]";
			lineArray[3] = "back";

		}
		Controls.setEnter(false);
		inOptionsMenu = false;
    StoryState.menu();
  }

	public static String prompt() {
		inputString = "";
		prompted = true;
		while (!Controls.getEnter() || inputString.trim().equals("")) {
			String temp = Controls.getInput();
			try {
				Thread.sleep(16);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

			if (!temp.equals("")) {
				flashyThingy = 30;
			}

			if (temp.equals("BACK_SPACE")) {
				if (inputString.length() > 0) {
					inputString = inputString.substring(0, inputString.length() - 1);
				}
			} else {
				inputString += temp;
			}
			temp = "";
		}
		prompted = false;

		for (int i = numLines - 1; i >= 1; i--) {
			lineArray[i] = lineArray[i - 1];
			actorArray[i] = actorArray[i - 1];
		}
		lineArray[0] = inputString;
    actorArray[0] = StoryState.player;

		return inputString;
	}

	public static void renderText() {
		flashyThingy++;

		if (askOptionsShown) {
			for (int i = 0; i < numLines; i++) {
				Color tempColor = actorArray[i].getTextColor();
				VoidMain.getGraphicsContext().setFont(Text.getDefaultFont());
				VoidMain.getGraphicsContext().setFill(tempColor);
				VoidMain.getGraphicsContext().fillText(lineArray[i], 8, (Options.getRealHeight() - (32 + 16 * (choices.length + i)) * Text.getTextScale()));
        VoidMain.getGraphicsContext().setFill(StoryState.player.getTextColor());
      }
			for (int i = 0; i < choices.length; i++) {
				VoidMain.getGraphicsContext().fillText(((tempChoice == i && flashyThingy % 60 < 30) ? "� " : "  ") + choices[i], 8, (Options.getRealHeight() - (32 + 16 * (choices.length - 1) - (16 * i)) * Text.getTextScale()));
			}
		} else if (prompted) {
			for (int i = 0; i < numLines; i++) {
				Color tempColor = actorArray[i].getTextColor();
				tempColor = new Color(tempColor.getRed(), tempColor.getGreen(), tempColor.getBlue(), (1.0d * numLines - (i + 1)) / numLines);
				VoidMain.getGraphicsContext().setFill(tempColor);
				VoidMain.getGraphicsContext().fillText(lineArray[i], 8, (Options.getRealHeight() - 32) - 16 * (i + 1) * Text.getTextScale());
			}
      VoidMain.getGraphicsContext().setFill(StoryState.player.getTextColor());
      VoidMain.getGraphicsContext().fillText(((flashyThingy % 60 < 30) ? "� " : "  ") + inputString, 8, (Options.getRealHeight() - 32));

		} else if (inOptionsMenu) {
			for (int i = 0; i < lineArray.length; i++) {
        VoidMain.getGraphicsContext().setFill(StoryState.universe.getTextColor());
        VoidMain.getGraphicsContext().fillText(((tempChoice == i && flashyThingy % 60 < 30) ? "� " : "  ") + lineArray[i], 8, (Options.getRealHeight() - (32 + 16 * (lineArray.length - 1) - (16 * i)) * Text.getTextScale()));
			}
		} else {
			Color tempColor;
			for (int i = 0; i < numLines; i++) {
				if (i == 0 && next && flashyThingy % 80 < 40) {
					tempColor = actorArray[i].getTextColor();
					tempColor = new Color(tempColor.getRed(), tempColor.getGreen(), tempColor.getBlue(), (1.0d * numLines - i) / numLines);
					VoidMain.getGraphicsContext().setFill(tempColor);
					VoidMain.getGraphicsContext().fillText(lineArray[i] + " �", 8 * Text.getTextScale(), (Options.getRealHeight() - (32 + 16 * i) * Text.getTextScale()));
				} else {
					tempColor = actorArray[i].getTextColor();
					tempColor = new Color(tempColor.getRed(), tempColor.getGreen(), tempColor.getBlue(), (1.0d * numLines - i) / numLines);
					VoidMain.getGraphicsContext().setFill(tempColor);
					VoidMain.getGraphicsContext().fillText(lineArray[i], 8 * Text.getTextScale(), (Options.getRealHeight() - (32 + 16 * i) * Text.getTextScale()));
				}

			}
		}
	}

	public static void write(String str, Actor actor) {
		for (int i = numLines - 1; i >= 1; i--) {
			lineArray[i] = lineArray[i - 1];
			actorArray[i] = actorArray[i - 1];
		}
		lineArray[0] = "";
		actorArray[0] = actor;
		char temp;
		for (int i = 0; i < str.length(); i++) {
			if (i == 1 && (Options.getRealWidth() / 8) <= str.length()) {
				String s1 = str.substring(0, (int) (Options.getRealWidth() / Text.getDefaultFont().getSize() - 2));
				int index = s1.lastIndexOf(" ");
				s1 = s1.substring(0, (index >= 0) ? index : 0);
				String s2 = str.substring((index >= 0) ? index : 0);

				s2 = s2.replaceFirst(" ", "/n");
				str = s1.concat(s2);
			}

			if (Controls.getEnter()) {
				temp = str.charAt(i);
				if (temp == '/') {
					char temp2 = str.charAt(i + 1);
					if (temp2 == 'p' || temp2 == '*' || temp2 == '#' || temp2 == '^')
						i++;
					else if (temp2 == 'n') {
						i++;
						for (int j = numLines - 1; j >= 1; j--) {
							lineArray[j] = lineArray[j - 1];
							actorArray[j] = actorArray[j - 1];
						}
						lineArray[0] = "";
						actorArray[0] = actor;
						str = str.substring(i);
						i = 0;
					}
				} else {
					lineArray[0] += str.charAt(i);
				}
			} else {
				temp = str.charAt(i);
				if (temp == '/' && str.charAt(i + 1) == 'n') {
					i++;
					for (int j = numLines - 1; j >= 1; j--) {
						lineArray[j] = lineArray[j - 1];
						actorArray[j] = actorArray[j - 1];
					}
					lineArray[0] = "";
					actorArray[0] = actor;
					str = str.substring(i);
					i = 0;
				} else if ((i > 1 && (temp == '.' && str.charAt(i - 1) == '.')) || temp == ',') {
					lineArray[0] += str.charAt(i);
					try {
						Audio.playSFX(0);
						Thread.sleep(180);
					} catch (final Exception e) {
					}
				} else if (temp == '.') {
					lineArray[0] += str.charAt(i);
					try {
						Audio.playSFX(0);
						Thread.sleep(225);
					} catch (final Exception e) {
					}
				} else if (temp == '-' && str.charAt(i + 1) == '-') {
					i++;
					lineArray[0] += "\u2014";

					try {
						Thread.sleep(350);
					} catch (final Exception e) {
					}
				} else if (temp == '/' && str.charAt(i + 1) == '*') {
					i++;
					try {
						Thread.sleep(250);
						fastActive = !fastActive;
						if (fastActive)
							letterSpeed = fastSpeed;
						else if (slowActive)
							letterSpeed = slowSpeed;
						else
							letterSpeed = defaultSpeed;
					} catch (final Exception e) {
					}
				} else if (temp == '/' && str.charAt(i + 1) == '^') {
					i++;
					fastActive = !fastActive;
					if (fastActive)
						letterSpeed = fastSpeed;
					else if (slowActive)
						letterSpeed = slowSpeed;
					else
						letterSpeed = defaultSpeed;
				} else if (temp == '/' && str.charAt(i + 1) == '#') {
					i++;
					slowActive = !slowActive;
					if (slowActive)
						letterSpeed = slowSpeed;
					else if (fastActive)
						letterSpeed = fastSpeed;
					else
						letterSpeed = defaultSpeed;
				} else if (temp == '/' && str.charAt(i + 1) == 'p') {
					i++;
					try {
						Thread.sleep(500);
					} catch (final Exception e) {
					}
				} else if (temp == ' ') {
					try {
						lineArray[0] += str.charAt(i);
						Thread.sleep(32);
					} catch (final Exception e) {
					}
				} else {
					try {
						if (str.charAt(i) != ' ')
							Audio.playSFX(0);

						lineArray[0] += str.charAt(i);
						Thread.sleep(letterSpeed);
					} catch (final Exception e) {
					}


				}
			}
		}
		Controls.setEnter(false);
		flashyThingy = 0;
		next = true;
		while (!Controls.getEnter()) {
			try {
				Thread.sleep(16);
			} catch (final Exception e) {
			}
		}
		next = false;
		Controls.setEnter(false);
	}

	public static void notifySizeUpdate() {
		numLines = (int) (4 * Text.getTextScale());

		String[] temp1 = lineArray;
		Actor[] temp2 = actorArray;
		lineArray = new String[numLines];
		actorArray = new Actor[numLines];

		for (int i = 0; i < numLines; i++) {
			if (i < temp1.length) {
				lineArray[i] = temp1[i];
				actorArray[i] = temp2[i];
			} else {
				lineArray[i] = "";
				actorArray[i] = new Actor("", new Color(0, 0, 0, 0));
			}
		}
	}
}
