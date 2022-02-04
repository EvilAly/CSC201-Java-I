package awilchermod2csc201;

import java.util.Random;
import java.util.Scanner;

//2 hour code

public class SecretCode {

	public static void main(String[] args) {
		// initialize scanner, random and variables
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int randomNum, // computer generated number
				placeHolder, // placeHolder to help break down the number to its digits
				firstDigit, secDigit, thirdDigit, guess, // users guess
				firstGuess, secGuess, thirdGuess;
		int count = 0;
		boolean first, second, third, noMatch;
		String replay = "yes";

		// loop to keep playing
		while (replay.equals("yes")) {

			// randomize a number and split it out
			randomNum = rand.nextInt(900) + 100;
			thirdDigit = randomNum % 10;
			placeHolder = randomNum / 10;
			secDigit = placeHolder % 10;
			firstDigit = placeHolder / 10;

			// add in debugging line
			System.out.println("***FOR DEBUGGING ONLY  The computer numbers are " + firstDigit + " " + secDigit + " "
					+ thirdDigit);

			// have user guess a three digit number
			noMatch = true;

			while (noMatch) {
				System.out.println("Guess a three digit number");
				guess = scan.nextInt();
				count = count + 1;
			
				// break out the guess numbers
				thirdGuess = guess % 10;
				placeHolder = guess / 10;
				secGuess = placeHolder % 10;
				firstGuess = placeHolder / 10;

				// repeat the numbers
				System.out.println("The user numbers are " + firstGuess + " " + secGuess + " " + thirdGuess);

				// compare each number
				first = (firstDigit == firstGuess);
				second = (secDigit == secGuess);
				third = (thirdDigit == thirdGuess);

				// Give comparison results
				if (first) {
					System.out.println("Your " + firstGuess + " matches");
				}
				if (second) {
					System.out.println("Your " + secGuess + " matches");
				}
				if (third) {
					System.out.println("Your " + thirdGuess + " matches");
				}
				if (!first && !second && !third) {
					System.out.println("None of your numbers matched");
				} else if (first && second && third) {
					System.out.println("You got it! It took " + count + " guesses");
					noMatch = false;
				}

			}
			scan.nextLine();
			System.out.println("Do you want to play again? (yes or no)");
			replay = scan.nextLine();
			count = 0;
		} 
	}
}
