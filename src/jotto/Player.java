package jotto;

import java.util.Scanner;

public class Player {
	
	private String name;
	private boolean isTurn;
	private boolean isWinner = false;
	private Word playerWord;
	private Word playerGuess;
	
	public Player(String name, Word playerWord) {
		this.name = name;
		this.playerWord = playerWord;
		isTurn = false;
	}
	
	public boolean isPlayersTurn() {
		guess();
		isTurn = true;
		return isTurn;
	}
	
	public Word getPlayerGuess() {
		return playerGuess;
	}

	public void setPlayerGuess(Word playerGuess) {
		this.playerGuess = playerGuess;
	}

	public Word getPlayerWord() {
		return playerWord;
	}

	public String getPlayerName () {
		return this.name;
	}
	
	public boolean hasWon() {
		isWinner = true;
		return isWinner;
	}
	
	public String guess() {
		Scanner input = new Scanner(System.in);
		isTurn = true;
		System.out.println(name.toUpperCase() + ", ENTER YOUR GUESS");
		String guess = input.nextLine();
		return guess;
	}
	

}
