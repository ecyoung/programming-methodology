import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** Delay time in between ball moves */
	private static final int PAUSE_TIME = 10;
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		// set up environment
		setUp();
		// run game
		for (int i = 0; i < NTURNS; i++) {
			printTurns(i);
			createBall();
			pause(1000);
			remove(turns);
			bounceBall();
			if (brickCounter == 0) {
				// delete ball
				ball.setVisible(false);
				printWinner();
				break;
			}
		}
		// after 3 rounds if brickCounter > 0, game over
		if (brickCounter > 0) {
			printLoser();
		}
	}
	// creates all relevant GObjects
	private void setUp() {
		createBoard();
		createBricks(); 
		createPaddle();
	}

	private GRect board;
	private void createBoard() {
		board = new GRect(0, 0, WIDTH, HEIGHT);
		add(board);
	}
	
	private GRect brick;
	private void createBricks() {
		// reshape window size
		// this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		for (int row = 0; row < NBRICK_ROWS; row++) {
			for (int col = 0; col < NBRICKS_PER_ROW; col++) {
				int x = getWidth()/2 - ((NBRICKS_PER_ROW * BRICK_WIDTH)/2 + ((NBRICKS_PER_ROW - 1) * BRICK_SEP)/2) + ((col * BRICK_WIDTH) + (col * BRICK_SEP));
				int y = BRICK_Y_OFFSET + (row * BRICK_HEIGHT) + (row * BRICK_SEP);
				brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
				brick.setFilled(true);
				if (row<2) {
					brick.setColor(Color.RED);
				}
				else if (row<4) {
					brick.setColor(Color.ORANGE);
				}
				else if (row<6) {
					brick.setColor(Color.YELLOW);
				}
				else if (row<8) {
					brick.setColor(Color.GREEN);
				}
				else {
					brick.setColor(Color.CYAN);
				}
			}
		}
	}
	
	private GRect paddle;
	private void createPaddle() {
		int x = getWidth()/2 - PADDLE_WIDTH/2;
		int y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		// give permission for mouse controls
		addMouseListeners();
	}
	
	// overriding public helper method
	public void mouseMoved(MouseEvent e) {
		// upper and lower bounds
		if ((e.getX() < getWidth() - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) {
			// only the x coordinate of the mouse location changes
			paddle.setLocation(e.getX() - PADDLE_WIDTH/2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}
	
	private GOval ball; 
	private void createBall() {
		int x = getWidth()/2 - BALL_RADIUS;
		int y = getHeight()/2 - BALL_RADIUS;
		ball = new GOval(x, y, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
	}
	
	private void bounceBall() {
		// waitForClick();
		trackVelocity();
		while (true) {
			moveBall();
			// ball hits bottom 
			if (ball.getY() >= getHeight()) {
				break;
			}
			// all bricks destroyed
			if (brickCounter == 0) {
				break;
			}
		}
	}
	
	private double vx;
	private double vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private void trackVelocity() {
		// x and y components of velocity vector 
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5) == true) {
			vx = -vx;
		}
		vy = 4.0;
	}
	
	// Total number of bricks = 10 * 10 = 100
	private int brickCounter = NBRICKS_PER_ROW * NBRICK_ROWS;
	private void moveBall() {
		ball.move(vx, vy);
		if ((ball.getX() - vx <= 0 && vx < 0) || (ball.getX() + vx >= (getWidth() - BALL_RADIUS*2) && vx > 0)) {
            vx = -vx;
        }
        if ((ball.getY() - vy <= 0 && vy < 0) || (ball.getY() + vy >= (getHeight() - BALL_RADIUS*2) && vy < 0)) {
            vy = -vy;
        }
        GObject collider = getCollidingObject();
        boolean isPaddle = collider == paddle;
        boolean withinLowerBound = ball.getY() >= getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2;
        boolean withinUpperBound = ball.getY() < getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 + BRICK_SEP;
        // Case 1: Ball hits paddle and reflects
        if (isPaddle && withinLowerBound && withinUpperBound) {
        	vy = -vy;
        }
        // Case 2: Ball hits brick and destroys it then reflects
        else if (collider != null) {
        	remove(collider);
        	brickCounter--;
        	vy = -vy;
        }
        pause(PAUSE_TIME);
	}
	
	private GObject getCollidingObject() {
		if((getElementAt(ball.getX(), ball.getY())) != null) {
	         return getElementAt(ball.getX(), ball.getY());
	      }
		else if (getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY()) != null ){
			return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY());
		}
		else if (getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS*2)) != null ){
			return getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS*2));
		}
		else if (getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY() + BALL_RADIUS*2) != null ){
			return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY() + BALL_RADIUS*2);
		}
		else {
			return null;
		}
	}
	private GLabel turns;
	private void printTurns(int turnNum) {
		turns = new GLabel ("Turns: " + (3-turnNum));
		turns.setFont("SansSerif-36");
		turns.setColor(Color.ORANGE);
		double x = (getWidth() - turns.getWidth())/2;
		double y = (getHeight() - turns.getHeight())/2;
		add(turns, x, y);
	}
	
	private void printWinner() {
		GLabel winner = new GLabel ("You are the Winner!");
		winner.setFont("SansSerif-36");
		winner.setColor(Color.GREEN);
		double x = (getWidth() - winner.getWidth())/2;
		double y = (getHeight() - winner.getHeight())/2;
		add(winner, x, y);
	}
	
	private void printLoser() {
		GLabel loser = new GLabel ("Game Over...");
		loser.setFont("SansSerif-36");
		loser.setColor(Color.RED);
		double x = (getWidth() - loser.getWidth())/2;
		double y = (getHeight() - loser.getHeight())/2;
		add(loser, x, y);
	}
}