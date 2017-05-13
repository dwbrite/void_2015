package Handlers.Text;

import javafx.scene.paint.Color;

public class TextFormatting {

	public static Color defaultColor = Color.WHITE;
	public static boolean defaultItalics = false;
	public static boolean defaultBold = false;
	public static boolean defaultUnderline = false;
	public static TextAnimation defaultAnimationIn = TextAnimation.TYPEWRITER;
	public static TextAnimation defaultAnimationOut = TextAnimation.NONE;

	private Color color;
	private Boolean italics;
	private Boolean bold;
	private Boolean underline;
	private TextAnimation animationIn;
	private TextAnimation animationOut;

	// todo: fix this terrible method--not scalable
	public void fillDefaults() {
		if (color == null)
			this.color = defaultColor;
		if (italics == null)
			this.italics = defaultItalics;
		if (bold == null)
			this.bold = defaultBold;
		if (underline == null)
			this.underline = defaultUnderline;
		if (animationIn == null)
			this.animationIn = defaultAnimationIn;
		if (animationOut == null)
			this.animationOut = defaultAnimationOut;
	}

	public Color getColor() {
		return this.color;
	}

	public TextFormatting setColor(Color color) {
		this.color = color;
		return this;
	}

	public Boolean getItalics() {
		return this.italics;
	}

	public TextFormatting setColor(Boolean italics) {
		this.italics = italics;
		return this;
	}

	public Boolean getBold() {
		return this.bold;
	}

	public TextFormatting setBold(Boolean bold) {
		this.bold = bold;
		return this;
	}

	public Boolean getUnderline() {
		return underline;
	}

	public TextFormatting setUnderline(Boolean underline) {
		this.underline = underline;
		return this;
	}

	public TextAnimation getAnimationIn() {
		return animationIn;
	}

	public TextFormatting setAnimationIn(TextAnimation animationIn) {
		this.animationIn = animationIn;
		return this;
	}

	public TextAnimation getAnimationOut() {
		return animationOut;
	}

	public TextFormatting setAnimationOut(TextAnimation animationOut) {
		this.animationOut = animationOut;
		return this;
	}
}
