package jotto;

import java.io.FileNotFoundException;

public class Game {

	private Player player1;
	private Player player2;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;

	}

	public Game() {

	}

	public void playGame() throws FileNotFoundException {
		while (!(player1.hasWon() || player2.hasWon())) {
			player1.startTurn();
			guessWord(player2, player1.guess());
			player1.endTurn();
			if (player1.hasWon()) {
				System.out.println(gameOver(player1));
				break;
			}

			player2.startTurn();
			guessWord(player1, player2.guess());
			player2.endTurn();
			if (player2.hasWon()) {
				System.out.println(gameOver(player2));
				break;
			}
		}

	}

	public String gameOver(Player winner) {
		String message = "CONGRATULATIONS, " + winner.getPlayerName() + ", YOU HAVE WON!";
		return message;
	}

	public void guessWord(Player listener, String word) throws FileNotFoundException {
		if (player1.isPlayersTurn()) {
			listener = player2;
			compareWords(player1, word, listener.getSecretWord());
		} else if (player2.isPlayersTurn()) {
			listener = player1;
			compareWords(player2, word, listener.getSecretWord());
		}

	}

	private void compareWords(Player guessor, String guess, Word secret) throws FileNotFoundException {
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
		System.out.println(guess + " has " + correctLetters + " correct letters");

	}

	public void displayRules() {
		System.out.println("\n1) Each player will pick a secret word of 5 letters");
		System.out.println("\t- All words must appear in an English dictionary");
		System.out.println("\t- NO proper nouns!");
		System.out.println("\t- NO repeating letters!");
		System.out.println("2) Players will take turns trying to correctly guess each other's secret word");
		System.out.println(
				"3) For every player's guess, the computer will give the number of letters in the \n  guess word that match a unique letter in the opposing player's secret word");
		System.out.println("4) Each player must use deduction to try and figure out the other's secret word");
		System.out.println("5) The first player to correctly guess the other's secret word wins the game");
	}

}
