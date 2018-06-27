package jotto;

public class Player {
	
	private String name;
	private boolean isTurn;
	private Word playerWord;
	private Word playerGuess;
	
	public Player(String name, Word playerWord) {
		this.name = name;
		this.playerWord = playerWord;
		isTurn = false;
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
	
	public void isPlayersTurn() {
		isTurn = true;
	}
	
	

}
