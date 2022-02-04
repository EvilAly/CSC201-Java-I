package awilchermod5csc201;

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

	public Rental(Customer c, Auto a, int n) {
		this.cust = c;
		this.auto = a;
		this.numDays = n;
		discCode();
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
		if (this.discount == 'B')
			string = string	+ "   This person was both a gold card member and rented over six days and received a a 25% discount. \n";
		else if (this.discount == 'G')
			string = string + "   This person was  a gold card memeber and received a a 10% discount. \n";
		else if	(this.discount == 'D')
			string = string + "   This person rented over six days and received a 15% discount. \n";
		else
			string = string + "   This person did not qualify for a discount. \n";

		return string;
	}

	// TO DO!!!the setRentalCost is where the cost is set
	public void setRentalCost() {
		// give them a 15% discount if they rent over 6 days. Also Gold card members get
		// an
		// extra 10% off the original cost regardless of the number of days
		// note next line is just a place holder. Also set the discount code
		if (this.discount == 'B') {
			setRentalCost((COST_PER_DAY * this.numDays) * 0.75);
		}
		else if (this.discount == 'G') {
			setRentalCost((COST_PER_DAY * this.numDays) * 0.90);
		}
		else if (this.discount == 'D') {
			setRentalCost((COST_PER_DAY * this.numDays) * 0.85);
		}
		else
			setRentalCost(COST_PER_DAY * this.numDays);

	}
	
	public void discCode() {
		if (this.cust.isGoldCardMember()) {
			if (this.numDays > 6) {
				setDiscount('B');
			} else {
				setDiscount('G');
			}
		} else {
			if (this.numDays > 6) {
				setDiscount('D');
			} else {
				setDiscount('N');
			}
		}
		
	}

	// generate getters and setters
	public void setAuto(Auto a) {
		this.auto = a;
	}

	public Auto getAuto() {
		return this.auto;
	}

	public Customer getCust() {
		return this.cust;
	}

	public void setCust(Customer c) {
		this.cust = c;
	}

	public int setNumDays() {
		return this.numDays;
	}

	public void setNumDays(int n) {
		this.numDays = n;
	}

	public double getRentalCost() {
		return this.rentalCost;
	}

	public char getDiscount() {
		return discount;
	}

	public void setDiscount(char d) {
		this.discount = d;
	}

	public void setRentalCost(double r) {
		this.rentalCost = r;
	}

}
