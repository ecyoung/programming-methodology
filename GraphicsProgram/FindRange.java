/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		displayMessage();
		findRange();
	}
	
	private void displayMessage() {
		println("This program finds the largest and smallest numbers.");;
	}
	
	private void findRange() {
		int firstNum = readInt("? ");
		if(firstNum == SENTINEL) {
			println("No values have been entered!");
		}
		else {
			int smallestNum = firstNum;
			int largestNum = firstNum;
			
			while(firstNum != SENTINEL) {
				int secondNum = readInt("? ");
				if(secondNum == 0) {
					println("smallest: " + smallestNum);
					println("largest: " + largestNum);
					break;
				}
				else if(secondNum < smallestNum) {
					smallestNum = secondNum;
				}
				else if(secondNum > largestNum) {
					largestNum = secondNum;
				}
			}
		}
	}
}

