package awilchermod6csc201;

import java.util.*;

public class TrackInsurance {
	public static Scanner scan = new Scanner(System.in);

	// method that runs first
	public static void main(String[] args) throws Exception {

		// make an ArrayList of customers and insurance policies
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// note - the ArrayList below can hold Insurance objects
		// but with inheritance, that includes Auto, Health, Life and Art
		ArrayList<Insurance> ins = new ArrayList<Insurance>();

		// create some fake customers (used for testing the program)
		Customer c = new Customer("Duck", "Donald");
		Customer c1 = new Customer("Mouse", "Minnie");
		Customer c2 = new Customer("Mouse", "Mickey");

		// add the customers to the array list

		cust.add(c2);
		cust.add(c1);
		cust.add(c);

		// make and add some insurance policies to the ArrayList
		ins.add(new AutoInsurance(c, 2));
		ins.add(new AutoInsurance(c1, 3));
		ins.add(new HealthInsurance(c, 5));
		ins.add(new HealthInsurance(c2, 1));
		ins.add(new LifeInsurance(c, 30000, 65));
		ins.add(new LifeInsurance(c1, 400000, 34));

		// add your ArtInsurance instances here
		ins.add(new ArtInsurance(c1, "The Scream", 119900));
		ins.add(new ArtInsurance(c, "Au Moulin de la Galette", 78100));
		ins.add(new ArtInsurance(c1, "Salvator Mundi", 450300));
		ins.add(new ArtInsurance(c2, "The Gross Clinic", 68000));
		ins.add(new ArtInsurance(c2, "Diana and Callisto", 71700));

		int choice = 0;
		while (choice >= 0) {
			choice = menu();
			if (choice == 1)
				printAllCustomers(cust);
			else if (choice == 2)
				printAllInsurance(ins);
			else if (choice == 3) {
				System.out.println("Now lets find the information for a certain policy number");
				System.out.println("What policy number do you want to find?");
				int num = scan.nextInt();
				printPolicy(ins, num);
			} else if (choice == 4) {
				System.out.println("Now let's find all of the policies for a given customer");
				System.out.println("What is the customer id?");
				int custNum = scan.nextInt();
				getCustomer(ins, custNum);
			} else if (choice == 5)
				sortCustNum(ins);
			else if (choice == 6)
				sortPolNum(ins);
			else if (choice == 7) {
				System.out.println("Bye!!!!!");
				choice = -1;
			}
		} // end while

	}

	public static int menu() {
		System.out.println("Choice:");
		System.out.println("   1.  Print all customers (call the toString method)");
		System.out.println("   2.  Print all insurance information (call the toString method)");
		System.out.println("   3.  Given a policy number, print the policy information");
		System.out.println("   4.  Find all of the policies for a given customer");
		System.out.println("   5.  Sort the insurance policy information by customer number");
		System.out.println("   6.  Sort the insurance policy information by policy number");
		System.out.println("   7. QUIT!! ");
		System.out.println("\n CHOICE:");
		int value = scan.nextInt();
		return value;

	}

	// write a printAllCusts method that prints out the toString method for all
	// of the customers
	public static void printAllCustomers(ArrayList<Customer> cust) {
		for (int i = 0; i < cust.size(); i++)
			System.out.println(cust.get(i).toString());

	}

	// write a printAllInsurance method that prints out the toString method for
	// all of the insurance policies
	public static void printAllInsurance(ArrayList<Insurance> insure) {
		// print out all of the information
		for (Insurance ins : insure)
			System.out.println(ins.toString());
	}

	// write a printPolicy method that prints the information for the policy
	// number
	// passed in or the statement "That policy does not exist" if it is not
	// present
	public static void printPolicy(ArrayList<Insurance> insure, int num) {
		// set found to false and create looping variable
		boolean found = false;

		// loop thru looking for requested policy
		for (int i = 0; i < insure.size(); i++) {
			// get and compare the policy number to that requested
			if (insure.get(i).getPolicyNumber() == num) {
				// if found, print out policy information and set boolean to true
				System.out.println(insure.get(i).toString());
				found = true;
			}

		}
		// if after cycling through entire policy list and policy is still not found,
		// print that it does not exist
		if (!found) {
			System.out.println("*** That policy does not exist. ***");
		}
	}

	// write a getCustomer method that prints the information for all of the
	// policies for a given customer
	// that customer number is passed in. If none, have it print
	// "There are no policies for that customer"
	public static void getCustomer(ArrayList<Insurance> insure, int num) {
		// set found to false
		boolean found = false;
		// loop through entire insurance database
		for (int j = 0; j < insure.size(); j++) {
			// if the customer id matches the given number
			if (insure.get(j).getCustomer().getId() == num) {
				// print out the customer policy info and change found to true
				System.out.println(insure.get(j).toString());
				found = true;
			}
		}
		// if after looping through entire policy list and customer was not found,
		// print that customer does not have any policies
		if (!found) {
			System.out.println("*** There are no policies for that customer ***");
		}
	}

	// write a method that sorts the policies by policy number
	// look at the example in the search_sort package
	public static void sortPolNum(ArrayList<Insurance> insure) {
		Collections.sort(insure);
	}

	// write a method that sorts the policies by customer number
	// this one is tougher since you can not use the Collections.sort() method
	// so you need to just slug out some code.
	// Look at the bubble sort from the SortByHand in the search_sort package
	// You will want to do something similar
	// Here is some pseudocode to help
	//

	public static void sortCustNum(ArrayList<Insurance> insure) {

		for (int out = insure.size() - 1; out > 1; out--)
			for (int in = 0; in < out; in++) {
				// get the first insurance policy
				// get the customer from that insurance policy
				// get the customer number from that insurance policy
				Insurance first = insure.get(in);
				int firstCust = first.getCustomer().getId();
				// get the second insurance policy
				// get the customer from that insurance policy
				// get the customer number from that insurance policy
				Insurance second = insure.get(in+1);
				int secondCust = second.getCustomer().getId();
				// We want to check to see if the second customer number is
				// less than the first one
				if (firstCust > secondCust) {

					// NOTE: When comparing customer numbers:
					// SortByHand uses Strings so it uses the compareTo()
					// method.
					// We are comparing integers so we can just use <

					// if the second customer number is less than the first one
					// swap the two insurance policies in the original "insure"
					// ArrayList
					// check out the SortByHand to see how to swap.
					insure.set(in, second);
					insure.set(in+1, first);
				}
			}
		
	}
}
