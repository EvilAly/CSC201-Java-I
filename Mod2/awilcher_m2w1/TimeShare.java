package awilcher_m2w1;

import java.text.NumberFormat;
import java.util.Scanner;

public class TimeShare {

	public static void main(String[] args) {
		//declare variables
		final double nightlyCost = 210.00;
		int numOfNights;
		String premierMember;
		String visitingCity;
		double discount;
		double netCost;
		double grossCost;
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();	
		Scanner scan = new Scanner (System.in);
		//Gather information
		System.out.println("Welcome to the Java Timeshares");
		System.out.println("Number of nights:");
		numOfNights = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Are you a premier member (yes or no)");
		premierMember = scan.nextLine();
		
		System.out.println("What city will you be visiting?");
		visitingCity = scan.nextLine();		
		
		//Calculate gross
		grossCost = numOfNights * nightlyCost;
		//Determine if discount applicable and give total
		if (premierMember.equals("yes") && numOfNights > 7) {
			discount = grossCost * 0.25;
			netCost = grossCost - discount;
			System.out.println("Your cost to visit " + visitingCity + " is " + nf.format(netCost) +
					" which includes a discount of " + nf.format(discount));
		}
		else if (premierMember.equals("yes") || numOfNights > 7) {
			discount = grossCost * 0.10;
			netCost = grossCost - discount;
			System.out.println("Your cost to visit " + visitingCity + " is " + nf.format(netCost) +
					" which includes a discount of " + nf.format(discount));
		}
		else
			System.out.println("Your cost to visit " + visitingCity + " is " + nf.format(grossCost));
		
		

	}

}
