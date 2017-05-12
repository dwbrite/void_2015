package Handlers;

// import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Selection {
	private static ArrayList<Integer> data = new ArrayList<Integer>();
	private static String filename = "save.dat";
	// private static BufferedReader input;
	private static BufferedWriter output;

	public static void add(int selection) {
		data.add(selection);
		write();
	}

	/*
	 * / public static int get(int index) { if (data == null) { read(); } return data.get(index - 1); } private static void read() { try { input = new BufferedReader(new FileReader(filename)); int i = 0; String s = input.readLine(); while (s != null) { data.set(i, Integer.parseInt(s)); i++; s = input.readLine(); } } catch (IOException e) { e.printStackTrace(); } } //
	 */
	public static void reset() {
		data.clear();
		write();
	}

	private static void write() {
		try {
			output = new BufferedWriter(new FileWriter(filename));
			for (int i = 0; i < data.size(); i++) {
				System.out.println(data.get(i));
				output.write(data.get(i) + "\n");
				output.close();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
