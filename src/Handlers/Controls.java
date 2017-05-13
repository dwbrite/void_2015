package Handlers;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controls {
	private static boolean enter, up, down, left, right, shift, caps;
	private static String inputChar = "";

	public static boolean getDown() {
		return down;
	}

	public static boolean getEnter() {
		return enter;
	}

	public static String getInput() {
		String temp = inputChar;
		inputChar = "";
		return temp;
	}

	public static boolean getUp() {
		return up;
	}

	public static boolean getLeft() {
		return left;
	}

	public static boolean getRight() {
		return right;
	}

	public static void setDown(boolean b) {
		down = b;
	}

	public static void setEnter(boolean b) {
		enter = b;
	}

	public static void setUp(boolean b) {
		up = b;
	}

	public static void setLeft(boolean b) {
		left = b;
	}

	public static void setRight(boolean b) {
		right = b;
	}

	public static void textInput(KeyEvent event) {
		inputChar = (event.getCode() != KeyCode.BACK_SPACE) ? (getCase()) ? event.getText().toUpperCase() : event.getText().toLowerCase() : "BACK_SPACE";
	}

	public static boolean getCaps() {
		return caps;
	}

	public static void setCaps(boolean b) {
		caps = b;
	}

	public static boolean getShift() {
		return shift;
	}

	public static void setShift(boolean b) {
		shift = b;
	}

	public static boolean getCase() {
		return shift ^ caps;
	}

	public static void waitForInput(KeyCode keyCode) {
		while (getInput().equals(keyCode.toString())) {
			try {
				Thread.sleep(16);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
