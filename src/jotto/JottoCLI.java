package jotto;

import java.util.Scanner;


public class JottoCLI {
	
	private static final String MAIN_MENU_OPTION_PLAYER_ONE = "ENTER PLAYER 1 INFO";
	private static final String MAIN_MENU_OPTION_PLAYER_TWO = "ENTER PLAYER 2 INFO";
	private static final String MAIN_MENU_OPTION_GAME_RULES = "READ GAME RULES";
	private static final String MAIN_MENU_OPTION_START_GAME = "START GAME";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_PLAYER_ONE, 
																   MAIN_MENU_OPTION_PLAYER_TWO, 
																   MAIN_MENU_OPTION_START_GAME,
																   MAIN_MENU_OPTION_GAME_RULES,
																	 MAIN_MENU_OPTION_EXIT };
	
	private Player player1;
	private Player player2;
	private Word player1Word;
	private Word player2Word;
	private Menu menu;
	private Scanner userInput = new Scanner(System.in);
	
	public JottoCLI() {
		this.menu = new Menu(System.in, System.out);
	}
	

	public static void main(String[] args) {
		JottoCLI game = new JottoCLI();
		game.run();

	}
	
	private void run() {
	displayGameBanner();
	while(true) {
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		if(choice.equals(MAIN_MENU_OPTION_PLAYER_ONE)) {
			setUpPlayer1();
		} else if(choice.equals(MAIN_MENU_OPTION_PLAYER_TWO)) {
			setUpPlayer2();
		} else if(choice.equals(MAIN_MENU_OPTION_START_GAME)) {
			//Begin playing
			System.exit(0);
		} else if(choice.equals(MAIN_MENU_OPTION_GAME_RULES)) {
			displayRules();
		} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
			System.exit(0);
		}
	}
	}
	
	private void setUpPlayer1() {
		System.out.print("\nPLAYER 1 ENTER YOUR NAME >>>>>");
		String userName = userInput.nextLine();
		System.out.println("\n" + userName.toUpperCase() + " IS NOW A REGISTERED PLAYER.");
		System.out.print("\n" + userName.toUpperCase() + ", PLEASE ENTER YOUR SECRET 5-LETTER-WORD >>>>>");
		String userWord = userInput.nextLine();
		player1Word = new Word(userWord);
		player1 = new Player(userName, player1Word);
	}
	
	private void setUpPlayer2() {
		System.out.print("\nPLAYER 2 ENTER YOUR NAME >>>>>");
		String userName = userInput.nextLine();
		System.out.println("\n" + userName.toUpperCase() + " IS NOW A REGISTERED PLAYER.");
		System.out.print("\n" + userName.toUpperCase() + ", PLEASE ENTER YOUR SECRET 5-LETTER-WORD >>>>>");
		String userWord = userInput.nextLine();
		player2Word = new Word(userWord);
		player2 = new Player(userName, player2Word);
	}
	
	private void displayRules() {
		System.out.println("\nGame rules to be displayed here");
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
