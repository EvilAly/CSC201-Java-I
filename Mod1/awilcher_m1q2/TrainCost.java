package awilcher_m1q2;
import java.util.Scanner;
import java.text.NumberFormat;

public class TrainCost {

	public static void main(String[] args) {
		// Declare variables
		double ticketCost, adTic, chTic, total;
		int adults, kids;
		String depCity, destCity;
		
		//Activate user input and formatting
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		//Asks for input from user
		System.out.println("What is the cost per train ticket? ");
		ticketCost = scan.nextDouble();
		
		System.out.println("How many adults are traveling? ");
		adults = scan.nextInt();
		
		System.out.println("How many children are traveling? ");
		kids = scan.nextInt();
		
		scan.nextLine();
				
		System.out.println("What is the departure city? ");
		depCity = scan.nextLine();
		
		System.out.println("What is your destination city? ");
		destCity = scan.nextLine();

		//Calculate costs
		adTic = (ticketCost * adults);
		chTic = ((ticketCost * 0.60) * kids);
		total = (adTic + chTic);
		
		//Print summary
		System.out.println("There are " + adults + " adults and " + kids + 
				" children traveling from " + depCity + " to " + destCity +".");
		System.out.println("\n");
		System.out.println("The total cost for the adults is " + nf.format(adTic));
		System.out.println("The total cost for the children is " + nf.format(chTic));
		System.out.println("The cost for the entire trip is " + nf.format(total));
	}

}
