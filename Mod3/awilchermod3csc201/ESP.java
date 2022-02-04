package awilchermod3csc201;

import java.util.Random;
import java.util.Scanner;

//1.2 hour coded

public class ESP {

	public static void main(String[] args) {
		// Have the computer randomly pick a number
		// Have user guess the number
		// Convert the number to a color
		// Compare and give results

		Scanner scan = new Scanner(System.in);
		Random rn = new Random();
		int count = 0;

		// start loop
		for (int i = 0; i < 10; i++) {
			// random number
			int ranNum = rn.nextInt(5);

			// get user guess
			System.out.println("Guess a color: red, green, blue, orange, or yellow");
			String userColor = scan.nextLine();

			// convert number to color
			String color = convertColor(ranNum);
			// compare the colors
			boolean compare = checkCorrect(userColor, color);
			//correct counter
			if (compare) {
				count++;
			}
			// print results
			printResult(compare);
		} // end loop
		
		//print final count
		System.out.println("In ten guesses, you got " + count + " correct.");
	}

	public static String convertColor(int num) {
		String pcColor;
		if (num == 0)
			pcColor = "red";
		else if (num == 1)
			pcColor = "green";
		else if (num == 2)
			pcColor = "blue";
		else if (num == 3)
			pcColor = "orange";
		else
			pcColor = "yellow";

		System.out.println("The computer color was " + pcColor);

		return pcColor;
	}

	public static boolean checkCorrect(String user, String pc) {
		boolean match = false;
		if (user.equals(pc)) {
			match = true;
		}

		return match;
	}

	public static void printResult(boolean Match) {
		if (Match) {
			System.out.println("You got it!!");
		} else {
			System.out.println("You need to think harder.");
		}
	}

}
