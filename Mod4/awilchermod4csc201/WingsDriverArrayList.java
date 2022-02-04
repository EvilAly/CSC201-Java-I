package awilchermod4csc201;

import java.text.NumberFormat;
import java.util.*;

//45 min code
public class WingsDriverArrayList {

	public static void main(String[] args) {
		//initialization and creation
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		ArrayList<Wings> wings = new ArrayList<Wings>();
		String more = "yes";
		//create loop to add wings
		while (more.equals("yes")) {
			//add wings to AL
			// Ask for sauce
			System.out.println("Enter the sauce on this wing order");
			String sauce = scan.nextLine();
			// Bones or Boneless
			System.out.println("Bones? (true or false)");
			boolean bones = scan.nextBoolean();
			// number of wings
			System.out.println("Enter the number of wings you would like: ");
			int num = scan.nextInt();
			// cost per wing
			System.out.println("Enter the cost per wing:");
			double costEach = scan.nextDouble();
			Wings w = new Wings(sauce, bones, num, costEach);
			wings.add(w);
			
			// more?
			scan.nextLine();
			System.out.println("Enter another wing order? (yes or no)");
			more = scan.nextLine();
		}//end while loop
		
		//print orders
		printOrders(wings);
		
		//Calculate total number of wings ordered
		int numOfWings = totalNum(wings);
		System.out.println("\nThe total number of wings purchased is " + numOfWings);
		
		//Calculate total cost of orders
		double orderTotal = totalCost(wings);
		System.out.println("The cost of allt he wings ordered is " + nf.format(orderTotal));
	}

	public static void printOrders(ArrayList<Wings> w) {
		//start loop to print orders
		System.out.println("The orders are: ");
		for (int j=0; j<w.size(); j++) {
			System.out.println(w.get(j).toString());
			int num = w.get(j).getNum();
			//check for discount
			String discount;
			if (num > 12) 
				discount = "You got a 10% discount!";
			else
				discount = "No discount.";
			
			System.out.println("  Bones: " + w.get(j).isBones() + ".  " + discount);
		}
		
	}

	public static int totalNum(ArrayList<Wings> w) {
		//start loop to total up number of wings ordered
		int sum = 0;
		for (int j=0; j<w.size(); j++) {
			sum = sum + w.get(j).getNum();
		}
		return sum;
	}

	public static double totalCost(ArrayList<Wings> w) {
		//calculate total cost of all wings ordered
		double cost = 0;
		for (int j=0; j<w.size(); j++) {
			int num = w.get(j).getNum();
			if (num > 12)
				cost = cost + ((num * w.get(j).getCostEach()) * .90);
			else
				cost = cost + (num * w.get(j).getCostEach());
		}
		return cost;
	}

}
