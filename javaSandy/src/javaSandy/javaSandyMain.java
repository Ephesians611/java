package javaSandy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class javaSandyMain {

	// Static Data
	static ArrayList<Integer> aLineLengths = new ArrayList<Integer>();
	static boolean endofline = false;
	static int whitespaces = 0;
	static int LineLength = 0;
	static int WordSize = 0;
	static int lines = 0;
	static int words = 0;
	static int characters = -1;
	static File file = new File("C:\\Projects\\TX State\\Dev\\Eclipse_Java\\java\\Prog0.txt");

	// `characters' is initialized to -1 because it is incremented with
	// each read, including the final read executed at end-of-file and
	// that final read does not actually add a character.

	// whiteSpace returns true iff its argument is a
	// space, newline, formfeed, tab, or carriage return.

	public static boolean whiteSpace(char c) {
		switch (c) {
		case ' ':
		case '\n':
		case '\f':
		case '\t':
		case '\r':
			return true;
		default:
			return false;
		}
	}

	public static int getNext(BufferedReader br) throws java.io.IOException {
		characters++;
		return br.read();
	}

	// The main method is invoked when this program is interpreted with
	// the java interpreter.

	public static void main(String argv[]) throws java.io.IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));

		int i = getNext(br);

		while (i != -1) { // Repeat until end-of-file is reached.
			// LineLength += WordSize;

			if (!whiteSpace((char) i)) {
				//
				// Word state
				//
				whitespaces = 0;
				WordSize = 0;
				words++; // We've seen another word.
				do { // Skip to the next white space character.
					WordSize++;
					i = getNext(br);
				} while (i != -1 && !whiteSpace((char) i));

			} else {
				//
				// whiteSpace state
				//
				whitespaces = 0;
				do {
					i = getNext(br);
					if ((char) i == '\n') {
						lines++; // We've seen another line;
						endofline = true;
					}
					if (endofline) {
						LineLength += WordSize + whitespaces;
						aLineLengths.add(LineLength);
						LineLength = 0;
						endofline = false;
					} else {
						whitespaces++;
						LineLength += WordSize + whitespaces;

					}
				} while (whiteSpace((char) i) && !endofline);
			}
		}
		System.out.println(" " + lines + " " + words + " " + characters + " " + LineLength);
	}
}
