package Story;

import Handlers.TextHandler;

/**
 * Created by juliencherry on 05/11/17.
 */
public class Dialogue implements Event {

	Actor actor;
	String dialogue;

	public Dialogue(Actor actor, String dialogue) {
		this.actor = actor;
		this.dialogue = dialogue;
	}

	@Override
	public void run() {
		//	TextHandler.display(this.actor.getColor());
	}
}
