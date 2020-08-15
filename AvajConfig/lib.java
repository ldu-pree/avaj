package AvajConfig;

import java.io.FileWriter;
import java.io.IOException;

public class lib {
	public static void writeF(String line) {
		try {
			opts.myWriter.write(line);
		} catch (IOException e) {
			System.out.println("An error occurred writing to simulation.txt.");
			e.printStackTrace();
		}
	}
}