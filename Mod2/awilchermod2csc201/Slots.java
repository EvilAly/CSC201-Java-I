package awilchermod2csc201;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

//1.5 hour code

public class Slots {

	public static void main(String[] args) {
		// initialize imports
		Scanner scan = new Scanner(System.in);
		Random rn = new Random();
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		// initialize variables
		int bet;
		int win;
		int totalBet;
		int totalWon = 0;
		int netWinnings;
		int firstDial;
		int secDial;
		int thirdDial;
		String firstSym;
		String secSym;
		String thirdSym;


		// start program
		System.out.println("Welcome to the Slot Machine Simulation.");
		System.out.println("Enter the amount you would like to bet:  $");
		bet = scan.nextInt();

		// start spinning
		for (int spin = 0; spin < 20; spin++) {

			// spin each slot

			firstDial = rn.nextInt(6);
			secDial = rn.nextInt(6);
			thirdDial = rn.nextInt(6);

			// decode first dial
			if (firstDial == 0)
				firstSym = "Cherries";
			else if (firstDial == 1)
				firstSym = "Oranges";
			else if (firstDial == 2)
				firstSym = "Plums";
			else if (firstDial == 3)
				firstSym = "Bells";
			else if (firstDial == 4)
				firstSym = "Melons";
			else
				firstSym = "Bars";

			// decode second dial
			if (secDial == 0)
				secSym = "Cherries";
			else if (secDial == 1)
				secSym = "Oranges";
			else if (secDial == 2)
				secSym = "Plums";
			else if (secDial == 3)
				secSym = "Bells";
			else if (secDial == 4)
				secSym = "Melons";
			else
				secSym = "Bars";

			// decode third dial
			if (thirdDial == 0)
				thirdSym = "Cherries";
			else if (thirdDial == 1)
				thirdSym = "Oranges";
			else if (thirdDial == 2)
				thirdSym = "Plums";
			else if (thirdDial == 3)
				thirdSym = "Bells";
			else if (thirdDial == 4)
				thirdSym = "Melons";
			else
				thirdSym = "Bars";

			// print symbols
			System.out.println(firstSym + "     " + secSym + "     " + thirdSym);

			// Find matches
			if (firstDial == secDial && firstDial == thirdDial) {
				win = bet * 3;
				System.out.println("All three match! That triples your bet!");

			} else if (firstDial != secDial && firstDial != thirdDial && secDial != thirdDial) {
				System.out.println("Sorry, none match...");
				win = bet * 0;
			} else {
				System.out.println("Two match. That doubles your bet!");
				win = bet * 2;
			}

			System.out.println("You win " + nf.format(win) + "\n");
			totalWon = totalWon + (win);
			System.out.println("");

			// end spinning
		}
		// calculate final results
		totalBet = bet * 20;
		netWinnings = totalWon - totalBet;

		// announce results
		System.out.println("You bet a total of " + nf.format(totalBet));
		System.out.println("You won a total of " + nf.format(totalWon));
		System.out.println("The net amount won is " + nf.format(netWinnings));
	}

}
