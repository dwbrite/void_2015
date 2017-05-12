package Entities;

import javafx.scene.paint.Color;
import GameState.Story;
import Handlers.TextDisplay;

public class Actor {
	private int answer = 0;
	private String name;
	private Color textColor;

	public Actor(String name, Color color) {
		this.name = name;
		textColor = color;
	}

	public int ask(String question, String[] choices) {
		say(question);
		return TextDisplay.ask(choices);
	}

	public int getAnswer() {
		return answer;
	}

	public String getName() {
		return name;
	}

	public Color getTextColor() {
		return textColor;
	}

	public int menu(String[] choices) {
		return TextDisplay.menu(choices);
	}

	public String prompt(String string) {
		this.say(string);
		return TextDisplay.prompt();
	}

	public void say(String str) {
		if (equals(Story.player)) {
			TextDisplay.write(name + ": " + str, this);
		} else {
			TextDisplay.write(str, this);
		}
	}

	public void setAnswer(int ans) {
		answer = ans;
	}

	public void setColor(Color color) {
		textColor = color;
	}

	public void setName(String str) {
		name = str;
	}

	public void options() {
		TextDisplay.options();
	}

	public void answer(String choice) {
		TextDisplay.blinkWrite(choice, Story.player);
	}
}
