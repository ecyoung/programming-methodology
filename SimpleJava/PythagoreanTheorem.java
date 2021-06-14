import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	
	public void run() {
		displayMessage();
		askForInput();
	}
	
	private void displayMessage() {
		println("Enter values to compute Pythagorean Theorem.");
	}
	
	private void askForInput() {
		int a = readInt("a: ");
		int b = readInt("b ");
		double c = Math.sqrt((double)(a*a) + (double)(b*b));
		println("c: " + c);
	}
}
