/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	
	private ArrayList<String> wordList = new ArrayList<String>();

	// empty constructor 
	public HangmanLexicon() {
		try {
			BufferedReader hangmanWords = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true) {
				String line = hangmanWords.readLine();
				if(line == null) {
					break;
				}
				else {
					wordList.add(line);
				}
			}
			hangmanWords.close();
		}
		catch (IOException ex){
			throw new ErrorException(ex);
		}
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	}
}
