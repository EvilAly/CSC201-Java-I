package awilchermod7csc201;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Comparator;

public class Sales implements Comparable<Sales> {

	private String service;
	private double salesAmt;
	private LocalDate date;
	private Customer customer;

	// empty constructor
	public Sales() {

	}

	// full constructor
	public Sales(Customer c, String s, double a, LocalDate d) {
		this.customer = c;
		this.service = s;
		this.salesAmt = a;
		this.date = d;
	}

	// Methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return this.customer.toString() + " was billed " + nf.format(this.salesAmt) + " for " + this.service + " on "
				+ this.date;
	}

	public String toFileString() {
		return customer.toFileString() + "|" + service + "|" + salesAmt + "|" + date.toString();
	}

	@Override
	public int compareTo(Sales o) {
		if (o.getDate().isBefore(this.getDate()))
			return 1;
		else if (o.getDate().isAfter(this.getDate()))
			return -1;
		else
			return 0;

	}
	
	// getters & setters
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public double getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(double salesAmt) {
		this.salesAmt = salesAmt;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
