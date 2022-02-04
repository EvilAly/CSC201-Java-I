package awilchermod2csc201;

import java.util.Scanner;

//1.2 hours coded

public class ChessColor {

	public static void main(String[] args) {
		// initialize variables and scanner
		String letter = "A";
		int number = 0;
		String color;
		Scanner scan = new Scanner(System.in);

		// Create loop
		while (!letter.equals("Z")) {
			// Ask user for letter
			System.out.println("What is the letter for the square? (A - H) - type in Z to end");
			letter = (scan.next()).toUpperCase();
			
			// checks for end or continues
			if (!letter.equals("Z")) {
				System.out.println("What is the number for the square? (1 - 8)");
				number = scan.nextInt();

				// verify validity of input
				while (number < 1 || number > 8) {
					System.out.println(" Invalid input. Please enter a number between 1 and 8.");
					number = scan.nextInt();
				}

				// checks the letter against corresponding number and assigns color
				if (letter.equals("A") || letter.equals("C") || letter.equals("E") || letter.equals("G")) {
					if (number == 1 || number == 3 || number == 5 || number == 7) {
						color = "brown";
					} else {
						color = "tan";
					}
				} else {
					if (number == 2 || number == 4 || number == 6 || number == 8) {
						color = "brown";
					} else {
						color = "tan";
					}
				}

				// prints out color
				System.out.println("The color is " + color);
			} else {
				System.out.println("Thanks for using my chess program!");
			}

		}

	}
}
