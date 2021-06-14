import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final int width = 150;
	private static final int height = 60;
	
	public void run() {
		drawProgramBox();
		drawConsoleLine();
		drawConsoleBox();
		drawGraphicsLine();
		drawGraphicsBox();
		drawDialogLine();
		drawDialogBox();
	}
	
	private void drawProgramBox() {
		int x = getWidth()/2 - width/2;
		int y = getHeight()/2 - height;
		GRect drawBox = new GRect(x, y, width, height);
		add(drawBox);
		GLabel program = new GLabel("Program", x, y);
		add(program);
		double boxCenterX = width / 2;
		double boxCenterY = height / 2;
		double halfProgramWidth = program.getWidth()/2;
		double halfProgramHeight = program.getAscent()/2;
		program.move((boxCenterX-halfProgramWidth), (boxCenterY + halfProgramHeight));
	}
	
	private void drawConsoleLine() {
		int x1 = getWidth()/2;
		int y1 = getHeight()/2;
		int x2 = getWidth()/2;
		int y2 = getHeight()/2 + height;
		GLine drawLine = new GLine(x1, y1, x2, y2);
		add(drawLine);
	}
	
	private void drawConsoleBox() {
		int x = getWidth()/2 - width/2;
		int y = getHeight()/2 + height;
		GRect drawBox = new GRect(x ,y, width, height);
		add(drawBox);
		GLabel console = new GLabel("ConsoleProgram", x, y);
		add(console);
        double boxCenterX = width / 2;
        double boxCenterY = height / 2;
        double halfConsoleWidth = console.getWidth()/2; 
        double halfConsoleHeight = console.getAscent()/2; 
        console.move((boxCenterX - halfConsoleWidth), (boxCenterY + halfConsoleHeight));
	}
	
	private void drawGraphicsLine() {
		int x1 = getWidth()/2;
		int y1 = getHeight()/2;
		int x2 = getWidth()/2 - 3*(width/2);
		int y2 = getHeight()/2 + height;
		GLine drawLine = new GLine(x1, y1, x2, y2);
		add(drawLine);
	}
	
	private void drawGraphicsBox() {
		int x = getWidth()/2 - 2*width;
		int y = getHeight()/2 + height;
		GRect drawBox = new GRect(x ,y, width, height);
		add(drawBox);
		GLabel graphics = new GLabel("GraphicsProgram", x, y);
		add(graphics);
        double boxCenterX = width / 2;
        double boxCenterY = height / 2;
        double halfConsoleWidth = graphics.getWidth()/2; 
        double halfConsoleHeight = graphics.getAscent()/2; 
        graphics.move((boxCenterX - halfConsoleWidth), (boxCenterY + halfConsoleHeight));
	}

	private void drawDialogLine() {
		int x1 = getWidth()/2;
		int y1 = getHeight()/2;
		int x2 = getWidth()/2 + 3*(width/2);
		int y2 = getHeight()/2 + height;
		GLine drawLine = new GLine(x1, y1, x2, y2);
		add(drawLine);
	}
	
	private void drawDialogBox() {
		int x = getWidth()/2 + width;
		int y = getHeight()/2 + height;
		GRect drawBox = new GRect(x , y, width, height);
		add(drawBox);
		GLabel dialog = new GLabel("DialogProgram", x, y);
		add(dialog);
        double boxCenterX = width / 2;
        double boxCenterY = height / 2;
        double halfConsoleWidth = dialog.getWidth()/2; 
        double halfConsoleHeight = dialog.getAscent()/2; 
        dialog.move((boxCenterX - halfConsoleWidth), (boxCenterY + halfConsoleHeight));
	}
	
}

