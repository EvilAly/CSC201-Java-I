package awilchermod3csc201;

import java.text.NumberFormat;
import java.util.Scanner;
//1 hour code
public class EatEm2 {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		boolean more = true;
		Insect in = new Insect();
		// Ask for type of snack requested
		while (more) {
			System.out.println("Which type of edible insect would you like?");
			System.out.println("cricket (CR), mealy worm (MW), locust (LO), cicada (CI), or silk worm (SW)");
			System.out.println("Please type in the two letter code");
			in.setCode(scan.nextLine());
			
			// invoke validation method
			boolean bugType = valid(in.getCode());

			if (!bugType) {
				System.out.println("That is not a valid code");
			} else {
				// set bug name
				Insect name = getInsect(in);
				
				//set cost
				if (in.getCode().equalsIgnoreCase("MW")) {
					in.setCost(1580);
				} else if (in.getCode().equalsIgnoreCase("LO")) {
					in.setCost(1680);
				} else if (in.getCode().equalsIgnoreCase("CI")) {
					in.setCost(1380);
				} else 
					in.setCost(1480);
				} 
				
				System.out.println(in.toString());
				
				// call for payment
				payBill(in.getCost());

				// call for conversion
				double dollars = convert(in.getCost());
				System.out.println("In American money, the snack would cost " + nf.format(dollars));

				// ask user if they want another snack
				System.out.println("More yummy insects? (yes or no)");
				String another = scan.nextLine();
				if (!another.equalsIgnoreCase("yes")) {
					more = false;
				}

			}
		}

	

	public static boolean valid(String code) {
		boolean valid;
		if (code.equalsIgnoreCase("CR") || code.equalsIgnoreCase("MW") || code.equalsIgnoreCase("LO")
				|| code.equalsIgnoreCase("CI") || code.equalsIgnoreCase("SW")) {
			valid = true;
		} else {
			valid = false;
		}

		return valid;
	}

	public static Insect getInsect(Insect in) {
		String name;
		if (in.getCode().equalsIgnoreCase("MW")) {
			in.setName("Mealy Worms");
		} else if (in.getCode().equalsIgnoreCase("LO")) {
			in.setName("Locusts");
		} else if (in.getCode().equalsIgnoreCase("CI")) {
			in.setName("Cicadas");
		} else if (in.getCode().equalsIgnoreCase("CR")){
			in.setName("Crickets");
		} else {
			in.setName("Silk Worms");
		}
		
		return in;

		
		
	}

	public static void coinsBack(int change) {
		System.out.println("Your change is " + change + "Y. Here is your snack.");
		// calculate coins back
		int oneHundred = change / 100;
		int remaining = change % 100;
		int fifty = remaining / 50;
		int tens = remaining % 50;
		
		// give number & type of coins returned
		if (oneHundred > 0 && fifty > 0 && tens > 0) {
			System.out.println("Your change is " + oneHundred + " 100Y   " + fifty + " 50Y  " + tens + " 10Y  coins");
		}
		else if (oneHundred > 0 && fifty > 0) {
			System.out.println("Your change is " + oneHundred + " 100Y   " + fifty + " 50Y  coins");
		}
		else if (oneHundred > 0 && tens > 0) {
			System.out.println("Your change is " + oneHundred + " 100Y   " + tens + " 10Y  coins");
		}
		else if (fifty > 0 && tens > 0) {
			System.out.println("Your change is " + fifty + " 50Y  " + tens + " 10Y  coins");
		}
		else if (oneHundred > 0) {
			System.out.println("Your change is " + oneHundred + " 100Y   coins");
		}
		else if (fifty > 0) {
			System.out.println("Your change is " + fifty + " 50Y  coins");
		}
		else {
			System.out.println("Your change is " + tens + " 10Y  coins");
		}
	}

	public static void payBill(int cost) {
			int paid = 0;
			int remaining;
			Scanner scan = new Scanner(System.in);
			// keeps asking for coins until paid
			while (cost >= paid) {
				int insert = validCoin();
				remaining = cost - paid - insert;
				paid = paid + insert;
				// Amount remaining
				if (remaining > 0) {
					System.out.println("The remaining cost is " + remaining);
				}
			}
			// if exact change was paid
			if (paid == cost) {
				System.out.println("Here is your snack.");
			} else {
				// calculate change
				int change = (paid - cost);
				coinsBack(change);

			}
	}

	public static int validCoin() {
		int coin = 0;
		boolean valid = false;
		Scanner scan = new Scanner(System.in);
		// loop to validate inserted coin
		while (!valid) {
			coin = 0;
			System.out.println("Please deposit a coin: 10, 50, 100, or 500 yen");

			System.out.println("How much is your coin?");
			coin = scan.nextInt();

			if (coin == 10 || coin == 50 || coin == 100 || coin == 500) {
				valid = true;
			} else {
				System.out.println("Not a valid coin.");
			}

		}
		return coin;
	}

	public static double convert(int cost) {
		// exchange rate based on 9/27, 2:23 AM UTC
		final double EXCHANGE_RATE = .009;
		double usd; // US Dollars
		usd = cost * EXCHANGE_RATE;
		return usd;
	}

}
