package jotto;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {

	private String name;
	private boolean isTurn;
	private boolean isWinner;
	private Word secretWord;

	public Player(String name, Word secretWord) {
		this.name = name;
		this.secretWord = secretWord;
		isTurn = false;
		isWinner = false;
	}

	public boolean startTurn() {
		isTurn = true;
		return isTurn;
	}

	public boolean endTurn() {
		isTurn = false;
		return isTurn;
	}

	public boolean isPlayersTurn() {
		return isTurn;
	}

	public Word getSecretWord() {
		return secretWord;
	}

	public String getPlayerName() {
		return this.name;
	}

	public boolean isWinner() {
		isWinner = true;
		return isWinner;
	}

	public boolean hasWon() {
		if (isWinner) {
			return true;
		} else {
			return false;
		}
	}

	public String guess() throws FileNotFoundException {
		boolean goodWord = false;
		String guess = "";
		while (!goodWord) {
			guess = "";
			Scanner input = new Scanner(System.in);
			System.out.print(name.toUpperCase() + ", ENTER YOUR GUESS >>>>> ");
			guess = guess + input.nextLine();
			Word guessWord = new Word(guess);
			if (guessWord.verifyWord(guess)) {
				goodWord = true;
			} else {
				System.out.println("'" + guess + "' " + "is not a playable word. Please try again.");
				goodWord = false;
			}
		}
		return guess;
	}
}
