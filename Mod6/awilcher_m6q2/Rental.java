package awilcher_m6q2;

import java.text.NumberFormat;

public class Rental {

	// the Rental class has four fields

	private Customer cust;
	private Auto auto;
	private int numDays;
	private double rentalCost;
	private char discount; // N = none G = gold D = days B = both

	// all cars rent for $75.00 per day
	final private double COST_PER_DAY = 75.00;
	// TO DO!!write an empty and a full constructor

	public Rental() {
	}

	public Rental(Customer c, Auto a, int d) {
		cust = c;
		auto = a;
		numDays = d;
		setRentalCost();
	}

	// toString method
	// remember that each class should print out its own fields
	// so we let the Auto and Customer class print out theirs
	// this class only prints out the number of days field
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string;
		string = cust.toString() + " rented ";
		string = string + auto.toString() + " for " + numDays + " days.";
		string = string + "\n   The cost was " + nf.format(rentalCost) + "\n";
		switch (discount) {
		case 'B':
			string = string
					+ "This person was both a gold card memeber and rented over six days and received a 25% discount";
			break;
		case 'G':
			string = string + "This person was  a gold card member and received a 10% discount";
			break;
		case 'D':
			string = string + "This person rented over six days and received a 15% discount";
			break;
		case 'N':
			string = string + "This person did not qualify for a discount";

		}

		return string;
	}

	// TO DO!!!the setRentalCost is where the cost is set
	public void setRentalCost() {
		final double GCM_DISCOUNT = (.10);
		final double DAYS_DISCOUNT = (.15);
		final double GCM_DAYS_DISCOUNT = (.25);
		if (this.auto.getClass().equals(SuperCar.class) == true) {
			rentalCost = numDays * (COST_PER_DAY * 1.5);
		}
		else {
			rentalCost = numDays * COST_PER_DAY;
		}

		if (numDays > 6 && cust.isGoldCardMember()) {
			rentalCost = rentalCost - (rentalCost * GCM_DAYS_DISCOUNT);
			discount = 'B';
		} else if (numDays > 6) {
			rentalCost = rentalCost - (rentalCost * DAYS_DISCOUNT);
			discount = 'D';
		} else if (cust.isGoldCardMember()) {
			rentalCost = rentalCost - (rentalCost * GCM_DISCOUNT);
			discount = 'G';
		} else
			discount = 'N';

	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public double getRentalCost() {
		return rentalCost;
	}

	public char getDiscount() {
		return discount;
	}

	public void setDiscount(char discount) {
		this.discount = discount;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}

	// give them a 15% discount if they rent over 6 days. Also Gold card members get
	// an
	// extra 10% off the original cost regardless of the number of days
	// note next line is just a place holder. Also set the discount code

}

// generate getters and setters
