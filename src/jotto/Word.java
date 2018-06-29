package jotto;


import java.util.HashMap;
import java.util.Map;


public class Word {
	
	 private HashMap<Character, Integer> wordMap;
	 private int correctLetters = 0;
	 
	 public Word(String word) {
		 wordMap = new HashMap<Character, Integer>();
		 
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
	 
	public HashMap<Character, Integer> getMap() {
		return wordMap;
	}
	 

}
