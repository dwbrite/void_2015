package Handlers.Text;

import javafx.scene.paint.Color;

/**
 * Represents an immutable string formatted with some particular format (e.g. color, bold, italics)
 * or animation
 */
public final class FormattedString {

	private final CharSequence text;
	private final Color color;
	private final boolean italics;
	private final boolean bold;
	private final boolean underline;
	// private final TextAnimation inAnimation;
	// private final TextAnimation outAnimation;

	public static class Builder {

		private final CharSequence text;

		private Color color = Color.WHITE;
		private boolean italics = false;
		private boolean bold = false;
		private boolean underline = false;

		public Builder(CharSequence text) {
			this.text = text;
		}

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

		public FormattedString build() {
			return new FormattedString(this);
		}
	}

	private FormattedString(Builder builder) {
		this.bold = builder.bold;
		this.color = builder.color;
		this.italics = builder.italics;
		this.text = builder.text;
		this.underline = builder.underline;
	}
}
