package Handlers.Text;

import Handlers.Options;
import Main.VoidMain;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;

public class TextHandler {
	private static String[] text = new String[]{"", "", "", "", "", "", "", ""};
	private static Color[] txtColor = new Color[]{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE};

	public static void addText(String str, Color color) {
		String[] splitText = str.split("\n");

		setTxtColor(0, color);
		setLine(0, getLine(0) + splitText[0]);
		// System.out.println("First: " + splitText[0]);

		if (splitText.length > 1) {
			for (int i = 1; i < splitText.length; i++) {

				for (int j = text.length - 1; j > 0; j--) {
					setTxtColor(j, getTxtColor(j - 1));
					setLine(j, getLine(j - 1));
				}

				setTxtColor(0, color);
				setLine(0, splitText[i]);
			}
		}

    /*
	for (int i = 1; i < splitText.length; i++) {
			for (int j = text.length - 1; j > 0; j--) {
        setTxtColor(j, getTxtColor(j - 1));
				setLine(j, getLine(j - 1));
			}
      setTxtColor(0, color);
			setLine(0, getLine(0) + splitText[i]);
		}*/
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

	public static void render() {
		for (int i = 0; i < text.length; i++) {
			VoidMain.getGraphicsContext().setFill(getTxtColor(i));
			VoidMain.getGraphicsContext().fillText(getLine(i), 8, (Options.getRealHeight() - 32) - 16 * (i + 1) * Text.getTextScale());
		}
	}

	public static void render(Line line) {

	}

	public static Color getTxtColor(int i) {
		return txtColor[i];
	}

	public static void setTxtColor(int i, Color color) {
		TextHandler.txtColor[i] = color;
	}
}
