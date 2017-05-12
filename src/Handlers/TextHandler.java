package Handlers;

import Main.VoidMain;
import javafx.scene.paint.Color;

public class TextHandler {
	private static String[] text = new String[8];

  public static void addText(String str, Color color) {
    String[] splitText = str.split("\n");
		VoidMain.getGraphicsContext().setFill(color);
		for (int i = 0; i < splitText.length; i++) {
			for (int j = text.length - 1; j > 0; j--) {
				setLine(j, getLine(j - 1));
			}
			setLine(0, splitText[i]);
		}
	}

	public static void setLine(int i, String str) {
		text[i] = str;
	}

	public static String getLine(int i) {
		return text[i];
	}

  public static void addText(String str) {
    addText(str, Color.WHITE);
  }
}
