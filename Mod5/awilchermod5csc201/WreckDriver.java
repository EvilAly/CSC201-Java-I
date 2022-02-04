package awilchermod5csc201;

import java.util.*;

import java.text.*;

public class WreckDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String more = "yes";
		ArrayList<Auto> car = new ArrayList<Auto>();
		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Rental> rent = new ArrayList<Rental>();

		loadNewData(car, cust);
		// start loop
		while (more.equalsIgnoreCase("yes")) {
			// rent or return car
			System.out.println("Do you want to rent a car (1) or return a car (2)?");
			int choice = scan.nextInt();

			// if rent
			if (choice == 1) {
				rentCar(cust, car, rent);
			} else if (choice == 2) {
				returnCar(rent, car);
			} else {
				System.out.println("Not a valid option.");
			}

			// more?
			scan.nextLine();
			System.out.println("More rentals/returns? (yes/no)");
			more = scan.nextLine();
		} // end loop

		// print Rental Summary
		System.out.println("\n");
		printRentals(rent);
	}

	public static void loadNewData(ArrayList<Auto> a, ArrayList<Customer> c) {
		a.add(new Auto(2009, "Ford", "Mustang", "ABC123", 1256.54));
		a.add(new Auto(2010, "Chevy", "Camero", "QWI459", 33.98));
		a.add(new Auto(1970, "Pink", "Cadillac", "950AKH", 212874.51));
		a.add(new Auto(2007, "Lotus", "Elise MkII", "1A2D3F", 12859.90));
		a.add(new Auto(2021, "Chevy", "Corvette C8", "867AA3", 1200));

		c.add(new Customer("Mike Trout", false));
		c.add(new Customer("Bruce Springsteen", true));
		c.add(new Customer("Mickey Mouse", true));
		c.add(new Customer("Fernando Tatis", true));
		c.add(new Customer("Donald Duck", true));
	}

	// Prints the cars that are available for rent
	public static void showCars(ArrayList<Auto> a) {
		System.out.println("The following cars are avaialble to rent ...");
		for (int i = 0; i < a.size(); i++) {
			System.out.println((i + 1) + " " + a.get(i).toString());
		}

	}

	// prints all the rentals that have been made
	public static void printRentals(ArrayList<Rental> rents) {
		// loop thru ArrayList
		for (int i = 0; i < rents.size(); i++) {
			System.out.println("Rental #" + (i + 1) + " " + rents.get(i).toString());
		}

	}

	// print customer list
	public static void showCust(ArrayList<Customer> c) {
		System.out.println("Customers: ");
		for (int i = 0; i < c.size(); i++) {
			System.out.println((i + 1) + " " + c.get(i).toString());
		}

	}

	public static void rentCar(ArrayList<Customer> c, ArrayList<Auto> car, ArrayList<Rental> r) {
		Scanner scan = new Scanner(System.in);
		// print and select Customer
		showCust(c);

		// select customer
		System.out.println("\n");
		System.out.println("Which customer?");
		int cust = scan.nextInt();
		Customer you = c.get(cust-1);

		// gold member?
		boolean gold = c.get(cust-1).isGoldCardMember();
		if (gold)
			System.out.println("This customer is a gold card member so we will treat him well! \n");
		else
			System.out.println("This customer is not a gold card member.\n ");

		// print available cars
		showCars(car);

		// which car?
		System.out.println("\nWhich auto?");
		int auto = scan.nextInt();
		Auto vroom = car.get(auto-1);
		car.remove(auto-1);

		// num of days
		System.out.println("How many days will you be renting this vehicle?");
		int days = scan.nextInt();

		// add to rental ArrayList
		r.add(new Rental(you, vroom, days));
		int rentals = r.size() - 1;
		System.out.println(r.get(rentals).toString());

	}

	public static void returnCar(ArrayList<Rental> rents, ArrayList<Auto> a) {
		Scanner scan = new Scanner(System.in);

		// are there rentals out?
		if (rents.size() > 0) {
			// print Rentals
			System.out.println("\n");
			printRentals(rents);

			// get rental to be returned
			System.out.println("What is the rental number of the one to be returned?");
			int ret = scan.nextInt();
						
			// return location from ArrayList
			a.add(rents.get(ret-1).getAuto());
			
			//remove returned rental from rentals list
			rents.remove(ret-1);
			
			
		} else {
			System.out.println("There are no rentals to return.");
		}
	}

}
