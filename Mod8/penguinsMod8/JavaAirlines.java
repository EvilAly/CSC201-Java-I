package penguinsMod8;

import java.util.*;

public class JavaAirlines {

	public static void main(String[] args) {
		// create the flights on each day
		String[][] dec1 = createFlight();
		String[][] dec2 = createFlight();
		String[][] dec3 = createFlight();
		ArrayList<Reservations> reserves = new ArrayList<Reservations>();
		ArrayList<Customers> cust = new ArrayList<Customers>();

		// while loop until user chooses to end
		while (true) {
			int choice = menu();
			if (choice == 1) {
				// create customer
			} else if (choice == 2) {
				// make a reservation
			} else if (choice == 3) {
				// print plane loading
				int date = chooseDate();
				if (date == 1)
					printSeating(dec1);
				else if (date == 2)
					printSeating(dec2);
				else if (date == 3)
					printSeating(dec3);
			} else if (choice == 4) {
				//modify/cancel reservation
			} else if (choice == 5) {
				// save data to file
				saveResData(reserves);
			} else if (choice == 6) {
				// read data to file
				reserves = readResData();
			} else if (choice == 7) {
				System.out.println("Thank you for using Java Airlines! ");
				System.exit(0);
			}
		}

	}

	public static String[][] createFlight() {
		// create flight with 20 seats
		String[][] temp = { { null, null }, { null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null } };
		// return flight
		return temp;
	}

	public static int chooseDate() {
		Scanner scan = new Scanner(System.in);
		// give customer date options
		System.out.println("Which date would you like to view? ");
		System.out.println("1. December 1st ");
		System.out.println("2. December 2nd ");
		System.out.println("3. December 3rd ");
		// get customer input
		int d = scan.nextInt();
		// return customer choice
		return d;

	}

	public static void printSeating(String[][] s) {
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[row].length; col++) {
				if ((row == 0 && col == 0) || (row == 1 && col == 0)) {
					System.out.print("| " + s[row][col] + " | XXXX | XXXX | XXXX | AISLE | XXXX | XXXX | XXXX | ");
				} else if (col == 0) {
					System.out.print("| " + s[row][col] + " | ");
				} else if (col == 3) {
					System.out.print(s[row][col] + " | AISLE | ");
				} else {
					System.out.print(s[row][col] + " | ");
				}
			}
			System.out.println();

			// }

		}
	}

	
	public static void saveResData(ArrayList<Reservations> r) {
		//
	}
	
	public static ArrayList<Reservations> readResData() {
		//use the reservation method as it reads in the reservation/customer data
	}
	
		
		
	}
}
