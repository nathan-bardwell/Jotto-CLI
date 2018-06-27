package jotto;


import java.util.Map;
import java.util.TreeMap;

public class Word {
	
	 private Map<Character, Integer> wordMap;
	 private int correctLetters = 0;
	 
	 public Word(String word) {
		 wordMap = new TreeMap<Character, Integer>();
		 
		 for (int i = 0; i < word.length(); i++) {
			 wordMap.put(word.charAt(i), 0);
		 }
	 }
	 
	 public boolean is5Letters(String word) {
			if (word.length() == 5) {
				return true;
			} else {
				return false;
			}
		}
	 
	 private int getCorrectLetters() {
		 return correctLetters;
	 }
	 
	 private void findCorrectLetters() {
		 
	 }

}
