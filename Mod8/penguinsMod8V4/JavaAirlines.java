package penguinsMod8V4;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class JavaAirlines {

	public static void main(String[] args) {

		// Customer ArrayList
		ArrayList<Customer> custs = new ArrayList<Customer>();
		ArrayList<Reservation> res = new ArrayList<Reservation>();

		// create the flights on each day
		String[][] dec1 = createFlight();
		String[][] dec2 = createFlight();
		String[][] dec3 = createFlight();

		String[][][] flights = { dec1, dec2, dec3 };

		// while loop until user chooses to end
		while (true) {
			int choice = menu();
			if (choice == 1) {
				custs.add(createCust());

			} else if (choice == 2) {
				// make a reservation
				res.add(makeRes(flights, custs));
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
				// Show plane loading
				int date = chooseDate();
				if (date == 1)
					showSeating(dec1);
				else if (date == 2)
					showSeating(dec2);
				else if (date == 3)
					showSeating(dec3);
			} else if (choice == 5) {
				// cancel reservation
				adjRes(flights, res);
			} else if (choice == 6) {
				// save data to a file
				saveData(res);
			} else if (choice == 7) {
				// read data from a file
				res = readData(custs);
				createRes(flights, res);
			} else if (choice == 8) {
				System.out.println("Thank you for using Java Airlines! ");
				System.exit(0);
			} else {
				System.out.println("You did not choose a valid menu option. Please choose again.\n");
			}
		} // end of while loop
	} // end of main

	public static Reservation makeRes(String[][][] f, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		Customer c = new Customer();
		Reservation r = new Reservation();

		System.out.println("Are you a current customer? (true or false)");
		boolean isCust = scan.nextBoolean();

		if (isCust == false)
			c = createCust();
		else {
			boolean yes = false;
			while (!yes) {
				System.out.println("Please enter your customer Id?");
				int idInput = scan.nextInt();

				try {
					for (int i = 0; i < cust.size(); i++) {
						if (idInput == cust.get(i).getId()) {
							c = cust.get(i);
						}
					}
					if (!c.getFirst().equals(null)) {
						System.out.println("Are you " + c.getFirst() + " " + c.getLast() + "? (true or false)");
						yes = scan.nextBoolean();
					}
				} catch (NullPointerException npe) {
					System.out.println("You did not enter a valid customer number. \n");
				}
				// } }
			}
			// end of if else

			scan.nextLine();

			System.out.println("Do you want first class or economy seating?");
			String type = scan.nextLine();

			// skips this question if first class, as only window are a
			if (!type.equals("first class")) {
				System.out.println("Do you prefer a window or an aisle seat?");
				String choice = scan.nextLine();
			}

			// show available seats on selected date
			int date = chooseDate();
			while (date != 1 && date != 2 && date != 3) {
				System.out.println("You did not choose a correct date. Please choose again. ");
				date = chooseDate();
			}
			LocalDate d = LocalDate.of(2021, 12, date);

			for (int i = 0; i < f.length; i++)
				if (date == (i + 1))
					showSeating(f[i]);

			String seat = pickResSeat();
			int col = Character.getNumericValue(seat.charAt(0));
			int row = Character.getNumericValue(seat.charAt(1));

			col -= 10;
			row -= 1;

			if ((row == 0 || row == 1) && col == 7)
				col -= 6;

			// set the reservation
			r.setCust(c);
			r.setSeat(seat);
			r.setDate(d);

			f[date - 1][row][col] = (" " + r.getResId() + " ");

		}
		return r;
	}

	public static String pickResSeat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose one of the open seats (ex. A4)");

		String s = scan.nextLine();

		return s;
	}

	public static void adjRes(String[][][] f, ArrayList<Reservation> r) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < r.size(); i++)
			System.out.println((i + 1) + ". " + r.get(i).toString());
		System.out.println();

		System.out.println("Please enter the reservation number you would like to cancel: ");
		int num = s.nextInt();

		try {
			String seat = r.get(num - 1).getSeat();
			int d = r.get(num - 1).getDate().getDayOfMonth();

			// get seat
			int col = Character.getNumericValue(seat.charAt(0));
			int row = Character.getNumericValue(seat.charAt(1));

			col -= 10;
			row -= 1;

			if ((row == 0 || row == 1) && col == 7)
				col -= 6;
			// removes the reservation
			f[d - 1][row][col] = ("     ");

			// remove value from ArrayList
			r.remove(num - 1);

			System.out.println("We're sorry you had to cancel. Please choose Java Airlines for your future travels!\n");
		} catch (IndexOutOfBoundsException ioe) {
			System.out.println("That was not a valid reservation number. \n");
		}
	}

	public static void printSeating(String[][] s) {

		System.out.println("\n        A       B       C       D               E       F       G       H   "
				+ "\n     ------- ------- ------- ------- ------- ------- ------- ------- -------");
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[row].length; col++) {
				if ((row == 0 && col == 0) || (row == 1 && col == 0)) {
					if (!s[row][col].equals("     ")) {
						System.out.print(" " + (row + 1)
								+ " |   X    |   X   |   X   |   X   | AISLE |   X   |   X   |   X   | ");
					} else {
						System.out.print(" " + (row + 1) + "  | " + s[row][col]
								+ " |   X   |   X   |   X   | AISLE |   X   |   X   |   X   | ");
					}

				} else if (col == 0) {
					if (!s[row][col].equals("     ")) {
						System.out.print(" " + (row + 1) + "  |   X    | ");
					} else {
						System.out.print(" " + (row + 1) + "  | " + s[row][col] + " | ");
					}
				} else if (col == 3) {
					if (!s[row][col].equals("     ")) {
						System.out.print("  X   | AISLE | ");
					} else {
						System.out.print(s[row][col] + " | AISLE | ");
					}
				} else {
					if (!s[row][col].equals("     ")) {
						System.out.print("  X   | ");
					} else {
						System.out.print(s[row][col] + " | ");
					}
				}
			} // end of inner for loop
				// System.out.println();
				// System.out.println("\n
				// _______________________________________________________________");
			System.out.println("\n     ------- ------- ------- ------- ------- ------- ------- ------- -------");

			// }
		}
	}

	public static void printCust(ArrayList<Customer> custs) {
		for (int i = 0; i < custs.size(); i++)
			System.out.println(custs.get(i).toString());
	}

	public static Customer createCust() {
		Customer c = new Customer();
		Scanner s = new Scanner(System.in);

		System.out.println("What is your first name?");
		c.setFirst(s.nextLine());
		System.out.println("What is your last name?");
		c.setLast(s.nextLine());

		System.out.println("\nYour customer id is " + c.getId() + "\n");

		return c;
	}

	public static int menu() {
		Scanner s = new Scanner(System.in);

		System.out.println("Please choose one of the following options from the menu:");
		System.out.println("   1.  Create a Customer object");
		System.out.println("   2.  Make a reservation");
		System.out.println("   3.  Print available seats");
		System.out.println("   4.  Show plane loading");
		System.out.println("   5.  Cancel reservation");
		System.out.println("   6.  Save data to a file");
		System.out.println("   7.  Load data from a file");
		System.out.println("   8.  EXIT");

		System.out.println("\n Choice:");

		int value = s.nextInt();
		return value;
	}// end of method

	public static String[][] createFlight() {
		// create flight with 20 seats
		String[][] temp = { { "     ", "     " }, { "     ", "     " },
				{ "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", },
				{ "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     " } };
		// return flight
		return temp;
	}

	public static int chooseDate() {
		Scanner scan = new Scanner(System.in);
		// give customer date options
		System.out.println("Please choose one of the following dates? ");
		System.out.println("1. December 1st ");
		System.out.println("2. December 2nd ");
		System.out.println("3. December 3rd ");
		// get customer input
		int d = scan.nextInt();
		// return customer choice

		return d;

	}

	public static void saveData(ArrayList<Reservation> r) {
		String filename = FileLoc.pickLocOut();

		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data from array and write it to the file.
			for (int i = 0; i < r.size(); i++) {
				// Write the object. Note we are writing the toStringF() that is pipe delimited
				outputFile.println(r.get(i).toStringF());
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}
	}

	public static ArrayList<Reservation> readData(ArrayList<Customer> cust) {
		ArrayList<Reservation> readIn = new ArrayList<>();
		// Get the filename.
		String filename = FileLoc.pickLocRead();
		// Open the file.
		File file = new File(filename);

		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				String line = inputFile.nextLine();
				// StringTokenizer will break apart each piece of information
				StringTokenizer t = new StringTokenizer(line, "|/-");

				// Assign information to variables
				String first = t.nextToken().trim();
				String last = t.nextToken().trim();
				int id = Integer.parseInt(t.nextToken().trim());
				// create customer
				Customer c = new Customer(last, first, id);
				cust.add(c);
				// get the information for the date
				int year = Integer.parseInt(t.nextToken().trim());
				int mon = Integer.parseInt(t.nextToken().trim());
				int day = Integer.parseInt(t.nextToken().trim());
				// create a Day instance
				LocalDate d = LocalDate.of(year, mon, day);
				// get remaining reservation information
				String seat = t.nextToken().trim();
				int resID = Integer.parseInt(t.nextToken().trim());

				// create reservation
				Reservation r = new Reservation(d, c, seat, resID);

				// add the instance to the ArrayList
				readIn.add(r);
			}
			return readIn;

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}
		return readIn;
	}

	public static void createRes(String[][][] f, ArrayList<Reservation> r) {
		// loop thru array
		for (int i = 0; i < r.size(); i++) {
			// get seat information
			int d = r.get(i).getDate().getDayOfMonth();
			String seat = r.get(i).getSeat();
			// break up seat info
			int col = Character.getNumericValue(seat.charAt(0));
			int row = Character.getNumericValue(seat.charAt(1));

			col -= 10;
			row -= 1;

			if ((row == 0 || row == 1) && col == 7)
				col -= 6;

			f[d - 1][row][col] = (" " + r.get(i).getResId() + " ");

		}
	}

	public static void showSeating(String[][] s) {

		System.out.println("\n        A       B       C       D               E       F       G       H   "
				+ "\n     ------- ------- ------- ------- ------- ------- ------- ------- -------");
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[row].length; col++) {
				if ((row == 0 && col == 0) || (row == 1 && col == 0)) {
					System.out.print(" " + (row + 1) + "  | " + s[row][col]
							+ " |   X   |   X   |   X   | AISLE |   X   |   X   |   X   | ");
				} else if (col == 0) {
					System.out.print(" " + (row + 1) + "  | " + s[row][col] + " | ");
				} else if (col == 3) {
					System.out.print(s[row][col] + " | AISLE | ");
				} else {
					System.out.print(s[row][col] + " | ");
				}
			} // end of inner for loop
				// System.out.println();
				// System.out.println("\n
				// _______________________________________________________________");
			System.out.println("\n     ------- ------- ------- ------- ------- ------- ------- ------- -------");

			// }
		}
	}
}
