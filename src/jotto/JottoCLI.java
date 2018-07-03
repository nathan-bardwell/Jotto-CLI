package jotto;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class JottoCLI {

	private static final String MAIN_MENU_OPTION_GAME_RULES = "READ GAME RULES";
	private static final String MAIN_MENU_OPTION_START_GAME = "START GAME";
	private static final String MAIN_MENU_OPTION_EXIT = "QUIT";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_START_GAME,
			MAIN_MENU_OPTION_GAME_RULES, MAIN_MENU_OPTION_EXIT };
	
	private static final String PLAY_AGAIN_OPTION_PLAY_AGAIN = "PLAY AGAIN?";
	private static final String PLAY_AGAIN_OPTION_EXIT = "QUIT";
	private static final String[] PLAY_AGAIN_OPTIONS = new String[] {PLAY_AGAIN_OPTION_PLAY_AGAIN, PLAY_AGAIN_OPTION_EXIT };

	private Player player1;
	private Player player2;
	private Word player1Word;
	private Word player2Word;
	private Menu menu;
	private static JottoCLI application = new JottoCLI();
	private Scanner userInput = new Scanner(System.in);

	public JottoCLI() {
		this.menu = new Menu(System.in, System.out);
	}

	public static void main(String[] args) throws FileNotFoundException {
		application.run();
	}

	private void run() throws FileNotFoundException {
		clearScreen();

		Game game = new Game();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_START_GAME)) {
				game = new Game(application.setUpPlayer1(), application.setUpPlayer2());
				game.playGame();
				application.playAgain();
			} else if (choice.equals(MAIN_MENU_OPTION_GAME_RULES)) {
				game.displayRules();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}
	
	private void playAgain() throws FileNotFoundException {
		
		Game game = new Game();
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PLAY_AGAIN_OPTIONS);
			if (choice.equals(PLAY_AGAIN_OPTION_PLAY_AGAIN)) {
				game = new Game(application.setUpPlayer1(), application.setUpPlayer2());
				game.playGame();
			} else if (choice.equals(PLAY_AGAIN_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}

	private Player setUpPlayer1() throws FileNotFoundException {
		boolean goodWord = false;
		System.out.print("\nPLAYER 1 ENTER YOUR NAME >>>>> ");
		String userName = userInput.nextLine();
		System.out.println("\n" + userName.toUpperCase() + " IS NOW A REGISTERED PLAYER.");
		while (!goodWord) {
			System.out.print("\n" + userName.toUpperCase() + ", PLEASE ENTER YOUR SECRET 5-LETTER-WORD >>>>> ");
			String userWord = userInput.nextLine();
			clearScreen();
			player1Word = new Word(userWord);
			if (player1Word.verifyWord(userWord)) {
				player1 = new Player(userName, player1Word);
				goodWord = true;
			} else {
				System.out.println("'" + userWord + "' " + "is not a playable word. Please try again.");
				goodWord = false;
			}
		}
		return player1;
	}

	private Player setUpPlayer2() throws FileNotFoundException {
		boolean goodWord = false;
		System.out.print("\nPLAYER 2 ENTER YOUR NAME >>>>> ");
		String userName = userInput.nextLine();
		System.out.println("\n" + userName.toUpperCase() + " IS NOW A REGISTERED PLAYER.");
		while (!goodWord) {
			System.out.print("\n" + userName.toUpperCase() + ", PLEASE ENTER YOUR SECRET 5-LETTER-WORD >>>>> ");
			String userWord = userInput.nextLine();
			clearScreen();
			player2Word = new Word(userWord);
			if (player2Word.verifyWord(userWord)) {
				player2 = new Player(userName, player2Word);
				goodWord = true;
			} else {
				System.out.println("'" + userWord + "' " + "is not a playable word. Please try again.");
				goodWord = false;
			}
		}
		return player2;
	}
	
	private void clearScreen() {
		System.out.print("\033[H\033[2J");
		displayGameBanner();
		System.out.println("\n\n\n");
	}

	private void displayGameBanner() {
		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("*            888888          888    888                      *");
		System.out.println("*              \"88b          888    888                      *");
		System.out.println("*               888          888    888                      *");
		System.out.println("*               888  .d88b.  888888 888888  .d88b.           *");
		System.out.println("*               888 d88\"\"88b 888    888    d88\"\"88b          *");
		System.out.println("*               888 888  888 888    888    888  888          *");
		System.out.println("*               88P Y88..88P Y88b.  Y88b.  Y88..88P          *");
		System.out.println("*               888  \"Y88P\"   \"Y888  \"Y888  \"Y88P\"           *");
		System.out.println("*             .d88P                                          *");
		System.out.println("*          .d88P\"                                            *");
		System.out.println("*          888P\"                                             *");
		System.out.println("**************************************************************");
		System.out.println();
	}

}
