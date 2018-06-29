package jotto;

import java.util.HashMap;

public class Game {
	
	
	public Game() {
		
		
	}
	
	public void playGame() {
//		while (!player1.hasWon() && !player2.hasWon()) {
//			
//		}
	}
	
	public void gameOver() {
		
	}
	
	public void guessWord() {
		
	}
	
	public int compareWords(String guess, Word secret) {
		int correctLetters = 0;
	   
	    for (int i = 0; i < guess.length(); i++) {
	    		char x = guess.charAt(i);
	    		if (secret.getMap().containsKey(x)) {
	    			correctLetters++;
	    			secret.getMap().replace(x, secret.getMap().get(x) + 1);
	    		}
	    }
	   
		 return correctLetters;
	 }
	
	

}
