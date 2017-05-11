package Handlers;

import javafx.scene.image.Image;
import Main.VoidMain;

public class Backgrounds
{
	private static Image	currentImage;
	private static String	imageString;
	
	public static void drawBackground()
	{
		VoidMain.getGraphicsContext().drawImage(currentImage, 0, 0, Options.getRealWidth(), Options.getRealHeight());
	}

	public static void setBackground(String bg)
	{
		imageString = bg;
		currentImage = new Image(bg, Options.getRealWidth(), Options.getRealHeight(), true, false);
	}

	public static void notifySizeUpdate()
	{
		setBackground(imageString);
	}
}
