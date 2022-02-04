package awilchermod4csc201;

import java.text.NumberFormat;
import java.util.Scanner;

//2.5 hour code for both files
public class WingsDriverArray {

	public static void main(String[] args) {
		//initialize scanner & create variables
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String more = "yes";
		String sauce;
		boolean bones;
		int num;
		double costEach;

		// create array
		Wings[] wings = new Wings[30];
		int o = 0; // to count number of orders
		// while loop start
		while (more.equalsIgnoreCase("yes")) {
			// Ask for sauce
			System.out.println("Enter the sauce on this wing order");
			sauce = scan.nextLine();
			// Bones or Boneless
			System.out.println("Bones? (true or false)");
			bones = scan.nextBoolean();
			// number of wings
			System.out.println("Enter the number of wings you would like: ");
			num = scan.nextInt();
			// cost per wing
			System.out.println("Enter the cost per wing:");
			costEach = scan.nextDouble();
			Wings w = new Wings(sauce, bones, num, costEach);
			wings[o] = w;
			o++;

			// more?
			scan.nextLine();
			System.out.println("Enter another wing order? (yes or no)");
			more = scan.nextLine();
		}
		// Print orders
		printOrders(wings, o);

		// total number of wings ordered
		int totalWings = totalNum(wings, o);
		System.out.println("\nThe total number of wings purchased is " + totalWings + ".");

		// total cost of wings
		double orderTotal = totalCost(wings, o);
		System.out.println("The cost of all the wing orders is " + nf.format(orderTotal));
	}

	public static void printOrders(Wings[] a, int n) {
		System.out.println("The orders are: ");
		//start loop printing orders and if there is a discount
		for (int i = 0; i < n; i++) {
			System.out.println(a[i].toString());
			String discount;
			//determine if discount is applicable
			if (a[i].getNum() > 12)
				discount = "You got a 10% discount!";
			else
				discount = "No discount.";
			System.out.println("  Bones: " + a[i].isBones() + ".  " + discount);
		}//end loop

	}

	public static int totalNum(Wings[] a, int n) {
		int total = 0;
		//loop to calculate total number of wings
		for (int i = 0; i < n; i++) {
			total = total + a[i].getNum();
		}
		return total;
	}

	public static double totalCost(Wings[] a, int n) {
		double sum = 0;
		//start loop that calculates the total cost of all wings ordered
		for (int i = 0; i < n; i++) {
			double cost = a[i].getCostEach() * a[i].getNum();
			if (a[i].getNum() > 12)
				sum = sum + (cost * .9);
			else
				sum = sum + cost;
		}
		return sum;
	}

}
