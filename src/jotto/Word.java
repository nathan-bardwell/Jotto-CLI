package jotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Word {

	private String wordString;
	private File acceptableWords; 
	private Scanner wordVerifier; 
	private HashMap<Character, Integer> wordMap;

	public Word(String word) throws FileNotFoundException {
			this.wordString = word;
			wordMap = new HashMap<Character, Integer>();

			for (int i = 0; i < word.length(); i++) {
				wordMap.put(word.charAt(i), 0);
			}
		
	}

	public boolean verifyWord(String word) throws FileNotFoundException {
		acceptableWords = new File("AcceptableWordList.txt");
		wordVerifier = new Scanner (acceptableWords.getAbsoluteFile());
		boolean verified = false;
		while (wordVerifier.hasNextLine()) {
			String line = wordVerifier.nextLine();
			if (word.equals(line)) {
				verified = true;
				break;
			}
		}
		if (verified) {
			return true;
		} else {
			return false;
		}
	}

	public HashMap<Character, Integer> getMap() {
		return wordMap;
	}

	public String wordToString() {
		return wordString;
	}

}
