package awilchermod1csc201;
import java.text.NumberFormat;
import java.util.Scanner;

public class HomeSale {

	public static void main(String[] args) {
		//Add scanner and formatting
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
				
		//Declare variables
		float purchase;
		float upgrades;
		float	sold;
		float basis;
		float commission;
		float profit;
		float commissionRate;
		
		//Get variable information
		System.out.println("What was the originial cost of the house? ");
		purchase = scan.nextInt();
		System.out.println("How much did you put into the home for upgrades? ");
		upgrades = scan.nextInt();
		System.out.println("What was the sales price of the house?");
		sold = scan.nextInt();
		System.out.println("What is the commission rate in percentage?");
		commissionRate = scan.nextFloat();
		
		//Calculations
		commission = sold * (commissionRate/100);
		basis = purchase + upgrades;
		profit = sold - commission - basis;
		
		//Report
		System.out.println("You bought your house for "+ nf.format(purchase)+".");
		System.out.println("The cost for upgrades was "+ nf.format(upgrades)+ ".");
		System.out.println("The basis of your house was "+ nf.format(basis));
		System.out.println("The sales price was "+ nf.format(sold));
		System.out.println("Sales Commission: "+ nf.format(commission));
		System.out.println("\tYour net profit was "+nf.format(profit));
			

	}

}
