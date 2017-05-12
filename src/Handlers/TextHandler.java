package Handlers;

import Main.VoidMain;
import javafx.scene.paint.Color;

public class TextHandler {
	private static String[] text = new String[8];

	public static void display(Color color, String str) {
		String[] splitText = str.split("\n");
		VoidMain.getGraphicsContext().setFill(color);
		for (int i = 0; i < splitText.length; i++) {
			for (int j = text.length - 1; j > 0; j--) {
				setLine(j, getLine(j - 1));
			}
			setLine(0, splitText[i]);
		}

		for (int i = 0; i < text.length; i++) {
			VoidMain.getGraphicsContext().fillText(getLine(i), 8, (Options.getRealHeight() - 32) - 16 * (i + 1) * Text.getTextScale());
		}
	}

	public static void setLine(int i, String str) {
		text[i] = str;
	}

	public static String getLine(int i) {
		return text[i];
	}
}
