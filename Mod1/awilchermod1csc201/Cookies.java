package awilchermod1csc201;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Cookies {

	public static void main(String[] args) {
		//Declare and initialize recipe ingredients
		double sugar = 1.5;
		double butter = 1;
		double flour = 2.75;
				
		//Set input and format
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.0");
		
		//Ask user how many cookies they want
		System.out.println("How many dozens of cookies would you like to make? ");
		int dozens = scan.nextInt();
		
		//Calculates new amounts
		double total = (dozens * 12);
		sugar = ((total / 48) * sugar);
		butter = ((total / 48) * butter);
		flour = ((total / 48) * flour);
		
		//Gives user new amounts
		System.out.println("You ordered " + total + " cookies.");
		System.out.println("You will need the following ingredients:");
		System.out.println("\t" + df.format(sugar) + " cups of sugar");
		System.out.println("\t" + df.format(butter) + " cups of butter");
		System.out.println("\t" + df.format(flour) + " cups of flour");
		

	}

}
