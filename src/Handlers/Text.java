package Handlers;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import Main.VoidMain;

public class Text {
	private static Font font;
	private static String url;
	private static int defaultSize;

	public static void setFont(String str) {
		url = str;
		font = Font.loadFont(VoidMain.class.getResourceAsStream(str), defaultSize * getTextScale());

	}

	public static Font getDefaultFont() {
		return font;
	}

	public static void notifySizeUpdate() {
		setFont(url);
	}

	public static void setDefaultSize(int size) {
		defaultSize = size;
	}

	public static double getTextScale() {
		return ((Options.getScale() <= 2) ? 1 : 2);
	}
}
