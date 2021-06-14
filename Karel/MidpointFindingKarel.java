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
