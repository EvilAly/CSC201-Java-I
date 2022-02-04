package awilchermod4csc201;

import java.text.NumberFormat;

public class Cookies {

	private String type;
	private int numInPck;
	private double cost;

	public Cookies() {

	}

	public Cookies(String t, int n, double c) {
		type = t;
		numInPck = n;
		cost = c;
	}

	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return type + " has " + numInPck + " cookies and a cost of " + nf.format(cost);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumInPck() {
		return numInPck;
	}

	public void setNumInPck(int numInPck) {
		this.numInPck = numInPck;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
