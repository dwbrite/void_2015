package Handlers.Text;

import java.util.Arrays;
import javafx.scene.paint.Color;

/**
 * Represents an immutable string formatted with some particular format (e.g. color, bold, italics)
 * or animation
 */
public final class FormattedString {

	final String text;

	final Builder builder;
	final Color color;
	final boolean italics;
	final boolean bold;
	final boolean underline;
	// final TextAnimation inAnimation;
	// final TextAnimation outAnimation;

	public static class Builder {

		private Color color = Color.WHITE;
		private boolean italics = false;
		private boolean bold = false;
		private boolean underline = false;

		public Builder color(Color val) {
			this.color = val;
			return this;
		}

		public Builder italics() {
			this.italics = true;
			return this;
		}

		public Builder bold() {
			this.bold = true;
			return this;
		}

		public Builder underline() {
			this.underline = true;
			return this;
		}
	}

	public FormattedString(String text) {
		this(text, new Builder());
	}

	private FormattedString(String text, Builder builder) {
		this.text = text;
		this.builder = builder;
		this.bold = builder.bold;
		this.color = builder.color;
		this.italics = builder.italics;
		this.underline = builder.underline;
	}

	public FormattedString[] split(String regex) {
		return Arrays.stream(this.text.split(regex)).map(s -> new FormattedString(s, this.builder)).toArray(FormattedString[]::new);
	}
}
