import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	// half of the length of the base of bricks
	private int xOffset = (BRICK_WIDTH * BRICKS_IN_BASE) / 2;
	
	public void run() {
		// x is set at the far left end of where bricks start
		int x = (getWidth() / 2) - xOffset;
		// y's positive direction is downwards, so y = getHeight() is at the bottom
		int y = getHeight();
		for (int i = 1; i <= BRICKS_IN_BASE; i++) {
			// Y needs to start from a high value to a low value (i increases)
			int Y = y - (i * BRICK_HEIGHT);
			// j = 14, 13, 12, ..., 1 in first trial
			for (int j = BRICKS_IN_BASE; j >= i; j--) {
				// need to understand
				int X = x - (BRICK_WIDTH / 2) + (j * BRICK_WIDTH) - (i * (BRICK_WIDTH / 2));
				GRect brick = new GRect(X, Y, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
			}
		}
	}
}
