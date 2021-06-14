import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		
		while(frontIsClear()) {
			fillColumn();
			moveToNextColumn();
		}
		fillColumn();
	}
	
	private void fillColumn() {
		if(rightIsBlocked()) {
			turnLeft();
		}
		else if(leftIsBlocked()) {
			turnRight();
		}
		while(frontIsClear()) {
			if(noBeepersPresent()) {
				putBeeper();
				move();
			}
			else {
				move();
			}
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	private void moveToNextColumn() {
		
		if(facingNorth()) {
			turnRight();
		}
		
		else if(facingSouth()) {
			turnLeft();
		}
		
		for(int i = 0; i < 4; i++) {
			move();
		}
	}
}
