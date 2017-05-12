package Story;

import java.util.Stack;

/**
 * Created by juliencherry on 05/11/17.
 */
public abstract class Scene {
	Stack<Event> events;

	public abstract void play();
}
