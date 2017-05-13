package Handlers.Text;

import java.util.Arrays;
/**
 * Represents an immutable string formatted with some particular format (e.g. color, bold, italics)
 * or animation
 */
public final class FormattedString {

	private final String text;
	private final TextFormatting formatting;

	public FormattedString(String text, TextFormatting formatting) {
		this.text = text;
		this.formatting = formatting;
		this.formatting.fillDefaults();
	}

	public FormattedString(String text) {
		this(text, new TextFormatting());
	}

	public FormattedString[] split(String regex) {
		return Arrays.stream(this.text.split(regex)).map(s -> new FormattedString(s, this.formatting)).toArray(FormattedString[]::new);
	}

	@Override
	public String toString() {
		return this.text;
	}
}
