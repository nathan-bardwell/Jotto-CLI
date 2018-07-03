package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordSorter {
	
	public void findFiveLetterWords() throws FileNotFoundException {
		File wordList = new File("dict.txt");
		Scanner fileScanner = new Scanner(wordList.getAbsoluteFile());
		File newFile = new File("fiveletterwords.txt");
		PrintWriter fileWriter = new PrintWriter(newFile);
		
		while (fileScanner.hasNextLine()) {
			String word = fileScanner.nextLine();
			if (word.length() == 5) {
				fileWriter.println(word);
			} else if (word.length() == 4) {
				word = word + "s";
				fileWriter.println(word);
			} else if (word.length() == 3) {
				word = word + "es";
				fileWriter.println(word);
			}
		}
		fileScanner.close();
		fileWriter.close();
	}
	
	public void findWordsWithNoRepeatingLetters() throws FileNotFoundException {
		File wordList = new File("fiveletterwords.txt");
		Scanner fileScanner = new Scanner(wordList.getAbsoluteFile());
		File newFile = new File("AcceptableWordList.txt");
		PrintWriter fileWriter = new PrintWriter(newFile);
		
		while(fileScanner.hasNextLine()) {
			String word = fileScanner.nextLine();
			int charCount = 0;
			int[] charCountArray = new int[5];
			boolean repeatLetters = false;
			boolean properNoun = false;
			for (int i = 0; i < word.length(); i++) {
				char x = word.charAt(i);
				if (Character.isUpperCase(word.charAt(0))) {
					properNoun = true;
				}
				for (int j = i + 1; j < word.length(); j++) {
					char y = word.charAt(j);
					if (x == y) {
						charCount++;
						charCountArray[i] = charCount;
					}
				}
				for (int count : charCountArray) {
					if (count > 0) {
						repeatLetters = true;
					}
				}
				
			}
			if (repeatLetters || properNoun) {
				
			} else {
				fileWriter.println(word);
			}
		}
		fileScanner.close();
		fileWriter.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		WordSorter sorter = new WordSorter();
		System.out.println("Sorting through word list...");
		sorter.findFiveLetterWords();
		System.out.println("Sorting through narrowed list...");
		sorter.findWordsWithNoRepeatingLetters();
		System.out.println("DONE!");
	}


}
