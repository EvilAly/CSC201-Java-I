package awilchermod6csc201;

import java.text.NumberFormat;

public class Cookies extends Sweets {

	// fields
	private int numInPk;

	// constructors
	public Cookies() {

	}

	public Cookies(String t, double c, int nip) {
		super(t, c);
		this.numInPk = nip;
	}

	// methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return super.toString() + " with " + this.numInPk + " in each package at a cost of "
				+ nf.format(this.calcCost()) + " per cookie.";
	}

	public double calcCost() {
		double cost = this.cost / this.numInPk;
		return cost;
	}

	// getters and setters
	public int getNumInPk() {
		return this.numInPk;
	}

	public void setNumInPk(int n) {
		this.numInPk = n;
	}
}
