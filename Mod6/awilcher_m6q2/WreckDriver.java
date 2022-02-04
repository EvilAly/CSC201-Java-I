package awilcher_m6q2;

import java.util.*;

public class WreckDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> c = new ArrayList<Customer>();
		ArrayList<Auto> a = new ArrayList<Auto>();
		ArrayList<Rental> r = new ArrayList<Rental>();
		loadNewData(a, c);

		String more = "yes";
		while (more.equals("yes")) {

			System.out.println("Do you want to rent a car(1) or return a car(2)");
			int num = sc.nextInt();
			if (num == 1) {

				System.out.println("Customers:");
				for (int i = 0; i < c.size(); i++)
					System.out.println(i + 1 + " " + c.get(i).toString());
				// customer list displayed and input requested from user//
				System.out.println("\nWhich customer?");
				int cust = sc.nextInt() - 1;
				// customer record checked for gold card member status//
				if (c.get(cust).isGoldCardMember())
					System.out.println("This customer is a gold card member so we will treat him well!\n");
				else
					System.out.println("This customer is not a gold card member\n");

				System.out.println("The following cars are available to rent...");
				showCars(a);
				// menu of cars available to rent is displayed and user is prompted for choice//
				System.out.println("\nWhich auto?");
				int car = sc.nextInt() - 1;

				System.out.println("How many days do you wish to have this beautiful vehicle?");
				int days = sc.nextInt();
				// rental length determined
				if (days < 3 && a.get(car).getClass().equals(SuperCar.class)) {
					System.out.println("This car has a rental minimum of 3 days.");
				} else {
					Rental rent = new Rental(c.get(cust), a.get(car), days);
					r.add(rent);
					a.remove(car);
					System.out.println(rent.toString());
				}
			}
			// new rental record added to ArrayList 'r'//
			else if (num == 2) {
				if (r.size() == 0)
					System.out.println("There are no rentals to return");
				else {
					printRentals(r);
					System.out.println("What is the rental number of the one to be returned?");
					int which = sc.nextInt();
					Rental rental = r.get(which - 1);
					Auto auto = rental.getAuto();
					a.add(auto);
					r.remove(which - 1);
				}

			}
			sc.nextLine();
			System.out.println("more rentals/returns? (yes/no): ");
			more = sc.nextLine();

			// if 'no' , rental summaries are printed //
		}
		System.out.println("\nRental Summary:");

		printRentals(r);

	}

	public static void loadNewData(ArrayList<Auto> a, ArrayList<Customer> c) {
		a.add(new Auto(2009, "Ford", "Mustang", "ABC123", 1256.54));
		a.add(new Auto(2010, "Chevy", "Camero", "QWI459", 33.98));
		a.add(new Auto(1970, "Pink", "Cadillac", "950AKH", 212874.51));
		a.add(new Auto(2007, "Lotus", "Elise MkII", "1A2D3F", 12859.90));
		a.add(new Auto(2021, "Chevy", "Corvette C8", "867AA3", 1200));
		a.add(new SuperCar(2021, "McLaren", "570S", "MEFAST", 100.03, true, 204));
		a.add(new SuperCar(2022, "Audi", "R8", "ZOOOOM", 20, true, 205));
		a.add(new SuperCar(2020, "Aston Martin", "DB11 V8", "CATCHME", 75.1, true, 187));

		c.add(new Customer("Mike Trout", false));
		c.add(new Customer("Bruce Springsteen", true));
		c.add(new Customer("Mickey Mouse", true));
		c.add(new Customer("Fernando Tatis", true));
		c.add(new Customer("Donald Duck", true));
	}

	// Prints the cars that are available for rent
	public static void showCars(ArrayList<Auto> a) {
		for (int i = 0; i < a.size(); i++)
			System.out.println(i + 1 + " " + a.get(i).toString());

	}

	// prints all the rentals that have been made
	public static void printRentals(ArrayList<Rental> r) {
		for (int i = 0; i < r.size(); i++)
			System.out.println("Rental #" + (i + 1) + ":   " + r.get(i).toString() + "\n");

	}
}
