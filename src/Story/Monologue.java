package Story;

import Handlers.Text.FormattedString;
import Handlers.Text.TextFormatting;
import Handlers.Text.TextHandler;

public class Monologue implements Event {

	private FormattedString text;

	public Monologue(String text, TextFormatting formatting) {
		this.text = new FormattedString(text, formatting);
	}

	public Monologue(String text) {
		this(text, new TextFormatting());
	}

	@Override
	public void run() {
		TextHandler.addText(this.text);

		// todo: replace with new WaitForKey(enter);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
