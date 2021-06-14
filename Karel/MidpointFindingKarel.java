/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	private int rowNum;
	
	public void run() {
		rowNum = countRowNum();
		turnAround();
		for(int i = 0; i < (int)(rowNum/2+0.5); i++) {
			move();
		}
		putBeeper();
		turnAround();
	}
	
	private int countRowNum() {
		int rowCount = 0;
		while(frontIsClear()) {
			rowCount++;
			move();
		}
		rowCount++;
		return rowCount;
	}
}
