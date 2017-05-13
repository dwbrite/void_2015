package Story;

import Handlers.Text.FormattedString;
import Handlers.Text.TextFormatting;
import Handlers.Text.TextHandler;

public class Dialogue implements Event {

	private Actor actor;
	private FormattedString dialogue;

	public Dialogue(Actor actor, String dialogue, TextFormatting formatting) {
		this.actor = actor;
		this.dialogue = new FormattedString(dialogue, formatting);
	}

	public Dialogue(Actor actor, String dialogue) {
		this(actor, dialogue, new TextFormatting());
	}

	@Override
	public void run() {

		TextHandler.addText(new FormattedString(this.actor.getName(), new TextFormatting().setColor(this.actor.getColor())));
		TextHandler.addText(new FormattedString(": " + this.dialogue));
	}
}
