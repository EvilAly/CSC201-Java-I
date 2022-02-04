package awilchermod7csc201;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class HotelCharges {

	public static void main(String[] args) {
		ArrayList<Sales> sales = new ArrayList<Sales>();
		while (true) {
			int opt = menu();

			// Option 1 - Read in Data
			if (opt == 1) {
				readInFile(sales);
			}
			// Option 2 - Sort file by Service Type
			else if (opt == 2) {
				fileByService(sales);
			}
			// Option 3 - Sort file by date
			else if (opt == 3) {
				Collections.sort(sales);
			}
			// Option 4 - Add a sale
			else if (opt == 4) {
				addSale(sales);
			}
			// Option 5 - Print all Sales to console
			else if (opt == 5) {
				printSales(sales);
			}
			// Option 6 - Save data to a file
			else if (opt == 6) {
				saveToFile(sales);
			}
			// Option 7 - Exit
			else if (opt == 7) {
				System.out.println("Thank you.");
				System.exit(0);

			} else
				System.out.println("This is not a valid selection.");
		}
	}

	public static int menu() {
		Scanner scan = new Scanner(System.in);
		// Print out menu
		System.out.println("Make a selection: ");
		System.out.println("1: Read in sales data from file");
		System.out.println("2: Sort sales by type");
		System.out.println("3: Sort sales by date");
		System.out.println("4. Add a sale");
		System.out.println("5: Print all Sales");
		System.out.println("6: Save data to file");
		System.out.println("7: EXIT");

		// get user input
		System.out.println("\nPlease enter the number of your selection: ");
		int num = scan.nextInt();
		// return selection
		return num;

	}

	public static void readInFile(ArrayList<Sales> s) {
		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);
			String line = inputFile.nextLine();
			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				line = inputFile.nextLine();
				// create a StringTokenizer and break the line at the | symbols
				StringTokenizer st = new StringTokenizer(line, ",/-");
				// get each field, make the object, and then add it to the ArrayList
				int custID = Integer.parseInt(st.nextToken().trim());
				String first = st.nextToken();
				String last = st.nextToken();
				String service = st.nextToken().trim();
				double salesAmt = Double.parseDouble(st.nextToken().trim());
				int month = Integer.parseInt(st.nextToken().trim());
				int day = Integer.parseInt(st.nextToken().trim());
				int year = Integer.parseInt(st.nextToken().trim());

				// create LocalDate
				LocalDate date = LocalDate.of(year, month, day);
				// create customer & sales data
				Customer cust = new Customer(first, last, custID);
				Sales sale = new Sales(cust, service, salesAmt, date);
				// add sale to ArrayList
				s.add(sale);
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
			System.out.println("\nThe data has been loaded.\n");
		}

	}

	public static void fileByService(ArrayList<Sales> s) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		// sort ArrayList
		for (int out = s.size() - 1; out > 1; out--)
			for (int in = 0; in < out; in++) {
				Sales first = s.get(in);
				Sales second = s.get(in + 1);
				String fSale = first.getService();
				String sSale = second.getService();
				if (sSale.compareTo(fSale) < 0) {
					s.set(in, second);
					s.set(in + 1, first);
				}
			}

		// load variables
		double lodTotal = 0;
		double barTotal = 0;
		double confTotal = 0;
		double dinTotal = 0;
		double otherTotal = 0;

		// loop thru Array List adding services up
		for (int i = 0; i < s.size(); i++) {
			String serv = s.get(i).getService();
			if (serv.equals("Lodging")) // if lodging, add amount
				lodTotal = lodTotal + s.get(i).getSalesAmt();
			else if (serv.equals("Bar Tab"))// if bar tab, add amount
				barTotal = barTotal + s.get(i).getSalesAmt();
			else if (serv.equals("Conference"))// if conference room was reserved, add amount
				confTotal = confTotal + s.get(i).getSalesAmt();
			else if (serv.equals("Dinner"))// if dinner, add amount
				dinTotal = dinTotal + s.get(i).getSalesAmt();
			else // if any other service, add amount
				otherTotal = otherTotal + s.get(i).getSalesAmt();
		}

		// print service totals
		System.out.println("The total amount for Lodging is " + nf.format(lodTotal));
		System.out.println("The total amount for Bar Tab is " + nf.format(barTotal));
		System.out.println("The total amount for Conference is " + nf.format(confTotal));
		System.out.println("The total amount for Dinner is " + nf.format(dinTotal));
		System.out.println("The total amount for Other is " + nf.format(otherTotal));
		System.out.println("\n");
	}

	public static void addSale(ArrayList<Sales> s) {
		// open scanner
		Scanner scan = new Scanner(System.in);
		// ask for first name
		System.out.println("Enter the first name of the customer: ");
		String first = scan.nextLine();
		// ask for last name
		System.out.println("Enter the last name of the customer: ");
		String last = scan.nextLine();
		// ask for service type
		System.out.println("Enter the service type of the charge: ");
		String service = scan.nextLine();
		// cost of service
		System.out.println("Enter the cost of the charge: ");
		double cost = scan.nextDouble();
		// enter day
		System.out.println("Enter the day of the transaction: ");
		int day = scan.nextInt();
		// enter month
		System.out.println("Enter the month of the transaction in number format: ");
		int month = scan.nextInt();
		// enter year
		System.out.println("Enter the four-digit year of the transaction: ");
		int year = scan.nextInt();

		LocalDate date = LocalDate.of(year, month, day);
		// add to AL
		Customer cust = new Customer(first, last);
		Sales sale = new Sales(cust, service, cost, date);
		s.add(sale);
		
	}

	public static void printSales(ArrayList<Sales> s) {
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i).toString());
		}

	}

	public static void saveToFile(ArrayList<Sales> sales) {
		String filename; // File name
		Scanner scan = new Scanner(System.in);

		// Get the filename.
		filename = FileLoc.pickLocOut();

		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			for (int i = 0; i < sales.size(); i++) {
				Sales s = sales.get(i);
				// Write the object. Note we are writing the toStrinF() that is pipe delimited
				outputFile.println(s.toFileString());
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}
		

	}
}
