package Story;

import java.util.ArrayList;

/**
 * Created by juliencherry on 05/11/17.
 */
public class Story {

	Event[] events;
	Scene scene1;

	public Story() {
		Event[] events = {
				new Monologue("..."),
				new Monologue("The universe is silent."),
				new Monologue("..."),
				new Monologue("What's that?"),
				new Monologue("A faint murmur masquerades amongst the silence."),
				new Monologue("It’s you."),
				new Monologue("..."),
				new Monologue("But wait--who *are* you...?"),
				new Monologue("You have no memories."),
				new Monologue("You just...exist."),
				new Monologue("You just...are."),
				new Monologue("You have no beginning nor ending."),
				new Monologue("No past nor future."),
				new Monologue("Just the present."),
				new Monologue("Just now."),
				new Monologue("...")
				//new Dialogue(),
		};

		this.events = events;

	}

	public void play() {
		scene1.play();
	}
}
