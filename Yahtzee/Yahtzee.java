/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		for(int i = 0; i<N_SCORING_CATEGORIES; i++) {
			for(int j = 1; j<= nPlayers; j++) {
				initializeFirstRoll(j);
				secondAndThirdRoll(j);
				selectCategory(j);
			}
		}
		calculateResults();
		calculateWinner();
	}
	
	private void initializeFirstRoll(int playerNumber) {
		for(int i = 0; i<N_DICE;i++) {
			int dieRoll = rgen.nextInt(1,6);
			dieResults[i] = dieRoll;
		}
		display.printMessage(playerNames[playerNumber-1]+ "'s turn! Click the roll dice button to roll the dice.");
		display.waitForPlayerToClickRoll(playerNumber);
		display.displayDice(dieResults);
	}
	
	private void selectCategory(int playerNumber) {
		while(true) {
			display.printMessage("Select a category for this roll");
			category = display.waitForPlayerToSelectCategory();
			if(selectedCategories[playerNumber][category]==0) {
				calculateCategoryScore(playerNumber);
				break;
			}
		}
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private int[] dieResults = new int[N_DICE];
	private int[][] categoryScores; 
	private int category;
	private int[][] selectedCategories;
}
