package awilchermod6csc201;

import java.text.*;

// note that this is an abstract class (see p455 of your text)
// I do not want any one to create a generic Insurance instance
// (we only sell Auto, Life, and Health) but so as not to repeat
// common fields in those , we move them up one hierarchy level
// and make a generic Inurance class

// implements the interface Comparable so I can define how to order
// or sort Insurance objects

public abstract class Insurance implements Comparable<Insurance> {

	// NOTE: these fields are protected!!!!! If I am to inherit
	// these , they must be protected (private allows NO other classes
	// to use them) - protected means this class and any class that inherits
	// from this one can use these
	protected Customer customer;
	protected double yearlyRate;
	protected int policyNumber;

	// a static variable used to make the insurance id unique
	public static int num = 1000;

	// full constructor - automatically creates a new Insurance id
	public Insurance(Customer cust) {
		customer = cust;
		policyNumber = num;
		num++;

	}

	// used for reading from a file where policy number and rate already set
	public Insurance(Customer cust, int polNum, double yrRate) {
		customer = cust;
		policyNumber = polNum;
		yearlyRate = yrRate;

	}

	// the empty constructor but still sets a unique id
	public Insurance() {
		policyNumber = num;
		num++;
	}

	// the calcRate method is used to set the yearlyRate
	// NOTE: this is an abstract class. That means it can not be used (has no body)
	// but by putting here, we require any class that inherits from the Insurance
	// class
	// to fully implement this method if they want to be a concrete class
	public abstract void calcRate();

	// toString method. Note - we let the customer write themself out since they
	// have their own toString method
	// a class should only write out their fields in the toString method
	public String toString() {
		// for currency output
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return (customer.toString() + " with policy number " + policyNumber + " has a yearly rate of "
				+ currency.format(yearlyRate));
	}

	// required by the Comparable interface. Describes how to compare two Insurance
	// instances
	// In this one, we want to compare policy numbers
	// Look at how we did the one in the Customer blueprint
	// Look at the one in the search_sort.Account class
	// Note the difference if you are sorting on primitives versus objects

	public int compareTo(Insurance ins) {
			// you get to write this!!
		if (ins.getPolicyNumber() < this.getPolicyNumber())
			return 1;
		else if (ins.getPolicyNumber() > this.getPolicyNumber())
			return -1;
		else
			return 0;

		}

	// getters and setters
	public Customer getCustomer() {
		return customer;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public double getYearlyRate() {
		return yearlyRate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public void setYearlyRate(double yearlyRate) {
		this.yearlyRate = yearlyRate;
	}

}
