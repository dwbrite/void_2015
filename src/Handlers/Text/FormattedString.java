package Handlers.Text;

import javafx.scene.paint.Color;

// represents a string formatted with some particular format (e.g. color, bold, italics) or animation
public class FormattedString {
	CharSequence text;
	Color color;
	boolean italics;
	boolean bold;
	boolean underline;
	TextAnimation animation;

	public FormattedString(CharSequence text, Color color) {
		this.text = text;
		this.color = color;
	}
}
