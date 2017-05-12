package Story;

/**
 * Created by juliencherry on 05/11/17.
 */
public class Monologue implements Event {
	String text;

	public Monologue(String text) {
		this.text = text;
	}

	@Override
	public void run() {
		new Text(text).run();
	}
}
