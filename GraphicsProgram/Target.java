/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	private static final int outerRadius = 72; 
	private static final double middleRadius = 72*0.65;
	private static final double innerRadius = 72*0.3;
	
	public void run() {
		sketchOuterCircle();
		sketchMiddleCircle();
		sketchInnerCircle();
	}
	
	private void sketchOuterCircle() {
		int d = 2*outerRadius;
		int x = (getWidth()/2) - outerRadius;
		int y = (getHeight()/2) - outerRadius;
		GOval outerCircle = new GOval(x, y, d, d);
		outerCircle.setColor(Color.RED);
		outerCircle.setFilled(true);
		add(outerCircle);
	}
	
	private void sketchMiddleCircle() {
		double d = 2*middleRadius;
		double x = (getWidth()/2) - middleRadius;
		double y = (getHeight()/2) - middleRadius;
		GOval middleCircle = new GOval(x, y, d, d);
		middleCircle.setColor(Color.WHITE);
		middleCircle.setFilled(true);
		add(middleCircle);		
	}
	
	private void sketchInnerCircle() {
		double d = 2*innerRadius;
		double x = (getWidth()/2) - innerRadius;
		double y = (getHeight()/2) - innerRadius;
		GOval innerCircle = new GOval(x, y, d, d);
		innerCircle.setColor(Color.RED);
		innerCircle.setFilled(true);
		add(innerCircle);		
	}
}
