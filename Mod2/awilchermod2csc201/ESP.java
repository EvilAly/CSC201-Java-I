package awilchermod2csc201;

import java.util.Random;
import java.util.Scanner;

//45 min code

public class ESP {

	public static void main(String[] args) {
		// Declare variables
		int correct = 0;
		int pcNum;
		String pcColor;
		String guess;

		// initialize random & scanner
		Random rn = new Random();
		Scanner scan = new Scanner(System.in);

		System.out.println("Test your ESP skills!");
		// for loop start - 10 iterations
		for (int test = 1; test < 11; test++) {
			// generate color
			pcNum = rn.nextInt(5);

			// assign colors based on random number
			if (pcNum == 0)
				pcColor = "red";
			else if (pcNum == 1)
				pcColor = "green";
			else if (pcNum == 2)
				pcColor = "blue";
			else if (pcNum == 3)
				pcColor = "orange";
			else
				pcColor = "yellow";

			// Start each round
			System.out.println("Round " + test);
			System.out.println("I am thinking of a color");
			

			// ask user for color
			System.out.println("Is it red, green, blue, orange, or yellow?");
			guess = scan.next();

			// if/else color comparison
			if (guess.equals(pcColor)) {
				System.out.println("Yes! I was thinking of " + pcColor);
				System.out.println("\n");
				correct = (correct + 1);
			} else {
				System.out.println("Sorry, I was thinking of " + pcColor);
				System.out.println("\n");
			}

		}

		//end game
		System.out.println("Game Over");
		System.out.println("You guessed " + correct + " out of 10 colors correctly.");

	}

}
