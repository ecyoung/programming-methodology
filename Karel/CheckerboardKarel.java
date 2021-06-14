import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	private int counter = 0;
	
	public void run() {
		while(true) {
			fillRow();
			nextRow();
		}
	}
	
	private void fillRow() {
		while(frontIsClear()) {
			if(counter % 2 == 0) {
				putBeeper();
			}
			counter++;
			move();
		}
		if(counter % 2 == 0) {
			putBeeper();
		}
		counter++;
	}
	
	private void nextRow() {
		if(facingEast()) {
			turnLeft();
			move();
			turnLeft();
		}
		else if(facingWest()) {
			turnRight();
			move();
			turnRight();
		}
	}
}
