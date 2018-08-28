package jotto;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Game {

	private Player player1;
	private Player player2;
	private Map<String, Integer> guessMap1;
	private Map<String, Integer> guessMap2;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.guessMap1 = new LinkedHashMap<String, Integer>();
		this.guessMap2 = new LinkedHashMap<String, Integer>();

	}

	public Game() {

	}

	public void playGame() throws FileNotFoundException {
		
		while (!(player1.hasWon() || player2.hasWon())) {
			player1.startTurn();
			JottoCLI.clearScreen();
			printGuesses(player1);
			guessWord(player2, player1.guess());
			player1.endTurn();
			
			if (player1.hasWon()) {
				JottoCLI.clearScreen();
				System.out.println(gameOver(player1));
				break;
			}

			player2.startTurn();
			JottoCLI.clearScreen();
			printGuesses(player2);
			guessWord(player1, player2.guess());
			player2.endTurn();
			
			if (player2.hasWon()) {
				JottoCLI.clearScreen();
				System.out.println(gameOver(player2));
				break;
			}
		}

	}

	private String gameOver(Player winner) {
		
		String message = "\n\n\nCONGRATULATIONS, " + winner.getPlayerName() + ", YOU HAVE WON!\n\n\n";
		return message;
	}

	private void guessWord(Player listener, String word) throws FileNotFoundException {
		int correctLetters;
		Scanner input = new Scanner(System.in);
		if (player1.isPlayersTurn()) {
			listener = player2;
			correctLetters = compareWords(player1, word, listener.getSecretWord());
			guessMap1.put(word, correctLetters);
			System.out.println("\n'" + word.toUpperCase() + "' has " + correctLetters + " correct letters");
			System.out.println("\nPress ENTER to continue");
			input.nextLine();
		} else if (player2.isPlayersTurn()) {
			listener = player1;
			correctLetters = compareWords(player2, word, listener.getSecretWord());
			guessMap2.put(word, correctLetters);
			System.out.println("\n'" + word.toUpperCase() + "' has " + correctLetters + " correct letters");
			System.out.println("\nPress ENTER to continue");
			input.nextLine();
		}

	}

	private int compareWords(Player guessor, String guess, Word secret) throws FileNotFoundException {
		int correctLetters = 0;

		for (int i = 0; i < guess.length(); i++) {
			char x = guess.charAt(i);
			if (secret.getMap().containsKey(x)) {
				correctLetters++;
				secret.getMap().replace(x, secret.getMap().get(x) + 1);
			}
		}
		if (guess.equals(secret.wordToString())) {
			guessor.isWinner();
		}
		return correctLetters;
	}
	
	private void printGuesses(Player player) {
		System.out.println("\n* * * * * * * *");
		System.out.println("*   GUESSES   *");
		System.out.println("*             *");
		if (player == player1) {
			for(Map.Entry<String, Integer> guess : guessMap1.entrySet()) {
				System.out.println(String.format("* %-9s%-2s *", guess.getKey().toUpperCase(), guess.getValue()));
			}
		} else if (player == player2) {
			for(Map.Entry<String, Integer> guess : guessMap2.entrySet()) {
				System.out.println(String.format("* %-9s%-2s *", guess.getKey().toUpperCase(), guess.getValue()));
			}
		}
		System.out.println("* * * * * * * *\n");
	}

	public void displayRules() {
		System.out.println("\n1) Each player will pick a secret word of 5 letters");
		System.out.println("\t- All words must appear in an English dictionary");
		System.out.println("\t- NO proper nouns!");
		System.out.println("\t- NO repeating letters!");
		System.out.println("2) Players will take turns trying to correctly guess each other's secret word");
		System.out.println("3) For every player's guess, the computer will give the number of letters in the \n  guess word that match a unique letter in the opposing player's secret word");
		System.out.println("4) Each player must use deduction to try and figure out the other's secret word");
		System.out.println("5) The first player to correctly guess the other's secret word wins the game");
	}

}
