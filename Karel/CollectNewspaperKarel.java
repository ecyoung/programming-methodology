import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	/*
	 * Main Method 
	 * 1. Move to the newspaper
	 * 2. Pick it up 
	 * 3. Return to starting point
	 */
	public void run() {
		moveToNewspaper();
		pickBeeper();
		returnToStart();
	}
	
	private void moveToNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	private void returnToStart() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnAround();
	}
}
