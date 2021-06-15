/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private HangmanLexicon hangmanWords = new HangmanLexicon();
	private RandomGenerator rgen = new RandomGenerator();
	private int trialCounter = 8;
	
	private String word = pickWord();
	private String hiddenWord = showProgress();
	private char ch; 
	
    public void run() {
		setup();
		play();
	}
    
    private String pickWord() {
    	int randomInt = rgen.nextInt(0, hangmanWords.getWordCount()-1);
    	String pickedWord = hangmanWords.getWord(randomInt);
    	return pickedWord;
    }
    
    private String showProgress() {
    	String result = "";
    	for(int i = 0; i < word.length(); i++) {
    		result = result + "-";
    	}
    	return result;
    }
    
    private void setup(){
    	println("Welcome to Hangman!");
    	println("The word now looks like this: " + hiddenWord);
    	println("You have " + trialCounter + " guesses");
    }
    
    private void updateProgress() {
    	if(word.indexOf(ch) == -1) {
    		println("There are no " + ch + "'s in the word...");
    		trialCounter--;
    	}
    	else if(word.indexOf(ch) != -1) {
    		println("Your guess is correct!");
    	}
    	for(int i = 0; i < word.length(); i++) {
    		if(ch == word.charAt(i)) {
    			if(i==0) {
    				hiddenWord = ch + hiddenWord.substring(1);
    			}
    			else if(i>0){
    				hiddenWord = hiddenWord.substring(0, i) + ch + hiddenWord.substring(i+1);
    			}
    		}
    	}
    }
    
    private void play() {
    	while(trialCounter > 0) {
    		String getChar = readLine("Your guess: ");
    		while(true) {
    			if(getChar.length()>1) {
    				println("You can only input one character at a time!");
    				getChar = readLine("Your guess: ");
    			}
    			else if(getChar.length() == 1){
    				break;
    			}
    		}
    		ch = getChar.charAt(0);
    		if(Character.isLowerCase(ch)) {
    			ch = Character.toUpperCase(ch);
    		}
    		updateProgress();
    		if(hiddenWord.equals(word)) {
    			println("You guessed the word!");
    			println("The word was " + word);
    			println("You won!");
    			break;
    		}
    		println("The word now looks like this: " + hiddenWord);
    		println("You have " + trialCounter + " guesses left");
    	}
    	if(trialCounter == 0) {
    		println("You are completely hung...");
    		println("The word was " + word);
    		println("You lose...");
    	}
    }
}
