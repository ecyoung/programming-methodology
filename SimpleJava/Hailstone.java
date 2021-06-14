import acm.program.*;

public class Hailstone extends ConsoleProgram {
	
	public void run() {
		iterateHailstone();
	}
	
	private void iterateHailstone() {
		int num = readInt("Enter a number: ");
		int counter = 0;
		while(num != 1) {
			if(num % 2 == 0) {
				println(num + " is even, so I take half: " + num/2);
				num = num/2;
				counter++;
			}
			else if(num % 2 == 1) {
				println(num + " is odd, so I make 3n + 1: " + (3*num+1));
				num = 3*num+1;
				counter++;
			}
		}
		println("This process took " + counter + " to reach 1");
	}
}

