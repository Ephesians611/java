package javaSandy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class javaSandyMain {

	// Static Data
	static ArrayList<Integer> aWordLengths = new ArrayList<Integer>();
	static ArrayList<Integer> aLineLengths = new ArrayList<Integer>();
	static boolean endofline = false;
	static int whitespaces = 0;
	static int LineLength = 0;
	static int WordSize = 0;
	static int lines = 0;
	static int words = 0;
	static int characters = -1;
	static int totalLineLength, avgLineLength = 0;
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
					if (i == -1) {
						// process the last line
						LineLength += WordSize + whitespaces;
						aLineLengths.add(LineLength);
					}
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
					aWordLengths.add(WordSize);
					if (endofline) {
						LineLength += WordSize + whitespaces;
						aLineLengths.add(LineLength);
						LineLength = 0;
						WordSize = 0;
						endofline = false;
						i = getNext(br);
						break;
					} else {
						if (i != '\r') {
							whitespaces++;
							LineLength += WordSize + whitespaces;
						}
					}
				} while (whiteSpace((char) i));
			}
		}

		// extra requirements
		Object objLongestWord = Collections.max(aWordLengths);
		for (int ll = 0; ll < aLineLengths.size(); ll++) {
			totalLineLength += aLineLengths.get(ll);
		}
		totalLineLength = totalLineLength / aLineLengths.size();

		System.out.println("Number of Lines: " + lines + '\n' + " Number of Words: " + words + '\n'
				+ " Number of Characters " + characters + '\n' + " Average Line Length: " + totalLineLength + '\n'
				+ " Longest Word Length: " + objLongestWord);
	}
}
